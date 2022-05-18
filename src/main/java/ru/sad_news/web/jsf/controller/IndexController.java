package ru.sad_news.web.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@RequestScoped
@Named
public class IndexController {

    public String moveToIndex(){
        return "index";
    }

}
