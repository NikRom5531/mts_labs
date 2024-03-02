package org.romanov.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAtm {
    private int id;                         // Id банкомата
    private String name;                    // Имя банкомата
    private String address;                 // Адрес (сопадает с адресом банковского офиса)
    private int status;                     // Статус (работает/не работает/нет денег)
    private BankOffice bankOffice;          // Банк, которому принадлежит банкомат
    private String location;                // Расположение банкомата (банкомат может быть расположен только в банковском офисе)
    private Employee servicingEmployee;     // Обслуживающий сотрудник
    private boolean cashWithdrawal;         // Работает ли на выдачу денег? (да/нет)
    private boolean cashDeposit;            // Можно ли внести деньги? (да/нет)
    private double totalMoney;              // Количество денег в банкомате (зависит от всего денег в банке)
    private double maintenanceCost;         // Стоимость обслуживания банкомата

    @Override
    public String toString() {
        return "ATM [" + id + "]" +
                "\n\tname='" + name + '\'' +
                "\n\taddress='" + address + '\'' +
                "\n\tstatus=" + status +
                "\n\tID bankOffice=" + bankOffice.getId() +
                "\n\tlocation='" + location + '\'' +
                "\n\tID servicingEmployee=" + servicingEmployee.getId() +
                "\n\tcashWithdrawal=" + cashWithdrawal +
                "\n\tcashDeposit=" + cashDeposit +
                "\n\ttotalMoney=" + totalMoney +
                "\n\tmaintenanceCost=" + maintenanceCost;
    }
}
