// Maaz Shaikh - 421007607
package org.example.car_rental_project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "licenseNumber", length = 20, nullable = false)
    private String licenseNumber;

    public Customer() {}

    public Customer(String username, String password, String email, String licenseNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getLicenseNumber() { return licenseNumber; }

    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
}