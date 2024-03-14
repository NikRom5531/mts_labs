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
    private long id;                        // Id банкомата
    private String name;                    // Имя банкомата
    private String address;                 // Адрес (сопадает с адресом банковского офиса)
    private int status;                     // Статус (работает/не работает/нет денег)
    private BankOffice bankOffice;          // Банк, которому принадлежит банкомат
    private String location;                // Расположение банкомата (банкомат может быть расположен только в банковском офисе)
    private Employee servicingEmployee;     // Обслуживающий сотрудник
    private boolean cashWithdrawal;         // Работает ли на выдачу денег? (да/нет)
    private boolean cashDeposit;            // Можно ли внести деньги? (да/нет)
    private double maintenanceCost;         // Стоимость обслуживания банкомата

    @Override
    public String toString() {
        return "ATM" +
                " id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", bankName=" + bankOffice.getBank().getName() +
                ", location='" + location + '\'' +
                ", ID servicingEmployee=" + servicingEmployee.getId() +
                ", cashWithdrawal=" + cashWithdrawal +
                ", cashDeposit=" + cashDeposit +
                ", totalMoney=" + bankOffice.getBank().getTotalMoney() +
                ", maintenanceCost=" + maintenanceCost;
    }
}
