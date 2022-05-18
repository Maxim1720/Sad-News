package ru.sad_news.service.crud.finder.user.info;

import jakarta.enterprise.context.ApplicationScoped;
import ru.sad_news.entity.user.UserInfo;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.service.crud.finder.Finder;

import java.util.List;

@ApplicationScoped
public class UserInfoFinder extends Finder<UserInfo, Long> {

    @Override
    protected Class<UserInfo> getEntityClass() {
        return UserInfo.class;
    }


    public List<UserInfo> findByFirstName(RangeResult rangeResult, String firstname) {
        return rankedQueryResults(getfindAllQuery(new String[]{"firstname"},firstname),rangeResult);//findListBy("firstname", firstname, rangeResult);
    }


    public List<UserInfo> findBySecondName(RangeResult rangeResult, String secondName) {
        return rankedQueryResults(getfindAllQuery(new String[]{"secondName"},secondName),rangeResult);
    }

    public List<UserInfo> findByLastName(RangeResult rangeResult, String lastname) {
        return rankedQueryResults(getfindAllQuery(new String[]{"lastname"},lastname),rangeResult);
    }

}
