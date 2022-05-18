package ru.sad_news.service.facade.user.account;

import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.crud.creator.Creator;
import ru.sad_news.service.crud.finder.Finder;
import ru.sad_news.service.crud.finder.user.account.UserAccountFinder;
import ru.sad_news.service.crud.remover.Remover;
import ru.sad_news.service.crud.updater.Updater;
import ru.sad_news.service.util.RangeResult;

import java.util.List;
import java.util.Optional;

public abstract class UserAccountFacade extends Facade<UserAccount, Long> implements IUserAccountService {

    public UserAccountFacade(Creator<UserAccount> creator,
                             Finder<UserAccount, Long> finder,
                             Updater<UserAccount, Long> updater,
                             Remover<UserAccount, Long> remover) {
        super(UserAccount.class, creator, finder, updater, remover);
    }

    public UserAccount findByLogin(String login) {
        Optional<UserAccount> result = Optional.of(
                ((UserAccountFinder) finder).findByLogin(login)
        );

        return result.orElseThrow(() -> {
            throw new RuntimeException("user account not found");
        });
    }

    public List<UserAccount> findAllByFirstName(String s, RangeResult rangeResult){
        return ((UserAccountFinder) finder).findAllByFirstName(s,rangeResult);
    }
    public List<UserAccount> findAllByLastName(String s, RangeResult rangeResult){
        return ((UserAccountFinder) finder).findAllByLastName(s,rangeResult);
    }
    public List<UserAccount> findAllBySecondName(String s, RangeResult rangeResult){
        return ((UserAccountFinder) finder).findAllBySecondName(s,rangeResult);
    }
}
