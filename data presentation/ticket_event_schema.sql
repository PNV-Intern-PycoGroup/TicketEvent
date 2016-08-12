CREATE DATABASE  IF NOT EXISTS `ticket_event_schema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ticket_event_schema`;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (2,2,'sonhv','$2a$10$MElRT8Zxqm19mc8YkhXKbupZSxbs2JggyyRe.F/BVODFSajhxN1Fi','sonhv@student.passerellesnumeriques.org',1,'2016-08-08 17:19:58'),(3,1,'admin','$2a$10$MElRT8Zxqm19mc8YkhXKbupZSxbs2JggyyRe.F/BVODFSajhxN1Fi','sonhv@student.passerellesnumeriques.org',1,'2016-08-09 17:19:58'),(4,2,'ypv','$2a$10$1eBxGJgW9IT7hwSZpo372eZkHxjBrremUC7erF7qOwQ8iaIVsYIO.','ypham@gmail.com',1,'2016-08-11 14:29:02'),(5,2,'user2','$2a$10$PluTzEV5Os0rYWoOGvo/tOwNRra8WNRlGkYgMXDUfFrIAuYRbGJoS','sonhv@student.passerellesnumeriques.org',1,'2016-08-12 17:18:51'),(6,2,'user3','$2a$10$8ZLQYwYzmnvAcsBTOusrjOJWWJrs8vw9kxoeDR6hs5X/bvz9LHIgS','sonhv@student.passerellesnumeriques.org',1,'2016-08-12 17:20:47'),(7,2,'user5','$2a$10$nRkC.hvWEnJDWFVm4ATrfu5xhiIyhRGL0Iyk5Lmg4ET5.SNHtlW5q','sonhv@student.passerellesnumeriques.org',1,'2016-08-12 17:33:29'),(8,2,'user7','$2a$10$8cyH2r0W83nUVw0iB6v1T.QBaLQWDXI3hY9sSNUeIu8m.xz4k9utG','sonhv@student.passerellesnumeriques.org',1,'2016-08-12 17:35:05'),(9,2,'user8','$2a$10$Q5S4naIdkb6nA.nko2pqoOmZY0Kl7aHtdoTwwi45lotHB58.JV5Ii','sonhv@student.passerellesnumeriques.org',1,'2016-08-12 17:35:28'),(10,2,'user9','$2a$10$uqAySdL396kF1P5aX7ifTOqSugh0pXAWPxNMcty7soZNeTDny4eXm','sonhv@student.passerellesnumeriques.org',1,'2016-08-12 17:35:50');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_layout`
--

LOCK TABLES `activity_layout` WRITE;
/*!40000 ALTER TABLE `activity_layout` DISABLE KEYS */;
INSERT INTO `activity_layout` VALUES (2,8,'accounts/ba7c/events/174f8/activity/background174f8.jpg','accounts/ba7c/events/174f8/activity/logo174f8.jpg','Thỏa sức tung màu và thể hiện bản ngã. Dơ gì phải lo, bẩn gì phải xoắn!'),(3,12,'accounts/5d3e/events/22f74/activity/background22f74.jpg','accounts/5d3e/events/22f74/activity/logo22f74.jpg','Khẩu hiệu Khẩu hiệu Khẩu hiệu Khẩu hiệu Khẩu hiệu Khẩu hiệu Khẩu hiệu '),(4,17,'accounts/5d3e/events/9e83/activity/background9e83.jpg','accounts/5d3e/events/9e83/activity/logo9e83.jpg','bcxbcxbxbf'),(5,19,'accounts/5d3e/events/b129/activity/backgroundb129.jpg','accounts/5d3e/events/b129/activity/logob129.jpg','sfdsfdsgfdsg');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_layout_image_library`
--

