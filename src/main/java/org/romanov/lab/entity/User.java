package org.romanov.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;                                             // Id клиента
    private String lastName;                                    // Фамилия
    private String firstName;                                   // Имя
    private String patronymic;                                  // Отчество
    private LocalDate birthDate;                                // Дата рождения
    private String workplace;                                   // Место работы
    private double monthlyIncome;                               // Ежемесячный доход (генерируется рандомно, но не более 10 000)
    private List<Bank> usedBanksIds;                            // Банки, которыми он пользуется
    private List<CreditAccount> creditAccountsIds = null;       // Кредитные счета (по умолчанию пусто)
    private List<PaymentAccount> paymentAccountsIds = null;     // Платежные счета (по умолчанию пусто)
    private int creditRating;                                   // Кредитный рейтинг для банка (генерируется рандомно исходя из ежемесячного дохода, от меньше 1 000 – 100, от 1 000 до 2 000 – 200 и т.д. вплоть до 10 000)

    @Override
    public String toString() {
        StringBuilder usedBanks = new StringBuilder();
        if (usedBanksIds != null) {
            for (Bank bank : usedBanksIds) {
                if (usedBanks.isEmpty()) usedBanks = new StringBuilder("\n\tID usedBanks=");
                else usedBanks.append(", ");
                usedBanks.append(bank.getId());
            }
        }
        StringBuilder creditAccounts = new StringBuilder();
        if (creditAccountsIds != null) {
            for (CreditAccount creditAccount : creditAccountsIds) {
                if (creditAccounts.isEmpty()) creditAccounts = new StringBuilder("\n\tID creditAccounts=");
                else creditAccounts.append(", ");
                creditAccounts.append(creditAccount.getId());
            }
        }
        StringBuilder paymentAccounts = new StringBuilder();
        if (paymentAccountsIds != null) {
            for (PaymentAccount paymentAccount : paymentAccountsIds) {
                if (paymentAccounts.isEmpty()) paymentAccounts = new StringBuilder("\n\tID paymentAccounts=");
                else paymentAccounts.append(", ");
                paymentAccounts.append(paymentAccount.getId());
            }
        }
        return "User [" + id + "]" +
                "\n\tlastName='" + lastName + '\'' +
                "\n\tfirstName='" + firstName + '\'' +
                "\n\tpatronymic='" + patronymic + '\'' +
                "\n\tbirthDate='" + birthDate + '\'' +
                "\n\tworkplace='" + workplace + '\'' +
                "\n\tmonthlyIncome=" + monthlyIncome +
                usedBanks +
                creditAccounts +
                paymentAccounts +
                "\n\tcreditRating=" + creditRating;
    }
}
