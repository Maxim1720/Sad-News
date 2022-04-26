package ru.sad_news.service.ejb.category;

import ru.sad_news.entity.Category;
import ru.sad_news.service.Facade;
import ru.sad_news.service.crud.remover.category.CategoryRemover;
import ru.sad_news.service.crud.creator.category.CategoryCreator;
import ru.sad_news.service.crud.finder.category.CategoryFinder;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.sad_news.service.crud.updater.category.CategoryUpdater;


@Transactional
public class CategoryFacade extends Facade<Category, Long> {

    @Inject
    public CategoryFacade(CategoryCreator creator, CategoryFinder finder, CategoryUpdater categoryUpdater, CategoryRemover categoryRemover){
        super(Category.class,creator,finder,categoryUpdater,categoryRemover);
    }

    public Category findByName(String name){
        return ((CategoryFinder) finder).findByName(name);
    }
}
