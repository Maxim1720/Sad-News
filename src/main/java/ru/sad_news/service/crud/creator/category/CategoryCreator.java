package ru.sad_news.service.crud.creator.category;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.Category;
import ru.sad_news.service.crud.creator.Creator;

@Stateless
public class CategoryCreator extends Creator<Category> {
    @Override
    public Class<Category> getEntityClass() {
        return Category.class;
    }
}
