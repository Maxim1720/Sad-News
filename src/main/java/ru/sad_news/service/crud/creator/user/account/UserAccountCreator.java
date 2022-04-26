package ru.sad_news.service.crud.creator.user.account;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.crud.creator.Creator;

@Stateless
public class UserAccountCreator extends Creator<UserAccount> {

    @Override
    public Class<UserAccount> getEntityClass() {
        return UserAccount.class;
    }
}
