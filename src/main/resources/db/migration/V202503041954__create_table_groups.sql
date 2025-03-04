CREATE TABLE `groups` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50) NOT NULL,
    `category` varchar(50) NOT NULL,
    `description` varchar(255) NOT NULL,
    `project_id` bigint NOT NULL,
    CONSTRAINT fk_groups_project FOREIGN KEY (`project_id`) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;