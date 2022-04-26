package ru.sad_news.service.crud.finder.article;

import ru.sad_news.entity.article.Article;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.service.crud.finder.article.saved.SavedArticleFinder;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.service.crud.finder.Finder;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import ru.sad_news.service.operations.article.IArticleFinder;

import java.util.*;


public class ArticleFinder extends Finder<Article> implements IArticleFinder<Article> {

    @Inject
    SavedArticleFinder savedArticleFinder;

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

    @Override
    public List<Article> findAllByRubric(Long rubricId, RangeResult rangeResult) {
        Query q = getfindAllQuery(
                new String[]{
                        "rubric","id"
                },rubricId
        );
        return rankedQueryResults(q,rangeResult);
    }

    @Override
    public List<Article> findAllByCategory(Long categoryId, RangeResult rangeResult) {
        return rankedQueryResults(getfindAllQuery(
           new String[]{"rubric","category","id"},
           categoryId
        ),rangeResult);
    }



    @Override
    public List<Article> findAllByUserAccountId(Long id, RangeResult rangeResult) {
        return rankedQueryResults(
                getfindAllQuery(new String[]{
                                "userAccount", "id"
                        }, id
                ), rangeResult);
    }


    @Override
    public List<Article> findAllSavedByUserAccountId(Long id, RangeResult rangeResult) {
        List<SavedArticle> savedArticles = savedArticleFinder.findAllByUserAccountId(id,rangeResult);
        List<Article> articles= new ArrayList<>();
        for (SavedArticle s:
             savedArticles) {
            articles.add(s.getArticle());
        }
        return articles;
    }

}
