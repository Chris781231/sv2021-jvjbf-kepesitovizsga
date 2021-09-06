CREATE TABLE `world_record` (
                                 `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                 `date_of_record` DATE NULL DEFAULT NULL,
                                 `description` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
                                 `unit_of_measure` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
                                 `value` DOUBLE(22,0) NULL DEFAULT NULL,
                                 `recorder_id` BIGINT(20) NULL DEFAULT NULL,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `FKp9crenyanmmp4ynwfcal13fx2` (`recorder_id`) USING BTREE,
                                 CONSTRAINT `FKp9crenyanmmp4ynwfcal13fx2` FOREIGN KEY (`recorder_id`) REFERENCES `guinessapp`.`recorders` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
    COLLATE='utf8mb4_general_ci'
    ENGINE=InnoDB
;
