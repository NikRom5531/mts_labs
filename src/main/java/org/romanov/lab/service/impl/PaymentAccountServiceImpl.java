package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.PaymentAccount;
import org.romanov.lab.entity.User;
import org.romanov.lab.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private PaymentAccount paymentAccount;

    public PaymentAccountServiceImpl() {
        this.paymentAccount = new PaymentAccount();
    }

    @Override
    public void create(int id, User user, Bank bank, double balance) {
        paymentAccount.setId(id);
        paymentAccount.setUser(user);
        paymentAccount.setBankName(bank.getName());
        paymentAccount.setBalance(balance);
    }

    @Override
    public PaymentAccount read() {
        return paymentAccount;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete(int id) {

    }
}
