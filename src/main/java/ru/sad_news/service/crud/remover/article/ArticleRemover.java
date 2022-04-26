package ru.sad_news.service.crud.remover.article;

import jakarta.inject.Inject;
import ru.sad_news.entity.article.Article;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.service.crud.finder.article.ArticleFinder;
import ru.sad_news.service.crud.remover.Remover;
import ru.sad_news.service.crud.remover.article.saved.SavedArticleRemover;

public class ArticleRemover extends Remover<Article, Long> {
    @Inject
    public ArticleRemover(ArticleFinder finder) {
        super(Article.class, finder);
    }

    @Inject
    SavedArticleRemover savedArticleRemover;
    public void removeSavedArticle(SavedArticle savedArticle){
        savedArticleRemover.remove(savedArticle);
    }
}
