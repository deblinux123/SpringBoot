package com.example.ValidationDemo;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer
{
    private String firstName;

    @NotNull(message = "Is required")
    @Size(min = 1, message = "Is Required")
    private String lastName;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
