CREATE TABLE projects_access (
    `author_id` bigint NOT NULL,
    `project_id` bigint NOT NULL,
    PRIMARY KEY (`author_id`, `project_id`),
    CONSTRAINT fk_accesses_author FOREIGN KEY (`author_id`) REFERENCES authors(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_accesses_project FOREIGN KEY (`project_id`) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;