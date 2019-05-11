package io.powersurfers.butterfly.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.QuestsRepository;
import io.powersurfers.butterfly.dao.jsonview.Views;
import io.powersurfers.butterfly.model.Quest;
import io.powersurfers.butterfly.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @Autowired
    private QuestsRepository questsRepository;

    @Autowired
    QuestService questService;

    @GetMapping("/")
    @JsonView(Views.QuestField.class)
    public List<Quest> getAll() {
        return questsRepository.findAll();
//        return Arrays.asList(
//                new Quest(1, "Ancient Kiev", "Here you can learn about ancient city and history", null),
//                new Quest(2, "Mistery places", "Learn about mistery places", null)
//        );
    }

    @GetMapping("/{id}")
    public Optional<Quest> getQuestById(@PathVariable("id") Integer id){
        return questsRepository.findById(id);
    }


}
