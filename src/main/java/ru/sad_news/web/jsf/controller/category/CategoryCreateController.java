package ru.sad_news.web.jsf.controller.category;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Category;
import ru.sad_news.service.facade.category.CategoryFacade;
import ru.sad_news.web.jsf.controller.CreateController;

@Named
@SessionScoped
@Getter@Setter
public class CategoryCreateController extends CreateController<Category, Long> {

    @Inject
    public CategoryCreateController(CategoryFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        setCreatingEntity(new Category());
    }
}
