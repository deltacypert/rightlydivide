package com.aca.backend.service;

import com.aca.backend.dao.ObservationDao;
import com.aca.backend.dao.ObservationDaoMock;
import com.aca.backend.model.Chapter;
import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationType;

import java.time.LocalDate;
import java.util.List;

public class ObservationService {

    private ObservationDao observationDao = new ObservationDaoMock();

    public List<Observation> getObervations() {
        return observationDao.getObservations();
    }

    public List<Observation> getObservationsByType(ObservationType observationType) {
        return observationDao.getObservationsByType(observationType);
    }

    public List<Observation> getObservationsByDate(LocalDate dateCreated) {
        return observationDao.getObservationsByDate(dateCreated);
    }

    public List<Observation> getObservationsByBook(String book) {
        return observationDao.getObservationsByBook(book);
    }

    public List<Observation> getObservationsByChapter(Chapter chapter) {
        return observationDao.getObservationsByChapter(chapter);
    }
}
