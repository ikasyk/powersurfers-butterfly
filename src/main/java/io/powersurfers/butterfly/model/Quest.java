package io.powersurfers.butterfly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.jsonview.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quest_id")
    @JsonView(Views.QuestField.class)
    private Integer id;

    @Column(name = "quest_title")
    @JsonView(Views.QuestField.class)
    private String title;

    @Column(name = "quest_description")
    @JsonView(Views.QuestField.class)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quest_start_stage_id")
    @JsonView(Views.QuestDetailField.class)
    private QuestStage startStage;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "quest_assigned_user",
            joinColumns = @JoinColumn(name = "quest_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
