package com.finance.bank.entities;

import com.finance.bank.utils.accountstatus.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @NotNull
    @Getter @Setter
    private Double capital;
    @NotNull
    @Getter @Setter
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date creationDate;
    @NotNull @NotEmpty @NotBlank
    @Setter @Getter
    private AccountStatus status;
}
