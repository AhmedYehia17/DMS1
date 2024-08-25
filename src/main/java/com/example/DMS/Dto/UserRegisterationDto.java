package com.example.DMS.Dto;
import jakarta.validation.constraints.*;

import jakarta.persistence.Column;
import org.antlr.v4.runtime.misc.NotNull;

public class UserRegisterationDto {

    @NotBlank(message = "firstname is required")
    private String firstname;

    @NotBlank(message = "lastname is required")
    private String lastname;

    @NotBlank(message = "Username is required")
    private String username;


    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

//    @Digits(integer = 16,fraction = 0,message = "National ID must be of 16 digits long")
    @Min(value = 1000000000000000L, message = "National ID must be 16 digits long")
    @Max(value = 9999999999999999L, message = "National ID must be 16 digits long")
    private Long nationalId;

    @NotBlank(message = "password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    public @NotBlank(message = "firstname is required") String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotBlank(message = "firstname is required") String firstname) {
        this.firstname = firstname;
    }

    public @NotBlank(message = "lastname is required") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank(message = "lastname is required") String lastname) {
        this.lastname = lastname;
    }

    public @NotBlank(message = "Username is required") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is required") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    @Digits(integer = 16, fraction = 0, message = "National ID must be of 16 digits long")
    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(@Digits(integer = 16, fraction = 0, message = "National ID must be of 16 digits long") Long nationalId) {
        this.nationalId = nationalId;
    }

    public @NotBlank(message = "password is required") @Size(min = 8, message = "Password must be at least 8 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "password is required") @Size(min = 8, message = "Password must be at least 8 characters long") String password) {
        this.password = password;
    }

    public UserRegisterationDto(String firstname, String lastname, String username, String email, long nationalId, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.nationalId = nationalId;
        this.password = password;
    }
}
