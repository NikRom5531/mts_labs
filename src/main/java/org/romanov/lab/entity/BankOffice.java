package org.romanov.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankOffice {
    private long id;                                            // Id банковского офиса
    private Bank bank;                                          // Банк офиса
    private String name;                                        // Название офиса
    private String address;                                     // Адрес банковского офиса
    private boolean status;                                     // Статус (работает/не работает)
    private boolean canPlaceAtm;                                // Можно ли разместить банкомат? (да/нет)
    private Map<Long, BankAtm> bankAtmMap = new HashMap<>();    // Банкоманты в офисе
    private boolean canProvideCredit;                           // Можно ли оформить кредит в данном офисе? (да/нет)
    private boolean cashWithdrawal;                             // Работает ли на выдачу денег? (да/нет)
    private boolean cashDeposit;                                // Можно ли внести деньги? (да/нет)
    private double rentCost;                                    // Стоимость аренды банковского офиса

    @Override
    public String toString() {
        return "Bank Office" +
                " id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bankName='" + bank.getName() + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", canPlaceAtm=" + canPlaceAtm +
                ", quantityAtms=" + bankAtmMap.size() +
                ", canProvideCredit=" + canProvideCredit +
                ", cashWithdrawal=" + cashWithdrawal +
                ", cashDeposit=" + cashDeposit +
                ", totalMoney=" + bank.getTotalMoney() +
                ", rentCost=" + rentCost;
    }
}
