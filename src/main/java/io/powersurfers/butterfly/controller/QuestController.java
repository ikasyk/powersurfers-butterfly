package io.powersurfers.butterfly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestController {

    @GetMapping("/all")
    public List<Quest> getAllQuests(){
        return questService.getAll();
    }

    @GetMapping("/{id}")
    public Quest getQuestById(@PathVariable Integer id){
        return questService.getQuestById(id);
    }
}
