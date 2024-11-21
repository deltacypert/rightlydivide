package com.aca.backend.model;

import java.time.LocalDate;

public class Observation {
    private Integer id;
    private java.lang.String text;
    private ObservationType type;
    private String scriptureRef;
    private LocalDate createDateTime;
    private LocalDate updateDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ObservationType getType() {
        return type;
    }

    public void setType(ObservationType type) {
        this.type = type;
    }

    public String getScriptureRef() { return scriptureRef; }

    public void setScriptureRef(String scriptureRef) { this.scriptureRef = scriptureRef; }

    public LocalDate getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDate createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDate getUpdateDateTime() { return updateDateTime; }

    public void setUpdateDateTime(LocalDate updateDateTime) { this.updateDateTime = updateDateTime; }

}
