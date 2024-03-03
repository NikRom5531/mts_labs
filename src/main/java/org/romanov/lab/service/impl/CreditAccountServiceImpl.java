package org.romanov.lab.service.impl;

import org.romanov.lab.entity.*;
import org.romanov.lab.service.CreditAccountService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Реализация интерфейса CreditAccountService для управления кредитными счетами.
 */
public class CreditAccountServiceImpl implements CreditAccountService {
    private CreditAccount creditAccount;

    /**
     * Конструктор класса CreditAccountServiceImpl, создает новый объект CreditAccount.
     */
    public CreditAccountServiceImpl() {
        this.creditAccount = new CreditAccount();
    }

    /**
     * Создает новый кредитный счет с заданными параметрами.
     *
     * @param id              Идентификатор кредитного счета.
     * @param user            Пользователь, для которого открывается счет.
     * @param bank            Банк, в котором открывается счет.
     * @param startDate       Дата начала кредита.
     * @param months          Количество месяцев на которые берется кредит.
     * @param loanAmount      Сумма кредита.
     * @param interestRate    Процентная ставка по кредиту.
     * @param issuingEmployee Сотрудник, выдавший кредит.
     * @param paymentAccount  Платежный счет для погашения кредита.
     */
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

    /**
     * Возвращает информацию о текущем кредитном счете.
     *
     * @return Объект класса {@link CreditAccount}, представляющий кредитный счет.
     */
    @Override
    public CreditAccount read() {
        return creditAccount;
    }

    /**
     * Обновляет информацию о кредитном счете.
     */
    @Override
    public void update() {

    }

    /**
     * Удаляет кредитный счет по указанному идентификатору.
     *
     * @param id Идентификатор кредитного счета для удаления.
     */
    @Override
    public void delete(int id) {

    }
}
