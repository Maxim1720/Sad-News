package ru.sad_news.entity.savedArticle;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class SavedArticlePK implements Serializable {
    private Long articleId;
    private Long userAccountId;

    public SavedArticlePK(Long articleId, Long userAccountId) {
        this.articleId = articleId;
        this.userAccountId = userAccountId;
    }

    public SavedArticlePK(){

    }

}
