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
public class Bank {
    private long id;                                                // Id банка
    private String name;                                            // Название банка
    private Map<Long, BankOffice> bankOfficeMap = new HashMap<>();  // Офисы банка
    private Map<Long, Employee> employeeMap = new HashMap<>();      // Сотрудники банка
    private Map<Long, User> userMap = new HashMap<>();              // Клиенты банка
    private int rating;                                             // Рейтинг банка (генерируется рандомно, от 0 до 100, где 100 наивысший балл, чем выше рейтинг банка, тем меньше должна быть процентная ставка)
    private double totalMoney;                                      // Всего денег в банке (генерируется рандомно, но не более 1 000 000)
    private double interestRate;                                    // Процентная ставка (генерируется рандомно, но не более 20%, однако нужно учитывать рейтинг банка, чем он выше, тем ставка должна сгенерироваться меньше)

    @Override
    public String toString() {
        int quantityAtm_s = 0;
        for (BankOffice bankOffice : bankOfficeMap.values()) quantityAtm_s += bankOffice.getBankAtmMap().size();
        return "Bank:" +
                " id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantityOffices=" + bankOfficeMap.size() +
                ", quantityATM=" + quantityAtm_s +
                ", quantityEmployees=" + employeeMap.size() +
                ", quantityClients=" + userMap.size() +
                ", rating=" + rating +
                ", totalMoney=" + totalMoney +
                ", interestRate=" + interestRate;
    }
}