LOCK TABLES `activity_layout_image_library` WRITE;
/*!40000 ALTER TABLE `activity_layout_image_library` DISABLE KEYS */;
INSERT INTO `activity_layout_image_library` VALUES (3,2,'accounts/ba7c/events/174f8/activity/libImage/1174f8.jpg'),(4,2,'accounts/ba7c/events/174f8/activity/libImage/2174f8.jpg'),(5,2,'accounts/ba7c/events/174f8/activity/libImage/3174f8.jpg'),(6,3,'accounts/5d3e/events/22f74/activity/libImage/222f74.jpg'),(7,4,'accounts/5d3e/events/9e83/activity/libImage/69e83.jpg'),(8,5,'accounts/5d3e/events/b129/activity/libImage/7b129.jpg');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_layout`
--

LOCK TABLES `course_layout` WRITE;
/*!40000 ALTER TABLE `course_layout` DISABLE KEYS */;
INSERT INTO `course_layout` VALUES (3,9,NULL,NULL),(4,10,'accounts/ba7c/events/1d236/course/banner1d236.jpg','accounts/ba7c/events/1d236/course/place1d236.jpg'),(5,15,'accounts/5d3e/events/8bdd/course/banner8bdd.jpg','accounts/5d3e/events/8bdd/course/place8bdd.jpg'),(6,16,'accounts/5d3e/events/2e9f0/course/banner2e9f0.jpg','accounts/5d3e/events/2e9f0/course/place2e9f0.jpg'),(7,18,'accounts/5d3e/events/3472e/course/banner3472e.jpg','accounts/5d3e/events/3472e/course/place3472e.jpg'),(8,20,'accounts/5d3e/events/3a46c/course/banner3a46c.jpg','accounts/5d3e/events/3a46c/course/place3a46c.jpg');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_layout_content`
--

