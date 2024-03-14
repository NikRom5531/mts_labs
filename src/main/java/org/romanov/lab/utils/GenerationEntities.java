package org.romanov.lab.utils;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.Employee;
import org.romanov.lab.entity.User;
import org.romanov.lab.service.*;
import org.romanov.lab.service.impl.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

public class GenerationEntities {
    private static final BankService bankService = new BankServiceImpl();
    private static final BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
    private static final EmployeeService employeeService = new EmployeeServiceImpl();
    private static final AtmService atmService = new AtmServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static final PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
    private static final CreditAccountService creditAccountService = new CreditAccountServiceImpl();
    private static final Random RANDOM = new Random();

    private static final int numBanks = 5;      // кол-во генерируемых банков
    private static final int numOffices = 3;    // кол-во генерируемых офисов в одном банке
    private static final int numEmployees = 5;  // кол-во генерируемых сотрудников в одном банке
    private static final int numUsers = 13;     // кол-во клиентов

    private static final List<String> bankNames = List.of("Сбер", "Газпром", "ВТБ", "Почта", "Тинькофф");
    private static final List<String> namePositions = List.of("Менеджер", "Старший сотрудник", "Специалист", "Кассир", "Младший сотрудник");
    private static final List<String> nameAtmLocation = List.of("Зал 1", "Зал 2", "2 этаж");
    private static final List<String> m_lastnames = Arrays.asList(
            "Иванов", "Петров", "Сидоров", "Козлов", "Михайлов",
            "Васильев", "Алексеев", "Егоров", "Николаев", "Кузнецов",
            "Ковалев", "Борисов", "Григорьев", "Дмитриев", "Федоров"
    );
    private static final List<String> m_names = Arrays.asList(
            "Иван", "Петр", "Сидор", "Александр", "Михаил",
            "Василий", "Алексей", "Егор", "Николай", "Артем",
            "Андрей", "Борис", "Григорий", "Дмитрий", "Федор"
    );
    private static final List<String> m_patronymics = Arrays.asList(
            "Иванович", "Петрович", "Сидорович", "Александрович", "Михайлович",
            "Васильевич", "Алексеевич", "Егорович", "Николаевич", "Артемович",
            "Андреевич", "Борисович", "Григорьевич", "Дмитриевич", "Федорович"
    );

    /**
     * Генерация случайной даты в указанном диапазоне лет.
     *
     * @param startYear начальный год
     * @param endYear   конечный год
     * @return случайная дата в диапазоне
     */
    public static LocalDate randomDate(int startYear, int endYear) {
        int dayOfYear = RANDOM.nextInt(1, 366);
        int year = RANDOM.nextInt(startYear, endYear + 1);
        return LocalDate.ofYearDay(year, dayOfYear);
    }

    /**
     * Генерация случайного целого числа в заданном диапазоне.
     *
     * @param num1 начальное значение диапазона
     * @param num2 конечное значение диапазона
     * @return случайное целое число
     */
    public static int randomInt(int num1, int num2) {
        int min = Integer.min(num1, num2);
        int max = Integer.max(num1, num2);
        return RANDOM.nextInt(max - min + 1) + min;
    }

    /**
     * Генерация случайного целого числа в заданном диапазоне.
     *
     * @param num максимальное значение диапазона
     * @return случайное целое число
     */
    public static int randomInt(int num) {
        return RANDOM.nextInt(num);
    }

    /**
     * Получение случайной фамилии из списка.
     *
     * @return случайная фамилия
     */
    public static String getLastName() {
        return m_lastnames.get(randomInt(m_lastnames.size()));
    }

    /**
     * Получение случайного имени из списка.
     *
     * @return случайное имя
     */
    public static String getFirstName() {
        return m_names.get(randomInt(m_names.size()));
    }

    /**
     * Получение случайного отчества из списка.
     *
     * @return случайное отчество
     */
    public static String getPatronymic() {
        return m_patronymics.get(randomInt(m_patronymics.size()));
    }

    /**
     * Генерация случайного вещественного числа в заданном диапазоне.
     *
     * @param min     минимальное значение диапазона
     * @param max     максимальное значение диапазона
     * @return случайное вещественное число
     */
    public static double randomDouble(double min, double max) {
        double randomValue = min + (max - min) * RANDOM.nextDouble();
        return BigDecimal.valueOf(randomValue)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * Генерация случайных сущностей.
     */
    public static void generation() {
        long idOffice = 0, idEmployee = 0, idUser = 0, idAtm = 0, idCreditAccount = 0, idPaymentAccount = 0;
        for (int i = 0; i < numBanks; i++) {
            long idBank = EntityMaps.getFreeId();
            bankService.create(idBank, bankNames.get(i % bankNames.size()));
            for (int j = 0; j < numOffices; j++, idOffice++, idAtm++) {
                bankOfficeService.create(idOffice, "Отделение банка №" + (j + 1), bankService.read(idBank), "г. Белгород, ул. Победы " + (idOffice + 1), true, true, true, true, true, randomDouble(1000, 10000));
                for (int k = 0; k < numEmployees; k++, idEmployee++)
                    employeeService.create(idEmployee, getLastName(), getFirstName(), getPatronymic(), randomDate(1964, 2004), namePositions.get(k % namePositions.size()), bankService.read(idBank), bankOfficeService.read(idOffice), true, true, randomDouble(20000, 50000));
                atmService.create(idAtm, "Банкомат №" + (j + 1), 1, bankOfficeService.read(idOffice), nameAtmLocation.get(j % nameAtmLocation.size()), employeeService.read(idEmployee - 3), true, true, randomDouble(100, 1000));
            }
        }
        Map<Long, Bank> banks = EntityMaps.bankMap;
        List<Long> bankIds = new ArrayList<>();
        for (Bank bank : banks.values()) bankIds.add(bank.getId());

        int usedBankIds = 0;
        for (int i = 0; i < numUsers; i++, idUser++) {
            if (usedBankIds >= bankIds.size()) usedBankIds = 0;
            Bank bank1 = banks.get(bankIds.get(usedBankIds++));
            if (usedBankIds >= bankIds.size()) usedBankIds = 0;
            Bank bank2 = banks.get(bankIds.get(usedBankIds++));
            List<Bank> bankList = new ArrayList<>(List.of(bank1, bank2));
            userService.create(idUser, getLastName(), getFirstName(), getPatronymic(), randomDate(1964, 2004), "Работа " + (i + 1), bankList);
            User user = userService.read(idUser);

            for (int j = 0; j < 2; j++, idPaymentAccount++, idCreditAccount++) {
                Bank bank = bankList.get(j);

                Map<Long, Employee> employeeMap = bank.getEmployeeMap();
                List<Long> employeeIds = new ArrayList<>();
                for (Employee employee : employeeMap.values()) employeeIds.add(employee.getId());

                paymentAccountService.create(idPaymentAccount, user, bank, randomDouble(100, 5000));
                creditAccountService.create(idCreditAccount, user, bank, LocalDate.now(), randomInt(1, 60), randomDouble(10000, 1000000), randomDouble(0, 20), bank.getEmployeeMap().get(employeeIds.get(1)), paymentAccountService.read(idPaymentAccount));
            }
            userService.update(idUser, user);
        }
    }
}
