package com.rightlydivide.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Observation {
    private Long id;
    private User user;
    private String text;
    private LocalDate dateCreated;
    private List<String> keywords;
    private List<Long> linkedObservationIds;
    private List<Chapter> chapters;

    public Observation(String text, List<Chapter> chapters) {
        this.text = text;
        this.chapters = chapters != null ? new ArrayList<>(chapters) : new ArrayList<>();
        this.dateCreated = LocalDate.now();
        this.keywords = new ArrayList<>();
        this.linkedObservationIds = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void addKeyword(String keyword) {
        if (!keywords.contains(keyword)) {
            this.keywords.add(keyword);
        }
    }

    public List<Long> getLinkedObservationIds() {
        return linkedObservationIds;
    }

    public void linkObservation(Long observationId) {
        if (observationId != null && !linkedObservationIds.contains(observationId)) {
            this.linkedObservationIds.add(observationId);
        }
    }

    public void unlinkObservation(Long observationID) {
        this.linkedObservationIds.remove(observationID);
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters != null ? new ArrayList<>(chapters) : new ArrayList<>();
    }

}