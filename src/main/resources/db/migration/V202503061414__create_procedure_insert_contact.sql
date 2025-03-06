DELIMITER $
    CREATE PROCEDURE prc_insert_contact (
        IN c_type varchar(20),
        IN c_label varchar(100),
        IN c_author_id bigint,
        OUT c_id bigint
    )
    BEGIN
        INSERT INTO contacts (type, label, author_id) VALUES (c_type, c_label, c_author_id);
        SET c_id = LAST_INSERT_ID();
    END
$