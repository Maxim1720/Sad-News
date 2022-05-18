package ru.sad_news.service.crud.finder;

import ru.sad_news.service.util.RangeResult;

import java.io.Serializable;
import java.util.List;

public interface Findable<E, ID> extends Serializable {
    E findByID(ID id);
    List<E> findAll(RangeResult rangeResult);
    List<E> findAll();
}
