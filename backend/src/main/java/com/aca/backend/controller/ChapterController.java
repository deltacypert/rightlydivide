package com.aca.backend.controller;

import com.aca.backend.model.Chapter;
import com.aca.backend.model.ReadingPlan;
import com.aca.backend.service.ChapterService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/chapters", produces = "application/json")
public class ChapterController {

    private ChapterService service = new ChapterService();

    @RequestMapping(value = "/{plan}/{dateValue}")
    public List<Chapter> getDailyChaptersByPlan(@PathVariable ReadingPlan plan, @PathVariable String dateValue) {
        LocalDate date = LocalDate.parse(dateValue);
        return service.getDailyChaptersByPlan(plan, date);
    }
}
