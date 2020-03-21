package com.meloafc.bookshelf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseModel {

    @Getter
    @Setter
    @NotEmpty
    private String name;

    @Getter
    @Setter
    @Email
    private String email;

    @Getter
    @Setter
    @NotEmpty
    private String password;
}
