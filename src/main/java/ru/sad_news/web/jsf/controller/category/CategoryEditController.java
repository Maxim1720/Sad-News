package ru.sad_news.web.jsf.controller.category;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Category;
import ru.sad_news.service.crud.finder.category.CategoryFinder;
import ru.sad_news.service.crud.updater.Updatable;
import ru.sad_news.service.crud.updater.category.CategoryUpdater;
import ru.sad_news.web.jsf.controller.EditController;

@Getter@Setter
@Named
@SessionScoped
public class CategoryEditController extends EditController<Category, Long> {

    @Inject
    public CategoryEditController(CategoryUpdater updater) {
        super(updater);
    }

    @Inject
    private CategoryFinder categoryFinder;

    @PostConstruct
    @Override
    protected void init() {
        setNewEntityValue(new Category());
        setOldEntityValue(new Category());
    }

    public void resetOldEntityValue(){
        setOldEntityValue(categoryFinder.findByID(getUpdatingID()));
    }
}
