package com.aca.backend.controller;

import com.aca.backend.model.Chapter;
import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationType;
import com.aca.backend.service.ObservationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/observations", produces = "application/json")
public class ObservationController {

    private ObservationService service = new ObservationService();

    @RequestMapping(method = RequestMethod.GET)
    public List<Observation> getObservation() {
        return service.getObervations();
    }

    @RequestMapping(
            value = "/type/{observationType}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsByType(@PathVariable ObservationType observationType) {
        return service.getObservationsByType(observationType);
    }

    @RequestMapping(
            value = "/date/{dateCreated}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsByDate(@PathVariable String dateCreated) {
        LocalDate date = LocalDate.parse(dateCreated);
        return service.getObservationsByDate(date);
    }


    @RequestMapping(
            value = "/chapter/{bookValue}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsByBook(@PathVariable String bookValue) {
        return service.getObservationsByBook(bookValue);
    }

    @RequestMapping(
            value = "/chapter/{bookValue}/{chapterValue}",
            method = RequestMethod.GET)
    public List<Observation> getObservationsByChapter(@PathVariable String bookValue, @PathVariable Integer chapterValue) {
        Chapter chapter = new Chapter(bookValue, chapterValue);
        return service.getObservationsByChapter(chapter);
    }
}
