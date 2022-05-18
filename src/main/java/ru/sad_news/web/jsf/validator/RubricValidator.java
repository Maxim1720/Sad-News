package ru.sad_news.web.jsf.validator;

import jakarta.el.ValueExpression;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.BeanValidator;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import lombok.Setter;

import java.util.regex.Pattern;

@Named
@RequestScoped
@Setter
@FacesValidator(value = "rubricValidator")
public class RubricValidator implements Validator<String> {

    private FacesContext context;
    private UIComponent component;
    private String value;
    private String message;



    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        setComponent(component);
        setContext(context);
        setValue(value);
        check();
    }

    private void check(){
        boolean error = false;

        if(incorrectRegex()){
            message = "Rubric name must start with 'A-Z' consist of 'A-Z','a-z','-',' '";
            error = true;
        }

        if(error){
            setError();
        }
    }

    private void setError(){
        FacesMessage facesMessage = new FacesMessage(message);
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        throwException(facesMessage);
    }

    private void throwException(FacesMessage message){
        throw new ValidatorException(message);
    }

    private boolean incorrectRegex(){
        Pattern pattern = Pattern.compile("[А-ЯA-Z]([A-Za-z- а-яА-я])+");
        return !pattern.matcher(value).matches();
    }

}
