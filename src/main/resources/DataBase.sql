CREATE SCHEMA IF NOT EXISTS `nykyforuk_db`;
USE `nykyforuk_db`;


DROP TABLE IF EXISTS `flight`;
DROP TABLE IF EXISTS `pilot`;
DROP TABLE IF EXISTS `airport`;
DROP TABLE IF EXISTS `aircraft`;
DROP TABLE IF EXISTS `aviacompany`;


CREATE TABLE `aviacompany`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(45) NOT NULL,
    `creation_date` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;


CREATE TABLE `airport`
(
    `id`                INT         NOT NULL AUTO_INCREMENT,
    `name`              VARCHAR(45) NOT NULL,
    `amount_of_workers` INT         NULL,
    `city`              VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
CREATE INDEX `name_airport_index` ON `airport` (`name`);

CREATE TABLE `pilot`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(45) NOT NULL,
    `surname`  VARCHAR(45) NOT NULL,
    `position` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
CREATE INDEX `surname_pilot_index` ON `pilot` (`surname`);

CREATE TABLE `aircraft`
(
    `id`             INT         NOT NULL AUTO_INCREMENT,
    `model_name`     VARCHAR(45) NOT NULL,
    `type`           VARCHAR(45) NULL,
    `years_in_use`   INT         NULL,
    `max_seats`      INT         NULL,
    `aviacompany_id` INT         NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `flight`
(
    `id`              INT         NOT NULL AUTO_INCREMENT,
    `from_airport`    INT         NOT NULL,
    `to_airport`      INT         NOT NULL,
    `departure_time`  VARCHAR(45) NOT NULL,
    `arrival_time`    VARCHAR(45) NOT NULL,
    `pilot_id`        INT         NOT NULL,
    `aircraft_id`     INT         NOT NULL,
    `is_available`    TINYINT     NULL,
    `aviacompany_id`  INT         NOT NULL,
    `available_seats` INT         NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
CREATE INDEX `aircraft_flight_index` ON `flight` (`aircraft_id`);


ALTER TABLE `aircraft`
    ADD CONSTRAINT `fk_aircraft_aviacompany1`
        FOREIGN KEY (`aviacompany_id`)
            REFERENCES `aviacompany` (`id`);

ALTER TABLE `flight`
    ADD CONSTRAINT `fk_flight_airport1`
        FOREIGN KEY (`from_airport`)
            REFERENCES `airport` (`id`),

    ADD CONSTRAINT `fk_flight_airport2`
        FOREIGN KEY (`to_airport`)
            REFERENCES `airport` (`id`),

    ADD CONSTRAINT `fk_flight_pilotage1`
        FOREIGN KEY (`pilot_id`)
            REFERENCES `pilot` (`id`),

    ADD CONSTRAINT `fk_flight_aircraft1`
        FOREIGN KEY (`aircraft_id`)
            REFERENCES `aircraft` (`id`),

    ADD CONSTRAINT `fk_flight_aviacompany1`
        FOREIGN KEY (`aviacompany_id`)
            REFERENCES `aviacompany` (`id`);


INSERT INTO `aviacompany` (id, name, creation_date)
VALUES (1, 'q', '2002-08-06'),
       (2, 'w', '2002-08-06'),
       (3, 'e', '2002-08-06'),
       (4, 'r', '2002-08-06'),
       (5, 't', '2002-08-06'),
       (6, 'y', '2002-08-06'),
       (7, 'u', '2002-08-06'),
       (8, 'i', '2002-08-06'),
       (9, 'o', '2002-08-06'),
       (10, 'p', '2002-08-06');


INSERT INTO `airport` (id, name, amount_of_workers, city)
VALUES (1, 'q', 1000, 'Lviv'),
       (2, 'w', 50, 'Tokyo'),
       (3, 'e', 100, 'Tokyo'),
       (4, 'r', 150, 'Tokyo'),
       (5, 't', 200, 'Tokyo'),
       (6, 'y', 300, 'Tokyo'),
       (7, 'u', 400, 'Tokyo'),
       (8, 'i', 700, 'Tokyo'),
       (9, 'o', 800, 'Tokyo'),
       (10, 'p', 900, 'Kyiv');

INSERT INTO `pilot` (id, surname, name, position)
VALUES (1, 'Desu', 'Oleg', 'first_pilot'),
       (2, 'Desu', 'Oleg', 'first_pilot'),
       (3, 'Desu', 'Oleg', 'first_pilot'),
       (4, 'Desu', 'Oleg', 'second_pilot'),
       (5, 'Desu', 'Oleg', 'first_pilot'),
       (6, 'Desu', 'Oleg', 'first_pilot'),
       (7, 'Desu', 'Oleg', 'second_pilot'),
       (8, 'Desu', 'Oleg', 'second_pilot'),
       (9, 'Desu', 'Oleg', 'first_pilot'),
       (10, 'Desu', 'Oleg', 'second_pilot');

INSERT INTO `aircraft` (id, model_name, type, years_in_use, max_seats, aviacompany_id)
VALUES (1, 'q', 'as', 12, 100, 2),
       (2, 'w', 'ad', 1, 100, 3),
       (3, 'e', 'af', 2, 100, 5),
       (4, 'r', 'ag', 7, 100, 4),
       (5, 't', 'ad', 9, 100, 2),
       (6, 'y', 'as', 10, 100, 2),
       (7, 'u', 'ag', 1, 100, 7),
       (8, 'i', 'ah', 1, 100, 8),
       (9, 'o', 'ad', 2, 100, 1),
       (10, 'p', 'ad', 3, 100, 3);

INSERT INTO `flight` (id, from_airport, to_airport, departure_time,
                      arrival_time, pilot_id, aircraft_id, is_available, aviacompany_id, available_seats)
VALUES (1, 1, 2, '2020-08-06', '2020-08-07', 1, 2, 1, 2, 100),
       (2, 1, 2, '2020-08-06', '2020-08-07', 3, 4, 0, 3, 100),
       (3, 1, 2, '2020-08-06', '2020-08-07', 4, 5, 1, 5, 100),
       (4, 1, 2, '2020-08-06', '2020-08-07', 5, 1, 0, 4, 100),
       (5, 1, 2, '2020-08-06', '2020-08-07', 1, 4, 1, 2, 50),
       (6, 1, 2, '2020-08-06', '2020-08-07', 7, 1, 0, 2, 10),
       (7, 1, 2, '2020-08-06', '2020-08-07', 8, 10, 0, 7, 50),
       (8, 1, 2, '2020-08-06', '2020-08-07', 1, 5, 1, 8, 50),
       (9, 1, 2, '2020-08-06', '2020-08-07', 2, 8, 1, 1, 50),
       (10, 1, 2, '2020-08-06', '2020-08-07', 1, 7, 1, 3, 50);
