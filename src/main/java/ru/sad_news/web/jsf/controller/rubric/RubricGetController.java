package ru.sad_news.web.jsf.controller.rubric;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.facade.rubric.RubricFacade;
import ru.sad_news.web.jsf.controller.GetController;

@Getter
@Setter
@RequestScoped
@Named
public class RubricGetController extends GetController<Rubric, Long> {

    @Inject
    public RubricGetController(RubricFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        setSearchEntity(new Rubric());
    }

    public String moveToRubric(){
        return "rubric";
    }
}
