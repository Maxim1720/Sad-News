package ru.sad_news.web.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named
public class Converter {

    public Long toLong(String id){
        return Long.parseLong(id);
    }

}
