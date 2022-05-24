package ru.sad_news.web.jsf.controller.rubric;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.facade.rubric.RubricFacade;
import ru.sad_news.web.jsf.controller.CreateController;

@Getter@Setter
@Named
@SessionScoped
public class RubricCreateController extends CreateController<Rubric,Long> {

    @Inject
    public RubricCreateController(RubricFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        setCreatingEntity(new Rubric());
    }

    @Override
    public void create() {
        super.create();
    }
}
