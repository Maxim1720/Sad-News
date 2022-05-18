package ru.sad_news.web.resource.article;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import ru.sad_news.entity.article.Article;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.web.resource.Resource;
import ru.sad_news.service.facade.article.ArticleFacade;
import ru.sad_news.service.facade.article.ArticleFacadeImpl;

import java.net.URI;

@Named
@RequestScoped
@Path("/article/")
public class ArticleResource extends Resource<Article, Long> implements IArticleResourceFinder {

    @Inject
    protected ArticleResource(ArticleFacade articleService) {
        super(articleService);
    }

    @GET
    @Override
    public Response findAll(@QueryParam("offset") int offset,
                            @QueryParam("limit") int limit) {
        return super.findAll(offset, limit);
    }

    @GET
    @Path("{id}")
    @Override
    public Response findById(@PathParam("id") Long aLong) {
        return super.findById(aLong);
    }

    @PUT
    @Path("{id}")
    @Override
    public Response edit(Article entity,
                         @PathParam("id") Long aLong) {
        return super.edit(entity, aLong);
    }

    @GET
    @Path("/count")
    @Override
    public Long count() {
        return super.count();
    }

    @DELETE
    @Path("{id}")
    @Override
    public Response remove(@PathParam("id") Long aLong) {
        return super.remove(aLong);
    }

    @GET
    @Path("rubrics/{rubricId}")
    @Override
    public Response findAllByRubric(@PathParam("rubricId") Long rubricId,
                                    @QueryParam("offset") int offset,
                                    @QueryParam("limit") int limit) {
        return Response.accepted(((ArticleFacadeImpl) serviceFacade).findAllByRubric(rubricId,new RangeResult(offset,limit))).build();
    }

    @GET
    @Path("categories/{categoryId}")
    @Override
    public Response findAllByCategory(@PathParam("categoryId") Long categoryId,
                                      @QueryParam("offset") int offset,
                                      @QueryParam("limit")int limit) {
        return Response.accepted(
                ((ArticleFacadeImpl) serviceFacade).findAllByCategory(categoryId,new RangeResult(offset,limit))
        ).build();
    }

    @GET
    @Path("authors/{user-id}")
    @Override
    public Response findAllByUserAccount(@PathParam("user-id") Long userAccountId,
                                         @QueryParam("offset") int offset,
                                         @QueryParam("limit")int limit) {
        return Response.accepted(
                ((ArticleFacadeImpl) serviceFacade).findAllByUserAccountId(userAccountId,new RangeResult(offset,limit))
        ).build();
    }
    @GET
    @Path("authors/{user-id}/saved")
    @Override
    public Response findAllSavedByUserAccountId(@PathParam("user-id") Long userAccountId,
                                                @QueryParam("offset") int offset,
                                                @QueryParam("limit")int limit) {
        return Response.accepted(
                ((ArticleFacadeImpl) serviceFacade).findAllSavedByUserAccountId(userAccountId,new RangeResult(offset,limit))
        ).build();
    }

    @POST
    @Path("{article-id}/authors/{user-id}/saved")
    public Response save(@PathParam("article-id") Long articleId,
                         @PathParam("user-id") Long userId){
        return Response.created(URI.create("/article/"+articleId+"/authors/"+userId+"/saved")).entity(
                ((ArticleFacadeImpl) serviceFacade).createSavedArticle(articleId,userId)
        ).build();
    }

    @DELETE
    @Path("{articleId}/authors/{userId}/saved")
    public Response removeSaved(@PathParam("articleId") Long articleId, @PathParam("userId") Long authorId){
        ((ArticleFacade) serviceFacade).removeSavedArticle(articleId,authorId);
        return Response.noContent().build();
    }

    @POST
    @Override
    public Response create(Article entity) {
        return super.create(entity);
    }
}
