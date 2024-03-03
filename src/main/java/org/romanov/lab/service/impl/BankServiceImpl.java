package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.service.BankService;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Реализация интерфейса {@link BankService} для управления банками.
 * <p>
 * Этот класс предоставляет методы для создания, чтения, обновления и удаления информации о банке.
 * </p>
 * <p>
 * Все методы этого класса предполагается использовать для манипуляции данными о банке.
 * </p>
 *
 * @see BankService
 */
public class BankServiceImpl implements BankService {
    private static final Random RANDOM = new Random();

    /**
     * Создает новый банк с указанными параметрами.
     *
     * @param id    Уникальный идентификатор банка.
     * @param name  Название банка.
     * @return      Созданный объект класса {@link Bank}.
     */
    @Override
    public Bank create(int id, String name) {
        Bank bank = new Bank();
        bank.setId(id);
        bank.setName(name);
        int rating = RANDOM.nextInt(101);
        double totalMoney = (double) (Math.round((RANDOM.nextDouble() * 1_000_000) * 100)) / 100;
        bank.setRating(rating);
        bank.setTotalMoney(totalMoney);
        bank.setInterestRate(BigDecimal.valueOf(20).subtract(BigDecimal.valueOf(rating).multiply(BigDecimal.valueOf(0.2))).doubleValue());
        return bank;
    }

    /**
     * Возвращает детали текущего банка.
     *
     * @param id    Уникальный идентификатор банка.
     * @return      Экземпляр {@link Bank}.
     */
    @Override
    public Bank read(int id) {
        return null;
    }

    /**
     * Обновляет информацию о банке с указанными параметрами.
     *
     * @param id                Уникальный идентификатор банка.
     * @param name              Название банка.
     * @param quantityOffices   Количество офисов в банке.
     * @param quantityATM       Количество банкоматов в банке.
     * @param quantityEmployees Количество сотрудников в банке.
     * @param quantityClients   Количество клиентов, связанных с банком.
     * @param rating            Рейтинг банка.
     * @param totalMoney        Общая сумма денег в банке.
     */
    @Override
    public void update(int id, String name, int quantityOffices, int quantityATM, int quantityEmployees, int quantityClients, int rating, double totalMoney) {
        Bank bank = read(id);
        bank.setName(name);
        bank.setQuantityOffices(quantityOffices);
        bank.setQuantityATM(quantityATM);
        bank.setQuantityEmployees(quantityEmployees);
        bank.setQuantityClients(quantityClients);
        bank.setRating(rating);
        bank.setTotalMoney(totalMoney);
        bank.setInterestRate(BigDecimal.valueOf(20).subtract(BigDecimal.valueOf(rating).multiply(BigDecimal.valueOf(0.2))).doubleValue());
    }

    /**
     * Удаляет банк с указанным идентификатором.
     *
     * @param id Уникальный идентификатор банка для удаления.
     */
    @Override
    public void delete(int id) {
        // Реализация удаления
    }
}
