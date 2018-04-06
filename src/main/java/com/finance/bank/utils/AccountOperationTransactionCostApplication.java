package com.finance.bank.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class AccountOperationTransactionCostApplication implements AccountOperation {

    @Setter @Getter
    private Double cost;

    @Override
    public Double operateOnCapital(Double capital) {
        return capital - cost;
    }
}
