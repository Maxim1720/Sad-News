package ru.sad_news.web.jsf.controller.rubric;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Category;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.facade.rubric.RubricFacade;
import ru.sad_news.web.jsf.controller.Controller;

@Getter
@Setter
@Named
@RequestScoped
public class RubricController extends Controller<Rubric, Long> {

    @Inject
    protected RubricController(RubricFacade facade) {
        super(facade);
    }

    private Category category;

    @Size(max = 50, min = 2)
    private String name;

    @PostConstruct
    @Override
    protected void init() {
        e = new Rubric();
        category = new Category();
    }

    @Override
    public void create() {
        e.setName(name);
        e.setCategory(category);
        super.create();
    }
}
