package io.powersurfers.butterfly.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "quests")
@Data
@NoArgsConstructor
public class Quest {
    @Id
    @GeneratedValue
    @Column(name = "quest_id",unique = true)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "desc")
    private String description;

    @Column(name = "rating")
    @Max(5)
    @Min(0)
    private double rating;
}
