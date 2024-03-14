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
    private long id;                        // Id кредитного счета
    private User user;                      // Пользователь, за которым закреплен этот кредитный счет
    private Bank bank;                      // Название банка, где взят кредит
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
        String start_date = startDate.getDayOfMonth() + "." + startDate.getMonthValue() + "." + startDate.getYear();
        String end_date = endDate.getDayOfMonth() + "." + endDate.getMonthValue() + "." + endDate.getYear();
        return "Credit Account" +
                " id=" + id +
                ", ID user=" + user.getId() +
                ", bankName='" + bank.getName() + '\'' +
                ", startDate=" + start_date +
                ", endDate=" + end_date +
                ", months=" + months +
                ", loanAmount=" + loanAmount +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", ID issuingEmployee=" + issuingEmployee.getId() +
                ", ID paymentAccount=" + paymentAccount.getId();
    }
}
