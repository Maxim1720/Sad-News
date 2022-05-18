package ru.sad_news.service.crud.updater;

import java.io.Serializable;

public interface Updatable<E, ID> extends Serializable {
    E update(E e, ID id);
}
