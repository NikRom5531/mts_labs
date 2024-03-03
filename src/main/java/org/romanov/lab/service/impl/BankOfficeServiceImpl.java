package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.BankAtm;
import org.romanov.lab.entity.BankOffice;
import org.romanov.lab.service.BankOfficeService;

import java.util.List;

/**
 * Реализация сервиса управления банковским офисом.
 * Этот класс предоставляет методы для создания, чтения, обновления и удаления банковского офиса.
 * Обеспечивает взаимодействие с объектами типа BankOffice.
 */
public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice;

    /**
     * Конструктор по умолчанию. Создает новый экземпляр банковского офиса.
     */
    public BankOfficeServiceImpl() {
        this.bankOffice = new BankOffice();
    }

    /**
     * Создает новый банковский офис с указанными параметрами.
     *
     * @param id                Идентификатор банковского офиса.
     * @param name              Название банковского офиса.
     * @param bank              Банк, к которому принадлежит офис.
     * @param address           Адрес офиса.
     * @param status            Статус работы офиса.
     * @param canPlaceAtm       Возможность установки банкомата в офисе.
     * @param canProvideCredit  Возможность предоставления кредитов.
     * @param cashWithdrawal    Возможность снятия наличных.
     * @param cashDeposit       Возможность внесения наличных.
     * @param rentCost          Стоимость аренды офиса.
     */
    @Override
    public void create(int id, String name, Bank bank, String address, boolean status, boolean canPlaceAtm, boolean canProvideCredit, boolean cashWithdrawal, boolean cashDeposit, double rentCost) {
        bankOffice.setId(id);
        bankOffice.setName(name);
        bankOffice.setBank(bank);
        bank.setQuantityOffices(bank.getQuantityOffices() + 1);
        bankOffice.setAddress(address);
        bankOffice.setStatus(status);
        bankOffice.setCanPlaceAtm(canPlaceAtm);
        bankOffice.setCanProvideCredit(canProvideCredit);
        bankOffice.setCashWithdrawal(cashWithdrawal);
        bankOffice.setCashDeposit(cashDeposit);
        bankOffice.setTotalMoney(bankOffice.getBank().getTotalMoney());
        bankOffice.setRentCost(rentCost);
    }

    /**
     * Возвращает информацию о банковском офисе.
     *
     * @return Объект класса {@link BankOffice}.
     */
    @Override
    public BankOffice read() {
        return bankOffice;
    }

    /**
     * Обновляет информацию о банковском офисе с указанными параметрами.
     *
     * @param id                Идентификатор офиса.
     * @param name              Название офиса.
     * @param bank              Банк, к которому принадлежит офис.
     * @param address           Адрес офиса.
     * @param status            Статус работы офиса.
     * @param canPlaceAtm       Возможность установки банкомата в офисе.
     * @param bankAtms          Список банкоматов в офисе.
     * @param canProvideCredit  Возможность предоставления кредитов.
     * @param cashWithdrawal    Возможность снятия наличных.
     * @param cashDeposit       Возможность внесения наличных.
     * @param rentCost          Стоимость аренды офиса.
     */
    @Override
    public void update(int id, String name, Bank bank, String address, boolean status, boolean canPlaceAtm, List<BankAtm> bankAtms, boolean canProvideCredit, boolean cashWithdrawal, boolean cashDeposit, double rentCost) {
        bankOffice.setId(id);
        bankOffice.setName(name);
        bankOffice.setBank(bank);
        bankOffice.setAddress(address);
        bankOffice.setStatus(status);
        bankOffice.setCanPlaceAtm(canPlaceAtm);
        if (canPlaceAtm) {
            bankOffice.getBank().setQuantityATM(bankOffice.getBank().getQuantityATM() + bankAtms.size() - bankOffice.getQuantityAtms());
            bankOffice.setQuantityAtms(bankAtms.size());
        }
        bankOffice.setCanProvideCredit(canProvideCredit);
        bankOffice.setCashWithdrawal(cashWithdrawal);
        bankOffice.setCashDeposit(cashDeposit);
        bankOffice.setTotalMoney(bankOffice.getBank().getTotalMoney());
        bankOffice.setRentCost(rentCost);
    }

    /**
     * Удаляет банковский офис с указанным идентификатором.
     *
     * @param id Идентификатор офиса.
     */
    @Override
    public void delete(int id) {

    }
}
