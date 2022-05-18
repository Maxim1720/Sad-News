package ru.sad_news.web.jsf.controller.category;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Category;
import ru.sad_news.service.facade.category.CategoryFacade;
import ru.sad_news.web.jsf.controller.Controller;


@Getter
@Setter
@Named
@RequestScoped
public class CategoryController extends Controller<Category,Long> {

    @Inject
    protected CategoryController(CategoryFacade facade) {
        super(facade);
    }

    @Size
    String name;

    @PostConstruct
    @Override
    protected void init() {
        e = new Category();
    }


    @Override
    public void create() {
        e.setName(name);
        super.create();
    }

}
