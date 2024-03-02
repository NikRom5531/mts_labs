package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.CreditAccount;
import org.romanov.lab.entity.PaymentAccount;
import org.romanov.lab.entity.User;
import org.romanov.lab.service.UserService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class UserServiceImpl implements UserService {
    private static final Random RANDOM = new Random();
    private User user;

    public UserServiceImpl() {
        this.user = new User();
    }

    @Override
    public void create(int id, String lastName, String firstName, String patronymic, LocalDate birthDate, String workplace, List<Bank> usedBanksIds) {
        user.setId(id);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setPatronymic(patronymic);
        user.setBirthDate(birthDate);
        user.setWorkplace(workplace);
        double monthlyIncome = (double) (Math.round((RANDOM.nextDouble() * 10_000) * 100)) / 100;
        user.setMonthlyIncome(monthlyIncome);
        for (Bank bank : usedBanksIds) bank.setQuantityClients(bank.getQuantityClients() + 1);
        user.setUsedBanksIds(usedBanksIds);
        user.setCreditRating(getCreditRating(monthlyIncome));
    }

    private int getCreditRating(double monthlyIncome) {
        int creditRating = 100; // Минимальный рейтинг
        for (int i = 1_000; i <= 10_000; i += 1_000) {
            if (monthlyIncome < i) {
                creditRating += 100;
                break;
            } else creditRating += 100;
        }
        return Math.min(creditRating, 1000); // Ограничение максимального рейтинга
    }


    @Override
    public User read() {
        return user;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete(int id) {

    }
}
