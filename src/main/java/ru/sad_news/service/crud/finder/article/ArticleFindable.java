package ru.sad_news.service.crud.finder.article;

import ru.sad_news.service.crud.finder.Findable;
import ru.sad_news.service.util.RangeResult;

import java.util.List;

public interface ArticleFindable<T> extends Findable<T,Long> {
    List<T> findAllByRubric(Long rubricId, RangeResult rangeResult);

    List<T> findAllByCategory(Long categoryId, RangeResult rangeResult);

    List<T> findAllByUserAccountId(Long id, RangeResult rangeResult);

    List<T> findAllSavedByUserAccountId(Long id, RangeResult rangeResult);
}
