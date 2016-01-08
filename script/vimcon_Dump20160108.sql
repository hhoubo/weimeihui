CREATE DATABASE  IF NOT EXISTS `vimcon` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vimcon`;
-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: vimcon
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address_country` varchar(45) DEFAULT NULL,
  `address_sheng` varchar(45) DEFAULT NULL,
  `address_shi` varchar(45) DEFAULT NULL,
  `address_qv` varchar(45) DEFAULT NULL,
  `address_detail` varchar(45) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'pola','pola des');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL COMMENT '已付款, 已发货未结账, 已结账 ',
  `item_id` int(11) NOT NULL,
  `cost_jpy` decimal(10,0) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price_jpy` decimal(10,0) DEFAULT NULL,
  `exchange_rate` decimal(10,4) DEFAULT NULL,
  `price_cny` decimal(10,2) DEFAULT NULL,
  `cost_cny` decimal(10,2) DEFAULT NULL,
  `payment_mode` smallint(6) DEFAULT NULL COMMENT '1. 现金 2. 信用卡 3. 积分',
  `express_fee_jpy` decimal(10,0) DEFAULT NULL,
  `package_fee_jpy` decimal(10,0) DEFAULT NULL,
  `express_fee_cny` decimal(10,2) DEFAULT NULL,
  `package_fee_cny` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`,`item_id`),
  KEY `fk_orders_1_idx` (`customer_id`),
  CONSTRAINT `fk_orders_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-08 17:39:33
