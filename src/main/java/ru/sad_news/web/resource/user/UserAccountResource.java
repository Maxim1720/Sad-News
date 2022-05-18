package ru.sad_news.web.resource.user;

import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.facade.user.account.UserAccountFacadeImpl;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.service.facade.user.account.UserAccountFacade;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import ru.sad_news.web.resource.Resource;

@Path("/users/")
public class UserAccountResource extends Resource<UserAccount, Long> implements IUserResourceFinder {

    @Inject
    public UserAccountResource(UserAccountFacade userAccountService) {
        super(userAccountService);
    }

    @GET
    @Path("{id}")
    @Override
    public Response findById(@PathParam("id") Long aLong) {
        return super.findById(aLong);
    }

    @GET
    @Path("login/{l}")
    @Override
    public Response findByLogin(@PathParam("l") String login) {
        return returnAcceptedWithEntity(((UserAccountFacadeImpl) serviceFacade).findByLogin(login));
    }

    @GET
    @Path("firstname/{f}")
    @Override
    public Response findByFirstname(@PathParam("f") String f, @QueryParam("offset") int offset, @QueryParam("limit")int limit) {
        return returnAcceptedWithEntity(((UserAccountFacadeImpl) serviceFacade).findAllByFirstName(f, new RangeResult(offset,limit)));
    }

    @GET
    @Path("lastname/{l}")
    @Override
    public Response findByLastName(@PathParam("l") String l, @QueryParam("offset") int offset, @QueryParam("limit")int limit) {
        return returnAcceptedWithEntity(((UserAccountFacadeImpl) serviceFacade).findAllByLastName(l, new RangeResult(offset,limit)));
    }

    @GET
    @Path("second-name/{s}")
    @Override
    public Response findBySecondName(@PathParam("s") String s, @QueryParam("offset") int offset, @QueryParam("limit")int limit) {
        return returnAcceptedWithEntity(((UserAccountFacadeImpl) serviceFacade).findAllBySecondName(s, new RangeResult(offset,limit)));
    }

    @GET
    @Override
    public Response findAll(@QueryParam("offset") int offset, @QueryParam("limit") int limit){
        return super.findAll(offset,limit);
    }


    @POST
    @Override
    public Response create(UserAccount entity) {
        return super.create(entity);
    }

    @DELETE
    @Path("{id}")
    @Override
    public Response remove(@PathParam("id") Long aLong) {
        return super.remove(aLong);
    }

    @PUT
    @Path("{id}")
    @Override
    public Response edit(UserAccount entity, @PathParam("id") Long aLong) {
        return super.edit(entity, aLong);
    }

    @GET
    @Path("/count")
    @Override
    public Long count() {
        return super.count();
    }
}
