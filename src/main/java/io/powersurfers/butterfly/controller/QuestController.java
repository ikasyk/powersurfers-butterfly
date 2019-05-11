package io.powersurfers.butterfly.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.QuestRepository;
import io.powersurfers.butterfly.dao.jsonview.Views;
import io.powersurfers.butterfly.model.Quest;
import io.powersurfers.butterfly.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @Autowired
    QuestService questService;
    @Autowired
    private QuestRepository questsRepository;

    @GetMapping("/")
    @JsonView(Views.QuestField.class)
    public List<Quest> getAll() {
        return questService.getAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.QuestDetailField.class)
    public Quest getQuestById(@PathVariable("id") Integer id) {
        return questService.getQuestById(id);
    }


}
