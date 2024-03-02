package org.romanov.lab;

import org.romanov.lab.service.*;
import org.romanov.lab.service.impl.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankServiceImpl();
        BankOfficeService bankOffice = new BankOfficeServiceImpl();
        EmployeeService employee = new EmployeeServiceImpl();
        AtmService atm = new AtmServiceImpl();
        UserService user = new UserServiceImpl();
        PaymentAccountService paymentAccount = new PaymentAccountServiceImpl();
        CreditAccountService creditAccount = new CreditAccountServiceImpl();

        bank.create(1, "Сбер");
        bankOffice.create(1, "Отделение СберБанка", bank.read(),"г. Белгород, ул. Победа 85", true, true, true, true, true, 1000);
        employee.create(1, "Иванов", "Иван", "Иванович", LocalDate.of(1989, 2, 8), "Директор", bank.read(), bankOffice.read(), true, true, 28_000);
        atm.create(1, "Банкомат №1", 1, bankOffice.read(), "2 этаж", employee.read(), true, true, 100);
        user.create(1, "Петров", "Пётр", "Петрович", LocalDate.of(1993, 12, 20), "ООО \"Казино 777\"", List.of(bank.read()));
        paymentAccount.create(1, user.read(), bank.read(), 1250);
        creditAccount.create(1, user.read(), bank.read(), LocalDate.now(), 12, 100000, 10, employee.read(), paymentAccount.read());

        System.out.println(bank.read());
        System.out.println(bankOffice.read());
        System.out.println(employee.read());
        System.out.println(atm.read());
        System.out.println(user.read());
        System.out.println(paymentAccount.read());
        System.out.println(creditAccount.read());
    }
}