LOCK TABLES `course_layout_content` WRITE;
/*!40000 ALTER TABLE `course_layout_content` DISABLE KEYS */;
INSERT INTO `course_layout_content` VALUES (4,4,'Mở đầu','Nội dung bài giảng đầu tiên Nội dung bài giảng đầu tiên Nội dung bài giảng đầu tiên Nội dung bài giảng đầu tiên Nội dung bài giảng đầu tiên Nội dung bài giảng đầu tiên Nội dung bài giảng đầu tiên '),(5,4,'Nội dung thứ hai','Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm Giới thiệu nội dung thứ hai bao gồm '),(6,4,'Nội dung thứ ba','Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm Giới thiệu nội dung thứ ba bao gồm '),(7,4,'Cuối cùng','Giới thiệu nội dung cuối cùng bao gồm Giới thiệu nội dung cuối cùng bao gồm Giới thiệu nội dung cuối cùng bao gồm Giới thiệu nội dung cuối cùng bao gồm '),(8,5,'fgdsgdsg','gsdgdgs'),(9,6,'dhfhdfh','fhdfhfhfh'),(10,7,'hjghj','fjgj'),(11,8,'dfgfg','fgdfgfgd');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_layout_speaker`
--

LOCK TABLES `course_layout_speaker` WRITE;
/*!40000 ALTER TABLE `course_layout_speaker` DISABLE KEYS */;
INSERT INTO `course_layout_speaker` VALUES (5,4,'Lê Thẩm Dương','Nông nghiệp & Phát triển Nông thôn, Công thương Việt Nam, Ngoại thương Việt Nam','Là một trong những cố vấn của Thống đốc ngân hàng nhà nước Việt Nam, khách mời thường xuyên của chương trình CEO chìa khóa thành công VTV1. Chuyên gia tư vấn quản trị cho rất nhiều tập đoàn và doanh nghiệp vừa và nhỏ trong và ngoài nước.','accounts/ba7c/events/1d236/course/speaker/2e9f.jpg'),(6,5,'dgdg','dgdsgs','gdgdgdgsg','accounts/5d3e/events/8bdd/course/speaker/117ba.jpg'),(7,6,'fhfhdfh','fhdfhf','hfhfdhfh','accounts/5d3e/events/2e9f0/course/speaker/4145.jpg'),(8,7,'bjghj','hgjgfj','fgjgfjfgj','accounts/5d3e/events/3472e/course/speaker/174f8.jpg'),(9,8,'dgdgg','gdfgdfg','fdgdgfdgdgd','accounts/5d3e/events/3a46c/course/speaker/53eb.jpg');
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
  `introduction` mediumtext CHARACTER SET utf8,
  `place` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `organize_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `organize_logo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `organize_info` mediumtext CHARACTER SET utf8,
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `phone_number` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `is_public` int(1) NOT NULL DEFAULT '1',
  `is_accept` int(1) NOT NULL DEFAULT '0',
  `image_thumbnail` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `path` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `confirm_email` mediumtext CHARACTER SET utf8,
  PRIMARY KEY (`id`),
  KEY `layout_id` (`layout_id`),
  KEY `type_id` (`type_id`),
  KEY `events_ibfk_3_idx` (`account_id`),
  CONSTRAINT `events_ibfk_1` FOREIGN KEY (`layout_id`) REFERENCES `event_layout` (`id`),
  CONSTRAINT `events_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `event_type` (`id`),
  CONSTRAINT `events_ibfk_3` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (7,1,2,3,'Quest festival','Quest 2016 đã trở lại ở một đẳng cấp mới! Được bình chọn là một trong những lễ hội mãn nhãn nhất thế giới và một trong những lễ hội mang tính tiên phong của Châu Á (Mixmag, Buzzfeed), hãy chuẩn bị tinh thần để cho một dịp vui chưa từng có. Quest là đơn vị đầu tiên giới thiệu tới khán giả Việt Nam mô hình lễ hội âm nhạc với hơn 150 nghệ sĩ trong nước và quốc tế, biểu diễn tại 4 sân khấu tuyệt đẹp cùng với các hoạt động điện ảnh, workshop, nghệ thuật đường phố và hơn thế nữa … Tổ chức tại khuôn viên sinh thái Sơn Tinh camp (Ba Vì, Hà Nội), Quest là 3 ngày nguyên vẹn của những trải nghiệm âm nhạc, nghệ thuật giữa thiên nhiên.','47 Nguyễn Văn Đậu, TP Hồ Chí Minh','2016-08-11 11:35:07','2016-08-12 19:00:00','2016-08-12 22:00:00','Venture North Productions','accounts/5d3e/events/4145/organizeLogo4145.jpg','Venture North Productions specializes in bespoke, unique events with a twist \nwww.venturenorthproductions.com','quest@gmail.vn','0123456789',1,1,'accounts/5d3e/events/4145/thumbnail4145.jpg','4145','<p>Ch&uacute;c mừng bạn đ&atilde; đặt v&eacute; sự kiện QUEST th&agrave;nh c&ocirc;ng. Sự kiện diễn ra v&agrave;o l&uacute;c 19 giờ ng&agrave;y 11/08/2016 tại 47 Nguyễn Văn Đậu, tp Hồ Ch&iacute; Minh. Bạn h&atilde;y đến địa điểm đ&uacute;ng giờ nh&eacute;.</p>'),(8,2,4,2,'Rave in color','Sự xuất hiện của Escape ‘Rave in Color’ được ví như ngọn gió thanh nhiệt, giải toả cơn khát EDM kéo dài của giới trẻ Đà Thành.\nĐặc biệt, lần trở lại này, Escape thực sự là một lãnh địa màu sắc đúng như cái tên của nó. Các tín đồ EDM sẽ có một đêm điên đảo cùng âm nhạc đẳng cấp quốc tế và dàn âm thanh ánh sáng được dàn dựng công phu. Chỉ trong vài màn dạo đầu máu lửa, bạn sẽ bị \"thổi bay\" bởi sự độc đáo của màn phun sơn UV đa sắc màu, những màn biểu diễn cực hấp dẫn và vô số hoạt động bất ngờ khác.','Biển Phạm Văn Đồng, TP Đà Nẵng','2016-08-11 15:06:56','2016-08-15 16:00:00','2016-08-16 22:30:00','i68','accounts/ba7c/events/174f8/organizeLogo174f8.jpg','Công ty Cổ phần I68 thuộc công ty TNHH Truyền Thông Tích Hợp. Được biết đến là công ty chuyên tổ chức các sự kiện, lễ hội âm nhạc và giải trí mang tầm quốc tế với một số chương trình lớn như Escape Music Festival – lễ hội âm nhạc lớn nhất Việt Nam, The Wave Music Festival, City I Love, Sense Of Love, v.v…','i86@gmail.com','0123456789',1,1,'accounts/ba7c/events/174f8/thumbnail174f8.jpg','174f8','<p>Ch&uacute;c&nbsp;mừng bạn đ&atilde;&nbsp;đặt v&eacute;&nbsp;sự kiện RIC&nbsp;th&agrave;nh c&ocirc;ng. Sự kiện diễn ra v&agrave;o l&uacute;c&nbsp;16 giờ ng&agrave;y&nbsp;15/08/2016 tại B&atilde;i biễn Phạm Văn Đồng, tp Đ&agrave; Nẵng. Bạn&nbsp;h&atilde;y&nbsp;đến địa điểm đ&uacute;ng&nbsp;giờ nh&eacute;.&lt;/p&gt;</p>'),(10,3,4,4,'Công thức thành công','Chắc hẳn rằng ai trong đời này cũng đều có ước mơ. Ai cũng mong muốn rằng một ngày nào đó sẽ chạm đến giấc mơ của cuộc đời mình. Thế nhưng không phải ai cũng làm được điều đó, bởi chúng ta không biết chúng ta đang ở đâu, chúng ta phải làm gì để chạm đến thành công. Chúng ta cứ mãi trong một vòng lẩn quẩn mà không thể nào thoát ra được. Chúng ta không đủ tự tin để bước ra khỏi cái ranh giới an toàn để đến một thế giới khác. Và chính nơi đó, bạn thành công !','80B Lê Duẩn, TP Đà Nẵng','2016-08-11 15:40:28','2016-09-08 07:00:00','2016-09-09 20:00:00','Deveerich','accounts/ba7c/events/1d236/organizeLogo1d236.jpg','CÔNG TY TNHH DV Deveerich là công ty chuyên tổ chức các hội thảo, khóa học và tư vấn doanh nghiệp về tài chính, đầu tư, kinh doanh, marketing. Các chương trình hội thảo, khóa học công ty tổ chức với chuyên đề có tính ứng dụng thực tế cao với các diễn giả hàng đầu Việt Nam.','deveerich@gmail.com','0123456789',1,1,'accounts/ba7c/events/1d236/thumbnail1d236.jpg','1d236','<p>Cảm ơn bạn đ&atilde; đăng k&yacute; tham gia chương tr&igrave;nh.&nbsp;</p>'),(11,3,2,1,'Song ngữ Lạc Hồng','Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng Mô tả sự kiện Song Ngữ Lạc Hồng ','25 Hoàng Hoa Thám, TP Hồ Chí Minh','2016-08-12 10:23:34','2016-08-18 03:00:00','2016-08-19 03:30:00','abc','accounts/5d3e/events/6691/organizeLogo6691.jpg','Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc Giới thiệu nhà tổ chức abc ','abc@gmail.com','123456789',1,1,'accounts/5d3e/events/6691/thumbnail6691.jpg','6691','<p>Cảm ơn bạn đ&atilde; đăng k&yacute; sự kiện của ch&uacute;ng t&ocirc;i.</p>'),(12,2,2,2,'Game thủ số 1','dsfdsg','14 Lý Tự Trọng, TP Đà Nẵng','2016-08-12 13:57:14','2016-08-12 20:00:00','2016-08-19 22:00:00','game thủ số một','accounts/5d3e/events/22f74/organizeLogo22f74.jpg','Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin Thông tin ','abc@gmail.com','012346578',1,1,'accounts/5d3e/events/22f74/thumbnail22f74.jpg','22f74','<p>Cảm ơn.</p>'),(13,1,2,3,'Date','Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu Giới thiệu ','14 Hoàng Diệu, TP Hồ Chí Minh','2016-08-12 14:07:05','2016-08-19 21:00:00','2016-08-19 23:30:00','Mickey','accounts/5d3e/events/7937/organizeLogo7937.jpg','thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức thông tin nhà tổ chức ','abc@gmail.com','0123456789',1,1,'accounts/5d3e/events/7937/thumbnail7937.jpg','7937','<p>dfgsdgdg gfhfhsgd dgdgd</p>'),(14,1,2,3,'Guitar','rỳhdfhf','47 Hoàn Kiếm, TP Hà Nội','2016-08-12 14:11:13','2016-08-18 01:00:00','2016-08-19 03:00:00','Abc','accounts/5d3e/events/28cb2/organizeLogo28cb2.jpg','dgdfgfdgfgg','abc@gmail.com','012346547',1,1,'accounts/5d3e/events/28cb2/thumbnail28cb2.jpg','28cb2','<p>dsgd ggs</p>'),(15,3,2,4,'Book sale','fggfdgdfg g gds gdsg','40 Gia Định, TP Hồ Chí Minh','2016-08-12 14:14:04','2017-02-08 01:30:00','2017-02-15 04:00:00','abc','accounts/5d3e/events/8bdd/organizeLogo8bdd.jpg','dfgdsgdgsdsg g sdg','abc@gmail.com','0123456789',1,1,'accounts/5d3e/events/8bdd/thumbnail8bdd.jpg','8bdd','<p>Cảm ơn</p>'),(16,3,2,4,'Back to school','dgdggdsgd','33 Nguyễn Thị Minh Khai, TP Đà Nẵng','2016-08-12 14:18:06','2016-08-18 03:30:00','2016-08-24 03:30:00','T&D','accounts/5d3e/events/2e9f0/organizeLogo2e9f0.jpg','ádfsaff','abc@gmail.com','0123456789',1,1,'accounts/5d3e/events/2e9f0/thumbnail2e9f0.jpg','2e9f0','<p>Thank you!</p>'),(17,2,2,2,'Công nghệ','sfdsfdfsdfsdf','230 Cộng Hòa, TP Hồ Chí Minh','2016-08-12 14:21:02','2016-08-25 04:00:00','2016-09-01 03:30:00','IT ad','accounts/5d3e/events/9e83/organizeLogo9e83.jpg','sfsfasfsf','abc@gmail.com','0123456789',1,1,'accounts/5d3e/events/9e83/thumbnail9e83.jpg','9e83','<p>dgdgsgs</p>'),(18,3,2,4,'Train leader','sdgdgdsgsgdg','47 Cầu Giấy, TP Hà Nội','2016-08-12 14:24:11','2017-07-12 00:30:00','2017-07-19 04:00:00','Training','accounts/5d3e/events/3472e/organizeLogo3472e.jpg','gvdgsdgdsg','abc@gmail.com','0123456789',1,1,'accounts/5d3e/events/3472e/thumbnail3472e.jpg','3472e','<p>Thank you!</p>'),(19,2,2,2,'Food cheer','dfdgfdgds','33 Phan Thanh, TP Đà Nẵng','2016-08-12 14:28:04','2016-08-25 03:30:00','2016-08-27 03:00:00','Food shop','accounts/5d3e/events/b129/organizeLogob129.jpg','ssfsdfdsgdg','abc@gmail.com','0123456789',1,0,'accounts/5d3e/events/b129/thumbnailb129.jpg','b129','<p>thank you!</p>'),(20,3,2,4,'Làm giàu không khó','sfsfsf','55 Đinh Tiên Hoàng, TP Hồ Chí Minh','2016-08-12 14:32:45','2017-07-12 04:00:00','2017-07-12 04:00:00','Động lực','accounts/5d3e/events/3a46c/organizeLogo3a46c.jpg','vvdxvxvxvx','abc@gmail.com','0123456789',1,0,'accounts/5d3e/events/3a46c/thumbnail3a46c.jpg','3a46c','<p>Cảm ơn nh&eacute;!</p>'),(22,1,2,3,'CoCo fest','sdgfsdgdgg','55 Bùi Đình Túy, TP Hồ Chí Minh','2016-08-12 14:40:55','2017-01-01 19:00:00','2017-01-01 23:30:00','Oppo','accounts/5d3e/events/401aa/organizeLogo401aa.jpg','dfgdsgdgdgs','abc@gmail.com','0123456789',1,0,'accounts/5d3e/events/401aa/thumbnail401aa.jpg','401aa','<p>sdfsdfgdgs</p>');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_type`
--

LOCK TABLES `event_type` WRITE;
/*!40000 ALTER TABLE `event_type` DISABLE KEYS */;
INSERT INTO `event_type` VALUES (1,'Âm Nhạc'),(2,'Hoạt Động'),(3,'Khóa Học');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_layout`
--

