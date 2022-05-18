package ru.sad_news.web.jsf.utils;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Utils {

    public static Long fromString(String value){
        return Long.parseLong(value);
    }

}
