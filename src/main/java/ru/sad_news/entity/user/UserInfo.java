package ru.sad_news.entity.user;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity(name = "UserInfo")
@Table(name = "user_info")
public class UserInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String firstname;

    private String secondName;

    @NotNull
    @Column(nullable = false)
    private String lastname;

    @OneToMany(targetEntity = UserAccount.class, cascade = CascadeType.PERSIST, mappedBy = "info")
    List<UserAccount> userAccounts;

    @JsonbTransient
    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }
}
