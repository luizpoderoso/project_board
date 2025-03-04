CREATE TABLE authors_task (
    `author_id` bigint NOT NULL,
    `task_id` bigint NOT NULL,
    CONSTRAINT fk_authors_task_author FOREIGN KEY (`author_id`) REFERENCES authors(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_authors_task_task FOREIGN KEY (`task_id`) REFERENCES tasks(id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;