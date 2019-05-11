INSERT INTO users (user_id, user_unique_guid, user_login, avatar_url, user_experience) VALUES (1, '01eadf11-4247-4e84-833a-74cc57e5870e', 'igor' , 'https://randomuser.me/api/portraits/men/12.jpg', 66);
INSERT INTO users (user_id, user_unique_guid, user_login, avatar_url, user_experience) VALUES (2, '25060b3d-bc85-49ba-8473-2c1ee56caac5', 'vova_medved228', 'https://randomuser.me/api/portraits/women/42.jpg', 78);
INSERT INTO users (user_id, user_unique_guid, user_login, avatar_url, user_experience) VALUES (3, '01eadf11-4247-4e84-833a-74cc57e5870e', 'mamkatvoya', 'https://randomuser.me/api/portraits/women/75.jpg', 33);

INSERT INTO questions (question_id, question_text) VALUES (1, 'When the subway station was opened?');

INSERT INTO quest_stages (quest_stage_id, quest_stage_text, quest_stage_location, quest_stage_question_id) VALUES (1, 'Chreshatik', '123 123', null);
INSERT INTO quest_stages (quest_stage_id, quest_stage_text, quest_stage_location, quest_stage_question_id) VALUES (2, 'Ploshcha Lva Tolstogo', '124 123', 1);
INSERT INTO quest_stages (quest_stage_id, quest_stage_text, quest_stage_location, quest_stage_question_id) VALUES (3, 'Kntraktova Ploshch', '124 127', null);
INSERT INTO quest_stages (quest_stage_id, quest_stage_text, quest_stage_location, quest_stage_question_id) VALUES (4, 'Bereznyaki', '24 38', null);

INSERT INTO quest_stage_to_stage (quest_stage_id, quest_next_stage_id) VALUES (1, 2);
INSERT INTO quest_stage_to_stage (quest_stage_id, quest_next_stage_id) VALUES (1, 3);

INSERT INTO quests (quest_id, quest_title, quest_description, quest_start_stage_id) VALUES (1, 'Ancient Kiev', 'Here you can learn about ancient city and history', 1);
INSERT INTO quests (quest_id, quest_title, quest_description, quest_start_stage_id) VALUES (2, 'Mistery places', 'Learn about mistery places', 4);

-- UPDATE quest_stages SET quest_stage_quest_id = 1 WHERE quest_stage_id IN (1, 2, 3);
-- UPDATE quest_stages SET quest_stage_quest_id = 2 WHERE quest_stage_id IN (4);

INSERT INTO answer_cases (answer_case_id, answer_case_text, answer_case_is_correct, answer_case_question_id) VALUES (1, '1967', 'f', 1);
INSERT INTO answer_cases (answer_case_id, answer_case_text, answer_case_is_correct, answer_case_question_id) VALUES (2, '1976', 'f', 1);
INSERT INTO answer_cases (answer_case_id, answer_case_text, answer_case_is_correct, answer_case_question_id) VALUES (3, '1977', 't', 1);

