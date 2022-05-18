package ru.sad_news.web.jsf.controller.category;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import ru.sad_news.entity.Category;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.facade.category.CategoryFacade;
import ru.sad_news.web.jsf.controller.GetController;

import java.util.ArrayList;

@RequestScoped
@Named
public class CategoryGetController extends GetController<Category, Long> {

    @Inject
    public CategoryGetController(CategoryFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        setSearchEntity(new Category());
        setAll(new ArrayList<>());
    }

    public String moveToCreate() {
        return "category-create";
    }

    public String moveToShow() {
        return "category";
    }

    public String moveToCategories() {
        return "categories";
    }


}
