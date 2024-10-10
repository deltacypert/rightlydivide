package main.dao;

import main.model.Chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterDAOImpl implements GenericDAO<Chapter, Integer> {
    private List<Chapter> chapters = new ArrayList<>();
    private int currentId = 0;

    @Override
    public void save(Chapter chapter) {
        chapters.add(chapter);
    }

    @Override
    public Chapter findById(Integer id) {
        if (id >= 0 && id < chapters.size()) {
            return chapters.get(id);
        }
        return null;
    }

    @Override
    public List<Chapter> findAll() {
        return new ArrayList<>(chapters);
    }

    @Override
    public void update(Chapter entity) {
        // TODO: implement logic
    }

    @Override
    public void delete(Integer id) {
        if (id >= 0 && id < chapters.size()) {
            chapters.remove(id);
        }
    }
}
