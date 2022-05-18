package ru.sad_news.web.jsf.controller;

import jakarta.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.util.RangeResult;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
public abstract class GetController<E, ID>{

    private Facade<E, ID> facade;
    private ID searchId;
    private E searchEntity;
    private List<E> all;

    public GetController(Facade<E,ID> facade){
        this.facade = facade;
    }

    protected abstract void init();


    public E findById(ID id){
        searchId = id;
        Logger.getGlobal().log(Level.WARNING, searchId.toString() + " searching");
        searchEntity = facade.findById(searchId);
        return searchEntity;
    }

    public void findById(){
        Logger.getGlobal().log(Level.WARNING, searchId.toString() + " searched");
        searchEntity = facade.findById(searchId);
    }

    public void findAll(){
        all = facade.findAll(new RangeResult(0,150));
    }
}