LOCK TABLES `free_layout` WRITE;
/*!40000 ALTER TABLE `free_layout` DISABLE KEYS */;
INSERT INTO `free_layout` VALUES (2,11,'<p><span style=\"background-color: #ff9900;\">SONG NGỮ LẠC HỒNG L&Agrave; MỘT CHƯƠNG TR&Igrave;NH HỌC GI&Uacute;P TRẢI NGHIỆM V&Agrave; CẢI THIỆN NHIỀU KỸ NĂNG CỦA BẢN TH&Acirc;N</span></p>\n<ul>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n<li><span style=\"background-color: #00ffff;\">Học Tập g&igrave; đ&oacute;</span></li>\n</ul>\n<p>Một số h&igrave;nh ảnh của kh&oacute;a học</p>\n<p><img src=\"../resources/images/accounts/5d3e/events/6691/freelayout/16691.jpg\" width=\"712\" height=\"400\" /><img src=\"../resources/images/accounts/5d3e/events/6691/freelayout/26691.jpg\" width=\"580\" height=\"400\" /><img src=\"../resources/images/accounts/5d3e/events/6691/freelayout/36691.jpg\" alt=\"\" width=\"674\" height=\"400\" /><img src=\"../resources/images/accounts/5d3e/events/6691/freelayout/46691.jpg\" alt=\"\" width=\"676\" height=\"400\" /></p>\n<p>&nbsp;</p>\n<h1><strong>V&agrave;o l&uacute;c 20 giờ 00 Ng&agrave;y 20 th&aacute;ng 8 năm 2016 Tại 25 Ho&agrave;ng Hoa Th&aacute;m, tp Hồ Ch&iacute; Minh</strong></h1>\n<p><strong>Li&ecirc;n hệ: 0123456789 (Gặp anh A)</strong></p>');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_layout_image_library`
--

LOCK TABLES `free_layout_image_library` WRITE;
/*!40000 ALTER TABLE `free_layout_image_library` DISABLE KEYS */;
INSERT INTO `free_layout_image_library` VALUES (2,2,'accounts/5d3e/events/6691/freelayout/16691.jpg'),(3,2,'accounts/5d3e/events/6691/freelayout/26691.jpg'),(4,2,'accounts/5d3e/events/6691/freelayout/36691.jpg'),(5,2,'accounts/5d3e/events/6691/freelayout/46691.jpg');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_layout`
--

