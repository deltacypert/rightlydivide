package com.aca.backend.dao;

import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationType;

import java.time.LocalDate;
import java.util.List;

public interface ObservationDao {
    public abstract Observation createObservation(Observation newObservation);
    public abstract List<Observation> getObservations();
    public abstract List<Observation> getObservationsById(Integer observationId);
    public abstract List<Observation> getObservationsByType(ObservationType typeValue);
    public abstract List<Observation> getObservationsByDay(LocalDate dateCreated);
    public abstract List<Observation> getObservationsByScripture(String scriptureValue);
    public abstract List<Observation> getObsByTypeAndScrip(ObservationType typeValue, String scriptureValue);
    public abstract Observation updateObservation(Observation updateObservation);
    public abstract Observation deleteObservationById(Integer observationIdValue);

}