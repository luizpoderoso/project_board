CREATE TABLE groups_task (
    `group_id` bigint NOT NULL,
    `task_id` bigint NOT NULL,
    CONSTRAINT fk_groups_task_group FOREIGN KEY (`group_id`) REFERENCES `groups`(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_groups_task_task FOREIGN KEY (`task_id`) REFERENCES tasks(id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;