package com.aca.backend.dao;

import com.aca.backend.model.Chapter;
import com.aca.backend.model.ReadingPlan;

import java.time.LocalDate;
import java.util.List;

public interface ChapterDao {
    public abstract List<Chapter> getDailyChaptersByPlan(ReadingPlan plan, LocalDate today);
}
