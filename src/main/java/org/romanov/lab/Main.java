package org.romanov.lab;

import org.romanov.lab.entity.*;
import org.romanov.lab.utils.EntityMaps;
import org.romanov.lab.utils.GenerationEntities;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        GenerationEntities.generation();
        main_menu();
    }

    private static void main_menu() {
        boolean flag = true;
        while (flag) {
            System.out.print("""
                    Главное меню:
                    1. Вывод всех данных по банку.
                    2. Вывод всей информации по клиенту.
                    0. Завершить программу.
                    """);
            System.out.print("Введите номер пункта: ");
            switch (inputInteger()) {
                case 0 -> flag = false;
                case 1 -> menuBank();
                case 2 -> menuClient();
                default -> errorMessage();
            }
        }
    }

    /**
     * Метод для работы с меню вывода данных по банку.
     */
    private static void menuBank() {
        boolean flag = true;
        while (flag) {
            Map<Long, Bank> banks = EntityMaps.bankMap;
            List<Long> bankIds = new ArrayList<>();
            System.out.println("\nМеню вывода всех данных по банку:");
            System.out.println(" 0. Вернуться назад.");
            int id = 0;
            for (Bank bank : banks.values()) {
                bankIds.add(bank.getId());
                System.out.println("[" + ++id + "] " + bank.getName() + ".");
            }
            System.out.print("Введите [порядковый номер] банка: ");

            int input = inputInteger() - 1;
            if (input == -1) flag = false;
            else {
                if (0 <= input && input < banks.size()) outputOfBank(banks.get(bankIds.get(input)));
                else errorMessage();
            }
        }
    }

    /**
     * Метод для вывода всех данных по банку.
     *
     * @param bank объект класса {@link Bank}
     */
    private static void outputOfBank(Bank bank) {
        Map<Long, BankOffice> bankOfficeMap = bank.getBankOfficeMap();
        Map<Long, BankAtm> bankAtmMap = new HashMap<>();
        System.out.println("Банк: " + bank);
        System.out.println("Офисы: " + bankOfficeMap.size());
        for (BankOffice bankOffice : bankOfficeMap.values()) {
            System.out.println(bankOffice);
            bankAtmMap.putAll(bankOffice.getBankAtmMap());
        }
        System.out.println("Банкоматы: " + bankAtmMap.size());
        for (BankAtm bankAtm : bankAtmMap.values()) System.out.println(bankAtm);

        Map<Long, Employee> employeeMap = bank.getEmployeeMap();
        System.out.println("Сотрудники: " + employeeMap.size());
        for (Employee employee : employeeMap.values()) System.out.println(employee);

        Map<Long, User> userMap = bank.getUserMap();
        System.out.println("Клиенты: " + userMap.size());
        for (User user : userMap.values()) System.out.println(user);
    }

    /**
     * Метод для работы с меню вывода информации по клиенту.
     */
    private static void menuClient() {
        boolean flag = true;
        while (flag) {
            System.out.println("\nМеню вывода всей информации по клиенту:");
            System.out.println(" 0. Вернуться назад.");
            Map<Long, User> userMap = new HashMap<>();
            List<Long> userIds = new ArrayList<>();
            int id = 0;
            for (Bank bank : EntityMaps.bankMap.values())
                for (User user : bank.getUserMap().values())
                    if (!userMap.containsKey(user.getId())) {
                        userIds.add(user.getId());
                        userMap.put(user.getId(), user);
                        System.out.println("[" + ++id + "] " + user);
                    }
            System.out.print("Введите [порядковый номер] клиента: ");
            int input = inputInteger() - 1;
            if (input == -1) flag = false;
            else {
                if (0 <= input && input < userMap.size()) outputOfClient(userMap.get(userIds.get(input)));
                else errorMessage();
            }
        }
    }

    /**
     * Метод для вывода всей информации по клиенту.
     *
     * @param user объект класса {@link User}
     */
    private static void outputOfClient(User user) {
        System.out.println("\nКлиент: " + user.getLastName() + " " + user.getFirstName() + (!user.getPatronymic().trim().isEmpty() ? " " + user.getPatronymic() : "") +
                ", Дата рождения: " + user.getBirthDate().getDayOfMonth() + "." + user.getBirthDate().getMonthValue() + "." + user.getBirthDate().getYear() +
                ", Место работы: " + user.getWorkplace() + ", Ежемесячный доход: " + user.getMonthlyIncome() +
                ", Кредитный рейтинг: " + user.getCreditRating()
        );
        for (PaymentAccount paymentAccount : user.getPaymentAccounts().values()) {
            System.out.println("Платёжный счёт: ID: " + paymentAccount.getId() +
                    ", Банк: " + paymentAccount.getBank().getName() +
                    ", Баланс: " + paymentAccount.getBalance());
        }
        for (CreditAccount creditAccount : user.getCreditAccounts().values()) {
            System.out.println("Кредитный счёт: ID: " + creditAccount.getId() +
                    ", Банк: " + creditAccount.getBank().getName() +
                    ", Дата начала: " + creditAccount.getStartDate().getDayOfMonth() + "." + creditAccount.getStartDate().getMonthValue() + "." + creditAccount.getStartDate().getYear() +
                    ", Кол-во месяцев: " + creditAccount.getMonths() +
                    ", Дата окончания: " + creditAccount.getEndDate().getDayOfMonth() + "." + creditAccount.getEndDate().getMonthValue() + "." + creditAccount.getEndDate().getYear() +
                    ", Сумма кредита: " + creditAccount.getLoanAmount() +
                    ", Сумма ежемесячного платежа: " + creditAccount.getMonthlyPayment() +
                    ", Процентная ставка: " + creditAccount.getInterestRate() + "% годовых" +
                    ", ID платёжного счёта: " + creditAccount.getPaymentAccount().getId());
        }
    }

    /**
     * Метод для ввода целочисленного значения с консоли.
     *
     * @return введенное целочисленное значение
     */
    public static int inputInteger() {
        Scanner in = new Scanner(System.in);
        String strInput = in.nextLine();
        int result;
        try {
            result = Integer.parseInt(strInput);
        } catch (NumberFormatException e) {
            result = -1;
        }
        return result;
    }

    /**
     * Метод для вывода сообщения об ошибке ввода.
     */
    public static void errorMessage() {
        System.out.println("Введено неверное значение!");
    }
}