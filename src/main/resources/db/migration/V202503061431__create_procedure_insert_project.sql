DELIMITER $
    CREATE PROCEDURE prc_insert_project(
        IN a_id bigint, -- id do autor adicionar à tabela de acessos
        IN p_name varchar(50),
        IN p_category varchar(50),
        IN p_description varchar(255),
        OUT p_id bigint
    )
    BEGIN
        INSERT INTO projects (name, category, description) VALUES (p_name, p_category, p_description);
        SET p_id = LAST_INSERT_ID();
        INSERT INTO projects_access (author_id, project_id) VALUES (a_id, p_id);
    END
$