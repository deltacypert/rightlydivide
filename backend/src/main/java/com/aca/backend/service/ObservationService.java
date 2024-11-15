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

    public List<Observation> getObervations() {
        return observationDao.getObservations();
    }

    public List<Observation> getObservationsByType(ObservationType observationType) {
        return observationDao.getObservationsByType(observationType);
    }

    public List<Observation> getObservationsById(Integer observationIdValue) {
        return observationDao.getObservationsById(observationIdValue);
    }

    public Observation createObservation(Observation newObservation) {
        return observationDao.createObservation(newObservation);
    }

    public Observation updateObservation(Observation updateObservation) {
        return observationDao.updateObservation(updateObservation);
    }

    public Observation deleteObservationById(Integer observationIdValue) {
        return observationDao.deleteObservationById(observationIdValue);
    }

    public List<Observation> getObservationsByDay(LocalDate dateCreated) {
        return observationDao.getObservationsByDay(dateCreated);
    }


    //TODO: getObservationsByBook
    //TODO: getObservationsByChapter
}
