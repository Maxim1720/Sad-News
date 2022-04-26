package ru.sad_news.service.crud.finder.user.account;

import jakarta.enterprise.context.ApplicationScoped;
import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.entity.user.UserInfo;
import ru.sad_news.service.operations.user.IUserAccountFinder;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.service.crud.finder.Finder;
import ru.sad_news.service.crud.finder.user.info.UserInfoFinder;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserAccountFinder extends Finder<UserAccount> implements IUserAccountFinder {


    @Inject
    private UserInfoFinder userInfoFinder;

    @Override
    protected Class<UserAccount> getEntityClass() {
        return UserAccount.class;
    }
    @Override
    public UserAccount findByLogin(String login){
        return findBy("login", login);
    }


    public UserAccount findByUserInfo(UserInfo userInfo){
        return (UserAccount) getfindAllQuery(new String[]{"info"},userInfo).getSingleResult();
    }


    @Override
    public List<UserAccount> findAllByFirstName(String s, RangeResult rangeResult) {
        List<UserAccount> userAccounts = new ArrayList<>();
        userInfoFinder.findByFirstName(rangeResult,s).forEach(
                (u)->userAccounts.add(findByUserInfo(u))
        );
        return userAccounts;
    }

    @Override
    public List<UserAccount> findAllByLastName(String s, RangeResult rangeResult) {
        List<UserAccount> userAccounts = new ArrayList<>();
        userInfoFinder.findByLastName(rangeResult,s).forEach(
                (u)->userAccounts.add(findByUserInfo(u))
        );
        return userAccounts;
    }

    @Override
    public List<UserAccount> findAllBySecondName(String s, RangeResult rangeResult) {
        List<UserAccount> userAccounts = new ArrayList<>();
        userInfoFinder.findBySecondName(rangeResult,s).forEach(
                (u)->userAccounts.add(findByUserInfo(u))
        );
        return userAccounts;
    }
}
