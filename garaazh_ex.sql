-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: garaazh
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `kategooria`
--

DROP TABLE IF EXISTS `kategooria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategooria` (
  `kood` bigint(20) NOT NULL AUTO_INCREMENT,
  `nimetus` varchar(255) DEFAULT NULL,
  `kategooria_kood` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`kood`),
  KEY `FK_lpml5td21g2sqlcnbh9mgdo4x` (`kategooria_kood`),
  CONSTRAINT `FK_lpml5td21g2sqlcnbh9mgdo4x` FOREIGN KEY (`kategooria_kood`) REFERENCES `kategooria` (`kood`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategooria`
--

LOCK TABLES `kategooria` WRITE;
/*!40000 ALTER TABLE `kategooria` DISABLE KEYS */;
INSERT INTO `kategooria` VALUES (1,'Emaplaadid',NULL),(2,'Mälud',NULL),(3,'Toiteplokid',NULL);
/*!40000 ALTER TABLE `kategooria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaubaomadus`
--

DROP TABLE IF EXISTS `kaubaomadus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaubaomadus` (
  `kood` bigint(20) NOT NULL AUTO_INCREMENT,
  `vaartus` varchar(255) DEFAULT NULL,
  `kaup_kood` bigint(20) DEFAULT NULL,
  `omadus_kood` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`kood`),
  KEY `FK_dmfnfbqm6rbsmrw9atet898qm` (`kaup_kood`),
  KEY `FK_hh6q9m7eiw4rs7p6rflkcr15n` (`omadus_kood`),
  CONSTRAINT `FK_dmfnfbqm6rbsmrw9atet898qm` FOREIGN KEY (`kaup_kood`) REFERENCES `kaup` (`kood`),
  CONSTRAINT `FK_hh6q9m7eiw4rs7p6rflkcr15n` FOREIGN KEY (`omadus_kood`) REFERENCES `omadus` (`kood`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaubaomadus`
--

LOCK TABLES `kaubaomadus` WRITE;
/*!40000 ALTER TABLE `kaubaomadus` DISABLE KEYS */;
INSERT INTO `kaubaomadus` VALUES (1,'250mm',7832872,1),(2,'180mm',7832872,2),(3,'must',7832872,3),(4,'Must',1234567,3),(5,'12fps',1234567,5);
/*!40000 ALTER TABLE `kaubaomadus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaubaseisund`
--

DROP TABLE IF EXISTS `kaubaseisund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaubaseisund` (
  `kood` bigint(20) NOT NULL AUTO_INCREMENT,
  `nimetus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kood`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaubaseisund`
--

LOCK TABLES `kaubaseisund` WRITE;
/*!40000 ALTER TABLE `kaubaseisund` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaubaseisund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaup`
--

DROP TABLE IF EXISTS `kaup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaup` (
  `kood` bigint(20) NOT NULL,
  `hind` decimal(19,2) DEFAULT NULL,
  `nimetus` varchar(255) DEFAULT NULL,
  `kategooria_kood` bigint(20) DEFAULT NULL,
  `seisund_kood` bigint(20) DEFAULT NULL,
  `tarnija_registriKood` bigint(20) DEFAULT NULL,
  `tootaja_isikukood` varchar(255) DEFAULT NULL,
  `tootja_registriKood` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`kood`),
  KEY `FK_nacd17hv865di4p60ifhbnj7h` (`kategooria_kood`),
  KEY `FK_6wierob6e0u8f7rw13c95sc7y` (`seisund_kood`),
  KEY `FK_qd0k8irc5bdlrn5bojpe827gd` (`tarnija_registriKood`),
  KEY `FK_hd2k85lgxcnr4afa85esqiiw0` (`tootaja_isikukood`),
  KEY `FK_4jf7x74rthociimcit504yjrf` (`tootja_registriKood`),
  CONSTRAINT `FK_4jf7x74rthociimcit504yjrf` FOREIGN KEY (`tootja_registriKood`) REFERENCES `tootja` (`registriKood`),
  CONSTRAINT `FK_6wierob6e0u8f7rw13c95sc7y` FOREIGN KEY (`seisund_kood`) REFERENCES `seisund` (`kood`),
  CONSTRAINT `FK_hd2k85lgxcnr4afa85esqiiw0` FOREIGN KEY (`tootaja_isikukood`) REFERENCES `tootaja` (`isikukood`),
  CONSTRAINT `FK_nacd17hv865di4p60ifhbnj7h` FOREIGN KEY (`kategooria_kood`) REFERENCES `kategooria` (`kood`),
  CONSTRAINT `FK_qd0k8irc5bdlrn5bojpe827gd` FOREIGN KEY (`tarnija_registriKood`) REFERENCES `tarnija` (`registriKood`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaup`
--

LOCK TABLES `kaup` WRITE;
/*!40000 ALTER TABLE `kaup` DISABLE KEYS */;
INSERT INTO `kaup` VALUES (1234567,12.45,'Hiir',2,1,1341,'39212344321',1338),(7832872,449.90,'ABIT eXtreme Gaming Board',1,1,1340,NULL,1337);
/*!40000 ALTER TABLE `kaup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `omadus`
--

DROP TABLE IF EXISTS `omadus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `omadus` (
  `kood` bigint(20) NOT NULL AUTO_INCREMENT,
  `nimetus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kood`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `omadus`
--

LOCK TABLES `omadus` WRITE;
/*!40000 ALTER TABLE `omadus` DISABLE KEYS */;
INSERT INTO `omadus` VALUES (1,'pikkus'),(2,'laius'),(3,'värv'),(4,'sügavus'),(5,'võimsus'),(6,'siinikiirus'),(7,'maht');
/*!40000 ALTER TABLE `omadus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organisatsioon`
--

DROP TABLE IF EXISTS `organisatsioon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organisatsioon` (
  `registriKood` bigint(20) NOT NULL,
  `nimi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`registriKood`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organisatsioon`
--

LOCK TABLES `organisatsioon` WRITE;
/*!40000 ALTER TABLE `organisatsioon` DISABLE KEYS */;
INSERT INTO `organisatsioon` VALUES (1337,'Samyang'),(1338,'Samsung'),(1339,'chiPhone Industries Ltd'),(1340,'Gediminas Transports UAB'),(1341,'OÜ Patsaanid'),(1342,'OÜ Riskikuller');
/*!40000 ALTER TABLE `organisatsioon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seisund`
--

DROP TABLE IF EXISTS `seisund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seisund` (
  `kood` bigint(20) NOT NULL AUTO_INCREMENT,
  `nimetus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kood`),
  UNIQUE KEY `UK_mqrtk7ojwktbtvh780vp7f840` (`nimetus`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seisund`
--

LOCK TABLES `seisund` WRITE;
/*!40000 ALTER TABLE `seisund` DISABLE KEYS */;
INSERT INTO `seisund` VALUES (1,'aktiivne'),(2,'mitteaktiivne');
/*!40000 ALTER TABLE `seisund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarnija`
--

DROP TABLE IF EXISTS `tarnija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarnija` (
  `tarneaeg` decimal(19,2) DEFAULT NULL,
  `registriKood` bigint(20) NOT NULL,
  PRIMARY KEY (`registriKood`),
  CONSTRAINT `FK_1g8n44h6wbdie3njmo84aluih` FOREIGN KEY (`registriKood`) REFERENCES `organisatsioon` (`registriKood`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarnija`
--

LOCK TABLES `tarnija` WRITE;
/*!40000 ALTER TABLE `tarnija` DISABLE KEYS */;
INSERT INTO `tarnija` VALUES (10.00,1340),(NULL,1341),(1.00,1342);
/*!40000 ALTER TABLE `tarnija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tootaja`
--

DROP TABLE IF EXISTS `tootaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tootaja` (
  `isikukood` varchar(255) NOT NULL,
  `eMail` varchar(255) DEFAULT NULL,
  `nimi` varchar(255) DEFAULT NULL,
  `parool` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`isikukood`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tootaja`
--

LOCK TABLES `tootaja` WRITE;
/*!40000 ALTER TABLE `tootaja` DISABLE KEYS */;
INSERT INTO `tootaja` VALUES ('39212344321','laomees@hot.ee','Laomees Lagunov','JkbHb7tVt');
/*!40000 ALTER TABLE `tootaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tootja`
--

DROP TABLE IF EXISTS `tootja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tootja` (
  `hinne` float DEFAULT NULL,
  `registriKood` bigint(20) NOT NULL,
  PRIMARY KEY (`registriKood`),
  CONSTRAINT `FK_gglkiig80ofdv4qwfy414mbs3` FOREIGN KEY (`registriKood`) REFERENCES `organisatsioon` (`registriKood`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tootja`
--

LOCK TABLES `tootja` WRITE;
/*!40000 ALTER TABLE `tootja` DISABLE KEYS */;
INSERT INTO `tootja` VALUES (2,1337),(NULL,1338),(0.5,1339);
/*!40000 ALTER TABLE `tootja` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-27 12:21:09
