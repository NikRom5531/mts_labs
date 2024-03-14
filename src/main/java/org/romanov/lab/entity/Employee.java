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
public class Employee {
    private long id;                    // Id сотрудника
    private String lastName;            // Фамилия
    private String firstName;           // Имя
    private String patronymic;          // Отчество
    private LocalDate birthDate;        // Дата рождения
    private String position;            // Должность
    private Bank bank;                  // Банк, в котором работает сотрудник
    private BankOffice bankOffice;      // Банковский офис, в котором работает сотрудник
    private boolean worksInOffice;      // Работает ли в банковском офисе или удалённо (да/нет)
    private boolean canIssueCredits;    // Может ли выдавать кредиты? (да/нет)
    private double salary;              // Размер зарплаты

    @Override
    public String toString() {
        String birth_date = birthDate.getDayOfMonth() + "." + birthDate.getMonthValue() + "." + birthDate.getYear();
        return "Employee" +
                " id=" + id +
                ", fullName='" + lastName +
                " " + firstName +
                (!patronymic.trim().isEmpty() ? " " + patronymic : "") + '\'' +
                ", birthDate=" + birth_date +
                ", position='" + position + '\'' +
                ", ID bank=" + bank.getId() +
                ", ID bankOffice=" + bankOffice.getId() +
                ", worksInOffice=" + worksInOffice +
                ", canIssueCredits=" + canIssueCredits +
                ", salary=" + salary;
    }
}
