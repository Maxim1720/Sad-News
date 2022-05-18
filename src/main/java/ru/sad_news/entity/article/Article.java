package ru.sad_news.entity.article;

import jakarta.json.bind.annotation.JsonbTransient;
import ru.sad_news.entity.Rubric;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.entity.user.UserAccount;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Article implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "article_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rubric_id", nullable = false)
    Rubric rubric = new Rubric();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "text_id",nullable = false)
    private ArticleText text = new ArticleText();

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private UserAccount userAccount = new UserAccount();

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SavedArticle> savedArticles = new ArrayList<>();

    @JsonbTransient
    public List<ArticleImg> getArticleImgs() {
        return articleImgs;
    }

    @JsonbTransient
    public List<SavedArticle> getSavedArticles() {
        return savedArticles;
    }

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleImg> articleImgs = new ArrayList<>();

    @PrePersist
    private void setCreatedTime(){
        timestamp = new Date();
    }

}
