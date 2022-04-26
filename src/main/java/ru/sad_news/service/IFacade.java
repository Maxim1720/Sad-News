package ru.sad_news.service;

import ru.sad_news.service.operations.ICrud;
import ru.sad_news.service.operations.IEntityService;

public interface IFacade<E,ID> extends ICrud<E,ID>, IEntityService<E,ID> {
}
