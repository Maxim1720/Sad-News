package ru.sad_news.web.jsf.controller.article;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.Rubric;
import ru.sad_news.entity.article.Article;
import ru.sad_news.entity.user.UserAccount;
import ru.sad_news.service.facade.article.ArticleFacade;
import ru.sad_news.web.jsf.controller.Controller;

import java.io.*;

@Getter
@Setter
@Named
@RequestScoped
@MultipartConfig
public class ArticleController extends Controller<Article, Long> {

    @Inject
    protected ArticleController(ArticleFacade facade) {
        super(facade);
    }

    @ManagedProperty("id")
    private Long id;

    @NotNull
    @Size(max = 300)
    private String title;

    @NotNull
    @Size(max = 5000)
    private String mainText;

    @NotNull
    @Size(max = 2000)
    private String lead;

    @NotNull
    @Size(max = 1000)
    private String conclusion;

    @NotNull
    private UserAccount author;

    @NotNull
    private Rubric rubric;

    private Part[] imgs;

    @PostConstruct
    @Override
    protected void init() {
        e = new Article();
        rubric = new Rubric();
        author = new UserAccount();
        //imgs = new ArrayList<>();
    }

    private void setFields(){
        e.setRubric(rubric);
        e.setUserAccount(author);
        e.getText().setTitle(title);
        e.getText().setConclusion(conclusion);
        e.getText().setLead(lead);
        e.getText().setMainText(mainText);
        //setImgs();
    }

    @Override
    public void create() {
        setFields();
        super.create();
        System.out.println("КОЛИЧЕСТВО ИЗОБРАЖЕНИЙ:"  +e.getArticleImgs().size());
    }



    public void saveByUser(){
        ((ArticleFacade) facade).createSavedArticle(e.getId(),author.getId());
    }

    public void saveByUser(Long id){
        ((ArticleFacade) facade).createSavedArticle(id,author.getId());
    }



    public void setImgs()  {
        try {
            trySetImgs();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void trySetImgs()throws IOException{
        /*for (Part p:
                imgs) {
            ArticleImg articleImg = new ArticleImg();
            articleImg.setArticle(e);
            articleImg.setImg(getImgFromPart(p));
            e.getArticleImgs().add(articleImg);
        }*/
    }

    private Byte[] getImgFromPart(Part p) throws IOException {
        byte[] img = new byte[((int) p.getSize())];
        p.getInputStream().read(img);
        return convertToByteObjectArray(img);
    }

    private Byte[] convertToByteObjectArray(byte[] bytes){
        Byte[] bytes1 = new Byte[bytes.length];
        int i=0;
        for (byte b:
                bytes) {
            bytes1[i++] = b;
        }
        return bytes1;
    }

    public String moveToArticle(){
        return "article";
    }
/*
    @Override
    public Article findById(Long aLong) {
        setId(aLong);
        return findById();
    }

    @Override
    public Article findById() {
        e = facade.findById(id);
        lead = e.getText().getLead();
        mainText = e.getText().getMainText();
        conclusion = e.getText().getConclusion();
        title = e.getText().getTitle();
        return e;
    }*/


    public void setIdFromString(String id){
        setId(Long.parseLong(id));
    }
}
