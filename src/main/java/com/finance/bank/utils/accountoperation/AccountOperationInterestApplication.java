package com.finance.bank.utils.accountoperation;

import com.finance.bank.utils.exceptions.CapitalTransactionException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class AccountOperationInterestApplication implements AccountOperation {

    @Setter @Getter
    private float interestRate;

    @Override
    public Double operateOnCapital(Double capital) throws CapitalTransactionException {
        Double sum = (capital / 100) * interestRate;
        return capital + sum;
    }
}
