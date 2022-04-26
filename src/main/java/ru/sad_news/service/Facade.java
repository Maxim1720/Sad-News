package ru.sad_news.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.service.crud.creator.Creator;
import ru.sad_news.service.crud.finder.Finder;
import ru.sad_news.service.crud.remover.Remover;
import ru.sad_news.service.crud.updater.Updater;

import java.util.List;

public abstract class Facade<E, ID>  implements IFacade<E,ID>{

    public Facade(final Class<E> entityClass, Creator<E> creator, Finder<E> finder, Updater<E, ID> updater, Remover<E,ID> remover){
        this.entityClass = entityClass;
        this.finder = finder;
        this.creator = creator;
        this.updater = updater;
        this.remover = remover;
    }

    protected Class<E> entityClass;

    @PersistenceContext(unitName = "news_portal")
    private EntityManager em;

    protected  EntityManager getEntityManager(){
        return em;
    }

    protected final Finder<E> finder;
    protected final Creator<E> creator;
    protected final Updater<E,ID> updater;
    protected final Remover<E,ID> remover;

    @Override
    public void create(E e) {
        creator.create(e);
    }

    @Override
    public void remove(E e) {
        remover.remove(e);
    }

    @Override
    public E findById(ID id) {
        return finder.findById(id);
    }

    @Override
    public List<E> findAll() {
        return finder.findAll();
    }

    @Override
    public List<E> findAll(RangeResult rangeResult) {
        return finder.findAll(rangeResult);
    }

    @Override
    public Long count() {
        CriteriaQuery<E> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
        Root<E> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt).as(entityClass));
        Query q = getEntityManager().createQuery(cq);
        return (Long) q.getSingleResult();
    }

    @Override
    public void edit(E e, ID id) {
        updater.update(e,id);
    }
}


