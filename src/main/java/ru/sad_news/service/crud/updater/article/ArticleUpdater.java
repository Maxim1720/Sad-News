package ru.sad_news.service.crud.updater.article;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.article.Article;
import ru.sad_news.service.crud.updater.Updater;

@Stateless
public class ArticleUpdater extends Updater<Article, Long> {

    public ArticleUpdater() {
        super(Article.class);
    }

    @Override
    protected Article getEditedEntity(Article source, Article target) {
        target.setArticleImgs(source.getArticleImgs());
        target.setRubric(source.getRubric());
        target.setText(source.getText());
        target.setUserAccount(source.getUserAccount());
        return target;
    }
}
