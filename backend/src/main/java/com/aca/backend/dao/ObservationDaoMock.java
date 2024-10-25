package com.aca.backend.dao;

import com.aca.backend.model.Chapter;
import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// FIXME: testing purposes
public class ObservationDaoMock implements ObservationDao {

    private static List<Observation> observations = new ArrayList<>();

    static {
        Observation spiritual = new Observation();
        spiritual.setText("This is a spiritual obervation on Romans 1.");
        spiritual.setType(ObservationType.SPIRITUAL);
        spiritual.setDateCreated(LocalDate.now());
        spiritual.setId(1);
        Chapter spiritualChapter = new Chapter("Isaiah", 25);
        spiritual.setChapter(spiritualChapter);


        Observation moral = new Observation();
        moral.setText("This is a moral observation.");
        moral.setType(ObservationType.MORAL);
        moral.setDateCreated(LocalDate.now());
        moral.setId(2);
        Chapter moralChapter = new Chapter("Ephesians", 2);
        moral.setChapter(moralChapter);

        Observation literal = new Observation();
        literal.setText("This is a literal observation.");
        literal.setType(ObservationType.LITERAL);
        literal.setDateCreated(LocalDate.now());
        literal.setId(3);
        Chapter literalChapter = new Chapter("Romans", 1);
        literal.setChapter(literalChapter);

        observations.add(spiritual);
        observations.add(moral);
        observations.add(literal);
    }

    @Override
    public List<Observation> getObservations() {
        List<Observation> allObservations = new ArrayList<>();
        allObservations.addAll(ObservationDaoMock.observations);
        return allObservations;
    }

    @Override
    public List<Observation> getObservationsByType(ObservationType observationType) {
        List<Observation> observationsByType = new ArrayList<>();
        for (Observation observation : observations) {
            if (observation.getType().equals(observationType)) {
                observationsByType.add(observation);
            }
        }
        return observationsByType;
    }

    @Override
    public List<Observation> getObservationsByDate(LocalDate dateCreated) {
        List<Observation> observationsByDate = new ArrayList<>();
        for (Observation observation : observations) {
            if (observation.getDateCreated().equals(dateCreated)) {
                observationsByDate.add(observation);
            }
        }
        return observationsByDate;
    }

    @Override
    public List<Observation> getObservationsByBook(String book) {
        List<Observation> observationsByBook = new ArrayList<>();
        for (Observation observation : observations) {
            if (observation.getChapter() != null && observation.getChapter().getBook().equals(book)) {
                observationsByBook.add(observation);
            }
        }
        return observationsByBook;
    }
    @Override
    public List<Observation> getObservationsByChapter(Chapter chapter) {
        List<Observation> observationsByChapter = new ArrayList<>();
        for (Observation observation : observations) {
            if (observation.getChapter() != null
                && observation.getChapter().getBook().equals(chapter.getBook())
                && observation.getChapter().getChapterNumber() == chapter.getChapterNumber()) {
                observationsByChapter.add(observation);
            }
        }
        return observationsByChapter;
    }
}