LOCK TABLES `music_layout` WRITE;
/*!40000 ALTER TABLE `music_layout` DISABLE KEYS */;
INSERT INTO `music_layout` VALUES (2,7,'accounts/5d3e/events/4145/music/banner4145.jpg','https://www.youtube.com/embed/AQm9GDjVdgs','accounts/5d3e/events/4145/music/place4145.jpg'),(3,13,'accounts/5d3e/events/7937/music/banner7937.jpg','youtube.com','accounts/5d3e/events/7937/music/place7937.jpg'),(4,14,'accounts/5d3e/events/28cb2/music/banner28cb2.jpg','dgdggd','accounts/5d3e/events/28cb2/music/place28cb2.jpg'),(5,22,'accounts/5d3e/events/401aa/music/banner401aa.jpg','dfsfd','accounts/5d3e/events/401aa/music/place401aa.jpg');
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
  `introduction` mediumtext CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_music_layout` (`music_layout_id`),
  CONSTRAINT `mus_lay_famous_person_ibfk_1` FOREIGN KEY (`music_layout_id`) REFERENCES `music_layout` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_layout_famous_person`
--

LOCK TABLES `music_layout_famous_person` WRITE;
/*!40000 ALTER TABLE `music_layout_famous_person` DISABLE KEYS */;
INSERT INTO `music_layout_famous_person` VALUES (3,2,'accounts/5d3e/events/4145/music/famousPerson/1bf9.jpg','Noo Phước Thịnh','1988-12-18','Khác với nhiều ca sĩ Việt Nam khác về hoàn cảnh xuất thân, Noo Phước Thịnh được coi là có trình độ học vấn, anh đã là sinh viên đại học, tuy nhiên do nhiều yếu tố, anh đã chọn con đường nghệ thuật. Bằng tài năng của mình, anh đã nỗ lực tìm kiếm vị trí của mình trong lòng người yêu nhạc, đặc biệt là giới trẻ Việt Nam.'),(5,3,'accounts/5d3e/events/7937/music/famousPerson/2e9f.jpg','fgdggsgd','2016-08-12','dgdsgdsgs'),(6,3,'accounts/5d3e/events/7937/music/famousPerson/117ba.jpg','dgdsgdg','2016-07-07','dgdsgdgsgd'),(7,4,'accounts/5d3e/events/28cb2/music/famousPerson/4145.jpg','ẻtgdfghd','2016-08-12','fhdfhfdhfdhd'),(8,5,'accounts/5d3e/events/401aa/music/famousPerson/174f8.jpg','dffdfs','2016-08-12','dfsdfdfs');
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_layout_image_library`
--

LOCK TABLES `music_layout_image_library` WRITE;
/*!40000 ALTER TABLE `music_layout_image_library` DISABLE KEYS */;
INSERT INTO `music_layout_image_library` VALUES (5,2,'accounts/5d3e/events/4145/music/libImage/14145.jpg'),(6,2,'accounts/5d3e/events/4145/music/libImage/24145.jpg'),(7,2,'accounts/5d3e/events/4145/music/libImage/34145.jpg'),(8,2,'accounts/5d3e/events/4145/music/libImage/44145.jpg'),(9,2,'accounts/5d3e/events/4145/music/libImage/54145.jpg'),(10,2,'accounts/5d3e/events/4145/music/libImage/64145.jpg'),(11,2,'accounts/5d3e/events/4145/music/libImage/74145.jpg'),(12,2,'accounts/5d3e/events/4145/music/libImage/84145.jpg'),(13,2,'accounts/5d3e/events/4145/music/libImage/94145.jpg'),(14,2,'accounts/5d3e/events/4145/music/libImage/104145.jpg'),(15,3,'accounts/5d3e/events/7937/music/libImage/37937.jpg'),(16,4,'accounts/5d3e/events/28cb2/music/libImage/428cb2.jpg'),(17,5,'accounts/5d3e/events/401aa/music/libImage/10401aa.jpg');
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
  `description` mediumtext CHARACTER SET utf8,
  `is_free` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (10,7,500000,'Vé 3 ngày (thứ 6 - CN) đợt 2/ 3 day tickets (Friday-Sunday) - Phase 2','Được mở bán từ ngày Thứ Sáu 04/11 tới Chủ Nhật 06/11 - lều trại và chi phí đi lại chưa bao gồm trong giá vé / Valid for entry from Friday 04/11 until Sunday 06/11 - camping and transport not included.\n',0),(11,7,400000,'Vé 3 ngày (thứ 6 - CN) cho học sinh - đợt 2/ Student 3 day tickets (Friday-Sunday) - Phase 2','Vé ưu đãi dành riêng cho học sinh, sinh viên. Bạn sẽ phải trình thẻ sinh viên khi nhận vòng đeo tay phân loại vé. Nếu không có thẻ sinh viên, bạn bắt buộc phải mua vé full price. Lưu ý lều trại và chi phí đi lại chưa bao gồm trong giá vé. Vé đang được bán với tốc độ chóng mặt và có thể sẽ khóa sổ trước đợt 2 Available for Full Time Students. ID must be presented upon collection of wristbands. Full price applies if ID is not presented. Camping and transport not included. Tickets subject to availability and can sell out before phase 2.\n',0),(12,7,300000,'Vé 2 ngày (Thứ 7 - CN) đợt 2/ 2 day tickets (Saturday-Sunday) - Phase 2','Được mở bán từ ngày Thứ bảy 05/11 09:00 tới Chủ Nhật 06/11 20:00 - lều trại và chi phí đi lại chưa bao gồm trong giá vé/ Valid for entry from Saturday 05/11 09:00am until Sunday 06/11 20:00 - camping and transport not included.\n',0),(13,8,500000,'VIP ','Miễn phí bia',0),(14,8,200000,'Ga','không có ưu đãi',0),(15,10,200000,'Vip','Ghế gần giảng viên nhất. Có nước uống miễn phí',0),(16,10,50000,'Thường','không có quyền lợi',0),(17,11,0,'Miễn phí','Không có ăn uống và trò chơi',1),(18,11,50000,'Trọn gói','Có ăn trưa và trò chơi trong buổi dã ngoại',0),(19,12,0,'mien phi','mô tả',1),(20,13,0,'miễn phí','dgdgdsg',1),(21,14,0,'free','hfhh',1),(22,15,0,'free','dfgsdgs',1),(23,16,0,'free','sdgdgsdfg',1),(24,17,0,'free','fhfdg',1),(25,17,250000,'Vip','dgfdggdg',0),(26,18,260000,'Research ','dgdg',0),(27,18,400000,'Vip','dgdsgd',0),(28,19,200000,'Vip 1','dsgdsgdgsg',0),(29,19,150000,'Vip 2','dgdgdg',0),(30,20,10000,'Thường','dsgdsgdgs',0),(31,20,30000,'Vip','gfdggsgd',0),(32,22,500000,'Thường','dgdsgdggs',0),(33,22,600000,'Vip','dsfgdsgdsgsg',0);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_buyer`
