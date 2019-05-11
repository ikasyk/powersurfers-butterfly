package io.powersurfers.butterfly.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.jsonview.Views;
import io.powersurfers.butterfly.model.Quest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/quests")
public class QuestsController {
    @GetMapping("/")
    @JsonView(Views.QuestField.class)
    public List<Quest> getAllQuests() {
        return Arrays.asList(
                new Quest(1, "Ancient Kiev", "Here you can learn about ancient city and history", null),
                new Quest(2, "Mistery places", "Learn about mistery places", null)
        );
    }


}
