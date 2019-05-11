package io.powersurfers.butterfly.service;

import io.powersurfers.butterfly.dao.QuestRepository;
import io.powersurfers.butterfly.exception.NoSuchQuestException;
import io.powersurfers.butterfly.model.Quest;
import io.powersurfers.butterfly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Transactional
    public void assignToUser(Integer id, Integer userId) {
        User user = userService.getUserById(userId);

        Quest quest = getQuestById(id);

        user.addQuest(quest);
        userService.update(user);
    }

    public Set<User> getUsersFromQuest(Integer id) {
        Quest quest = getQuestById(id);
        try {
            return quest.getUsers();
        } catch (NullPointerException e) {
            throw new NoSuchQuestException();
        }
    }
}
