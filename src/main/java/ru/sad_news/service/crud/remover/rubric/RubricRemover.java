package ru.sad_news.service.crud.remover.rubric;

import jakarta.inject.Inject;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.crud.finder.rubric.RubricFinder;
import ru.sad_news.service.crud.remover.Remover;


public class RubricRemover extends Remover<Rubric,Long> {
    @Inject
    public RubricRemover(RubricFinder finder) {
        super(Rubric.class, finder);
    }
}