--

LOCK TABLES `ticket_buyer` WRITE;
/*!40000 ALTER TABLE `ticket_buyer` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_order`
--

LOCK TABLES `ticket_order` WRITE;
/*!40000 ALTER TABLE `ticket_order` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_information`
--

LOCK TABLES `user_information` WRITE;
/*!40000 ALTER TABLE `user_information` DISABLE KEYS */;
INSERT INTO `user_information` VALUES (2,'Huỳnh Sơn','Tam Phước','0123456789','Nam','1996-12-11','sonhv.jpg'),(3,'admin','khjk','khbkh','Nam','2016-08-16',NULL),(4,'Phạm Văn Ý','Quảng Bình','0123456789','Nam','1995-01-01','ypv.jpg'),(5,'Hoàng Yến','Quảng Nam','0123456789','Nữ','2016-08-10','user2.jpg'),(6,'Ngọc Đặng','Quảng Bình','0123456789','Nữ','2016-08-15','user3.jpg'),(7,'user 5','acvcv','01213213134','Nam','2016-08-16','user5.jpg'),(8,'user 7','dfasf','0254510','Nam',NULL,'user7.jpg'),(9,'user 8','','','Nam',NULL,'user8.jpg'),(10,'user 9','dfsdf','','Nam',NULL,'user9.jpg');
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

-- Dump completed on 2016-08-13  6:05:15
