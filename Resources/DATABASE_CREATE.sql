-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema DCA
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DCA
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DCA` DEFAULT CHARACTER SET latin1 ;
USE `DCA` ;

-- -----------------------------------------------------
-- Table `DCA`.`claims`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DCA`.`claims` ;

CREATE TABLE IF NOT EXISTS `DCA`.`claims` (
  `id` INT(11) NOT NULL,
  `mem_id` VARCHAR(20) NOT NULL,
  `date` DATE NOT NULL,
  `rationale` MEDIUMTEXT NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  `amount` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `DCA`.`members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DCA`.`members` ;

CREATE TABLE IF NOT EXISTS `DCA`.`members` (
  `id` INT NOT NULL,
  `name` VARCHAR(40) NULL DEFAULT NULL,
  `address` MEDIUMTEXT NULL DEFAULT NULL,
  `dob` DATE NULL DEFAULT NULL,
  `dor` DATE NULL DEFAULT NULL,
  `balance` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `DCA`.`payments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DCA`.`payments` ;

CREATE TABLE IF NOT EXISTS `DCA`.`payments` (
  `id` INT(11) NOT NULL,
  `mem_id` VARCHAR(20) NOT NULL,
  `type_of_payment` CHAR(10) NOT NULL,
  `amount` FLOAT NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `DCA`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DCA`.`users` ;

CREATE TABLE IF NOT EXISTS `DCA`.`users` (
  `id` INT NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `status` CHAR(10) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `members_id` INT NOT NULL,
  `usertype` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_members`
    FOREIGN KEY (`members_id`)
    REFERENCES `DCA`.`members` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_users_members_idx` ON `DCA`.`users` (`members_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
