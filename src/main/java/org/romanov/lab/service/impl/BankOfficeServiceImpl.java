package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.BankOffice;
import org.romanov.lab.service.BankOfficeService;
import org.romanov.lab.utils.EntityMaps;

/**
 * Реализация сервиса управления банковским офисом.
 * Этот класс предоставляет методы для создания, чтения, обновления и удаления банковского офиса.
 * Обеспечивает взаимодействие с объектами типа BankOffice.
 */
public class BankOfficeServiceImpl implements BankOfficeService {
    @Override
    public void create(long id, String name, Bank bank, String address, boolean status, boolean canPlaceAtm, boolean canProvideCredit, boolean cashWithdrawal, boolean cashDeposit, double rentCost) {
        if (read(id) == null) {
            BankOffice bankOffice = new BankOffice();
            bankOffice.setId(id);
            bankOffice.setName(name);
            bankOffice.setBank(bank);
            bankOffice.setAddress(address);
            bankOffice.setStatus(status);
            bankOffice.setCanPlaceAtm(canPlaceAtm);
            bankOffice.setCanProvideCredit(canProvideCredit);
            bankOffice.setCashWithdrawal(cashWithdrawal);
            bankOffice.setCashDeposit(cashDeposit);
            bankOffice.setRentCost(rentCost);

            bank.getBankOfficeMap().put(id, bankOffice);
        }
    }

    @Override
    public BankOffice read(long id) {
        BankOffice bankOffice = null;
        for (Bank bank : EntityMaps.bankMap.values()) {
            if (bank.getBankOfficeMap().containsKey(id)) {
                bankOffice = bank.getBankOfficeMap().get(id);
                break;
            }
        }
        return bankOffice;
    }

    @Override
    public void update(long id, BankOffice bankOffice) {
        BankOffice mapBankOffice = read(id);
        if (mapBankOffice != null && bankOffice != null) bankOffice.getBank().getBankOfficeMap().replace(id, bankOffice);
    }

    @Override
    public void delete(long id) {
        BankOffice mapBankOffice = read(id);
        if (mapBankOffice != null) mapBankOffice.getBank().getBankOfficeMap().remove(id);
    }
}
