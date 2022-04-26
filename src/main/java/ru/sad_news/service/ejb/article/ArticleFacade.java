package ru.sad_news.service.ejb.article;

import ru.sad_news.entity.article.Article;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.entity.savedArticle.SavedArticlePK;
import ru.sad_news.service.Facade;
import ru.sad_news.service.crud.creator.Creator;
import ru.sad_news.service.crud.finder.Finder;
import ru.sad_news.service.crud.finder.article.ArticleFinder;
import ru.sad_news.service.crud.remover.Remover;
import ru.sad_news.service.crud.remover.article.ArticleRemover;
import ru.sad_news.service.crud.updater.Updater;
import ru.sad_news.service.ejb.user.account.UserAccountFacadeImpl;
import ru.sad_news.service.util.RangeResult;

import java.util.List;


public abstract class ArticleFacade extends Facade<Article, Long> implements IArticleService{

    public ArticleFacade(Creator<Article> creator,
                         Finder<Article> finder,
                         Updater<Article, Long> updater,
                         Remover<Article, Long> remover,
                         UserAccountFacadeImpl userAccountFacadeImpl) {
        super(Article.class, creator, finder, updater, remover);
        this.userAccountFacadeImpl = userAccountFacadeImpl;
    }

    private final UserAccountFacadeImpl userAccountFacadeImpl;

    public List<Article> findAllByRubric(Long rubricId, RangeResult result) {
        return ((ArticleFinder) finder).findAllByRubric(rubricId,result);
    }


    public List<Article> findAllByCategory(Long categoryId, RangeResult rangeResult) {
        return ((ArticleFinder) finder).findAllByCategory(categoryId, rangeResult);
    }


    public List<Article> findAllByUserAccountId(Long id, RangeResult rangeResult) {
        return ((ArticleFinder) finder).findAllByUserAccountId(id,rangeResult);
    }


    public List<Article> findAllSavedByUserAccountId(Long id, RangeResult rangeResult) {
        return ((ArticleFinder) finder).findAllSavedByUserAccountId(id,rangeResult);
    }


    @Override
    public SavedArticle createSavedArticle(Long articleId, Long userId) {
        SavedArticle s = initSavedArticle(articleId,userId);
        getEntityManager().persist(s);
        return s;
    }

    @Override
    public void removeSavedArticle(Long articleId, Long userId) {
        ((ArticleRemover) remover).removeSavedArticle(initSavedArticle(articleId,userId));
    }

    protected SavedArticle initSavedArticle(Long articleId, Long userId){
        SavedArticle savedArticle = new SavedArticle();
        savedArticle.setId(new SavedArticlePK(articleId,userId));
        savedArticle.setArticle(findById(articleId));
        savedArticle.setUserAccount(userAccountFacadeImpl.findById(userId));
        return savedArticle;
    }
}
