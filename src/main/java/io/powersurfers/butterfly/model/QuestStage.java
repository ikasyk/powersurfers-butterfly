package io.powersurfers.butterfly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "quest_stages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestStage {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "quest_stage_id")
    private String id;

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


}
