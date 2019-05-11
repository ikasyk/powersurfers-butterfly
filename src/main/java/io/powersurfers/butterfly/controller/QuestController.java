package io.powersurfers.butterfly.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.powersurfers.butterfly.dao.QuestRepository;
import io.powersurfers.butterfly.dao.jsonview.Views;
import io.powersurfers.butterfly.model.Quest;
import io.powersurfers.butterfly.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @Autowired
    private QuestRepository questsRepository;

    @Autowired
    QuestService questService;

    @GetMapping("/")
    @JsonView(Views.QuestField.class)
    public List<Quest> getAll() {
        return questService.getAll();
//        return Arrays.asList(
//                new Quest(1, "Ancient Kiev", "Here you can learn about ancient city and history", null),
//                new Quest(2, "Mistery places", "Learn about mistery places", null)
//        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quest> getQuestById(@PathVariable("id") Integer id){
        Optional<Quest> optionalQuest = questService.getQuestById(id);
        if (optionalQuest.isPresent()) return new ResponseEntity<Quest>(optionalQuest.get(),HttpStatus.OK);
        return new ResponseEntity<Quest>(HttpStatus.NO_CONTENT);
    }


}
