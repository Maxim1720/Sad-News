package ru.sad_news.service.crud.creator.article.saved;

import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.service.crud.creator.Creator;

public class SavedArticleCreator extends Creator<SavedArticle> {
    @Override
    public Class<SavedArticle> getEntityClass() {
        return SavedArticle.class;
    }
}
