package ru.sad_news.service.ejb.user.info;

import ru.sad_news.service.crud.remover.user.info.UserInfoRemover;
import ru.sad_news.service.operations.user.IUserInfoFinder;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.entity.user.UserInfo;
import ru.sad_news.service.crud.creator.user.info.UserInfoCreator;
import ru.sad_news.service.crud.updater.user.info.UserInfoUpdater;
import ru.sad_news.service.crud.finder.user.info.UserInfoFinder;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.sad_news.service.Facade;

import java.util.List;
import java.util.logging.Logger;


@Transactional
public class UserInfoService extends Facade<UserInfo,Long> implements IUserInfoFinder<UserInfo> {

    private static final Logger logger = Logger.getLogger(UserInfoService.class.getCanonicalName());


    @Inject
    public UserInfoService(UserInfoCreator creator,
                           UserInfoFinder finder,
                           UserInfoUpdater updater,
                           UserInfoRemover remover) {
        super(UserInfo.class, creator, finder,updater,remover);
    }

    @Override
    public List<UserInfo> findByFirstName(RangeResult rangeResult, String firstname) {
        return ((UserInfoFinder) finder).findByFirstName(rangeResult,firstname);
    }


    @Override
    public List<UserInfo> findBySecondName(RangeResult rangeResult, String secondName) {
        return ((UserInfoFinder) finder).findByFirstName(rangeResult,secondName);
    }

    @Override
    public List<UserInfo> findByLastName(RangeResult rangeResult, String lastname) {
        return ((UserInfoFinder) finder).findByFirstName(rangeResult,lastname);
    }
}
