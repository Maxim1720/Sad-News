package ru.sad_news.web.resource.article;

import jakarta.faces.bean.ManagedBean;
import jakarta.ws.rs.core.Response;

public interface IArticleResourceFinder {

    Response findAllByRubric(Long rubricId, int offset, int limit);

    Response findAllByCategory(Long categoryId, int offset, int limit);

    Response findAllByUserAccount(Long userAccountId, int offset, int limit);

    Response findAllSavedByUserAccountId(Long userAccountId, int offset, int limit);

}
