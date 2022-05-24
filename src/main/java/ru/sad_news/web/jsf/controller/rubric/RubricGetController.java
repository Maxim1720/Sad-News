package ru.sad_news.web.jsf.controller.rubric;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Category;
import ru.sad_news.entity.Rubric;
import ru.sad_news.service.facade.category.CategoryFacade;
import ru.sad_news.service.facade.rubric.RubricFacade;
import ru.sad_news.service.util.RangeResult;
import ru.sad_news.web.jsf.controller.GetController;

import java.util.List;

@Getter
@Setter
@SessionScoped
@Named
public class RubricGetController extends GetController<Rubric, Long> {

    @Inject
    public RubricGetController(RubricFacade facade) {
        super(facade);
    }

    @PostConstruct
    @Override
    protected void init() {
        setSearchEntity(new Rubric());
    }

    public String moveToRubric(){
        return "rubric";
    }


    @Inject
    private CategoryFacade categoryFacade;
    private Long categoryId;

    public void setAllByCategoryId(Long id){
        setCategoryId(id);
        setAll(((RubricFacade) getFacade()).findByCategory(
                categoryFacade.findById(getCategoryId()),
                new RangeResult(0,150)
        ));
    }

    public List<Rubric> findAllByCategoryId(Long id){
        setAllByCategoryId(id);
        return getAll();
    }
}
