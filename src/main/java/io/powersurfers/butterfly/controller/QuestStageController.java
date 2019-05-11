package io.powersurfers.butterfly.controller;

import io.powersurfers.butterfly.model.QuestStage;
import io.powersurfers.butterfly.service.QuestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/stages")
public class QuestStageController {

    @Autowired
    QuestStageService questStageService;

    @GetMapping("/")
    public List<QuestStage> questStageList() {
        return null;
    }
}
