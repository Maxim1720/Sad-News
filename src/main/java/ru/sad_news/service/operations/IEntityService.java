package ru.sad_news.service.operations;

import ru.sad_news.service.util.RangeResult;

import java.util.List;

public interface IEntityService<E, ID> {
    List<E> findAll();
    List<E> findAll(RangeResult rangeResult);
    Long count();
}
