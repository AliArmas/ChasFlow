-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cashflow
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cashflow
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cashflow` DEFAULT CHARACTER SET utf8 ;
USE `cashflow` ;

-- -----------------------------------------------------
-- Table `cashflow`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cashflow`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clasificacion` VARCHAR(100) NULL DEFAULT NULL,
  `categoria` VARCHAR(100) NULL DEFAULT NULL,
  `sub_categoria` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cashflow`.`flujo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cashflow`.`flujo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `monto` DECIMAL(10,5) NULL DEFAULT NULL,
  `categoria` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cashflow`.`registro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cashflow`.`registro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `noSemana` INT NULL DEFAULT NULL,
  `mes` VARCHAR(50) NULL DEFAULT NULL,
  `razon` VARCHAR(50) NULL DEFAULT NULL,
  `monto` DECIMAL(10,2) NULL DEFAULT NULL,
  `tipo` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cashflow`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cashflow`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `rol` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_de_nacimiento` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
