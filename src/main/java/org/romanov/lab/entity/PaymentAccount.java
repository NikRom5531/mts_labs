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
    private int id;                 // Id платёжного счета
    private User user;              // Пользователь, за которым закреплен этот платежный счет
    private String bankName;        // Название банка, в котором открыт этот счет
    private double balance = 0.0;   // Сумма, которая лежит в данный момент на счету (по умолчанию 0)

    @Override
    public String toString() {
        return "Payment Account [" + id + "]" +
                "\n\tuser=" + user.getId() +
                "\n\tbankName='" + bankName + '\'' +
                "\n\tbalance=" + balance;
    }
}
