package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.BankOffice;
import org.romanov.lab.entity.Employee;
import org.romanov.lab.service.EmployeeService;

import java.time.LocalDate;
import java.util.Date;

/**
 * Реализация интерфейса EmployeeService для управления информацией о сотрудниках банка.
 */
public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee;

    /**
     * Конструктор класса EmployeeServiceImpl, создает новый объект Employee.
     */
    public EmployeeServiceImpl() {
        this.employee = new Employee();
    }

    /**
     * Создает нового сотрудника с заданными параметрами.
     *
     * @param id               Идентификатор сотрудника.
     * @param lastName         Фамилия сотрудника.
     * @param firstName        Имя сотрудника.
     * @param patronymic       Отчество сотрудника.
     * @param birthDate        Дата рождения сотрудника.
     * @param position         Должность сотрудника.
     * @param bank             Банк, в котором работает сотрудник.
     * @param bankOffice       Офис банка, в котором работает сотрудник.
     * @param worksInOffice    Работает ли сотрудник в офисе (true - да, false - нет).
     * @param canIssueCredits  Может ли сотрудник выдавать кредиты (true - да, false - нет).
     * @param salary           Зарплата сотрудника.
     */
    @Override
    public void create(int id, String lastName, String firstName, String patronymic, LocalDate birthDate, String position, Bank bank, BankOffice bankOffice, boolean worksInOffice, boolean canIssueCredits, double salary) {
        employee.setId(id);
        employee.setLastName(lastName);
        employee.setFirstName(firstName);
        employee.setPatronymic(patronymic);
        employee.setBirthDate(birthDate);
        employee.setPosition(position);
        bank.setQuantityEmployees(bank.getQuantityEmployees() + 1);
        employee.setBank(bank);
        employee.setBankOffice(bankOffice);
        employee.setWorksInOffice(worksInOffice);
        employee.setCanIssueCredits(canIssueCredits);
        employee.setSalary(salary);
    }

    /**
     * Возвращает информацию о текущем сотруднике.
     *
     * @return Объект класса {@link Employee}, представляющий сотрудника.
     */
    @Override
    public Employee read() {
        return employee;
    }

    /**
     * Обновляет информацию о сотруднике.
     */
    @Override
    public void update() {

    }

    /**
     * Удаляет сотрудника по указанному идентификатору.
     *
     * @param id Идентификатор сотрудника для удаления.
     */
    @Override
    public void delete(int id) {

    }
}
