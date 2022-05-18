package ru.sad_news.web.jsf.validator;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.ResourceDependencies;
import jakarta.faces.application.ResourceDependency;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.BeanValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.facade.user.account.UserAccountFacade;

@Named
@RequestScoped
public class UserAccountValidator extends BeanValidator{//Validator<String> {

    @Inject
    UserAccountFacade facade;


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        if(userExists((String) value)){
            throw new ValidatorException(new FacesMessage("User already exists"));
        }
    }

    private boolean userExists(String login){

        try {
            UserAccount userAccount = facade.findByLogin(login);
            return userAccount!=null;
        }
        catch (jakarta.persistence.NoResultException e){
            e.printStackTrace();
            return false;
        }
    }

}
