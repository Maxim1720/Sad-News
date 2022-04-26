package ru.sad_news.service.crud.finder.category;

import jakarta.enterprise.context.ApplicationScoped;
import ru.sad_news.entity.Category;
import ru.sad_news.service.crud.finder.Finder;
@ApplicationScoped
public class CategoryFinder extends Finder<Category> {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    public Category findByName(String name){
        return findBy("name", name);
    }
}
