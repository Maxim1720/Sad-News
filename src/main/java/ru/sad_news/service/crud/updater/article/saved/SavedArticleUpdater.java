package ru.sad_news.service.crud.updater.article.saved;

import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.entity.savedArticle.SavedArticlePK;
import ru.sad_news.service.crud.updater.Updater;

public class SavedArticleUpdater extends Updater<SavedArticle, SavedArticlePK> {

    public SavedArticleUpdater() {
        super(SavedArticle.class);
    }

    @Override
    protected SavedArticle getEditedEntity(SavedArticle source, SavedArticle target) {
        target.setArticle(source.getArticle());
        target.setUserAccount(source.getUserAccount());
        return target;
    }
}
