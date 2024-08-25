package com.example.DMS.Dto;
import jakarta.validation.constraints.NotBlank;

public class UserLoginDto {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    public @NotBlank(message = "Username is required") String getUserName() {
        return username;
    }

    public void setUserName(@NotBlank(message = "Username is required") String userName) {
        this.username = userName;
    }

    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }
}
