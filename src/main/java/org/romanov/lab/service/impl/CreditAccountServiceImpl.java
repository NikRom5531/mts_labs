package org.romanov.lab.service.impl;

import org.romanov.lab.entity.*;
import org.romanov.lab.service.CreditAccountService;
import org.romanov.lab.utils.EntityMaps;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Реализация интерфейса CreditAccountService для управления кредитными счетами.
 */
public class CreditAccountServiceImpl implements CreditAccountService {
    @Override
    public void create(long id, User user, Bank bank, LocalDate startDate, int months, double loanAmount, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        if (read(id) == null){
            CreditAccount creditAccount = new CreditAccount();
            creditAccount.setId(id);
            creditAccount.setUser(user);
            creditAccount.setBank(bank);
            creditAccount.setStartDate(startDate);
            creditAccount.setMonths(months);
            creditAccount.setEndDate(startDate.plusMonths(months));
            creditAccount.setLoanAmount(loanAmount);
            if (interestRate > bank.getInterestRate()) interestRate = bank.getInterestRate();
            creditAccount.setInterestRate(interestRate);
            interestRate = interestRate / 100 / 12;
            double monthlyPayment;
            if (interestRate != 0) monthlyPayment = BigDecimal.valueOf(loanAmount).multiply(BigDecimal.valueOf(interestRate).add(BigDecimal.valueOf(interestRate).divide(BigDecimal.ONE.add(BigDecimal.valueOf(interestRate)).pow(months).subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP))).doubleValue();
            else monthlyPayment = loanAmount / months;
            creditAccount.setMonthlyPayment(BigDecimal.valueOf(monthlyPayment).setScale(2, RoundingMode.HALF_UP).doubleValue());
            creditAccount.setIssuingEmployee(issuingEmployee);
            creditAccount.setPaymentAccount(paymentAccount);
            user.getCreditAccounts().put(id, creditAccount);
        }
    }

    @Override
    public CreditAccount read(long id) {
        CreditAccount creditAccount = null;
        for (Bank bank : EntityMaps.bankMap.values()) {
            for (User user : bank.getUserMap().values()) {
                if (user.getCreditAccounts().containsKey(id)) {
                    creditAccount = user.getCreditAccounts().get(id);
                    break;
                }
            }
            if (creditAccount != null) break;
        }
        return creditAccount;
    }

    @Override
    public void update(long id, CreditAccount creditAccount) {
        if (read(id) != null && creditAccount != null) {
            creditAccount.getUser().getCreditAccounts().replace(id, creditAccount);
        }
    }

    @Override
    public void delete(long id) {
        CreditAccount creditAccount = read(id);
        if (creditAccount != null) creditAccount.getUser().getCreditAccounts().remove(id);
    }
}
