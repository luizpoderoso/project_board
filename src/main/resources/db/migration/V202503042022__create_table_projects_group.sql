CREATE TABLE projects_group (
    `project_id` bigint NOT NULL,
    `group_id` bigint NOT NULL,
    CONSTRAINT fk_projects_group_project FOREIGN KEY (`project_id`) REFERENCES projects(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_projects_group_group FOREIGN KEY (`group_id`) REFERENCES `groups`(id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;