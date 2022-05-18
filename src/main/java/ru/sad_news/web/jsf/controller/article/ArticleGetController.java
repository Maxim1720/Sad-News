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
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.web.jsf.controller.GetController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
@RequestScoped
@Named
public class ArticleGetController extends GetController<Article, Long> {
    @Inject
    public ArticleGetController(ArticleFacade facade) {
        super(facade);
    }

    private RangeResult getRangeResult(){
        return new RangeResult(0,150);
    }

    private List<Article> allByRubric;
    private Long rubricId;


    @PostConstruct
    @Override
    protected void init() {
        setSearchEntity(new Article());
        allByRubric = new ArrayList<>();
    }

    public void findAllByRubricId(Long rubricId){
        setRubricId(rubricId);
        findAllByRubricId();
    }

    public void findAllByRubricId(){
        Logger.getGlobal().log(Level.INFO, "finding all articles by rubric id" + rubricId);
        setAllByRubric(((ArticleFacade) getFacade()).findAllByRubric(rubricId,getRangeResult()));
    }
}
