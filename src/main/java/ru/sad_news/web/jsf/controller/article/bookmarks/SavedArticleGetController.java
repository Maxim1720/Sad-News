package ru.sad_news.web.jsf.controller.article.bookmarks;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.core.Request;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.article.Article;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.entity.savedArticle.SavedArticlePK;
import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.crud.finder.article.saved.SavedArticleFinder;
import ru.sad_news.service.facade.Facade;
import ru.sad_news.service.facade.article.ArticleFacade;
import ru.sad_news.service.facade.user.account.UserAccountFacade;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.web.jsf.controller.GetController;

import java.util.List;

@LoginToContinue
@Getter@Setter
@RequestScoped
@Named
public class SavedArticleGetController {

    private final ArticleFacade facade;
    private Article article;
    private UserAccount userAccount;
    private SavedArticlePK searchingSavedArticlePK;
    private SavedArticle searchingSavedArticle;
    private List<SavedArticle> searchingSavedArticles;

    @Inject
    public SavedArticleGetController(ArticleFacade facade) {
        this.facade = facade;
    }

    @Inject
    UserAccountFacade userAccountFacade;

    @PostConstruct
    protected void init() {
        article = new Article();
        userAccount = new UserAccount();
        /*try{
            HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false));
            userAccount = userAccountFacade.findByLogin(
                    session.getAttribute("login").toString()
            );
        }
        catch (){

        }*/
    }

    @Inject
    SavedArticleFinder savedArticleFinder;


    public void findByID(){
        searchingSavedArticle = savedArticleFinder.findByID(searchingSavedArticlePK);
    }

    public void findAll(){
        searchingSavedArticles =
                savedArticleFinder.findAllByUserAccountId(userAccount.getId(), new RangeResult(0,150));
    }

}
