package ru.sad_news.entity.article;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class ArticleText {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "artircle_text_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 300)
    private String title;
    @Column(nullable = false, length = 2000)
    private String lead;
    @Column(nullable = false, length = 5000)
    private String mainText;
    @Column(nullable = false, length = 1000)
    private String conclusion;

}
