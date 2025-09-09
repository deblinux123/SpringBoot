package com.example.Chapter4.model;

import java.util.Collections;
import java.util.List;

public class Student
{
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private List<String> favoriteOperatingSystem;




    public Student() {}

    public Student(String firstName,
                   String lastName,
                   String country,
                   String favoriteLanguage,
                   String favoriteOperatingSystem)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favoriteLanguage = favoriteLanguage;
        this.favoriteOperatingSystem = Collections.singletonList(favoriteOperatingSystem);
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCountry() { return country; }
    public String getFavoriteLanguage() { return favoriteLanguage; }
    public List<String> getFavoriteOperatingSystem() { return favoriteOperatingSystem; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setCountry(String country) { this.country = country; }
    public void setFavoriteLanguage(String favoriteLanguage) { this.favoriteLanguage = favoriteLanguage; }
    public void setFavoriteOperatingSystem(List<String> favoriteOperatingSystem) { this.favoriteOperatingSystem = favoriteOperatingSystem; }
}
