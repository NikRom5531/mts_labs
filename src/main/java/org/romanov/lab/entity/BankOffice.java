package org.romanov.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankOffice {
    private int id;                         // Id банковского офиса
    private Bank bank;                      // Банк офиса
    private String name;                    // Название офиса
    private String address;                 // Адрес банковского офиса
    private boolean status;                 // Статус (работает/не работает)
    private boolean canPlaceAtm;            // Можно ли разместить банкомат? (да/нет)
    private List<BankAtm> bankAtms = null;  // Банкоманты в офисе
    private int quantityAtms;               // Кол-во банкоматов в данном офисе (напрямую зависит от общего числа банкоматов у банка)
    private boolean canProvideCredit;       // Можно ли оформить кредит в данном офисе? (да/нет)
    private boolean cashWithdrawal;         // Работает ли на выдачу денег? (да/нет)
    private boolean cashDeposit;            // Можно ли внести деньги? (да/нет)
    private double totalMoney;              // Количество денег в банковском офисе (зависит от всего денег в банке)
    private double rentCost;                // Стоимость аренды банковского офиса

    @Override
    public String toString() {
        return "Bank Office [" + id + "]" +
                "\n\tname='" + name + '\'' +
                "\n\tbankName='" + bank.getName() + '\'' +
                "\n\taddress='" + address + '\'' +
                "\n\tstatus=" + status +
                "\n\tcanPlaceAtm=" + canPlaceAtm +
                "\n\tquantityAtms=" + quantityAtms +
                "\n\tcanProvideCredit=" + canProvideCredit +
                "\n\tcashWithdrawal=" + cashWithdrawal +
                "\n\tcashDeposit=" + cashDeposit +
                "\n\ttotalMoney=" + totalMoney +
                "\n\trentCost=" + rentCost;
    }
}
