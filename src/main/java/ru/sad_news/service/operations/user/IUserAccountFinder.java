package ru.sad_news.service.operations.user;

import ru.sad_news.service.util.RangeResult;
import ru.sad_news.entity.user.UserAccount;

import java.util.List;

public interface IUserAccountFinder {
    UserAccount findByLogin(String login);
    List<UserAccount> findAllByFirstName(String s, RangeResult rangeResult);
    List<UserAccount> findAllByLastName(String s, RangeResult rangeResult);
    List<UserAccount> findAllBySecondName(String s, RangeResult rangeResult);
}
