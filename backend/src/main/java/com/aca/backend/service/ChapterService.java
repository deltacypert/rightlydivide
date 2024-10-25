package com.aca.backend.service;

import com.aca.backend.dao.ChapterDao;
import com.aca.backend.dao.ChapterDaoMock;
import com.aca.backend.model.Chapter;
import com.aca.backend.model.ReadingPlan;

import java.time.LocalDate;
import java.util.List;

public class ChapterService {

    private ChapterDao chapterDao = new ChapterDaoMock();

    public List<Chapter> getDailyChaptersByPlan(ReadingPlan plan, LocalDate today) {
        return chapterDao.getDailyChaptersByPlan(plan, today);
    }
}
