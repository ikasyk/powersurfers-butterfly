package io.powersurfers.butterfly.service;

import io.powersurfers.butterfly.dao.QuestRepository;
import io.powersurfers.butterfly.exception.NoSuchQuestException;
import io.powersurfers.butterfly.model.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestService {

    @Autowired
    QuestRepository questRepository;

    public List<Quest> getAll() {
        return questRepository.findAll();
    }

    public Quest getQuestById(Integer id) {
        Optional<Quest> optionalQuest = questRepository.findById(id);
        if (!optionalQuest.isPresent()) throw new NoSuchQuestException();
        return optionalQuest.get();
    }
}
