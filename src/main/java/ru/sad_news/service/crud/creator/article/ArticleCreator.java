package ru.sad_news.service.crud.creator.article;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.article.Article;
import ru.sad_news.service.crud.creator.Creator;

@Stateless
public class ArticleCreator extends Creator<Article> {
    @Override
    public Class<Article> getEntityClass() {
        return Article.class;
    }
}
