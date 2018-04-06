package com.finance.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    @Column(name = "fiscal_code")
    @NotNull @NotEmpty @NotBlank
    @Setter @Getter
    private String fiscalCode;
    @NotNull
    @Setter @Getter
    private String name;
    @NotNull @NotEmpty @NotBlank
    @Setter @Getter
    private String familyName;
    @NotNull
    @Setter @Getter
    private String address;

}
