package org.romanov.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;                                                        // Id клиента
    private String lastName;                                                // Фамилия
    private String firstName;                                               // Имя
    private String patronymic;                                              // Отчество
    private LocalDate birthDate;                                            // Дата рождения
    private String workplace;                                               // Место работы
    private double monthlyIncome;                                           // Ежемесячный доход (генерируется рандомно, но не более 10 000)
    private Map<Long, Bank> usedBanks = new HashMap<>();                    // Банки, которыми он пользуется
    private Map<Long, CreditAccount> creditAccounts = new HashMap<>();      // Кредитные счета (по умолчанию пусто)
    private Map<Long, PaymentAccount> paymentAccounts = new HashMap<>();    // Платежные счета (по умолчанию пусто)
    private int creditRating;                                               // Кредитный рейтинг для банка (генерируется рандомно исходя из ежемесячного дохода, от меньше 1 000 – 100, от 1 000 до 2 000 – 200 и т.д. вплоть до 10 000)

    @Override
    public String toString() {
        StringBuilder usedBanks = new StringBuilder();
        if (this.usedBanks != null && !this.usedBanks.isEmpty()) {
            for (Bank bank : this.usedBanks.values()) {
                if (usedBanks.isEmpty()) usedBanks = new StringBuilder(", usedBanks=[");
                else usedBanks.append(", ");
                usedBanks.append(bank.getName());
            }
            usedBanks.append("]");
        }
        StringBuilder creditAccounts = new StringBuilder();
        if (this.creditAccounts != null && !this.creditAccounts.isEmpty()) {
            for (CreditAccount creditAccount : this.creditAccounts.values()) {
                if (creditAccounts.isEmpty()) creditAccounts = new StringBuilder(", ID creditAccounts=[");
                else creditAccounts.append(", ");
                creditAccounts.append(creditAccount.getId());
            }
            creditAccounts.append("]");
        }
        StringBuilder paymentAccounts = new StringBuilder();
        if (this.paymentAccounts != null && !this.paymentAccounts.isEmpty()) {
            for (PaymentAccount paymentAccount : this.paymentAccounts.values()) {
                if (paymentAccounts.isEmpty()) paymentAccounts = new StringBuilder(", ID paymentAccounts=[");
                else paymentAccounts.append(", ");
                paymentAccounts.append(paymentAccount.getId());
            }
            paymentAccounts.append("]");
        }
        String birth_date = birthDate.getDayOfMonth() + "." + birthDate.getMonthValue() + "." + birthDate.getYear();
        return "User" +
                " id=" + id +
                ", fullName='" + lastName +
                " " + firstName +
                (!patronymic.trim().isEmpty() ? " " + patronymic : "") + '\'' +
                ", birthDate='" + birth_date + '\'' +
                ", workplace='" + workplace + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                usedBanks +
                creditAccounts +
                paymentAccounts +
                ", creditRating=" + creditRating;
    }
}
