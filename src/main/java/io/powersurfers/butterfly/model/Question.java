package io.powersurfers.butterfly.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.jsonview.Views;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    @JsonView(Views.QuestDetailField.class)
    private Integer id;

    @Column(name = "question_text")
    @JsonView(Views.QuestDetailField.class)
    private String text;

    @JsonView(Views.QuestDetailField.class)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_case_question_id")
    private List<AnswerCase> answerCases;
}
