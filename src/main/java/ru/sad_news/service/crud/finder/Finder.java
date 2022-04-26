package ru.sad_news.service.crud.finder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import ru.sad_news.service.util.RangeResult;

import java.util.List;

public abstract class Finder<E> {

    @PersistenceContext(unitName = "news_portal")
    private EntityManager em;


    private EntityManager getEntityManager(){
        return em;
    }

    protected abstract Class<E> getEntityClass();

    public E findById(Object id){
        return getEntityManager().find(getEntityClass(), id);
    }

    public List<E> findAll(RangeResult rangeResult) {
        Query q = getEntityManager().createQuery(getFindAllQuery());
        return rankedQueryResults(q,rangeResult);
    }

    public List<E> findAll(){
        return getEntityManager().createQuery(getFindAllQuery()).getResultList();
    }

    private CriteriaQuery<E> getFindAllQuery(){
        CriteriaQuery<E> cq = getEntityManager().getCriteriaBuilder().createQuery(getEntityClass());
        cq.select(cq.from(getEntityClass()));
        return cq;
    }

    protected E findBy(String by, Object value){
        Query q = getFindQuery(by,value);
        return (E) q.getResultList().get(0);
    }

    private Query getFindQuery(String by, Object value){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<E> query = cb.createQuery(getEntityClass());
        Root<E> root = query.from(getEntityClass());
        query.where(cb.equal(root.get(by), value));
        return getEntityManager().createQuery(query);
    }
    protected Query getfindAllQuery(String[] nestEntities, Object value){
        CriteriaQuery<E> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(getEntityClass());
        Root<E> eRoot = criteriaQuery.from(getEntityClass());
        Predicate predicate;
        Path<E> path = eRoot.get(nestEntities[0]);
        for (int i=1;i<nestEntities.length;i++){
            path = path.get(nestEntities[i]);
        }
        predicate = getEntityManager().getCriteriaBuilder().equal(path,value);
        criteriaQuery.where(predicate);
        return getEntityManager().createQuery(criteriaQuery);
    }

    protected List<E> rankedQueryResults(Query q, RangeResult rangeResult){
        q.setFirstResult(rangeResult.getOffset());
        q.setMaxResults(rangeResult.getLimit());
        return ((List<E>) q.getResultList());
    }

}
