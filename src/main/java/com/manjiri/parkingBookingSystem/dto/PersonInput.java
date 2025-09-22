package com.manjiri.parkingBookingSystem.dto;

import jakarta.validation.constraints.NotBlank;

public class PersonInput {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
