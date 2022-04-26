package ru.sad_news.service.crud;

import jakarta.activation.DataSource;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;

public class EntityManagerFabric {

    @PersistenceContext(name = "news_portal")
    private static EntityManager em;

    public static EntityManager newsPortalEntityManagerInstance(){
        return em;
    }
}
