DELIMITER $
    CREATE PROCEDURE prc_get_by_id_author (IN a_id bigint)
    BEGIN
        SELECT * FROM authors WHERE id = a_id;
    END
$