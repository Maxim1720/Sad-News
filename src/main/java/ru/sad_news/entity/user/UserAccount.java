package ru.sad_news.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.article.Article;
import ru.sad_news.entity.savedArticle.SavedArticle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class UserAccount implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_account_id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_info_id", nullable = false)
    private UserInfo info;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SavedArticle> savedArticles = new ArrayList<>();

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

}
