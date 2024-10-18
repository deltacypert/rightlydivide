package com.aca.backend.dao;

import com.aca.backend.model.Chapter;
import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationType;

import java.time.LocalDate;
import java.util.List;

public interface ObservationDAO {
    public abstract List<Observation> getObservations();
    public abstract List<Observation> getObservationsByType(ObservationType observationType);
    public abstract List<Observation> getObservationsByDate(LocalDate dateCreated);
    public abstract List<Observation> getObservationsByBook(String book);
    public abstract List<Observation> getObservationsByChapter(Chapter chapter);
}
