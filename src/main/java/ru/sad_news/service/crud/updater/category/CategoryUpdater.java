package ru.sad_news.service.crud.updater.category;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.Category;
import ru.sad_news.service.crud.updater.Updater;

@Stateless
public class CategoryUpdater extends Updater<Category, Long> {

    public CategoryUpdater() {
        super(Category.class);
    }

    @Override
    protected Category getEditedEntity(Category source, Category target) {
        target.setName(source.getName());
        return target;
    }
}
