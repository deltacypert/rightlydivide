package com.aca.backend.dao;

import com.aca.backend.model.Chapter;
import com.aca.backend.model.ReadingPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChapterDaoMock implements ChapterDao {

    private static List<Chapter> wholeBibleChapters = new ArrayList<>();
    private static List<Chapter> newTestamentChapters = new ArrayList<>();

    static {

        // WHOLE_BIBLE plan: 1 chapters from each list a day, 8 chapters total
        wholeBibleChapters.add(new Chapter("Genesis", 1)); // LIST 1: Genesis-Deuteronomy
        wholeBibleChapters.add(new Chapter("Matthew", 1)); // LIST 2: Matthew-John
        wholeBibleChapters.add(new Chapter("Acts", 1)); // LIST 3: Acts
        wholeBibleChapters.add(new Chapter("Joshua", 1)); // LIST 4: Joshua-Esther
        wholeBibleChapters.add(new Chapter("Job", 1)); // LIST 5: Job-Song of Solomon
        wholeBibleChapters.add(new Chapter("Isaiah", 1)); // LIST 6: Isaiah-Malachi
        wholeBibleChapters.add(new Chapter("Romans", 1)); // LIST 7: Romans-Philemon
        wholeBibleChapters.add(new Chapter("Hebrews", 1)); // LIST 8: Hebrews

        // NEW_TESTAMENT plan: 7 consecutive chapters a day
        newTestamentChapters.add(new Chapter("Matthew", 1)); // SECTION 1: Matthew, Acts-Revelation
        newTestamentChapters.add(new Chapter("Matthew", 2));
        newTestamentChapters.add(new Chapter("Matthew", 3));
        newTestamentChapters.add(new Chapter("Matthew", 4));
        newTestamentChapters.add(new Chapter("Matthew", 5));
        newTestamentChapters.add(new Chapter("Matthew", 6));
        newTestamentChapters.add(new Chapter("Matthew", 7));

    }

    @Override
    public List<Chapter> getDailyChaptersByPlan(ReadingPlan plan, LocalDate today) {
        List<Chapter> dailyChaptersByPlan = new ArrayList<>();
        // TODO: implement logic to get Daily Chapters By Plan4
        return dailyChaptersByPlan;
    }
}
