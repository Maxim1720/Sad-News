package ru.sad_news.service.ejb.user.account;

import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.IFacade;
import ru.sad_news.service.util.RangeResult;

import java.util.List;

public interface IUserAccountService extends IFacade<UserAccount,Long> {

     UserAccount findByLogin(String login);
     List<UserAccount> findAllByFirstName(String s, RangeResult rangeResult);
     List<UserAccount> findAllByLastName(String s, RangeResult rangeResult);
     List<UserAccount> findAllBySecondName(String s, RangeResult rangeResult);


}
