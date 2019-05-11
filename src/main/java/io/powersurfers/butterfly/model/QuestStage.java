package io.powersurfers.butterfly.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "quest_stages")
@Data
@NoArgsConstructor
public class QuestStage {
    @Id
    @GeneratedValue
    @Column(name = "quest_stage_id",unique = true)
    private Integer id;

    @Column(name = "quest_id")
    private Integer questId;

    @Column(name = "text")
    private String text;


    // і так далі
}
