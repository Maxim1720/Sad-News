package ru.sad_news.service.crud.creator.user.info;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.user.UserInfo;
import ru.sad_news.service.crud.creator.Creator;

@Stateless
public class UserInfoCreator extends Creator<UserInfo> {
    @Override
    public Class<UserInfo> getEntityClass() {
        return UserInfo.class;
    }
}
