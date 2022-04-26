package ru.sad_news.service.crud.updater.user.account;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.crud.updater.Updater;

@Stateless
public class UserAccountUpdater extends Updater<UserAccount, Long> {

    public UserAccountUpdater() {
        super(UserAccount.class);
    }

    @Override
    protected UserAccount getEditedEntity(UserAccount source, UserAccount target) {
        target.setInfo(source.getInfo());
        target.setLogin(source.getLogin());
        target.setPassword(source.getPassword());
        return target;
    }
}
