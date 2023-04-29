-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cban
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `labeling`
--

DROP TABLE IF EXISTS `labeling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `labeling` (
  `book_id` int NOT NULL,
  `label_id` int NOT NULL,
  PRIMARY KEY (`book_id`,`label_id`),
  KEY `label_id` (`label_id`),
  CONSTRAINT `labeling_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON UPDATE CASCADE,
  CONSTRAINT `labeling_ibfk_2` FOREIGN KEY (`label_id`) REFERENCES `label` (`label_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labeling`
--

LOCK TABLES `labeling` WRITE;
/*!40000 ALTER TABLE `labeling` DISABLE KEYS */;
INSERT INTO `labeling` VALUES (1,1),(3,1),(5,1),(7,1),(9,1),(11,1),(13,1),(15,1),(17,1),(19,1),(21,1),(23,1),(25,1),(27,1),(29,1),(31,1),(33,1),(35,1),(37,1),(39,1),(41,1),(43,1),(45,1),(47,1),(49,1),(51,1),(53,1),(55,1),(57,1),(59,1),(61,1),(63,1),(65,1),(67,1),(69,1),(71,1),(73,1),(75,1),(77,1),(79,1),(81,1),(83,1),(85,1),(87,1),(89,1),(91,1),(93,1),(95,1),(97,1),(99,1),(101,1),(103,1),(105,1),(107,1),(109,1),(111,1),(113,1),(115,1),(117,1),(119,1),(121,1),(123,1),(125,1),(127,1),(129,1),(131,1),(133,1),(135,1),(137,1),(139,1),(141,1),(143,1),(145,1),(147,1),(149,1),(151,1),(153,1),(155,1),(157,1),(159,1),(161,1),(163,1),(165,1),(167,1),(169,1),(171,1),(173,1),(175,1),(177,1),(179,1),(181,1),(183,1),(185,1),(187,1),(189,1),(191,1),(193,1),(195,1),(197,1),(199,1),(2,2),(4,2),(6,2),(8,2),(10,2),(12,2),(14,2),(16,2),(18,2),(20,2),(22,2),(24,2),(26,2),(28,2),(30,2),(32,2),(34,2),(36,2),(38,2),(40,2),(42,2),(44,2),(46,2),(48,2),(50,2),(52,2),(54,2),(56,2),(58,2),(60,2),(62,2),(64,2),(66,2),(68,2),(70,2),(72,2),(74,2),(76,2),(78,2),(80,2),(82,2),(84,2),(86,2),(88,2),(90,2),(92,2),(94,2),(96,2),(98,2),(100,2),(102,2),(104,2),(106,2),(108,2),(110,2),(112,2),(114,2),(116,2),(118,2),(120,2),(122,2),(124,2),(126,2),(128,2),(130,2),(132,2),(134,2),(136,2),(138,2),(140,2),(142,2),(144,2),(146,2),(148,2),(150,2),(152,2),(154,2),(156,2),(158,2),(160,2),(162,2),(164,2),(166,2),(168,2),(170,2),(172,2),(174,2),(176,2),(178,2),(180,2),(182,2),(184,2),(186,2),(188,2),(190,2),(192,2),(194,2),(196,2),(198,2),(200,2),(24,3),(48,3),(68,3),(76,3),(77,3),(175,3),(190,3),(198,3),(6,4),(39,4),(153,4),(164,4),(7,5),(8,5),(14,5),(18,5),(27,5),(31,5),(34,5),(42,5),(55,5),(64,5),(67,5),(86,5),(88,5),(89,5),(95,5),(101,5),(102,5),(107,5),(113,5),(114,5),(117,5),(128,5),(134,5),(141,5),(147,5),(161,5),(165,5),(179,5),(183,5),(189,5);
/*!40000 ALTER TABLE `labeling` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-30  0:44:05
