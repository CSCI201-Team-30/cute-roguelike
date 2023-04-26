DROP DATABASE ratemycourse;
CREATE DATABASE ratemycourse;
USE ratemycourse;

CREATE TABLE `Users` (
	`userID` int NOT NULL AUTO_INCREMENT,
	`username` varchar(16) NOT NULL,
	`email` varchar(255) DEFAULT NULL,
	`password` varchar(32) NOT NULL,
	PRIMARY KEY (`userID`)
);

-- This table isn't used right now, but this is what they look like if we decide to use it.
CREATE TABLE `Courses` (
	`courseID` int NOT NULL AUTO_INCREMENT,
	`courseNumber` varchar(45) NOT NULL,
	`courseName` varchar(200) DEFAULT NULL,
	PRIMARY KEY (`courseID`)
);

-- This table isn't used right now, but this is what they look like if we decide to use it.
CREATE TABLE `Professors` (
	`professorID` int NOT NULL AUTO_INCREMENT,
    `firstName` varchar(45),
    `lastName` varchar(45) NOT NULL,
    PRIMARY KEY (professorID)
);

CREATE TABLE `Reviews` (
	`reviewID` int NOT NULL AUTO_INCREMENT,
    `userID` int,
    `title` varchar(200),
    `body` varchar(1000),
    `courseNumber` varchar(45),
    PRIMARY KEY (`reviewID`),
    FOREIGN KEY (`userID`) references Users(userID)
);