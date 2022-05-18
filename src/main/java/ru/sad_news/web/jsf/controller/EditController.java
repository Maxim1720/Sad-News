package ru.sad_news.web.jsf.controller;

import lombok.Getter;
import lombok.Setter;
import ru.sad_news.service.crud.updater.Updatable;

import java.io.Serializable;

@Getter@Setter
public abstract class EditController<E, ID> implements Serializable {

    private final Updatable<E,ID> updater;
    private E newEntityValue;
    private E oldEntityValue;
    private ID updatingID;


    public EditController(Updatable<E,ID> updater){
        this.updater = updater;
    }

    public void edit(){

        updater.update(newEntityValue, updatingID);
    }

    public void edit(E e, ID id){
        this.setNewEntityValue(e);
        this.setUpdatingID(id);
        updater.update(newEntityValue, updatingID);
    }

    protected abstract void init();



}
