package com.example.assigment7.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data @AllArgsConstructor
@Entity
@NoArgsConstructor
public class UsersSoftware {
    @NotNull(message = "ID must be filled")
    @Id
    private int ID;
    @NotEmpty(message = "Name must be filled")
    @Size(min = 5,message = "Name must be more than 4 letter")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotEmpty(message = "Username must be filled")
    @Size(min = 5,message = "Username must be more than 4 letter")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;
    @NotEmpty(message = "Password must be filled")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotEmpty(message = "Email must be filled")
    @Email(message = "Email is not valid", regexp="{(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])}")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @NotEmpty(message = "Role must be filled")
    @Column(columnDefinition = "varchar(20) check ( 'User' or 'Admin' )")
    private String role;
    @NotNull(message = "Age must be filled and must be number")
    @Column(columnDefinition ="int")
    private int age;

}
