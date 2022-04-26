package ru.sad_news.web.resource.rubric;

import ru.sad_news.entity.Rubric;
import ru.sad_news.service.ejb.category.CategoryFacade;
import ru.sad_news.service.util.RangeResult;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import ru.sad_news.web.resource.Resource;
import ru.sad_news.service.ejb.rubric.RubricFacade;

@Path("/rubrics/")
public class RubricResource extends Resource<Rubric, Long> {

    @Inject
    protected RubricResource(RubricFacade rubricFacade) {
        super(rubricFacade);
    }
    @Inject
    private CategoryFacade categoryFacade;

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.accepted(
                serviceFacade.findById(id)
        ).build();
    }

    @GET
    @Path("/name/{name}")
    public Response findByName(@PathParam("name")String name){
        return Response.accepted(
                ((RubricFacade) serviceFacade).findByName(name)
        ).build();
    }

    @GET
    @Path("categories/{id}")
    public Response findByCategoryId(@PathParam("id") Long categoryId,
                                     @QueryParam("offset") int offset,
                                     @QueryParam("limit") int limit){
        return Response.accepted(
                ((RubricFacade) serviceFacade).findByCategory(categoryFacade.findById(categoryId), new RangeResult(offset,limit))
        ).build();
    }

    @GET
    @Override
    public Response findAll(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
        return super.findAll(offset, limit);
    }

    @POST
    @Override
    public Response create(Rubric entity) {
        return super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Override
    public Response edit(Rubric entity, @PathParam("id") Long aLong) {
        return super.edit(entity, aLong);
    }

    @DELETE
    @Path("{id}")
    @Override
    public Response remove(@PathParam("id") Long aLong) {
        return super.remove(aLong);
    }


    @GET
    @Path("/count")
    @Override
    public Long count() {
        return super.count();
    }
}
