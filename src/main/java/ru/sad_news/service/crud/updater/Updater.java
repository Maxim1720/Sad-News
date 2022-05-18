package ru.sad_news.service.crud.updater;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class Updater<E, ID> implements Updatable<E,ID>{

    public Updater(Class<E> eClass){
        this.entityClass = eClass;
    }
    private final Class<E> entityClass;

    protected  Class<E> getEntityClass(){
        return entityClass;
    }

    @PersistenceContext(unitName = "news_portal")
    private EntityManager em;

    protected EntityManager getEntityManager(){
        return em;
    }

    public E update(E e, ID id){
        E e1 = getEntityManager().merge(
                getEditedEntity(e,getEntityManager().find(getEntityClass(),id))
                //getEntityManager().find(getEntityClass(),id)
        );
        //em.refresh(getEditedEntity(e,e1));
        return e1;
    }

    protected abstract E getEditedEntity(E source, E target);
}
