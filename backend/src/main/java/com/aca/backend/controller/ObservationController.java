package com.aca.backend.controller;

import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationException;
import com.aca.backend.model.ObservationType;
import com.aca.backend.service.ObservationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "api/observations", produces = "application/json")
@CrossOrigin("http://127.0.0.1:5500")
public class ObservationController {

    private ObservationService service = new ObservationService();

    // CREATE
    @RequestMapping(
            consumes = "application/json",
            method = RequestMethod.POST)
    public Observation createObservation(@RequestBody Observation newObservation) throws ObservationException {
        return service.createObservation(newObservation);
    }

    // READ
    @RequestMapping(method = RequestMethod.GET)
    public List<Observation> getObservations() {
        return service.getObservations();
    }

    @RequestMapping(
            value = "/type/{typeValue}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsByType(@PathVariable ObservationType typeValue) {
        return service.getObservationsByType(typeValue);
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
    public List<Observation> getObservationsByDay(@PathVariable LocalDateTime dateCreated) {
        return service.getObservationsByDay(dateCreated);
    }

    @RequestMapping(
            value = "/scripture/{scriptureValue}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsByScripture(@PathVariable String scriptureValue) {
        return service.getObservationsByScripture(scriptureValue);
    }

    @RequestMapping(
            value = "/type/{typeValue}/scripture/{scriptureValue}",
            method = RequestMethod.GET)
    public List<Observation> getObsByTypeAndScrip(@PathVariable ObservationType typeValue, @PathVariable String scriptureValue) {
        return service.getObsByTypeAndScrip(typeValue, scriptureValue);
    }

    // UPDATE
    @RequestMapping(
            consumes = "application/json",
            method = RequestMethod.PUT)
    public Observation updateObservation(@RequestBody Observation updateObservation) {
        return service.updateObservation(updateObservation);
    }

    // DELETE
    @RequestMapping(
            value = "/id/{observationIdValue}",
            method = RequestMethod.DELETE)
    public Observation deleteObservationById(@PathVariable Integer observationIdValue) {
        System.out.println("observation: " + observationIdValue + " deleted.");
        return service.deleteObservationById(observationIdValue);
    }

}
