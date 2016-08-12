-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ticket_event_schema
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(2) NOT NULL,
  `user_name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 NOT NULL,
  `is_active` int(1) NOT NULL DEFAULT '0',
  `active_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (2,2,'sonhv','$2a$10$MElRT8Zxqm19mc8YkhXKbupZSxbs2JggyyRe.F/BVODFSajhxN1Fi','sonhv@student.passerellesnumeriques.org',1,'2016-08-08 17:19:58'),(3,1,'admin','$2a$10$MElRT8Zxqm19mc8YkhXKbupZSxbs2JggyyRe.F/BVODFSajhxN1Fi','sonhv@student.passerellesnumeriques.org',1,'2016-08-09 17:19:58');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_layout`
--

DROP TABLE IF EXISTS `activity_layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_layout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `background_image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `event_logo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `sologan` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_id_UNIQUE` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_layout`
--

LOCK TABLES `activity_layout` WRITE;
/*!40000 ALTER TABLE `activity_layout` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_layout_image_library`
--

DROP TABLE IF EXISTS `activity_layout_image_library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_layout_image_library` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_layout_id` int(11) NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `act_id` (`activity_layout_id`),
  CONSTRAINT `act_lay_image_library_ibfk_1` FOREIGN KEY (`activity_layout_id`) REFERENCES `activity_layout` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_layout_image_library`
--

LOCK TABLES `activity_layout_image_library` WRITE;
/*!40000 ALTER TABLE `activity_layout_image_library` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_layout_image_library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `content` varchar(300) CHARACTER SET utf8 NOT NULL,
  `comment_date` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  KEY `comments_ibfk_2` (`account_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_layout`
--

DROP TABLE IF EXISTS `course_layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_layout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `banner_image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `place_image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_id_UNIQUE` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_layout`
--

LOCK TABLES `course_layout` WRITE;
/*!40000 ALTER TABLE `course_layout` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_layout_content`
--

DROP TABLE IF EXISTS `course_layout_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_layout_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_layout_id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 NOT NULL,
  `content` varchar(1000) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_layout_id`),
  CONSTRAINT `course_content_ibfk_1` FOREIGN KEY (`course_layout_id`) REFERENCES `course_layout` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_layout_content`
--

LOCK TABLES `course_layout_content` WRITE;
/*!40000 ALTER TABLE `course_layout_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_layout_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_layout_speaker`
--

DROP TABLE IF EXISTS `course_layout_speaker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_layout_speaker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_layout_id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `field` varchar(255) CHARACTER SET utf8 NOT NULL,
  `history` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_course_lay` (`course_layout_id`),
  CONSTRAINT `course_lay_speaker_ibfk_1` FOREIGN KEY (`course_layout_id`) REFERENCES `course_layout` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_layout_speaker`
--

LOCK TABLES `course_layout_speaker` WRITE;
/*!40000 ALTER TABLE `course_layout_speaker` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_layout_speaker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_config`
--

DROP TABLE IF EXISTS `email_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_config` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `mail_host` varchar(100) DEFAULT 'smtp.gmail.com',
  `username` varchar(255) DEFAULT 'phamyqb@gmail.com',
  `email_password` varchar(255) DEFAULT 'quangbinh',
  `mail_port` int(11) DEFAULT '465',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_config`
--

LOCK TABLES `email_config` WRITE;
/*!40000 ALTER TABLE `email_config` DISABLE KEYS */;
INSERT INTO `email_config` VALUES (1,'smtp.gmail.com','phamyqb@gmail.com','quangbinh',465);
/*!40000 ALTER TABLE `email_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `layout_id` int(11) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `introduction` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `place` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `organize_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `organize_logo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `organize_info` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `phone_number` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `is_public` int(1) NOT NULL DEFAULT '1',
  `is_accept` int(1) NOT NULL DEFAULT '0',
  `image_thumbnail` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `path` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `confirm_email` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `layout_id` (`layout_id`),
  KEY `type_id` (`type_id`),
  KEY `events_ibfk_3_idx` (`account_id`),
  CONSTRAINT `events_ibfk_1` FOREIGN KEY (`layout_id`) REFERENCES `event_layout` (`id`),
  CONSTRAINT `events_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `event_type` (`id`),
  CONSTRAINT `events_ibfk_3` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,1,2,1,'dsfsd','sgdsgdgsg','dsgdsg, TP Hải Phòng','2016-08-08 17:25:33','2016-08-09 00:00:00','2016-08-10 00:30:00','dsgdgdsgd','accounts/5d3e/events/953/organizeLogo953.jpg','dsgdsgds','dgdgdsg','dgdgdgs',1,1,'accounts/5d3e/events/953/thumbnail953.jpg','95322','<p>dgdfgdfgdf</p>');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_layout`
--

DROP TABLE IF EXISTS `event_layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_layout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_layout`
--

LOCK TABLES `event_layout` WRITE;
/*!40000 ALTER TABLE `event_layout` DISABLE KEYS */;
INSERT INTO `event_layout` VALUES (1,'Free'),(2,'Activity'),(3,'Music'),(4,'Course');
/*!40000 ALTER TABLE `event_layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_type`
--

DROP TABLE IF EXISTS `event_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_type`
--

LOCK TABLES `event_type` WRITE;
/*!40000 ALTER TABLE `event_type` DISABLE KEYS */;
INSERT INTO `event_type` VALUES (1,'Âm Nhạc');
/*!40000 ALTER TABLE `event_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_layout`
--

DROP TABLE IF EXISTS `free_layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `free_layout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `content` mediumtext CHARACTER SET utf8,
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_id_UNIQUE` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_layout`
--

LOCK TABLES `free_layout` WRITE;
/*!40000 ALTER TABLE `free_layout` DISABLE KEYS */;
INSERT INTO `free_layout` VALUES (1,1,'<p><img src=\"../resources/images/accounts/5d3e/events/953/freelayout/minion953.jpg\" alt=\"\" width=\"594\" height=\"670\" />gjgjgfjfgjg</p>');
/*!40000 ALTER TABLE `free_layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_layout_image_library`
--

DROP TABLE IF EXISTS `free_layout_image_library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `free_layout_image_library` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `free_layout_id` int(11) DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_free_layout` (`free_layout_id`),
  CONSTRAINT `free_layout_image_library_ibfk_1` FOREIGN KEY (`free_layout_id`) REFERENCES `free_layout` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_layout_image_library`
--

LOCK TABLES `free_layout_image_library` WRITE;
/*!40000 ALTER TABLE `free_layout_image_library` DISABLE KEYS */;
INSERT INTO `free_layout_image_library` VALUES (1,1,'accounts/5d3e/events/953/freelayout/minion953.jpg');
/*!40000 ALTER TABLE `free_layout_image_library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music_layout`
--

DROP TABLE IF EXISTS `music_layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music_layout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `banner_image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `link_highlight` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `place_image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_id_UNIQUE` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_layout`
--

LOCK TABLES `music_layout` WRITE;
/*!40000 ALTER TABLE `music_layout` DISABLE KEYS */;
/*!40000 ALTER TABLE `music_layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music_layout_famous_person`
--

DROP TABLE IF EXISTS `music_layout_famous_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music_layout_famous_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `music_layout_id` int(11) NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `date_of_birth` date NOT NULL,
  `introduction` varchar(1000) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_music_layout` (`music_layout_id`),
  CONSTRAINT `mus_lay_famous_person_ibfk_1` FOREIGN KEY (`music_layout_id`) REFERENCES `music_layout` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_layout_famous_person`
--

LOCK TABLES `music_layout_famous_person` WRITE;
/*!40000 ALTER TABLE `music_layout_famous_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `music_layout_famous_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music_layout_image_library`
--

DROP TABLE IF EXISTS `music_layout_image_library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music_layout_image_library` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `music_layout_id` int(11) NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mus_layout_id` (`music_layout_id`),
  CONSTRAINT `mus_lay_image_library_ibfk_1` FOREIGN KEY (`music_layout_id`) REFERENCES `music_layout` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_layout_image_library`
--

LOCK TABLES `music_layout_image_library` WRITE;
/*!40000 ALTER TABLE `music_layout_image_library` DISABLE KEYS */;
/*!40000 ALTER TABLE `music_layout_image_library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `price` float NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `is_free` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,1,142,'sfdsf','gfhdfh',0);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_buyer`
--

DROP TABLE IF EXISTS `ticket_buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_buyer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `gender` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_buyer`
--

LOCK TABLES `ticket_buyer` WRITE;
/*!40000 ALTER TABLE `ticket_buyer` DISABLE KEYS */;
INSERT INTO `ticket_buyer` VALUES (1,2,'Huỳnh Sơn','Tam Phước','0123456789','Nam','1996-12-11'),(2,2,'Huỳnh Sơn','Tam Phước','0123456789','Nam','1996-12-11'),(3,2,'Huỳnh Sơn','Tam Phước','0123456789','Nam','1996-12-11'),(4,2,'Huỳnh Sơn','Tam Phước','0123456789','Nam','1996-12-11');
/*!40000 ALTER TABLE `ticket_buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_order`
--

DROP TABLE IF EXISTS `ticket_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) DEFAULT NULL,
  `ticket_buyer_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `buy_date` datetime DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `ticket_fk_idx` (`ticket_id`),
  KEY `ticket_buyer_fk_idx` (`ticket_buyer_id`),
  CONSTRAINT `ticket_buyer_fk` FOREIGN KEY (`ticket_buyer_id`) REFERENCES `ticket_buyer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticket_fk` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_order`
--

LOCK TABLES `ticket_order` WRITE;
/*!40000 ALTER TABLE `ticket_order` DISABLE KEYS */;
INSERT INTO `ticket_order` VALUES (1,1,NULL,3,'2016-08-09 09:42:18',0),(2,1,4,5,'2016-08-09 09:48:35',0);
/*!40000 ALTER TABLE `ticket_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_information`
--

DROP TABLE IF EXISTS `user_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `gender` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_account_information` FOREIGN KEY (`id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_information`
--

LOCK TABLES `user_information` WRITE;
/*!40000 ALTER TABLE `user_information` DISABLE KEYS */;
INSERT INTO `user_information` VALUES (2,'Huỳnh Sơn','Tam Phước','0123456789','Nam',NULL,'sonhv.jpg');
/*!40000 ALTER TABLE `user_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-09 11:16:16
