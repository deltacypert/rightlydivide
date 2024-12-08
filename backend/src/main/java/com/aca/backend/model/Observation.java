package com.aca.backend.model;

import java.time.LocalDateTime;

public class Observation {
    private Integer id;
    private String text;
    private ObservationType type;
    private String scriptureRef;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

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

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() { return updateDateTime; }

    public void setUpdateDateTime(LocalDateTime updateDateTime) { this.updateDateTime = updateDateTime; }

}
