CREATE TABLE projects (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50) NOT NULL,
    `category` varchar(50) NOT NULL,
    `description` varchar(255) NOT NULL
) ENGINE=InnoDB;