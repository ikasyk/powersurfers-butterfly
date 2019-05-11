package io.powersurfers.butterfly.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.jsonview.Views;
import io.powersurfers.butterfly.model.Quest;
import io.powersurfers.butterfly.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @Autowired
    QuestService questService;

    @GetMapping("/")
    @JsonView(Views.QuestField.class)
    public List<Quest> getAll() {
        return Arrays.asList(
                new Quest(1, "Ancient Kiev", "Here you can learn about ancient city and history", null),
                new Quest(2, "Mistery places", "Learn about mistery places", null)
        );
    }

    @GetMapping("/{id}")
    public Quest getQuestById(Integer id){
        return questService.getQuestById(id);
    }


}
