package org.romanov.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private int id;                     // Id банка
    private String name;                // Название банка
    private int quantityOffices = 0;    // Кол-во офисов (заполняется и считается автоматически при добавлении нового офиса), по умолчанию 0
    private int quantityATM = 0;        // Кол-во банкоматов (заполняется и считается автоматически при добавлении нового банкомата), по умолчанию 0
    private int quantityEmployees = 0;  // Кол-во сотрудников (заполняется и считается автоматически при добавлении нового сотрудника), по умолчанию 0
    private int quantityClients = 0;    // Кол-во клиентов (заполняется и считается автоматически при добавлении нового клиента в банк), по умолчанию 0
    private int rating;                 // Рейтинг банка (генерируется рандомно, от 0 до 100, где 100 наивысший балл, чем выше рейтинг банка, тем меньше должна быть процентная ставка)
    private double totalMoney;          // Всего денег в банке (генерируется рандомно, но не более 1 000 000)
    private double interestRate;        // Процентная ставка (генерируется рандомно, но не более 20%, однако нужно учитывать рейтинг банка, чем он выше, тем ставка должна сгенерироваться меньше)

    @Override
    public String toString() {
        return "Bank [" + id + "]" +
                "\n\tname='" + name + '\'' +
                "\n\tquantityOffices=" + quantityOffices +
                "\n\tquantityATM=" + quantityATM +
                "\n\tquantityEmployees=" + quantityEmployees +
                "\n\tquantityClients=" + quantityClients +
                "\n\trating=" + rating +
                "\n\ttotalMoney=" + totalMoney +
                "\n\tinterestRate=" + interestRate;
    }
}
