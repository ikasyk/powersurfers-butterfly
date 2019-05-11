package io.powersurfers.butterfly.service;

import io.powersurfers.butterfly.dao.QuestRepository;
import io.powersurfers.butterfly.exception.NoSuchQuestException;
import io.powersurfers.butterfly.model.Quest;
import io.powersurfers.butterfly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestService {

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private UserService userService;

    public List<Quest> getAll() {
        return questRepository.findAll();
    }

    public Quest getQuestById(Integer id) {
        Optional<Quest> optionalQuest = questRepository.findById(id);
        if (!optionalQuest.isPresent()) throw new NoSuchQuestException();
        return optionalQuest.get();
    }

    public void assignToUser(Integer id, Integer userId) {
        User user = userService.getUserById(userId);

        Quest quest = getQuestById(id);

        quest.getUsers().add(user);
        questRepository.save(quest);
    }
}
