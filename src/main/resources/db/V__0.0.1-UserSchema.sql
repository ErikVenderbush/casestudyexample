CREATE TABLE `users`
(
    `id`         INT(11)      NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(45)  NOT NULL COLLATE 'utf8mb4_bin',
    `email`      VARCHAR(100) NOT NULL COLLATE 'utf8mb4_bin',
    `password`   VARCHAR(100) NOT NULL COLLATE 'utf8mb4_bin',
    `first_name` VARCHAR(45)  NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    `last_name`  VARCHAR(45)  NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `users_email_uindex` (`email`) USING BTREE
)
    COLLATE = 'utf8mb4_bin'
    ENGINE = InnoDB
;