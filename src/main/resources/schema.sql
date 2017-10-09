CREATE TABLE IF NOT EXISTS `author` (
  `id`         INT(11)      NOT NULL AUTO_INCREMENT,
  `birth_date` DATETIME              DEFAULT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name`  VARCHAR(255) NOT NULL,
  `sex`        VARCHAR(255)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


CREATE TABLE IF NOT EXISTS `book` (
  `id`    INT(11) NOT NULL AUTO_INCREMENT,
  `genre` VARCHAR(255)     DEFAULT NULL,
  `isbn`  VARCHAR(255)     DEFAULT NULL,
  `title` VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


CREATE TABLE IF NOT EXISTS `book_author` (
  `author_id` INT(11) NOT NULL,
  `book_id`   INT(11) NOT NULL,
  KEY `FKhwgu59n9o80xv75plf9ggj7xn` (`book_id`),
  KEY `FKbjqhp85wjv8vpr0beygh6jsgo` (`author_id`),
  CONSTRAINT `FKbjqhp85wjv8vpr0beygh6jsgo` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FKhwgu59n9o80xv75plf9ggj7xn` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `reward` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT,
  `title`        VARCHAR(255) NOT NULL,
  `year`         INT(11)               DEFAULT NULL,
  `fk_author_id` INT(11)               DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc28uip68e4d2hgat4gwdueksg` (`fk_author_id`),
  CONSTRAINT `FKc28uip68e4d2hgat4gwdueksg` FOREIGN KEY (`fk_author_id`) REFERENCES `author` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

