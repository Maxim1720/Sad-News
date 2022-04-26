package ru.sad_news.service.crud.updater.user.info;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.user.UserInfo;
import ru.sad_news.service.crud.updater.Updater;

@Stateless
public class UserInfoUpdater extends Updater<UserInfo, Long> {

    public UserInfoUpdater() {
        super(UserInfo.class);
    }

    @Override
    protected UserInfo getEditedEntity(UserInfo source, UserInfo target) {
        target.setFirstname(source.getFirstname());
        target.setLastname(source.getLastname());
        target.setSecondName(source.getSecondName());
        return target;
    }
}
