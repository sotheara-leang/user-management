-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.11-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for user_management
CREATE DATABASE IF NOT EXISTS `user_management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `user_management`;


-- Dumping structure for table user_management.departments
CREATE TABLE IF NOT EXISTS `departments` (
  `dept_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table user_management.departments: ~7 rows (approximately)
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` (`dept_id`, `dept_name`) VALUES
	(1, 'Sale'),
	(2, 'Administrator'),
	(3, 'Developement'),
	(4, 'Support'),
	(5, 'Maintenance'),
	(6, 'Test');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;


-- Dumping structure for table user_management.persistent_logins
CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table user_management.persistent_logins: ~0 rows (approximately)
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;


-- Dumping structure for table user_management.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_username` varchar(50) NOT NULL DEFAULT '0',
  `user_password` varchar(100) DEFAULT '0',
  `user_role` varchar(50) NOT NULL DEFAULT '0',
  `user_email` varchar(50) DEFAULT '0',
  `user_allow_login_email_notification` bit(1) DEFAULT b'0',
  `user_dept_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_users_departments` (`user_dept_id`),
  CONSTRAINT `FK_users_departments` FOREIGN KEY (`user_dept_id`) REFERENCES `departments` (`dept_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table user_management.users: ~9 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `user_username`, `user_password`, `user_role`, `user_email`, `user_allow_login_email_notification`, `user_dept_id`) VALUES
	(1, 'Admin', '$2a$10$ABEhz2fWEh.cUR9gyPtJ9uiTkew.eRJIcebN/L6FjdQ7kFNxjtBJa', 'ROLE_ADMIN', 'leangsotheara@gmail.com', b'0', 5),
	(3, 'Sotheara', '$2a$10$xRoj2yVIR1Mm2tD5pi/eT.6dUO/QfjiWJgTs13G7xbKmqW2yyuMOi', 'ROLE_ADMIN', 'leangsotheara@gmail.com', b'0', 4),
	(4, 'User', '$2a$10$/HQ5eSZKpNOKtgVfKFi1eu5D8ZKv0/7UAxf2KTM7Vem5dSLPhpEoS', 'ROLE_USER', 'seng@yahoo.com', b'0', 1),
	(5, 'Dararoth', '$2a$10$Ahzq3Z3zLShJk1UI3egoRegGlgpUYGt02WdrO/LaLr37pnTWbMwWG', 'ROLE_USER', 'dararoth@gmail.com', b'1', 1),
	(6, 'Hello', '0', 'ROLE_USER', 'hello@gmail.com', b'0', 4),
	(7, 'Hello 2', '0', 'ROLE_USER', 'hello@gmail.com', b'0', 4),
	(8, 'Hello 3', '0', 'ROLE_USER', 'hello@gmail.com', b'0', 4),
	(9, 'Hello 4', '0', 'ROLE_USER', 'hello@gmail.com', b'0', 4),
	(10, 'Hello 5', '0', 'ROLE_USER', 'hello@gmail.com', b'0', 4);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
