package model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Participant implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String email;
    private LocalDateTime registrationDate;
    private String status;

    public Participant() {
    }

    public Participant(int id, String name, String email, LocalDateTime registrationDate, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    
    

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
} 
