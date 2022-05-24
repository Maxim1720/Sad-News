package ru.sad_news.web.jsf.controller;

import lombok.Getter;
import lombok.Setter;
import ru.sad_news.service.facade.Facade;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


@Getter@Setter
public abstract class CreateController<E, ID> implements Creatable, Serializable {

    private final Facade<E, ID> facade;
    private E creatingEntity;

    public CreateController(Facade<E,ID> facade){
        this.facade = facade;
    }

    protected abstract void init();

    @Override
    public void create() {
        Logger.getGlobal().log(Level.WARNING, creatingEntity.toString() + " creating");
        facade.create(creatingEntity);
    }
}
