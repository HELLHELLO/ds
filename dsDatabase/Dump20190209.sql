-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: ds
-- ------------------------------------------------------
-- Server version	5.7.25-log

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
-- Table structure for table `consult_item`
--

DROP TABLE IF EXISTS `consult_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consult_item` (
  `consult_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `shop_name` varchar(45) NOT NULL,
  `brand_id` bigint(20) NOT NULL,
  `item_desc` text,
  `cid` bigint(10) NOT NULL,
  `brand_name` varchar(45) NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  `consult_tx` text,
  `respose_tx` text,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  `user_id` bigint(20) NOT NULL,
  `expert_id` bigint(20) DEFAULT NULL,
  `items_id` bigint(20) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：1未完成，0已完成',
  PRIMARY KEY (`consult_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consult_item`
--

LOCK TABLES `consult_item` WRITE;
/*!40000 ALTER TABLE `consult_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `consult_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NOT NULL COMMENT '分类ID',
  `title` varchar(200) DEFAULT NULL COMMENT '内容标题',
  `sub_title` varchar(100) DEFAULT NULL COMMENT '子标题',
  `title_desc` varchar(500) DEFAULT NULL COMMENT '标题描述',
  `url` varchar(500) DEFAULT NULL COMMENT '连接',
  `pic` varchar(500) DEFAULT NULL COMMENT '图片路径',
  `pic2` varchar(500) DEFAULT NULL COMMENT '图片路径',
  `content` text COMMENT '内容',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_category`
--

DROP TABLE IF EXISTS `content_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父级目录的ID，一级目录的父目录ID默认为0',
  `name` varchar(50) NOT NULL COMMENT '分类名称',
  `valued` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1正常0删除',
  `sort_order` int(4) DEFAULT NULL,
  `is_parent` tinyint(1) NOT NULL DEFAULT '0' COMMENT '表示是否是父节点，0否1是',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `parent` (`parent_id`,`valued`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_category`
--

LOCK TABLES `content_category` WRITE;
/*!40000 ALTER TABLE `content_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `content_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_admin`
--

DROP TABLE IF EXISTS `ds_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_admin` (
  `admin_id` bigint(20) NOT NULL,
  `admin_name` varchar(45) NOT NULL,
  `admin_password` varchar(45) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_admin`
--

LOCK TABLES `ds_admin` WRITE;
/*!40000 ALTER TABLE `ds_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_brands`
--

DROP TABLE IF EXISTS `ds_brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_brands` (
  `brand_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(45) NOT NULL COMMENT '品牌名',
  `brand_image` varchar(200) NOT NULL COMMENT '品牌商标图',
  `brand_dec` varchar(150) DEFAULT NULL COMMENT '品牌描述',
  `brand_url` varchar(200) DEFAULT NULL COMMENT '品牌主页',
  `valued` tinyint(1) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`brand_id`),
  UNIQUE KEY `brand_id_UNIQUE` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='品牌表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_brands`
--

LOCK TABLES `ds_brands` WRITE;
/*!40000 ALTER TABLE `ds_brands` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_cart`
--

DROP TABLE IF EXISTS `ds_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_cart` (
  `cart_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `item_num` int(10) NOT NULL DEFAULT '1',
  `item_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `item_statu` tinyint(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1正常2下架',
  `valued` tinyint(1) NOT NULL DEFAULT '1' COMMENT '该行有效与否，1有效0失效',
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `cart_id_UNIQUE` (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_cart`
--

LOCK TABLES `ds_cart` WRITE;
/*!40000 ALTER TABLE `ds_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_item_cat`
--

DROP TABLE IF EXISTS `ds_item_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_item_cat` (
  `cat_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) NOT NULL COMMENT '类目名称',
  `status` int(1) DEFAULT '1' COMMENT '状态。可选值：1.正常，2.删除',
  `sort_order` int(4) DEFAULT NULL COMMENT '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `is_parent` tinyint(1) DEFAULT '1' COMMENT '该类目是否为父类目，1为true，0为false',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  `pic_id` bigint(20) DEFAULT NULL,
  `cat_desc` mediumtext,
  PRIMARY KEY (`cat_id`),
  KEY `parent_id` (`parent_id`,`status`) USING BTREE,
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=1194 DEFAULT CHARSET=utf8 COMMENT='商品类目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_item_cat`
--

LOCK TABLES `ds_item_cat` WRITE;
/*!40000 ALTER TABLE `ds_item_cat` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_item_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_item_for_items`
--

DROP TABLE IF EXISTS `ds_item_for_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_item_for_items` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '具体商品的id',
  `items_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `title` varchar(100) NOT NULL COMMENT '商品标题',
  `paramter` varchar(500) NOT NULL COMMENT '商品参数，如区分土豪金典雅白',
  `price` bigint(20) unsigned NOT NULL COMMENT '商品价格，单位为：分',
  `num` int(10) NOT NULL COMMENT '库存数量',
  `barcode` varchar(30) DEFAULT NULL COMMENT '商品条形码',
  `image` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `cid` bigint(10) NOT NULL COMMENT '所属类目，叶子类目',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`item_id`),
  KEY `cid` (`cid`),
  KEY `status` (`status`),
  KEY `updated` (`updated`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_item_for_items`
--

LOCK TABLES `ds_item_for_items` WRITE;
/*!40000 ALTER TABLE `ds_item_for_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_item_for_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_item_param`
--

DROP TABLE IF EXISTS `ds_item_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_item_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `param_data` text,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_item_param`
--

LOCK TABLES `ds_item_param` WRITE;
/*!40000 ALTER TABLE `ds_item_param` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_item_param` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_item_param_item`
--

DROP TABLE IF EXISTS `ds_item_param_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_item_param_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `items_id` bigint(20) NOT NULL,
  `param_data` text,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `ITEMID` (`items_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_item_param_item`
--

LOCK TABLES `ds_item_param_item` WRITE;
/*!40000 ALTER TABLE `ds_item_param_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_item_param_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_item_pic`
--

DROP TABLE IF EXISTS `ds_item_pic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_item_pic` (
  `pic_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `items_id` bigint(20) DEFAULT NULL,
  `pic_dec` varchar(50) DEFAULT NULL COMMENT '图片描述',
  `pic_url` varchar(200) NOT NULL,
  `pic_statu` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，1是0否',
  `pic_master` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否是主图，1是0否',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pic_id`),
  UNIQUE KEY `pic_id_UNIQUE` (`pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='商品图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_item_pic`
--

LOCK TABLES `ds_item_pic` WRITE;
/*!40000 ALTER TABLE `ds_item_pic` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_item_pic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_item_trace`
--

DROP TABLE IF EXISTS `ds_item_trace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_item_trace` (
  `trace_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '追溯信息编号',
  `item_cat_id` bigint(20) DEFAULT NULL COMMENT '商品类目ID',
  `trace_admin_id` bigint(20) DEFAULT NULL,
  `items_id` bigint(20) NOT NULL COMMENT '商品款式id',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `shop_id` bigint(20) NOT NULL COMMENT '商家ID',
  `data` text COMMENT '追溯信息',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `verifed` tinyint(4) NOT NULL DEFAULT '0' COMMENT '验证与否，是1否0',
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`trace_id`),
  UNIQUE KEY `item_id_UNIQUE` (`item_id`),
  KEY `item_cat_id` (`item_cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品追溯信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_item_trace`
--

LOCK TABLES `ds_item_trace` WRITE;
/*!40000 ALTER TABLE `ds_item_trace` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_item_trace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_items`
--

DROP TABLE IF EXISTS `ds_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_items` (
  `items_id` bigint(20) NOT NULL COMMENT '商品ID',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺id',
  `brand_id` bigint(20) NOT NULL COMMENT '品牌ID',
  `name` varchar(45) NOT NULL,
  `item_desc` bigint(20) DEFAULT NULL COMMENT '商品描述',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `price` bigint(20) NOT NULL COMMENT '价格',
  `unit` varchar(45) NOT NULL COMMENT '商品单位',
  `shop_name` varchar(45) NOT NULL COMMENT '店铺名',
  `cid` bigint(10) NOT NULL COMMENT '商品类别id',
  `brand_name` varchar(45) NOT NULL COMMENT '品牌名',
  `image` varchar(500) DEFAULT NULL COMMENT '缩略图',
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`items_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品描述表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_items`
--

LOCK TABLES `ds_items` WRITE;
/*!40000 ALTER TABLE `ds_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_items_desc`
--

DROP TABLE IF EXISTS `ds_items_desc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_items_desc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `item_desc` text,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `ITEMSID` (`item_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_items_desc`
--

LOCK TABLES `ds_items_desc` WRITE;
/*!40000 ALTER TABLE `ds_items_desc` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_items_desc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_order`
--

DROP TABLE IF EXISTS `ds_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `payment` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `payment_type` int(2) DEFAULT NULL COMMENT '支付类型，1、在线支付，2、货到付款',
  `post_fee` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `status` int(10) DEFAULT NULL COMMENT '状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新时间',
  `payment_time` timestamp NULL DEFAULT NULL COMMENT '付款时间',
  `consign_time` timestamp NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '交易完成时间',
  `close_time` timestamp NULL DEFAULT NULL COMMENT '交易关闭时间',
  `shipping_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '物流名称',
  `shipping_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '物流单号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `buyer_message` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '买家留言',
  `buyer_nick` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '买家昵称',
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  `shipping_id` bigint(20) DEFAULT NULL,
  `shop_id` bigint(20) NOT NULL COMMENT '商家ID',
  PRIMARY KEY (`order_id`),
  KEY `create_time` (`create_time`),
  KEY `buyer_nick` (`buyer_nick`),
  KEY `status` (`status`),
  KEY `payment_type` (`payment_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_order`
--

LOCK TABLES `ds_order` WRITE;
/*!40000 ALTER TABLE `ds_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_order_item`
--

DROP TABLE IF EXISTS `ds_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_order_item` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `item_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '商品id',
  `order_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '订单id',
  `num` int(10) DEFAULT NULL COMMENT '商品购买数量',
  `title` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品标题',
  `price` bigint(50) DEFAULT NULL COMMENT '商品单价',
  `total_fee` bigint(50) DEFAULT NULL COMMENT '商品总金额',
  `pic_path` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片地址',
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_order_item`
--

LOCK TABLES `ds_order_item` WRITE;
/*!40000 ALTER TABLE `ds_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_order_shipping`
--

DROP TABLE IF EXISTS `ds_order_shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_order_shipping` (
  `shipping_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货人全名',
  `receiver_phone` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `receiver_mobile` varchar(30) DEFAULT NULL COMMENT '移动电话',
  `receiver_state` varchar(10) DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(10) DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) DEFAULT NULL COMMENT '区/县',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '收货地址，如：xx路xx号',
  `receiver_zip` varchar(6) DEFAULT NULL COMMENT '邮政编码,如：310001',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `shipping_code` varchar(20) DEFAULT NULL,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`shipping_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_order_shipping`
--

LOCK TABLES `ds_order_shipping` WRITE;
/*!40000 ALTER TABLE `ds_order_shipping` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_order_shipping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_user`
--

DROP TABLE IF EXISTS `ds_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '角色',
  `role` enum('cosumer','marchant','tracemng','expert') NOT NULL DEFAULT 'cosumer',
  `nick_name` varchar(50) NOT NULL COMMENT '昵称，默认为用户名',
  `head` mediumtext NOT NULL COMMENT '头像',
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_user`
--

LOCK TABLES `ds_user` WRITE;
/*!40000 ALTER TABLE `ds_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_user_address`
--

DROP TABLE IF EXISTS `ds_user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_user_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `phone` varchar(20) NOT NULL COMMENT '地址联系电话',
  `name` varchar(20) NOT NULL COMMENT '地址联系人',
  `zip_code` varchar(20) NOT NULL COMMENT '邮编',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  `state` varchar(10) DEFAULT NULL COMMENT '省份',
  `city` varchar(10) DEFAULT NULL,
  `district` varchar(20) DEFAULT NULL COMMENT '区/县',
  `address` varchar(200) DEFAULT NULL COMMENT '街道门牌号等地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_user_address`
--

LOCK TABLES `ds_user_address` WRITE;
/*!40000 ALTER TABLE `ds_user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_user_comuser`
--

DROP TABLE IF EXISTS `ds_user_comuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_user_comuser` (
  `comuser_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`comuser_id`),
  UNIQUE KEY `comuser_id_UNIQUE` (`comuser_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_user_comuser`
--

LOCK TABLES `ds_user_comuser` WRITE;
/*!40000 ALTER TABLE `ds_user_comuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_user_comuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_user_shop`
--

DROP TABLE IF EXISTS `ds_user_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ds_user_shop` (
  `shop_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商家ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `shop_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '店铺名',
  `link_man` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系人人名',
  `link_phone` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系电话',
  `bank_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '开户银行名',
  `bank_account` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '开户账户',
  `address` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '地址',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `shop_head` mediumtext CHARACTER SET latin1 NOT NULL COMMENT '店铺头像',
  `data` mediumtext CHARACTER SET latin1 COMMENT '店铺简介',
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  `ds_user_shopcol` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `shop_id_UNIQUE` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商户身份用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_user_shop`
--

LOCK TABLES `ds_user_shop` WRITE;
/*!40000 ALTER TABLE `ds_user_shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `ds_user_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expert`
--

DROP TABLE IF EXISTS `expert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expert` (
  `expert` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name_` varchar(50) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `fee` bigint(50) unsigned DEFAULT NULL,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  `user_id` bigint(20) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：1正常，0限制接单',
  PRIMARY KEY (`expert`),
  UNIQUE KEY `name_` (`name_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert`
--

LOCK TABLES `expert` WRITE;
/*!40000 ALTER TABLE `expert` DISABLE KEYS */;
/*!40000 ALTER TABLE `expert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trace_access`
--

DROP TABLE IF EXISTS `trace_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trace_access` (
  `trace_access_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trace_manager_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `cid` bigint(20) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`trace_access_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trace_access`
--

LOCK TABLES `trace_access` WRITE;
/*!40000 ALTER TABLE `trace_access` DISABLE KEYS */;
/*!40000 ALTER TABLE `trace_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trace_manager`
--

DROP TABLE IF EXISTS `trace_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trace_manager` (
  `mng_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mng_name` varchar(45) NOT NULL,
  `login_name` varchar(45) NOT NULL,
  `login_password` varchar(45) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valued` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`mng_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trace_manager`
--

LOCK TABLES `trace_manager` WRITE;
/*!40000 ALTER TABLE `trace_manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `trace_manager` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-09 23:31:34
