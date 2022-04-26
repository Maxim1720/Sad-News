package ru.sad_news.service.crud.creator.rubric;

import jakarta.ejb.Stateless;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.crud.creator.Creator;

@Stateless
public class RubricCreator extends Creator<Rubric> {
    @Override
    public Class<Rubric> getEntityClass() {
        return Rubric.class;
    }
}
