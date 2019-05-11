package io.powersurfers.butterfly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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


}
