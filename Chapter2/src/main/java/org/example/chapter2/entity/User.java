package org.example.chapter2.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "userInformaiton")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "passwords")
    private String passwords;

    public User() {}

    public User(String username, String email, String passwords)
    {
        this.username = username;
        this.email = email;
        this.passwords = passwords;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswords() { return passwords; }
    public void setPasswords(String passwords) { this.passwords = passwords; }


    @Override
    public String toString()
    {
        return "User " +
                "Id: " + id +
                ", Username: " + username +
                ", Email: " + email +
                ", Passwords: " + passwords;
    }


}
