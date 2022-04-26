package ru.sad_news.web.resource.category;

import ru.sad_news.entity.Category;
import ru.sad_news.service.ejb.category.CategoryFacade;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import ru.sad_news.web.resource.Resource;

@Path("/categories/")
public class CategoryResource extends Resource<Category, Long> {

    @Inject
    protected CategoryResource(CategoryFacade serviceFacade) {
        super(serviceFacade);
    }

    @POST
    @Override
    public Response create(Category entity) {
        return super.create(entity);
    }

    @PUT
    @Override
    @Path("{id}")
    public Response edit(Category entity, @PathParam("id") Long aLong) {
        return super.edit(entity,aLong);
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id){
        return super.findById(id);
    }

    @GET
    @Path("/name/{name}")
    public Response findByName(@PathParam("name") String name){
        return Response.accepted(
                ((CategoryFacade) serviceFacade).findByName(name)
        ).build();
    }


    @DELETE
    @Path("/{id}")
    @Override
    public Response remove(@PathParam("id") Long aLong) {
        return super.remove(aLong);
    }

    @GET
    @Override
    public Response findAll(@QueryParam("offset") int offset,@QueryParam("limit") int limit) {
        return super.findAll(offset,limit);
    }


    @GET
    @Path("/count")
    @Override
    public Long count() {
        return super.count();
    }


}
