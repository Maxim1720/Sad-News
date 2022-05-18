package ru.sad_news.entity.user;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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


    @Column(nullable = false, unique = true, updatable = false, length = 20)
    private String login;


    @Column(nullable = false, length = 120)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id", nullable = false)
    private UserInfo info = new UserInfo();

    @OneToMany(mappedBy = "userAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SavedArticle> savedArticles;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles;

    @JsonbTransient
    public List<SavedArticle> getSavedArticles() {
        return savedArticles;
    }

    @JsonbTransient
    public List<Article> getArticles() {
        return articles;
    }

}
