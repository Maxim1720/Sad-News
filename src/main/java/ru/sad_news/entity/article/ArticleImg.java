package ru.sad_news.entity.article;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "article_img")
public class ArticleImg {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "article_img_id", nullable = false)
    private Long id;

    @Lob
    @Column(length=100000)
    private Byte[] img;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
