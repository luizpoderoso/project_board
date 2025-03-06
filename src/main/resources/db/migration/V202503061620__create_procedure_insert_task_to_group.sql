DELIMITER $
    CREATE PROCEDURE prc_insert_task_to_group (
        IN a_id bigint,
        IN g_id bigint,
        IN t_name varchar(50),
        IN t_resume varchar(50),
        IN t_description varchar(255),
        OUT t_id bigint
    )
    BEGIN
        INSERT INTO tasks (name, resume, description) VALUES (t_name, t_resume, t_description);
        SET t_id = LAST_INSERT_ID();
        INSERT INTO authors_task (author_id, task_id) VALUES (a_id, t_id);
        INSERT INTO groups_task (group_id, task_id) VALUES (g_id, t_id);
    END
$