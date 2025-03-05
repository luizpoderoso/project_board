DELIMITER $
    CREATE PROCEDURE prc_insert_author(
        IN a_name varchar(80),
        IN a_occupation varchar(80),
        OUT a_id bigint
    )
    BEGIN
        INSERT INTO authors (name, occupation) VALUES (a_name, a_occupation);
        SET a_id = LAST_INSERT_ID();
    END
$