package ru.sad_news.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity(name = "UserInfo")
@Table(name = "user_info")
public class UserInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    String firstname;

    String secondName;

    @Column(nullable = false)
    String lastname;
}
