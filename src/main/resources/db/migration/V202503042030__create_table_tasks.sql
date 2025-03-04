CREATE TABLE tasks (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50) NOT NULL,
    `resume` varchar(50) NOT NULL,
    `description` varchar(255) NOT NULL
) ENGINE=InnoDB;