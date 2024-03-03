package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.PaymentAccount;
import org.romanov.lab.entity.User;
import org.romanov.lab.service.PaymentAccountService;

/**
 * Реализация интерфейса PaymentAccountService для управления информацией о платежных счетах пользователей банка.
 */
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private PaymentAccount paymentAccount;

    /**
     * Конструктор класса PaymentAccountServiceImpl, создает новый объект PaymentAccount.
     */
    public PaymentAccountServiceImpl() {
        this.paymentAccount = new PaymentAccount();
    }

    /**
     * Создает новый платежный счет с заданными параметрами.
     *
     * @param id      Идентификатор платежного счета.
     * @param user    Пользователь, которому принадлежит платежный счет.
     * @param bank    Банк, в котором открыт платежный счет.
     * @param balance Баланс платежного счета.
     */
    @Override
    public void create(int id, User user, Bank bank, double balance) {
        paymentAccount.setId(id);
        paymentAccount.setUser(user);
        paymentAccount.setBankName(bank.getName());
        paymentAccount.setBalance(balance);
    }

    /**
     * Возвращает информацию о текущем платежном счете.
     *
     * @return Объект класса {@link PaymentAccount}, представляющий платежный счет.
     */
    @Override
    public PaymentAccount read() {
        return paymentAccount;
    }

    /**
     * Обновляет информацию о платежном счете.
     */
    @Override
    public void update() {

    }

    /**
     * Удаляет платежный счет по указанному идентификатору.
     *
     * @param id Идентификатор платежного счета для удаления.
     */
    @Override
    public void delete(int id) {

    }
}
