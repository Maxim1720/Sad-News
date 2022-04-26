package ru.sad_news.service.crud.finder.article.saved;

import ru.sad_news.service.util.RangeResult;

import java.util.List;

public interface ISavedArticleFinder<T> {
    List<T> findAllByUserAccountId(Long id, RangeResult rangeResult);
}
