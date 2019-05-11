INSERT INTO users (user_id, user_unique_guid, user_login) VALUES (1, '01eadf11-4247-4e84-833a-74cc57e5870e', 'igor');
INSERT INTO users (user_id, user_unique_guid, user_login) VALUES (2, '25060b3d-bc85-49ba-8473-2c1ee56caac5', 'vova_medved228');
INSERT INTO users (user_id, user_unique_guid, user_login) VALUES (3, '01eadf11-4247-4e84-833a-74cc57e5870e', 'mamkatvoya');

INSERT INTO quests (quest_id, quest_title, quest_description) VALUES (1, 'Ancient Kiev', 'Here you can learn about ancient city and history');
INSERT INTO quests (quest_id, quest_title, quest_description) VALUES (2, 'Mistery places', 'Learn about mistery places');

INSERT INTO quest_stages (quest_stage_id, quest_id, quest_text, quest_location, quest_question_id) VALUES (1, 1, 'Chreshatik', '123 123', null);
INSERT INTO quest_stages (quest_stage_id, quest_id, quest_text, quest_location, quest_question_id) VALUES (2, 1, 'Ploshcha Lva Tolstogo', '124 123', null);

INSERT INTO quest_stage_to_stage (quest_stage_id, quest_next_stage_id) VALUES (1, 2);
