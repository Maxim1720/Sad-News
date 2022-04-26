package ru.sad_news.service.crud.remover;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.sad_news.service.crud.finder.Finder;

public abstract class Remover<E, ID> {

    private final Class<E> entityClass;
    protected final Finder<E> finder;
    @PersistenceContext(unitName = "news_portal")
    private EntityManager em;

    protected EntityManager getEntityManager(){
        return em;
    }
    protected Class<E> getEntityClass(){
        return entityClass;
    }


    public Remover(Class<E> eClass, Finder<E> finder){
        this.entityClass = eClass;
        this.finder = finder;
    }


    public void removeById(ID id){
        E e = finder.findById(id);
        remove(e);
    }

    public void remove(E e){
        if(!em.contains(e)){
            e = em.merge(e);
            em.refresh(e);
        }
        em.remove(e);
    }

}
