package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.BankOffice;
import org.romanov.lab.entity.Employee;
import org.romanov.lab.service.EmployeeService;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee;

    public EmployeeServiceImpl() {
        this.employee = new Employee();
    }

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

    @Override
    public Employee read() {
        return employee;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete(int id) {

    }
}
