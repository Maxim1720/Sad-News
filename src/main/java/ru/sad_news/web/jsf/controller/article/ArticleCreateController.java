package ru.sad_news.web.jsf.controller.article;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.article.Article;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.facade.article.ArticleFacade;
import ru.sad_news.web.jsf.controller.CreateController;

@Getter
@Setter
@RequestScoped
@Named
public class ArticleCreateController extends CreateController<Article, Long> {

    @Inject
    public ArticleCreateController(ArticleFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        setCreateEntity(new Article());
    }
}
