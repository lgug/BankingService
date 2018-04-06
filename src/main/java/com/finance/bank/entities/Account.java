package com.finance.bank.entities;

import com.finance.bank.utils.AccountOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "accounts")
@AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id
    @NotNull @NotEmpty @NotBlank
    @Getter @Setter
    private String id;
    @NotNull
    @Getter @Setter
    private User user;
    @NotNull @NotEmpty
    @Getter @Setter
    private String password;
    @NotNull
    @Getter @Setter
    private Double capital;
    @NotNull
    @Getter @Setter
    private Date creationDate;
    @Getter @Setter
    private List<AccountOperation> accountOperationList;
}
