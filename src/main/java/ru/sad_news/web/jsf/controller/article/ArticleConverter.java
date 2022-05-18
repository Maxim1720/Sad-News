package ru.sad_news.web.jsf.controller.article;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import ru.sad_news.entity.article.Article;
import ru.sad_news.service.facade.article.ArticleFacade;

import java.io.Serializable;


@FacesConverter(managed = true,value = "ru.sad_news.web.controller.article.ArticleConverter")
public class ArticleConverter implements Converter<Article>, Serializable {

    @Inject
    ArticleFacade facade;

    @Override
    public Article getAsObject(FacesContext context, UIComponent component, String value) {
        return facade.findById(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Article value) {
        return value.getId().toString();
    }
}
