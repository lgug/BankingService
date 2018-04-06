package com.finance.bank.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class AccountOperationInterestApplication implements AccountOperation {

    private float interestRate;

    @Override
    public Double operateOnCapital(Double capital) {
        Double sum = (capital / 100) * interestRate;
        return capital + sum;
    }
}
