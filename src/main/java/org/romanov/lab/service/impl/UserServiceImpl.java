package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.User;
import org.romanov.lab.service.UserService;
import org.romanov.lab.utils.EntityMaps;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * Реализация интерфейса UserService для управления информацией о клиентах банка.
 */
public class UserServiceImpl implements UserService {
    private static final Random RANDOM = new Random();

    @Override
    public void create(long id, String lastName, String firstName, String patronymic, LocalDate birthDate, String workplace, List<Bank> bankList) {
        if (read(id) == null) {
            User user = new User();
            user.setId(id);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setPatronymic(patronymic);
            user.setBirthDate(birthDate);
            user.setWorkplace(workplace);
            double monthlyIncome = (double) (Math.round((RANDOM.nextDouble() * 10_000) * 100)) / 100;
            user.setMonthlyIncome(monthlyIncome);
            user.setCreditRating(getCreditRating(monthlyIncome));
            for (Bank bank : bankList) {
                user.getUsedBanks().put(bank.getId(), bank);
                bank.getUserMap().put(id, user);
            }
        }
    }

    @Override
    public User read(long id) {
        User user = null;
        for (Bank bank : EntityMaps.bankMap.values()) {
            if (bank.getUserMap().containsKey(id)){
                user = bank.getUserMap().get(id);
                break;
            }
        }
        return user;
    }

    @Override
    public void update(long id, User user) {
        User oldUser = read(id);
        if (oldUser != null && user != null) {
            user.setCreditRating(getCreditRating(user.getMonthlyIncome()));
            if (!user.getUsedBanks().isEmpty()) {
                for (Bank bank : oldUser.getUsedBanks().values()) bank.getUserMap().remove(id);
                for (Bank bank : user.getUsedBanks().values()) bank.getUserMap().put(id, user);
            } else delete(id);
        }
    }

    @Override
    public void delete(long id) {
        User user = read(id);
        if (user != null) for (Bank bank : user.getUsedBanks().values()) bank.getUserMap().remove(id);
    }

    /**
     * Возвращает кредитный рейтинг клиента в зависимости от его ежемесячного дохода.
     *
     * @param monthlyIncome     Ежемесячный доход клиента.
     * @return                  Кредитный рейтинг клиента.
     */
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
}
