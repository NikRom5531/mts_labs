package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.service.BankService;

import java.math.BigDecimal;
import java.util.Random;

public class BankServiceImpl implements BankService {
    private static final Random RANDOM = new Random();
    private Bank bank;
    public BankServiceImpl(){
        this.bank = new Bank();
    }

    @Override
    public void create(int id, String name) {
        bank.setId(id);
        bank.setName(name);
        int rating = RANDOM.nextInt(101);
        double totalMoney = (double) (Math.round((RANDOM.nextDouble() * 1_000_000) * 100)) / 100;
        bank.setRating(rating);
        bank.setTotalMoney(totalMoney);
        bank.setInterestRate(BigDecimal.valueOf(20).subtract(BigDecimal.valueOf(rating).multiply(BigDecimal.valueOf(0.2))).doubleValue());
    }

    @Override
    public Bank read() {
        return bank;
    }

    @Override
    public void update(int id, String name, int quantityOffices, int quantityATM, int quantityEmployees, int quantityClients, int rating, double totalMoney) {
        bank.setId(id);
        bank.setName(name);
        bank.setQuantityOffices(quantityOffices);
        bank.setQuantityATM(quantityATM);
        bank.setQuantityEmployees(quantityEmployees);
        bank.setQuantityClients(quantityClients);
        bank.setRating(rating);
        bank.setTotalMoney(totalMoney);
        bank.setInterestRate(BigDecimal.valueOf(20).subtract(BigDecimal.valueOf(rating).multiply(BigDecimal.valueOf(0.2))).doubleValue());
    }

    @Override
    public void delete(int id) {
        // Реализация удаления
    }
}
