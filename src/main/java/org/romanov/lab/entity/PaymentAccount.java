package org.romanov.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAccount {
    private long id;                // Id платёжного счета
    private User user;              // Пользователь, за которым закреплен этот платежный счет
    private Bank bank;              // Название банка, в котором открыт этот счет
    private double balance = 0.0;   // Сумма, которая лежит в данный момент на счету (по умолчанию 0)

    @Override
    public String toString() {
        return "Payment Account" +
                " id=" + id +
                ", user=" + user.getId() +
                ", bankName='" + bank.getName() + '\'' +
                ", balance=" + balance;
    }
}
