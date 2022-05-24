package ru.sad_news.web.jsf.controller.rubric;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.facade.rubric.RubricFacade;
import ru.sad_news.web.jsf.controller.RemoveController;

@SessionScoped
@Named
@Getter@Setter
public class RubricRemoveController extends RemoveController<Rubric,Long> {

    @Inject
    public RubricRemoveController(RubricFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        setRemovingEntity(new Rubric());
    }
}
