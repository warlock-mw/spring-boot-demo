CREATE DATABASE IF NOT EXISTS `spring_boot_demo`;
CREATE USER 'spring_demo_user'@127.0.0.1 IDENTIFIED BY 'spring_demo_pass';
GRANT ALL ON `spring_boot_demo`.* TO 'spring_demo_user'@127.0.0.1 WITH GRANT OPTION;
CREATE USER 'spring_demo_user'@'172.%' IDENTIFIED BY 'spring_demo_pass';
GRANT ALL ON `spring_boot_demo`.* TO 'spring_demo_user'@'172.%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE `spring_boot_demo`;

CREATE TABLE `users` (
    `id`       int(10) unsigned NOT NULL auto_increment COMMENT 'id',
    `name`     varchar(40) NOT NULL COMMENT 'ユーザー名',
    `email`    varchar(40) NOT NULL COMMENT 'メール',
    `password` varchar(40) NOT NULL COMMENT 'パスワード',
    PRIMARY KEY( `id`),
    UNIQUE KEY `uk_users_email` (`email`)
) COMMENT 'ユーザー';

CREATE TABLE `projects` (
	`id`       int(10) unsigned NOT NULL auto_increment COMMENT 'id',
    `name`     varchar(40) NOT NULL COMMENT 'ユーザー名',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_projects_name` (`name`)
) COMMENT 'プロジェクト';