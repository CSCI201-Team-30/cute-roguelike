CREATE SCHEMA `FinalProject`;

CREATE TABLE `FinalProject`.`Users` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userID`));
  
  CREATE TABLE `FinalProject`.`Classes` (
  `classID` INT NOT NULL AUTO_INCREMENT,
  `prefix` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `averageRating` INT NOT NULL,
  PRIMARY KEY (`classID`));
  
  CREATE TABLE `FinalProject`.`Professors` (
  `professorID` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`professorID`));

CREATE TABLE `FinalProject`.`Ratings` (
  `ratingID` INT NOT NULL AUTO_INCREMENT,
  `classID` INT NOT NULL,
  `userID` INT NOT NULL,
  `professorID` INT NOT NULL,
  `numberRating` INT NOT NULL,
  `ratingDetails` VARCHAR(200) NULL,
  PRIMARY KEY (`ratingID`),
  INDEX `classID_idx` (`classID` ASC) VISIBLE,
  INDEX `userID_idx` (`userID` ASC) VISIBLE,
  INDEX `professorID_idx` (`professorID` ASC) VISIBLE,
  CONSTRAINT `classID`
    FOREIGN KEY (`classID`)
    REFERENCES `FinalProject`.`Classes` (`classID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `userID`
    FOREIGN KEY (`userID`)
    REFERENCES `FinalProject`.`Users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `professorID`
    FOREIGN KEY (`professorID`)
    REFERENCES `FinalProject`.`Professors` (`professorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO FinalProject.Users VALUES (1, 'MarySue', 'johndoe123');
INSERT INTO FinalProject.Users VALUES (2, 'SpongeBob', 'password83');
INSERT INTO FinalProject.Users VALUES (3, 'JustinBieber', 'babybabybaby');

INSERT INTO FinalProject.Classes VALUES (1, 'CSCI', '201', 5);
INSERT INTO FinalProject.Classes VALUES (2, 'CSCI', '104', 5);
INSERT INTO FinalProject.Classes VALUES (3, 'DANC', '185A', 5);

INSERT INTO FinalProject.Professors VALUES (1, 'Marco', 'Papa');
INSERT INTO FinalProject.Professors VALUES (2, 'Andrew', 'Goodney');
INSERT INTO FinalProject.Professors VALUES (3, 'Tiffany', 'Bong');

INSERT INTO FinalProject.Ratings VALUES (1, 2, 1, 1, 5, 'Wow');
INSERT INTO FinalProject.Ratings VALUES (2, 2, 2, 2, 5, 'Fun class');
INSERT INTO FinalProject.Ratings VALUES (3, 3, 2, 3, 5, 'I love dancing');

SELECT * FROM FinalProject.Users;

SELECT * FROM FinalProject.Classes;

SELECT * FROM FinalProject.Professors;

SELECT * FROM FinalProject.Ratings;
