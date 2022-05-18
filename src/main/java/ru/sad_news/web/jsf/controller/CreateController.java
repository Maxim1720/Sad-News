package ru.sad_news.web.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.service.facade.Facade;


@Getter@Setter
public abstract class CreateController<E, ID> implements Creatable {

    private final Facade<E, ID> facade;
    private E createEntity;

    public CreateController(Facade<E,ID> facade){
        this.facade = facade;
    }

    protected abstract void init();

    @Override
    public void create() {
        facade.create(createEntity);
    }
}
