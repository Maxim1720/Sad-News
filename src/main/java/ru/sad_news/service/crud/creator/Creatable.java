package ru.sad_news.service.crud.creator;

import java.io.Serializable;

public interface Creatable<E> extends Serializable {
    E create(E e);
}
