package ru.sad_news.service.crud.remover.user.account;

import jakarta.inject.Inject;
import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.crud.finder.user.account.UserAccountFinder;
import ru.sad_news.service.crud.remover.Remover;


public class UserAccountRemover extends Remover<UserAccount, Long> {
    @Inject
    public UserAccountRemover(UserAccountFinder finder) {
        super(UserAccount.class, finder);
    }
}
