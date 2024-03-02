package org.romanov.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccount {
    private int id;                         // Id кредитного счета
    private User user;                      // Пользователь, за которым закреплен этот кредитный счет
    private String bankName;                // Название банка, где взят кредит
    private LocalDate startDate;            // Дата начала кредита
    private LocalDate endDate;              // Дата окончания кредита
    private int months;                     // Количество месяцев, на которые взят кредит
    private double loanAmount;              // Сумма кредита
    private double monthlyPayment;          // Ежемесячный платеж
    private double interestRate;            // Процентная ставка (должна быть равной процентной ставке банка, в котором взят кредит или ниже)
    private Employee issuingEmployee;       // Сотрудник, который выдал кредит
    private PaymentAccount paymentAccount;  // Платежный счет в банке с которого будет осуществляться погашение данного кредита

    @Override
    public String toString() {
        return "Credit Account [" + id + "]" +
                "\n\tID user=" + user.getId() +
                "\n\tbankName='" + bankName + '\'' +
                "\n\tstartDate=" + startDate +
                "\n\tendDate=" + endDate +
                "\n\tmonths=" + months +
                "\n\tloanAmount=" + loanAmount +
                "\n\tmonthlyPayment=" + monthlyPayment +
                "\n\tinterestRate=" + interestRate +
                "\n\tID issuingEmployee=" + issuingEmployee.getId() +
                "\n\tID paymentAccount=" + paymentAccount.getId();
    }
}
