package io.powersurfers.butterfly.dao;

import io.powersurfers.butterfly.model.QuestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestStagesRepository extends JpaRepository<QuestStage, Integer> {
}
