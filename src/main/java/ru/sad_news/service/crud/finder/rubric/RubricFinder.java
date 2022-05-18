package ru.sad_news.service.crud.finder.rubric;

import jakarta.enterprise.context.ApplicationScoped;
import ru.sad_news.entity.Category;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.service.crud.finder.Finder;

import java.util.List;

@ApplicationScoped
public class RubricFinder extends Finder<Rubric,Long> implements IRubricFinder<Rubric> {

    @Override
    protected Class<Rubric> getEntityClass() {
        return Rubric.class;
    }

    public Rubric findByName(String name){
        return (Rubric) getfindAllQuery(new String[]{"name"}, name).getResultList().get(0);//findBy("name", name);

    }
    public List<Rubric> findByCategory(Category category, RangeResult rangeResult) {
         return rankedQueryResults(getfindAllQuery(new String[]{"category"},category),rangeResult);
    }
}
