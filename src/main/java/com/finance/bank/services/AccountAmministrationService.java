package com.finance.bank.services;

public interface AccountAmministrationService {

    boolean activeAccount(String accountID);

    boolean hibernateAccount(String accountID);

    boolean closeAccount(String accountID);

    boolean changePassword(String accountID, String oldPassword, String newPassword);
}
