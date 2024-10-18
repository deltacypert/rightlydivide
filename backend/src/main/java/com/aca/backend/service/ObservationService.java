package com.aca.backend.service;

import com.aca.backend.dao.ObservationDAO;
import com.aca.backend.dao.ObservationDaoMock;
import com.aca.backend.model.Chapter;
import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationType;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class ObservationService {

    private ObservationDAO observationDAO = new ObservationDaoMock();

    public List<Observation> getObervations() {
        return observationDAO.getObservations();
    }

    public List<Observation> getObservationsByType(ObservationType observationType) {
        return observationDAO.getObservationsByType(observationType);
    }

    public List<Observation> getObservationsByDate(LocalDate dateCreated) {
        return observationDAO.getObservationsByDate(dateCreated);
    }

    public List<Observation> getObservationsByBook(String book) {
        return observationDAO.getObservationsByBook(book);
    }

    public List<Observation> getObservationsByChapter(Chapter chapter) {
        return observationDAO.getObservationsByChapter(chapter);
    }
}
