package ru.sad_news.service.ejb.rubric;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.sad_news.entity.Category;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.Facade;
import ru.sad_news.service.crud.creator.rubric.RubricCreator;
import ru.sad_news.service.crud.finder.rubric.RubricFinder;
import ru.sad_news.service.crud.remover.rubric.RubricRemover;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.service.crud.updater.rubric.RubricUpdater;

import java.util.List;

@Transactional
public class RubricFacade extends Facade<Rubric,Long> {


    @Inject
    public RubricFacade(RubricCreator creator, RubricFinder finder, RubricUpdater rubricUpdater, RubricRemover rubricRemover) {
        super(Rubric.class, creator, finder,rubricUpdater,rubricRemover);
    }

    public Rubric findByName(String name) {
        return ((RubricFinder) finder).findByName(name);
    }

    public List<Rubric> findByCategory(Category category, RangeResult rangeResult) {
        return ((RubricFinder) finder).findByCategory(category,rangeResult);
    }

}
