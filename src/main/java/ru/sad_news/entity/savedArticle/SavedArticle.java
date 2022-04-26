package ru.sad_news.entity.savedArticle;

import ru.sad_news.entity.article.Article;
import ru.sad_news.entity.user.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
public class SavedArticle {

    @EmbeddedId
    private SavedArticlePK id;

    @MapsId("userAccountId")
    @JoinColumn(name = "user_account_id")
    @ManyToOne(targetEntity = UserAccount.class, optional = false)
    private UserAccount userAccount;

    @MapsId("articleId")
    @ManyToOne(targetEntity = Article.class, optional = false)
    @JoinColumn(name = "article_id",referencedColumnName = "article_id")
    private Article article;

    @Column(name = "timestamp")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;

    @PrePersist
    protected void setCreatedTime(){
        createdTime = Date.from(Instant.now());
    }
}
