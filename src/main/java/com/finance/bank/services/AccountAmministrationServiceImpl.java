package com.finance.bank.services;

import com.finance.bank.daos.AccountDao;
import com.finance.bank.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.finance.bank.utils.accountstatus.AccountStatus.ACTIVE;
import static com.finance.bank.utils.accountstatus.AccountStatus.CLOSED;
import static com.finance.bank.utils.accountstatus.AccountStatus.HIBERNATED;

@Service
public class AccountAmministrationServiceImpl implements AccountAmministrationService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean activeAccount(String accountID) {
        Optional<Account> a = accountDao.findById(accountID);
        if (a.isPresent()) {
            Account account = a.get();
            account.setStatus(ACTIVE);
        }
        return false;
    }

    @Override
    public boolean hibernateAccount(String accountID) {
        Optional<Account> a = accountDao.findById(accountID);
        if (a.isPresent()) {
            Account account = a.get();
            account.setStatus(HIBERNATED);
        }
        return false;
    }

    @Override
    public boolean closeAccount(String accountID) {
        Optional<Account> a = accountDao.findById(accountID);
        if (a.isPresent()) {
            Account account = a.get();
            account.setStatus(CLOSED);
        }
        return false;
    }

    @Override
    public boolean changePassword(String accountID, String oldPassword, String newPassword) {
        return false;
    }
}
