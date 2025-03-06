DELIMITER $
    CREATE PROCEDURE prc_insert_group (
        IN a_id bigint,
        IN p_id bigint,
        IN g_name varchar(50),
        IN g_category varchar(50),
        IN g_description varchar(255),
        OUT g_id bigint
    )
    BEGIN
        INSERT INTO `groups` (name, category, description, project_id) VALUES (g_name, g_category, g_description, p_id);
        SET g_id = LAST_INSERT_ID();
        INSERT INTO authors_group (author_id, group_id) VALUES (a_id, g_id);
    END
$