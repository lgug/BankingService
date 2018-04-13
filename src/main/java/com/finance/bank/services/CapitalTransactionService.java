package com.finance.bank.services;


import com.finance.bank.entities.Account;
import com.finance.bank.entities.User;
import com.finance.bank.utils.accountstatus.AccountStatus;
import com.finance.bank.utils.exceptions.CapitalTransactionException;
import com.finance.bank.utils.exceptions.UserNotFoundException;

public interface CapitalTransactionService {

    void credit(String accountID, Double quote) throws CapitalTransactionException, UserNotFoundException;

    void debit(String accountID, Double quote) throws CapitalTransactionException, UserNotFoundException;

    AccountStatus getCurrentAccountState(String accountID) throws UserNotFoundException;

    Double getCurrentAccountCapital(String accountID) throws UserNotFoundException;
}
