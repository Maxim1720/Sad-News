package ru.sad_news.service.crud.updater.rubric;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.crud.updater.Updater;

@Stateless
public class RubricUpdater extends Updater<Rubric, Long> {

    public RubricUpdater() {
        super(Rubric.class);
    }

    @Override
    protected Rubric getEditedEntity(Rubric source, Rubric target) {
        target.setArticles(source.getArticles());
        target.setCategory(source.getCategory());
        target.setName(source.getName());
        return target;
    }


}
