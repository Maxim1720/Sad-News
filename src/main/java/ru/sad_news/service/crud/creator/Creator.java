package ru.sad_news.service.crud.creator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class Creator<E> {
    @PersistenceContext(unitName = "news_portal")
    private EntityManager em;


    protected EntityManager getEntityManager(){
        return em;
    }
    public abstract Class<E> getEntityClass();

    public E create(E e){
        getEntityManager().persist(e);
        //getEntityManager().merge(e);
        return e;
    }
}
