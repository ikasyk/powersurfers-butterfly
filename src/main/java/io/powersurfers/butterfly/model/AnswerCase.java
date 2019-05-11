package io.powersurfers.butterfly.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.jsonview.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "answer_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_case_id")
    @JsonView(Views.QuestDetailField.class)
    private Integer id;

    @Column(name = "answer_case_text")
    @JsonView(Views.QuestDetailField.class)
    private String text;

    @Column(name = "answer_case_is_correct")
    @JsonView(Views.QuestDetailField.class)
    private Boolean isCorrect;
}
