package org.romanov.lab.service.impl;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.BankAtm;
import org.romanov.lab.entity.BankOffice;
import org.romanov.lab.service.BankOfficeService;

import java.util.List;

/**
 * Implementation of the BankOfficeService interface for managing BankOffice entities.
 */
public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice;

    /**
     * Default constructor for creating a new instance of BankOfficeServiceImpl.
     * Initializes a new BankOffice instance.
     */
    public BankOfficeServiceImpl() {
        this.bankOffice = new BankOffice();
    }

    /**
     * Creates a new BankOffice with the provided attributes.
     *
     * @param id                The unique identifier of the bank office.
     * @param name              The name of the bank office.
     * @param bank              The associated bank.
     * @param address           The address of the bank office.
     * @param status            The status of the bank office (true if it's operational, false otherwise).
     * @param canPlaceAtm       Indicates whether the bank office can place ATMs.
     * @param canProvideCredit  Indicates whether the bank office can provide credit services.
     * @param cashWithdrawal    Indicates whether the bank office supports cash withdrawal.
     * @param cashDeposit       Indicates whether the bank office supports cash deposit.
     * @param rentCost          The cost of renting the bank office.
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
     * Retrieves the current BankOffice instance.
     *
     * @return The current BankOffice instance.
     */
    @Override
    public BankOffice read() {
        return bankOffice;
    }

    /**
     * Updates the BankOffice with the provided attributes.
     *
     * @param id                The unique identifier of the bank office.
     * @param name              The name of the bank office.
     * @param bank              The associated bank.
     * @param address           The address of the bank office.
     * @param status            The status of the bank office (true if it's operational, false otherwise).
     * @param canPlaceAtm       Indicates whether the bank office can place ATMs.
     * @param bankAtms          The list of ATMs associated with the bank office.
     * @param canProvideCredit  Indicates whether the bank office can provide credit services.
     * @param cashWithdrawal    Indicates whether the bank office supports cash withdrawal.
     * @param cashDeposit       Indicates whether the bank office supports cash deposit.
     * @param rentCost          The cost of renting the bank office.
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
     * Deletes the BankOffice with the specified identifier.
     *
     * @param id The unique identifier of the bank office to be deleted.
     */
    @Override
    public void delete(int id) {

    }
}
