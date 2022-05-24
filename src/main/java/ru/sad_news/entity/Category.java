package ru.sad_news.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(targetEntity = Rubric.class, cascade = {CascadeType.ALL}, mappedBy = "category",fetch = FetchType.EAGER)
    private Set<Rubric> rubrics;

    @JsonbTransient
    public Set<Rubric> getRubrics() {
        return rubrics;
    }
}
