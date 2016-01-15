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
  `account_id` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
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
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `invoice_name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES ('1','pola','','pola des');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_receipts`
--

DROP TABLE IF EXISTS `purchase_receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_receipts` (
  `receipt_id` int(11) NOT NULL,
  `item_id` varchar(45) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` decimal(20,2) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `total` decimal(20,2) DEFAULT NULL,
  `purchase_date` datetime DEFAULT NULL,
  `purchaser` varchar(45) DEFAULT NULL COMMENT '购买人',
  `vendor_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`receipt_id`,`item_id`),
  KEY `item_id_idx` (`item_id`),
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_receipts`
--

LOCK TABLES `purchase_receipts` WRITE;
/*!40000 ALTER TABLE `purchase_receipts` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_receipts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_items`
--

DROP TABLE IF EXISTS `return_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_items` (
  `return_receipt_id` varchar(45) NOT NULL,
  `shipment_id` varchar(45) NOT NULL,
  PRIMARY KEY (`return_receipt_id`,`shipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_items`
--

LOCK TABLES `return_items` WRITE;
/*!40000 ALTER TABLE `return_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_receipts`
--

DROP TABLE IF EXISTS `return_receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_receipts` (
  `return_id` varchar(45) NOT NULL,
  `return_date` datetime DEFAULT NULL,
  `return_total` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`return_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_receipts`
--

LOCK TABLES `return_receipts` WRITE;
/*!40000 ALTER TABLE `return_receipts` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_receipts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_items`
--

DROP TABLE IF EXISTS `shipment_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_items` (
  `shipment_id` varchar(45) NOT NULL,
  `item_id` varchar(45) NOT NULL,
  `batch_id` varchar(45) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`shipment_id`,`item_id`,`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_items`
--

LOCK TABLES `shipment_items` WRITE;
/*!40000 ALTER TABLE `shipment_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_receipts`
--

DROP TABLE IF EXISTS `shipment_receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_receipts` (
  `shipment_id` varchar(45) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `gift` varchar(45) DEFAULT NULL,
  `gift_cost` decimal(20,2) DEFAULT NULL,
  `gift_currency` varchar(45) DEFAULT NULL,
  `express_fee` decimal(20,2) DEFAULT NULL,
  `express_currency` varchar(45) DEFAULT NULL,
  `package_fee` decimal(20,2) DEFAULT NULL,
  `package_currency` varchar(45) DEFAULT NULL,
  `exchange_rate` decimal(10,4) DEFAULT NULL,
  `sale_date` datetime DEFAULT NULL,
  `is_return` int(11) DEFAULT NULL COMMENT '1 true, 0 false',
  PRIMARY KEY (`shipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_receipts`
--

LOCK TABLES `shipment_receipts` WRITE;
/*!40000 ALTER TABLE `shipment_receipts` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_receipts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_items`
--

DROP TABLE IF EXISTS `stock_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_items` (
  `item_id` varchar(45) NOT NULL,
  `purchase_receipt_id` int(11) NOT NULL,
  `purchase_batch` varchar(45) DEFAULT NULL,
  `remain_amount` int(11) NOT NULL DEFAULT '0',
  `cost_price` decimal(10,2) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL COMMENT 'JPY, CNY, HKD',
  PRIMARY KEY (`item_id`,`purchase_receipt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_items`
--

LOCK TABLES `stock_items` WRITE;
/*!40000 ALTER TABLE `stock_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_account` varchar(45) NOT NULL,
  `password` varchar(256) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendors`
--

DROP TABLE IF EXISTS `vendors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendors` (
  `vendor_id` varchar(45) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendors`
--

LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-15 17:30:11
