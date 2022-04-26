package ru.sad_news.service.crud.remover.article.saved;


import jakarta.inject.Inject;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.entity.savedArticle.SavedArticlePK;
import ru.sad_news.service.crud.finder.article.saved.SavedArticleFinder;
import ru.sad_news.service.crud.remover.Remover;

public class SavedArticleRemover extends Remover<SavedArticle, SavedArticlePK> {
    @Inject
    public SavedArticleRemover(SavedArticleFinder finder) {
        super(SavedArticle.class, finder);
    }

}
