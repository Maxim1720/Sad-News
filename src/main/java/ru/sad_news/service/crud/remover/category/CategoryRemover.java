package ru.sad_news.service.crud.remover.category;

import jakarta.inject.Inject;
import ru.sad_news.entity.Category;
import ru.sad_news.service.crud.finder.category.CategoryFinder;
import ru.sad_news.service.crud.remover.Remover;

public class CategoryRemover extends Remover<Category, Long> {
    @Inject
    public CategoryRemover(CategoryFinder finder) {
        super(Category.class, finder);
    }
}
