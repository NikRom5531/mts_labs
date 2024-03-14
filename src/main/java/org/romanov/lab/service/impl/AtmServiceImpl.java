package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.BankAtm;
import org.romanov.lab.entity.BankOffice;
import org.romanov.lab.entity.Employee;
import org.romanov.lab.service.AtmService;
import org.romanov.lab.utils.EntityMaps;

/**
 * Реализация интерфейса AtmService для работы с объектами BankAtm.
 */
public class AtmServiceImpl implements AtmService {

    @Override
    public void create(long id, String name, int status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        BankAtm atm = new BankAtm();
        atm.setId(id);
        atm.setName(name);
        atm.setAddress(bankOffice.getAddress());
        switch (status) {
            case 1 -> {}            // работает
            case 2 -> {}            // нет денег
            default -> status = 0;  // не работает
        }
        atm.setStatus(status);
        atm.setBankOffice(bankOffice); // Для использования ID необходимы коллекции
        atm.setLocation(location);
        atm.setServicingEmployee(servicingEmployee); // Для использования ID необходимы коллекции
        atm.setCashWithdrawal(cashWithdrawal);
        atm.setCashDeposit(cashDeposit);
        atm.setMaintenanceCost(maintenanceCost);

        bankOffice.getBankAtmMap().put(id, atm);
    }

    @Override
    public BankAtm read(long id) {
        BankAtm atm = null;
        for (Bank bank : EntityMaps.bankMap.values()) {
            for (BankOffice bankOffice : bank.getBankOfficeMap().values()) {
                if (bankOffice.getBankAtmMap().containsKey(id)) {
                    atm = bankOffice.getBankAtmMap().get(id);
                    break;
                }
            }
            if (atm != null) break;
        }
        return atm;
    }

    @Override
    public void update(long id, BankAtm atm) {
        BankAtm atmMap = read(id);
        if (atmMap != null && atm != null) atm.getBankOffice().getBankAtmMap().replace(id, atm);
    }

    @Override
    public void delete(long id) {
        BankAtm bankAtm = read(id);
        if (bankAtm != null) bankAtm.getBankOffice().getBankAtmMap().remove(bankAtm.getId());
    }
}
