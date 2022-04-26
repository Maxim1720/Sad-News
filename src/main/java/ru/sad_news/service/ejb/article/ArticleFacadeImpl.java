package ru.sad_news.service.ejb.article;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.sad_news.service.crud.creator.article.ArticleCreator;
import ru.sad_news.service.crud.finder.article.ArticleFinder;
import ru.sad_news.service.crud.remover.article.ArticleRemover;
import ru.sad_news.service.crud.updater.article.ArticleUpdater;
import ru.sad_news.service.ejb.user.account.UserAccountFacadeImpl;


@Transactional
public class ArticleFacadeImpl extends ArticleFacade {

    @Inject
    public ArticleFacadeImpl(ArticleCreator creator,
                             ArticleFinder finder,
                             ArticleRemover articleRemover,
                             ArticleUpdater articleUpdater,
                             UserAccountFacadeImpl userAccountFacadeImpl) {
        super(creator,finder,articleUpdater,articleRemover, userAccountFacadeImpl);
    }

}
