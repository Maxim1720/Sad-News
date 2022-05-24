package ru.sad_news.web.jsf.controller;

import lombok.Getter;
import lombok.Setter;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.util.RangeResult;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
public abstract class GetController<E, ID> implements Serializable {

    private Facade<E, ID> facade;
    private ID searchId;
    private E searchEntity;
    private List<E> all;

    public GetController(Facade<E,ID> facade){
        this.facade = facade;
    }

    protected abstract void init();

    public E findById(ID id){
        setSearchId(id);
        setById();
        return getSearchEntity();
    }

    public void setById(){
        Logger.getGlobal().log(Level.WARNING, searchId.toString() + " searching");
        searchEntity = facade.findById(searchId);
    }

    public void setAllEntities(){
        Logger.getGlobal().log(Level.WARNING, "all searching: ");
        all = facade.findAll(new RangeResult(0,150));
        Logger.getGlobal().log(Level.WARNING, "all searched, size: "+ all.size());
    }

    public List<E> findAll(){
        setAllEntities();
        return all;
    }
}
