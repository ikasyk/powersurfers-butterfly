package io.powersurfers.butterfly.model;

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
    private Integer id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "quest_id")
    private Quest quest;

    @Column(name = "quest_text")
    private String text;

    @Column(name = "quest_location")
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quest_question_id")
    private Question question;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "quest_stage_to_stage",
            joinColumns = @JoinColumn(name = "quest_stage_id"),
            inverseJoinColumns = @JoinColumn(name = "quest_next_stage_id")
    )
    private List<QuestStage> nextStages;
}
