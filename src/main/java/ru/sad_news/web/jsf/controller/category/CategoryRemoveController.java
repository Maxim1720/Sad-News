package ru.sad_news.web.jsf.controller.category;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Category;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.facade.category.CategoryFacade;
import ru.sad_news.web.jsf.controller.RemoveController;

import java.io.Serializable;

@Getter@Setter
@SessionScoped
@Named
public class CategoryRemoveController extends RemoveController<Category, Long> implements Serializable {

    @Inject
    public CategoryRemoveController(CategoryFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        removingEntity = new Category();
    }
}
