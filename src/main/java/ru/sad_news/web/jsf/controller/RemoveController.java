package ru.sad_news.web.jsf.controller;


import lombok.Getter;
import lombok.Setter;
import ru.sad_news.service.facade.Facade;

import java.util.logging.Level;
import java.util.logging.Logger;

@Getter@Setter
public abstract class RemoveController<E,ID> {

    private final Facade<E,ID> facade;
    protected ID removingEntityId;
    protected E removingEntity;

    public RemoveController(Facade<E, ID> facade){
        this.facade = facade;
    }

    public void removeByID(ID id){
        Logger.getGlobal().log(Level.INFO, " removing by" + id);
        facade.removeById(id);
    }

    public void removeByID(){
        removeByID(removingEntityId);
    }

    public void removeEntity() {
        Logger.getGlobal().log(Level.INFO, " removing by" + removingEntity);
        facade.remove(removingEntity);
    }

    protected abstract void init();

}
