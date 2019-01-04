-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: ds
-- ------------------------------------------------------
-- Server version	5.7.24-log

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
-- Dumping data for table `consult_item`
--

LOCK TABLES `consult_item` WRITE;
/*!40000 ALTER TABLE `consult_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `consult_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_admin`
--

LOCK TABLES `ds_admin` WRITE;
/*!40000 ALTER TABLE `ds_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_brands`
--

LOCK TABLES `ds_brands` WRITE;
/*!40000 ALTER TABLE `ds_brands` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_cart`
--

LOCK TABLES `ds_cart` WRITE;
/*!40000 ALTER TABLE `ds_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_item_cat`
--

LOCK TABLES `ds_item_cat` WRITE;
/*!40000 ALTER TABLE `ds_item_cat` DISABLE KEYS */;
INSERT INTO `ds_item_cat` VALUES (1,0,'水产品',1,NULL,1,'2018-12-30 07:55:50','2018-12-30 07:55:50',1,'1','测试'),(2,0,'谷物',1,NULL,1,'2018-12-30 07:55:50','2018-12-30 07:55:50',1,'2','测试2'),(3,1,'鱼',1,NULL,1,'2018-12-30 07:55:50','2018-12-30 07:55:50',1,'3','测试3'),(4,1,'虾',1,NULL,1,'2018-12-30 07:55:50','2018-12-30 07:55:50',1,'3','测试4'),(5,3,'淡水鱼',1,NULL,0,'2018-12-30 07:55:50','2018-12-30 07:55:50',1,'4','测试5');
/*!40000 ALTER TABLE `ds_item_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_item_for_items`
--

LOCK TABLES `ds_item_for_items` WRITE;
/*!40000 ALTER TABLE `ds_item_for_items` DISABLE KEYS */;
INSERT INTO `ds_item_for_items` VALUES (1,1,'测试','测试',10000,500,'暂无','暂无',1,1,'2018-12-25 08:55:19','2018-12-25 08:55:19',1);
/*!40000 ALTER TABLE `ds_item_for_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_item_pic`
--

LOCK TABLES `ds_item_pic` WRITE;
/*!40000 ALTER TABLE `ds_item_pic` DISABLE KEYS */;
INSERT INTO `ds_item_pic` VALUES (1,NULL,NULL,'http://192.168.56.101/2018/12/31/bb81a399-b826-4eb3-9f49-01267bc39e1e.jpg',1,0,'2018-12-31 10:17:33',1,NULL),(2,NULL,NULL,'http://192.168.56.101/2018/12/31/b8b95003-f95e-4ae9-8714-d4196bd9cfeb.jpg',1,0,'2018-12-31 10:19:08',1,NULL);
/*!40000 ALTER TABLE `ds_item_pic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_item_trace`
--

LOCK TABLES `ds_item_trace` WRITE;
/*!40000 ALTER TABLE `ds_item_trace` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_item_trace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_items`
--

LOCK TABLES `ds_items` WRITE;
/*!40000 ALTER TABLE `ds_items` DISABLE KEYS */;
INSERT INTO `ds_items` VALUES (1,1,1,'测试','测试','2018-12-24 08:31:58','2018-12-24 08:31:58',1000,'件','测试',1,'测试','暂无',1);
/*!40000 ALTER TABLE `ds_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_order`
--

LOCK TABLES `ds_order` WRITE;
/*!40000 ALTER TABLE `ds_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_order_shipping`
--

LOCK TABLES `ds_order_shipping` WRITE;
/*!40000 ALTER TABLE `ds_order_shipping` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_order_shipping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_user`
--

LOCK TABLES `ds_user` WRITE;
/*!40000 ALTER TABLE `ds_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_user_address`
--

LOCK TABLES `ds_user_address` WRITE;
/*!40000 ALTER TABLE `ds_user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_user_comuser`
--

LOCK TABLES `ds_user_comuser` WRITE;
/*!40000 ALTER TABLE `ds_user_comuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_user_comuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ds_user_shop`
--

LOCK TABLES `ds_user_shop` WRITE;
/*!40000 ALTER TABLE `ds_user_shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_user_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expert`
--

LOCK TABLES `expert` WRITE;
/*!40000 ALTER TABLE `expert` DISABLE KEYS */;
/*!40000 ALTER TABLE `expert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_order_item`
--

LOCK TABLES `tb_order_item` WRITE;
/*!40000 ALTER TABLE `tb_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trace_mng`
--

LOCK TABLES `trace_mng` WRITE;
/*!40000 ALTER TABLE `trace_mng` DISABLE KEYS */;
/*!40000 ALTER TABLE `trace_mng` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-31 18:31:02
