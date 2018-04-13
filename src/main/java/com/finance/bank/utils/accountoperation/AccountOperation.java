package com.finance.bank.utils.accountoperation;


import com.finance.bank.utils.exceptions.CapitalTransactionException;

public interface AccountOperation {

    Double operateOnCapital(Double capital) throws CapitalTransactionException;
}
