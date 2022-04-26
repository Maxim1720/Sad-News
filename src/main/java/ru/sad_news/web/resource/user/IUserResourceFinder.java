package ru.sad_news.web.resource.user;

import jakarta.ws.rs.core.Response;

public interface IUserResourceFinder {
    Response findByLogin(String login);

    Response findByFirstname(String login, int offset, int limit);

    Response findByLastName(String login, int offset, int limit);

    Response findBySecondName(String login, int offset, int limit);
}
