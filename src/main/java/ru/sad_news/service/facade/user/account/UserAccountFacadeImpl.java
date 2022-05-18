package ru.sad_news.service.facade.user.account;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.sad_news.service.crud.creator.user.account.UserAccountCreator;
import ru.sad_news.service.crud.finder.user.account.UserAccountFinder;
import ru.sad_news.service.crud.remover.user.account.UserAccountRemover;
import ru.sad_news.service.crud.updater.user.account.UserAccountUpdater;

//@EJB(name = "UserAccountService", beanInterface = UserAccountFacade.class,beanName = "userAccountService")

@Transactional
public  class UserAccountFacadeImpl extends UserAccountFacade {
    @Inject
    public UserAccountFacadeImpl(UserAccountCreator creator,
                                 UserAccountFinder finder,
                                 UserAccountUpdater userAccountUpdater,
                                 UserAccountRemover userAccountRemover) {
        super(creator, finder,userAccountUpdater,userAccountRemover);
    }
}
