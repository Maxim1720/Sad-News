package ru.sad_news.service.operations;

public interface ICrud<E, ID> {
    void create(E e);
    void edit(E e, ID id);
    void remove(E e);
    E findById(ID id);
}
