package io.powersurfers.butterfly.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.jsonview.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quest_stages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quest_stage_id")
    @JsonView(Views.QuestDetailField.class)
    private Integer id;

//    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinColumn(name = "quest_stage_quest_id")
//    private Quest quest;

    @Column(name = "quest_stage_text")
    @JsonView(Views.QuestDetailField.class)
    private String text;

    @Column(name = "quest_stage_location")
    @JsonView(Views.QuestDetailField.class)
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quest_stage_question_id")
    @JsonView(Views.QuestDetailField.class)
    private Question question;

    @JsonView(Views.QuestDetailField.class)
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "quest_stage_to_stage",
            joinColumns = @JoinColumn(name = "quest_stage_id"),
            inverseJoinColumns = @JoinColumn(name = "quest_next_stage_id")
    )
    private List<QuestStage> nextStages;
}
