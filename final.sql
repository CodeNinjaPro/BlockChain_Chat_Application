-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema chat_fabric
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema chat_fabric
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `chat_fabric` DEFAULT CHARACTER SET utf8 ;
USE `chat_fabric` ;

-- -----------------------------------------------------
-- Table `chat_fabric`.`dlp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chat_fabric`.`dlp` (
  `dlp_id` INT NOT NULL AUTO_INCREMENT,
  `policy_id` INT NULL DEFAULT NULL,
  `words` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`dlp_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `chat_fabric`.`dlp_policy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chat_fabric`.`dlp_policy` (
  `dlp_policy_id` INT NOT NULL AUTO_INCREMENT,
  `policy` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`dlp_policy_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `chat_fabric`.`msg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chat_fabric`.`msg` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hash` VARCHAR(500) NULL DEFAULT NULL,
  `previousHash` VARCHAR(500) NULL DEFAULT NULL,
  `timeStamp` VARCHAR(100) NULL DEFAULT NULL,
  `sender_id` INT NULL DEFAULT NULL,
  `recever_id` VARCHAR(45) NULL DEFAULT NULL,
  `content` VARCHAR(10000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `chat_fabric`.`sesstion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chat_fabric`.`sesstion` (
  `sesstion_id` INT NOT NULL AUTO_INCREMENT,
  `user_first_id` INT NULL DEFAULT NULL,
  `user_second_id` INT NULL DEFAULT NULL,
  `sesstion_key` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`sesstion_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `chat_fabric`.`smart_contract`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chat_fabric`.`smart_contract` (
  `smart_contract_id` INT NOT NULL AUTO_INCREMENT,
  `policy_id` INT NULL DEFAULT NULL,
  `words` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`smart_contract_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `chat_fabric`.`smart_contract_policy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chat_fabric`.`smart_contract_policy` (
  `smart_contract_policy_id` INT NOT NULL AUTO_INCREMENT,
  `policy` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`smart_contract_policy_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `chat_fabric`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chat_fabric`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_fullname` VARCHAR(45) NULL DEFAULT NULL,
  `usertype` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `public_key` VARCHAR(500) NULL DEFAULT NULL,
  `private_key` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
