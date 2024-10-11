package com.rightlydivide.backend.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private ReadingPlan readingPlan;
    private List<Observation> observations;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password);
        this.readingPlan = null;
        this.observations = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public ReadingPlan getReadingPlan() {
        return readingPlan;
    }

    public void setReadingPlan(ReadingPlan readingPlan) {
        this.readingPlan = readingPlan;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void addObservations(Observation observation) {
        this.observations.add(observation);
    }

    private String hashPassword(String password) {
        // TODO: implement hash logic
        return password;
    }
}
