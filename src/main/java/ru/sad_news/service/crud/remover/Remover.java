package ru.sad_news.service.crud.remover;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.sad_news.service.crud.finder.Findable;
import ru.sad_news.service.crud.finder.Finder;

public abstract class Remover<E, ID> implements Removable<E, ID> {

    private final Class<E> entityClass;
    protected final Findable<E,ID> finder;

    @PersistenceContext(unitName = "news_portal")
    private EntityManager em;

    protected EntityManager getEntityManager(){
        return em;
    }
    protected Class<E> getEntityClass(){
        return entityClass;
    }


    public Remover(Class<E> eClass, Findable<E,ID> finder){
        this.entityClass = eClass;
        this.finder = finder;
    }


    @Override
    public void removeById(ID id){
        E e = finder.findByID(id);
        remove(e);
    }

    @Override
    public void remove(E e){
        if(!em.contains(e)){
            e = em.merge(e);
            em.refresh(e);
        }
        em.remove(e);
    }

}
