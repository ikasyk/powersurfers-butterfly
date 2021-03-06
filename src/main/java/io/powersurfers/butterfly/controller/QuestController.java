package io.powersurfers.butterfly.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.jsonview.Views;
import io.powersurfers.butterfly.model.Quest;
import io.powersurfers.butterfly.model.User;
import io.powersurfers.butterfly.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @Autowired
    QuestService questService;

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

    @PutMapping("/{id}/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void assignToUser(@PathVariable Integer id, @PathVariable Integer userId) {
        questService.assignToUser(id, userId);
    }

    @GetMapping("/{id}/users")
    public Set<User> getUsersFromQuest(@PathVariable Integer id) {
        return questService.getUsersFromQuest(id);
    }
}
