package ru.sad_news.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.sad_news.entity.article.Article;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
public class Rubric implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", updatable = false, nullable = false)
    private Category category;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "rubric")
    private List<Article> articles;
}
