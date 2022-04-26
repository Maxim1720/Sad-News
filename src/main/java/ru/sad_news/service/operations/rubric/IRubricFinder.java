package ru.sad_news.service.operations.rubric;

import ru.sad_news.entity.Category;
import ru.sad_news.service.util.RangeResult;

import java.util.List;

public interface IRubricFinder<R> {
    R findByName(String name);

    List<R> findByCategory(Category category, RangeResult rangeResult);
}
