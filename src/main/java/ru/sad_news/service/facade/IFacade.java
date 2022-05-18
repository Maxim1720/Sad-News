package ru.sad_news.service.facade;

import ru.sad_news.service.crud.ICrud;
import ru.sad_news.service.crud.IEntityService;

import java.io.Serializable;

public interface IFacade<E,ID> extends ICrud<E,ID>, IEntityService<E,ID>, Serializable{
}
