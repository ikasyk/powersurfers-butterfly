package io.powersurfers.butterfly.dao;

import io.powersurfers.butterfly.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Integer> {
}
