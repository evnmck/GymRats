-- MySQL Script generated by MySQL Workbench
-- Mon Apr  4 18:00:22 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema GymRats
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema GymRats
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GymRats` DEFAULT CHARACTER SET utf8 ;
USE `GymRats` ;

-- -----------------------------------------------------
-- Table `GymRats`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GymRats`.`User` (
  `User_Id` INT NOT NULL AUTO_INCREMENT,
  `FName` VARCHAR(45) NOT NULL,
  `Lname` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(45) UNIQUE NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Bio` VARCHAR(255) NULL,
  `FK_Trainer_Id` INT NULL,
  PRIMARY KEY (`User_Id`),
  INDEX `FK_Trainer_Id_idx` (`FK_Trainer_Id` ASC) VISIBLE,
  UNIQUE INDEX `User_Id_UNIQUE` (`User_Id` ASC) VISIBLE,
  CONSTRAINT `FK_Trainer_Id`
    FOREIGN KEY (`FK_Trainer_Id`)
    REFERENCES `GymRats`.`User` (`User_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GymRats`.`Body_Progress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GymRats`.`Body_Progress` (
  `Tracking_Id` INT NOT NULL AUTO_INCREMENT,
  `FK_User_Id` INT NOT NULL,
  `Date_Measured` DATE NULL DEFAULT (curdate()),
  `Chest` DOUBLE NULL,
  `Waist` DOUBLE NULL,
  `Hips` DOUBLE NULL,
  `Biceps` DOUBLE NULL,
  `Thigh` DOUBLE NULL,
  `Weight` DOUBLE NULL,
  `Height` DOUBLE NULL,
  PRIMARY KEY (`Tracking_Id`, `FK_User_Id`),
  INDEX `User_Id_idx` (`FK_User_Id` ASC) VISIBLE,
  UNIQUE INDEX `Tracking_Id_UNIQUE` (`Tracking_Id` ASC) VISIBLE,
  CONSTRAINT `User_Id`
    FOREIGN KEY (`FK_User_Id`)
    REFERENCES `GymRats`.`User` (`User_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GymRats`.`Exercise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GymRats`.`Exercise` (
  `Exercise_Id` INT NOT NULL AUTO_INCREMENT,
  `Exercise_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Exercise_Id`),
  UNIQUE INDEX `Exercise_Id_UNIQUE` (`Exercise_Id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GymRats`.`Workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GymRats`.`Workout` (
  `Workout_Id` INT NOT NULL,
  `FK_Exercise_Id` INT NOT NULL,
  `FK_User_Id` INT NOT NULL,
  `Start_Weight` INT NULL,
  `End_Weight` INT NULL,
  `Repetitions` INT NULL,
  `Sets` INT NULL,
  `Time_in_Minutes` INT NULL,
  `Date` DATE NULL DEFAULT (curdate()),
  PRIMARY KEY (`Workout_Id`, `FK_Exercise_Id`, `FK_User_Id`),
  INDEX `FK_User_Id_idx` (`FK_User_Id` ASC) VISIBLE,
  INDEX `FK_Exercise_Id_idx` (`FK_Exercise_Id` ASC) VISIBLE,
  CONSTRAINT `FK_User_Id`
    FOREIGN KEY (`FK_User_Id`)
    REFERENCES `GymRats`.`User` (`User_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Exercise_Id`
    FOREIGN KEY (`FK_Exercise_Id`)
    REFERENCES `GymRats`.`Exercise` (`Exercise_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GymRats`.`Comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GymRats`.`Comments` (
  `FK_Commenter_Id` INT NOT NULL,
  `FK_Workout_Id` INT NOT NULL,
  `Comment` VARCHAR(255) NULL,
  PRIMARY KEY (`FK_Commenter_Id`, `FK_Workout_Id`),
  INDEX `FK_Workout_Id_idx` (`FK_Workout_Id` ASC) VISIBLE,
  CONSTRAINT `FK_Commenter_Id`
    FOREIGN KEY (`FK_Commenter_Id`)
    REFERENCES `GymRats`.`User` (`User_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Workout_Id`
    FOREIGN KEY (`FK_Workout_Id`)
    REFERENCES `GymRats`.`Workout` (`Workout_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `GymRats` ;

-- -----------------------------------------------------
-- Placeholder table for view `GymRats`.`user_workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GymRats`.`user_workout` (`User_Id` INT, `Exercise_Name` INT, `Username` INT, `Start_Weight` INT, `End_Weight` INT, `Repetitions` INT, `Sets` INT, `Time_in_Minutes` INT);

-- -----------------------------------------------------
-- View `GymRats`.`user_workout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GymRats`.`user_workout`;
USE `GymRats`;
CREATE  OR REPLACE VIEW `user_workout` AS 
SELECT User.User_Id, Exercise.Exercise_Name, User.Username, Workout.Start_Weight, Workout.End_Weight, Workout.Repetitions, Workout.Sets, Workout.Time_in_Minutes
FROM User, Workout, Exercise
WHERE User.User_Id = Workout.FK_User_Id and Exercise.Exercise_Id = Workout.FK_Exercise_Id;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;