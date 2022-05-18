package ru.sad_news.web.resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.sad_news.service.facade.IFacade;
import ru.sad_news.service.util.RangeResult;

import java.net.URI;

public abstract class Resource<E, ID> implements IResource<E, ID>{

    protected final IFacade<E, ID> serviceFacade;
    protected Resource(IFacade<E, ID> serviceFacade){
        this.serviceFacade = serviceFacade;
    }

    @Override
    public Response findById(ID id) {
        return Response.accepted(serviceFacade.findById(id)).build();
    }


    @Override
    public Response findAll(int offset, int limit) {
        return Response.accepted(
                //serviceFacade.findRange(new RangeResult(offset,limit))
                serviceFacade.findAll(new RangeResult(offset,limit))
        ).build();
    }

    @Override
    public Response create(E entity) {
        serviceFacade.create(entity);
        return Response.created(URI.create("")).build();
    }


    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Override
    public Response edit(E entity, ID id) {
        serviceFacade.edit(entity,id);
        return Response.noContent().build();
    }

    @Override
    public Response remove(ID id) {
        serviceFacade.remove(serviceFacade.findById(id));
        return Response.noContent().build();
    }

    @GET
    @Override
    public Long count() {
        return serviceFacade.count();
    }

    protected Response returnAcceptedWithEntity(Object entity){
        return Response.accepted(entity).build();
    }
}
