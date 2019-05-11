package io.powersurfers.butterfly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Integer id;

    @Column(name = "user_unique_guid")
    private String uniqueGuid;

    @Column(name = "user_login")
    private String login;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "quest_assigned_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "quest_id")
    )
    @JsonIgnore
    private Set<Quest> quests;

    @Column(name = "avatar_url")
    @org.hibernate.validator.constraints.URL
    private URL avatarUrl;

    @Column(name = "user_experience")
    private int experience;

    public void addQuest(Quest quest) {
        if (quests == null) {
            quests = new HashSet<>();
        }
        quests.add(quest);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                Objects.equals(uniqueGuid, user.uniqueGuid) &&
                Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uniqueGuid, login);
    }
}
