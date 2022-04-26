package ru.sad_news.service.crud.remover.user.info;

import jakarta.inject.Inject;
import ru.sad_news.entity.user.UserInfo;
import ru.sad_news.service.crud.finder.user.info.UserInfoFinder;
import ru.sad_news.service.crud.remover.Remover;


public class UserInfoRemover extends Remover<UserInfo,Long> {
    @Inject
    public UserInfoRemover(UserInfoFinder finder) {
        super(UserInfo.class, finder);
    }

}
