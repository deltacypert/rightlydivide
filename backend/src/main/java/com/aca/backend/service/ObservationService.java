package com.aca.backend.service;

import com.aca.backend.dao.ObservationDao;
import com.aca.backend.dao.ObservationDaoImpl;
import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ObservationService {

    private ObservationDao observationDao = new ObservationDaoImpl();

    public Observation createObservation(Observation newObservation) {
        return observationDao.createObservation(newObservation);
    }

    public List<Observation> getObservations() {
        return observationDao.getObservations();
    }

    public List<Observation> getObservationsByType(ObservationType typeValue) {
        return observationDao.getObservationsByType(typeValue);
    }

    public List<Observation> getObservationsById(Integer observationIdValue) {
        return observationDao.getObservationsById(observationIdValue);
    }

    public List<Observation> getObservationsByDay(LocalDate dateCreated) {
        return observationDao.getObservationsByDay(dateCreated);
    }

    public List<Observation> getObservationsByScripture(String scriptureValue) {
        return observationDao.getObservationsByScripture(scriptureValue);
    }

    public List<Observation> getObsByTypeAndScrip(ObservationType typeValue, String scriptureValue) {
        return observationDao.getObsByTypeAndScrip(typeValue, scriptureValue);
    }

    public Observation updateObservation(Observation updateObservation) {
        return observationDao.updateObservation(updateObservation);
    }

    public Observation deleteObservationById(Integer observationIdValue) {
        return observationDao.deleteObservationById(observationIdValue);
    }
}
