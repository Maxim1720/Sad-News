package ru.sad_news.web.jsf.controller.article.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Named
@RequestScoped
public class ArticleViewController {
    public String getInfo(){
        return "article";
    }
}
