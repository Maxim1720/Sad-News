package ru.sad_news.service.crud.finder.article.saved;

import ru.sad_news.service.util.RangeResult;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.service.crud.finder.Finder;

import java.util.List;

public class SavedArticleFinder extends Finder<SavedArticle> implements ISavedArticleFinder<SavedArticle>{
    
    @Override
    protected Class<SavedArticle> getEntityClass() {
        return SavedArticle.class;
    }

    @Override
    public List<SavedArticle> findAllByUserAccountId(Long id, RangeResult rangeResult) {
        return rankedQueryResults(
                getfindAllQuery(new String[]{
                        "userAccount", "id"
                }, id), rangeResult);
    }
}
