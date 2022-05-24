package ru.sad_news.web.jsf.controller.article;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.article.Article;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.facade.article.ArticleFacade;
import ru.sad_news.web.jsf.controller.RemoveController;

@Getter@Setter
@SessionScoped
@Named
public class ArticleRemoveController extends RemoveController<Article, Long> {

    @Inject
    public ArticleRemoveController(ArticleFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        setRemovingEntity(new Article());
    }
}
