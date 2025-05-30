package model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Event implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String type;
    private String description;
    private LocalDateTime datetime;
    private String location;

    public Event() {
    }

    public Event(int id, String name, String type, String description, LocalDateTime datetime, String location) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.datetime = datetime;
        this.location = location;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   
} 
