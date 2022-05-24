package ru.sad_news.entity;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.json.bind.config.PropertyVisibilityStrategy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.article.Article;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Rubric implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", updatable = false, nullable = false)
    private Category category = new Category();


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubric")
    private List<Article> articles = new ArrayList<>();

    @JsonbTransient
    public List<Article> getArticles() {
        return articles;
    }
}
