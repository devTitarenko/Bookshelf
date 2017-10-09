CREATE TABLE `author` (
  `id`         INT(11)      NOT NULL AUTO_INCREMENT,
  `birth_date` DATETIME              DEFAULT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name`  VARCHAR(255) NOT NULL,
  `sex`        VARCHAR(255)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = latin1;


CREATE TABLE `book` (
  `id`    INT(11) NOT NULL AUTO_INCREMENT,
  `genre` VARCHAR(255)     DEFAULT NULL,
  `isbn`  VARCHAR(255)     DEFAULT NULL,
  `title` VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = latin1;


CREATE TABLE `book_author` (
  `book_id`   INT(11) NOT NULL,
  `author_id` INT(11) NOT NULL,
  KEY `FK7gjky30tgeg3fbl0eh0gy5o62` (`author_id`),
  KEY `FK2vndhku3xyc75led6n9l8gvqe` (`book_id`),
  CONSTRAINT `FK2vndhku3xyc75led6n9l8gvqe` FOREIGN KEY (`book_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FK7gjky30tgeg3fbl0eh0gy5o62` FOREIGN KEY (`author_id`) REFERENCES `book` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


CREATE TABLE `reward` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT,
  `title`        VARCHAR(255) NOT NULL,
  `year`         INT(11)               DEFAULT NULL,
  `fk_author_id` INT(11)               DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc28uip68e4d2hgat4gwdueksg` (`fk_author_id`),
  CONSTRAINT `FKc28uip68e4d2hgat4gwdueksg` FOREIGN KEY (`fk_author_id`) REFERENCES `author` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = latin1;
