package org.romanov.lab.service.impl;

import org.romanov.lab.entity.*;
import org.romanov.lab.service.CreditAccountService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CreditAccountServiceImpl implements CreditAccountService {
    private CreditAccount creditAccount;

    public CreditAccountServiceImpl() {
        this.creditAccount = new CreditAccount();
    }

    @Override
    public void create(int id, User user, Bank bank, LocalDate startDate, int months, double loanAmount, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        creditAccount.setId(id);
        creditAccount.setUser(user);
        creditAccount.setBankName(bank.getName());
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
        creditAccount.setMonthlyPayment(monthlyPayment);
        creditAccount.setIssuingEmployee(issuingEmployee);
        creditAccount.setPaymentAccount(paymentAccount);
    }

    @Override
    public CreditAccount read() {
        return creditAccount;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete(int id) {

    }
}
