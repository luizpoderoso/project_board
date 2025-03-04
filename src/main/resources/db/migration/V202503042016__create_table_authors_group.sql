CREATE TABLE authors_group (
    `author_id` bigint NOT NULL,
    `group_id` bigint NOT NULL,
    PRIMARY KEY (`author_id`, `group_id`),
    CONSTRAINT fk_authors_group_authors FOREIGN KEY (`author_id`) REFERENCES authors(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_authors_group_group FOREIGN KEY (`group_id`) REFERENCES `groups`(id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;