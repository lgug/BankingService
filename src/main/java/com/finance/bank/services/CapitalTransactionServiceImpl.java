package com.finance.bank.services;

import com.finance.bank.daos.AccountDao;
import com.finance.bank.entities.Account;
import com.finance.bank.utils.accountstatus.AccountStatus;
import com.finance.bank.utils.exceptions.CapitalTransactionException;
import com.finance.bank.utils.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.finance.bank.utils.accountstatus.AccountStatus.ACTIVE;


@Service
public class CapitalTransactionServiceImpl implements CapitalTransactionService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public void credit(String accountID, Double quote) throws CapitalTransactionException, UserNotFoundException {
        Optional<Account> a = accountDao.findById(accountID);
        if (a.isPresent()) {
            Account account = a.get();
            Double capital = account.getCapital();
            if (account.getStatus().equal(ACTIVE)) {
                capital += quote;
                account.setCapital(capital);
            } else {
                throw new CapitalTransactionException();
            }
        } else {
            throw new UserNotFoundException();
        }

    }

    @Override
    public void debit(String accountID, Double quote) throws CapitalTransactionException, UserNotFoundException {
        Optional<Account> a = accountDao.findById(accountID);
        if (a.isPresent()) {
            Account account = a.get();
            Double capital = account.getCapital();
            if (account.getStatus().equal(ACTIVE) && capital >= 0) {
                capital -= quote;
                account.setCapital(capital);
            } else {
                throw new CapitalTransactionException();
            }
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public AccountStatus getCurrentAccountState(String accountID) throws UserNotFoundException {
        Optional<Account> account = accountDao.findById(accountID);
        if (account.isPresent()) {
            return account.get().getStatus();
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public Double getCurrentAccountCapital(String accountID) throws UserNotFoundException {
        Optional<Account> account = accountDao.findById(accountID);
        if (account.isPresent()) {
            return account.get().getCapital();
        } else {
            throw new UserNotFoundException();
        }
    }
}
