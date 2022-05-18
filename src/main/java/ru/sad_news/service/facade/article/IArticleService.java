package ru.sad_news.service.facade.article;

import ru.sad_news.entity.article.Article;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.service.facade.IFacade;
import ru.sad_news.service.util.RangeResult;

import java.util.List;

public interface IArticleService extends IFacade<Article,Long> {
    List<Article> findAllByRubric(Long rubricId, RangeResult result);

    List<Article> findAllByCategory(Long categoryId, RangeResult rangeResult);

    List<Article> findAllByUserAccountId(Long id, RangeResult rangeResult);

    List<Article> findAllSavedByUserAccountId(Long id, RangeResult rangeResult);

    SavedArticle createSavedArticle(Long articleId, Long userId);

    void removeSavedArticle(Long articleId, Long userId);
}
