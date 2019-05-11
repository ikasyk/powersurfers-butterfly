package io.powersurfers.butterfly.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.jsonview.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "quests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quest {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "quest_id")
    @JsonView(Views.QuestField.class)
    private UUID id;

    @Column(name = "quest_title")
    @JsonView(Views.QuestField.class)
    private String title;

    @Column(name = "quest_description")
    @JsonView(Views.QuestField.class)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "quest_id")
    @JsonView(Views.QuestDetailField.class)
    private List<QuestStage> stages;
}
