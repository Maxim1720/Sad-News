package ru.sad_news.service.operations.user;

import ru.sad_news.service.util.RangeResult;

import java.util.List;

public interface IUserInfoFinder<U> {
    List<U> findByFirstName(RangeResult rangeResult, String firstname);
    List<U> findBySecondName(RangeResult rangeResult, String secondName);
    List<U> findByLastName(RangeResult rangeResult, String lastname);
}
