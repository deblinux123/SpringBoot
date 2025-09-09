package com.example.Chapter4.model;

import java.util.List;

public class Student
{
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;




    public Student() {}

    public Student(String firstName, String lastName, String country, String favoriteLanguage)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCountry() { return country; }
    public String getFavoriteLanguage() { return favoriteLanguage; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setCountry(String country) { this.country = country; }
    public void setFavoriteLanguage(String favoriteLanguage) { this.favoriteLanguage = favoriteLanguage; }
}
