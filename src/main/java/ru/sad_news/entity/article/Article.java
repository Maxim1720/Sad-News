package ru.sad_news.entity.article;

import ru.sad_news.entity.Rubric;
import ru.sad_news.entity.savedArticle.SavedArticle;
import ru.sad_news.entity.user.UserAccount;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "article_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rubric_id", nullable = false)
    Rubric rubric;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "text_id",nullable = false)
    private ArticleText text;

    @ManyToOne(/*cascade = CascadeType.REFRESH*/)
    @JoinColumn(name = "author_id",nullable = false)
    private UserAccount userAccount;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SavedArticle> savedArticles = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleImg> articleImgs = new ArrayList<>();

    @PrePersist
    private void setCreatedTime(){
        timestamp = new Date();
    }

}
