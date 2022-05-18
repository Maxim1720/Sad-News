package ru.sad_news.service.crud.remover;

import java.io.Serializable;

public interface Removable<E,ID> extends Serializable {
    void removeById(ID id);
    void remove(E e);
}
