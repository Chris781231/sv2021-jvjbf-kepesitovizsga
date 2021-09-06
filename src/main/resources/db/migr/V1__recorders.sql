CREATE TABLE `recorder` (
                             `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                             `date_of_birth` DATE NULL DEFAULT NULL,
                             `name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
                             PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='utf8mb4_general_ci'
    ENGINE=InnoDB
;
