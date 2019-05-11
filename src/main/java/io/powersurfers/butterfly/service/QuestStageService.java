package io.powersurfers.butterfly.service;

import io.powersurfers.butterfly.dao.QuestStagesRepository;
import io.powersurfers.butterfly.exception.NoSuchQuestException;
import io.powersurfers.butterfly.model.QuestStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestStageService {

    @Autowired
    QuestStagesRepository questStagesRepository;

    public QuestStage getStageById(Integer id) {
        Optional<QuestStage> optionalQuestStage = questStagesRepository.findById(id);
        if (!optionalQuestStage.isPresent()) throw new NoSuchQuestException();
        return optionalQuestStage.get();
    }
}
