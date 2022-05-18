package ru.sad_news.web.jsf.controller.user;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.entity.user.UserInfo;
import ru.sad_news.service.facade.user.account.UserAccountFacade;
import ru.sad_news.web.jsf.controller.Controller;

@Getter
@Setter
@Named
@RequestScoped
public class UserAccountController extends Controller<UserAccount, Long> {

    @Inject
    public UserAccountController(UserAccountFacade facade) {
        super(facade);
    }

    private UserInfo info;

    @NotEmpty(message = "login не может быть пустым")
    @NotNull
    @Size(max = 20, min = 8, message = "login length must be between 8 and 20.")
    private String login;

    @NotEmpty
    @Size(max = 120, min = 8, message = "password length must be greater than or equal to 8.")
    @NotNull
    private String password;

    @NotNull
    @NotBlank
    private String firstname;
    @NotNull
    @NotBlank
    private String lastname;

    private String secondName;

    private UsernamePasswordCredential credential;

    @PostConstruct
    @Override
    protected void init() {
        e = new UserAccount();
        /*info = new UserInfo();
        e.setInfo(info);*/
    }

    public void createUserAccount(){
        e.setLogin(login);
        e.setPassword(password);
        e.getInfo().setFirstname(firstname);
        e.getInfo().setLastname(lastname);
        e.getInfo().setSecondName(secondName);
        credential = new UsernamePasswordCredential(login,password);
        super.create();
    }


    public void logIn(){

    }
}
