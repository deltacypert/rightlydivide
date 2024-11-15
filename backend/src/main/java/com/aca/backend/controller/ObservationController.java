package com.aca.backend.controller;

import com.aca.backend.model.Chapter;
import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationException;
import com.aca.backend.model.ObservationType;
import com.aca.backend.service.ObservationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "api/observations", produces = "application/json")
public class ObservationController {

    private ObservationService service = new ObservationService();

    @RequestMapping(method = RequestMethod.GET)
    public List<Observation> getObservations() {
        return service.getObervations();
    }

    @RequestMapping(
            value = "/type/{observationValue}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsByType(@PathVariable ObservationType observationValue) {
        return service.getObservationsByType(observationValue);
    }

    @RequestMapping(
            value = "/id/{observationIdValue}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsById(@PathVariable Integer observationIdValue) {
        return service.getObservationsById(observationIdValue);
    }

    @RequestMapping(
            value = "/day/{dateCreated}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsByDay(@PathVariable LocalDate dateCreated) {
        return service.getObservationsByDay(dateCreated);
    }

    @RequestMapping(
            consumes = "application/json",
            method = RequestMethod.POST)
    public Observation createMovie(@RequestBody Observation newObservation) throws ObservationException {
        return service.createObservation(newObservation);
    }

    @RequestMapping(
            consumes = "application/json",
            method = RequestMethod.PUT)
    public Observation updateObservation(@RequestBody Observation updateObservation) {
        return service.updateObservation(updateObservation);
    }

    @RequestMapping(
            value = "/id/{observationIdValue}",
            method = RequestMethod.DELETE)
    public Observation deleteObservationById(@PathVariable Integer observationIdValue) {
        System.out.println("observation: " + observationIdValue + " deleted.");
        return service.deleteObservationById(observationIdValue);
    }

    //TODO: getObservationsByBook
    //TODO: getObservationsByChapter
}
