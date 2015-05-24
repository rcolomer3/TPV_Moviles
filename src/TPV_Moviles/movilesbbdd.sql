CREATE DATABASE  IF NOT EXISTS `movilesbbdd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `movilesbbdd`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: movilesbbdd
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `DNI` varchar(9) NOT NULL,
  `Edad` int(11) NOT NULL DEFAULT '0',
  `Telefono` varchar(9) DEFAULT NULL,
  `fechaNacimiento` varchar(50) NOT NULL DEFAULT '00-00-0000',
  `fechaAlta` varchar(50) NOT NULL DEFAULT '00-00-0000',
  `Usuario` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Estado` tinyint(1) DEFAULT '0',
  `Tipo` varchar(30) NOT NULL DEFAULT 'user',
  `Avatar` varchar(90) DEFAULT NULL,
  `Antiguedad` int(11) DEFAULT '0',
  `Saldo` float DEFAULT '0',
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('Miguel','Gandiaa','04677781H',26,'699586369','12-11-1988','19-10-2010','miguel','81dc9bdb52d04dc20036dbd8313ed055','miguel@gmail.com',1,'user','src/TPV/Img/empleado.png',4,900),('Juanito','Antonio','16200730J',32,'633256996','30-5-1982','18-5-2008','AE29I','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com',0,'Administrador','src/TPV/Img/empleado.png',6,1300),('Lauri','Ramos','16426883F',35,'698563202','6-4-1980','7-4-2002','laurita','81dc9bdb52d04dc20036dbd8313ed055','laurara@gmail.com',0,'user','src/TPV/Img/empleado.png',13,1300),('Sergio','Lopez','23469776R',33,'698563001','13-8-1981','25-3-2009','sergio','81dc9bdb52d04dc20036dbd8313ed055','sergio@gmail.com',0,'user','src/TPV/Img/empleado.png',6,1300),('Jaume','Taure','25076823S',33,'698563025','16-9-1981','21-5-2011','jaume','81dc9bdb52d04dc20036dbd8313ed055','jaume@gmail.com',0,'user','src/TPV/Img/empleado.png',3,1300),('Maria','Martinez','28056545H',36,'695369853','24-10-1978','18-11-2012','maria','81dc9bdb52d04dc20036dbd8313ed055','maria@gmail.com',0,'user','src/TPV/Img/empleado.png',2,980),('Tomass','Marti','39192792X',30,'698563021','21-2-1985','16-7-2011','tomaas','81dc9bdb52d04dc20036dbd8313ed055','tomaas@gmail.com',0,'user','src/TPV/Img/empleado.png',3,1300),('Josete','Gramage','45855444E',33,'600256398','4-4-1982','11-4-2009','jose','81dc9bdb52d04dc20036dbd8313ed055','jose2@gmail.com',0,'user','src/TPV/Img/empleado.png',6,1300),('Raul','Colomer','48607190W',22,'665538067','14-3-1993','1-1-2011','raul','827ccb0eea8a706c4c34a16891f84e7b','raul@gmail.com',1,'Administrador','src/TPV/Img/FE8WNTINUZ.jpg',4,1300),('Jose Miguel','Hernandez','57379364E',34,'666999668','3-5-1981','16-5-2010','S8DAX','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com',0,'Administrador','src/TPV/Img/empleado.png',4,1300),('Paulita','Sanz','71586317J',36,'669523021','22-4-1979','9-4-2011','paulasanz','81dc9bdb52d04dc20036dbd8313ed055','paulasanz@gmail.com',0,'user','src/TPV/Img/empleado.png',4,1300),('Lucia','Vidal','73484232Z',37,'659365201','12-11-1977','19-10-2007','lucia','81dc9bdb52d04dc20036dbd8313ed055','lucia@gmail.com',0,'user','src/TPV/Img/empleado.png',7,900),('Damina','Donate','78347191Z',38,'655896325','1-5-1977','19-5-2001','YO74V','41ac940640f89f07d8ce16bed0c20627','rcolomer3@gmail.com',0,'user','src/TPV/Img/empleado.png',13,1300),('ploloooo','ldadad','95451561C',42,'699625369','6-5-1973','17-5-1998','351IG','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com',0,'user',NULL,16,1300);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_insert_ef` AFTER INSERT ON `clientes` FOR EACH
ROW BEGIN
insert into historial_crear_ef(Nombre, Apellidos, DNI, Tipo, Usuario, Email, Fecha_nuevo)
values(new.Nombre, new.Apellidos, new.DNI, new.Tipo, USER(), new.Email, Now());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_hist_update_ef` AFTER UPDATE ON `clientes` FOR EACH
ROW BEGIN
insert into historial_update_ef(NombreOld, NombreNew, ApellidosOld, ApellidosNew, DNI, Tipo, UsuarioOld, UsuarioNew,
EmailOld, EmailNew, Fecha_modif)
values(old.Nombre, new.Nombre, old.Apellidos, new.Apellidos, old.DNI, old.Tipo, old.Usuario, new.Usuario,
old.Email, new.Email, NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_hist_delete_ef` AFTER DELETE ON `clientes` FOR EACH
ROW BEGIN
insert into historial_delete_ef(Nombre, Apellidos, DNI, Tipo, Usuario,
Email, Fecha_delet)
values(old.Nombre, old.Apellidos, old.DNI, old.Tipo, old.Usuario,
old.Email, NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `historial_crear_cli`
--

DROP TABLE IF EXISTS `historial_crear_cli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_crear_cli` (
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Tipo` varchar(15) NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Fecha_nuevo` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_crear_cli`
--

LOCK TABLES `historial_crear_cli` WRITE;
/*!40000 ALTER TABLE `historial_crear_cli` DISABLE KEYS */;
INSERT INTO `historial_crear_cli` VALUES ('Lucia','Vidal','73484232Z','user','root@localhost','lucia@gmail.com','2015-04-26 19:13:57'),('Miguel','Gandia','04677781H','user','root@localhost','lucia@gmail.com','2015-04-26 19:18:40'),('Carlos','Ferrando','98208102B','user','root@localhost','carlos@gmail.com','2015-04-26 19:36:47'),('Tomas','Marti','39192792X','user','root@localhost','tomaas@gmail.com','2015-04-27 10:48:48'),('Sergio','Lopez','23469776R','user','root@localhost','sergio@gmail.com','2015-05-05 10:28:44'),('Damian','Donat','78410045D','user','root@localhost','damian@gmail.com','2015-05-07 18:49:03'),('Borja','Alventosa','98653946T','user','root@localhost','borja@gmail.com','2015-05-07 18:50:17'),('Jaume','Taure','25076823S','user','root@localhost','jaume@gmail.com','2015-05-07 19:16:05'),('prueba','prueba','10402847Q','user','root@localhost','prueba@gmail.com','2015-05-09 12:09:25'),('pruebbaa','prueaa','60329202H','user','root@localhost','pruebaa@gmail.com','2015-05-09 12:33:02'),('olaaa','olaaaaaa','89775209E','user','root@localhost','olaa@gmail.com','2015-05-09 13:23:48'),('olaaaaa','eeeeeee','40933276S','user','root@localhost','1erdaw2015@gmail.com','2015-05-10 08:47:24'),('oliita','oliiitaa','29105854K','user','root@localhost','rcolomer3@gmail.com','2015-05-10 09:13:39'),('Paquita','Monleon','56024556Y','user','root@localhost','rcolomer3@gmail.com','2015-05-10 09:16:27'),('Pepito','Pereze','91877085C','user','root@localhost','rcolomer3@gmail.com','2015-05-10 09:27:21'),('pruebaa','prueba','35318511X','user','root@localhost','rcolomer3@gmail.com','2015-05-10 09:50:04'),('pruebita','pruebai','95391068V','user','root@localhost','rcolomer3@gmail.com','2015-05-10 09:56:06'),('Vicent','Esparza','69502757T','user','root@localhost','rcolomer3@gmail.com','2015-05-10 10:37:14'),('pruebaaaa','pruebaaaaa','57379364E','','root@localhost','rcolomer3@gmail.com','2015-05-10 11:10:33'),('prueee','prueaa','57379364E','Administrador','root@localhost','rcolomer3@gmail.com','2015-05-10 11:13:16'),('Damina','Donate','78347191Z','user','root@localhost','rcolomer3@gmail.com','2015-05-10 11:46:03'),('Juan','Antonio','16200730J','Administrador','root@localhost','rcolomer3@gmail.com','2015-05-10 12:03:34'),('peeee','poloee','16724792C','user','root@localhost','rcolomer3@gmail.com','2015-05-10 19:43:00'),('ploloooo','ldadad','95451561C','Administrador','root@localhost','rcolomer3@gmail.com','2015-05-10 19:46:13');
/*!40000 ALTER TABLE `historial_crear_cli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_delete_cli`
--

DROP TABLE IF EXISTS `historial_delete_cli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_delete_cli` (
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Tipo` varchar(15) NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Fecha_delet` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_delete_cli`
--

LOCK TABLES `historial_delete_cli` WRITE;
/*!40000 ALTER TABLE `historial_delete_cli` DISABLE KEYS */;
INSERT INTO `historial_delete_cli` VALUES ('Manolete','Esteve','48603730S','Administrador','manolo2','manolo@gmail.com','2015-04-26 20:04:50'),('Carlos','Ferrando','98208102B','user','carlos','carlos@gmail.com','2015-04-27 10:51:00'),('prueba','prueba','10402847Q','user','PIAJ9','prueba@gmail.com','2015-05-10 09:24:56'),('oliita','oliiitaa','29105854K','user','LYU8P','rcolomer3@gmail.com','2015-05-10 09:25:02'),('olaaaaa','eeeeeee','40933276S','user','G65VU','1erdaw2015@gmail.com','2015-05-10 09:25:06'),('pruebbaa','prueaa','60329202H','user','SQOPN','pruebaa@gmail.com','2015-05-10 09:25:09'),('olaaa','olaaaaaa','89775209E','user','75QRG','olaa@gmail.com','2015-05-10 09:25:15'),('Paquita','Monleon','56024556Y','user','F3YAQ','rcolomer3@gmail.com','2015-05-10 10:39:42'),('pruebaa','prueba','35318511X','user','45RB2','rcolomer3@gmail.com','2015-05-10 10:39:42'),('Vicent','Esparza','69502757T','user','O8P3C','rcolomer3@gmail.com','2015-05-10 10:39:42'),('pruebaaaa','pruebaaaaa','57379364E','','2W0KT','rcolomer3@gmail.com','2015-05-10 11:12:29'),('Borja','Alventosa','98653946T','user','borja','borja@gmail.com','2015-05-10 11:44:58'),('pruebita','pruebai','95391068V','user','6RKA9','rcolomer3@gmail.com','2015-05-10 11:44:58'),('Pepito','Pereze','91877085C','user','NFW3N','rcolomer3@gmail.com','2015-05-10 11:44:58'),('Damian','Donat','78410045D','user','damian','damian@gmail.com','2015-05-10 11:44:58'),('Vicent','Albert','73764391X','user','vicent','vicent2@gmail.com','2015-05-10 11:44:58'),('peeee','poloee','16724792C','user','Q50HT','rcolomer3@gmail.com','2015-05-11 12:37:50');
/*!40000 ALTER TABLE `historial_delete_cli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_update_cli`
--

DROP TABLE IF EXISTS `historial_update_cli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_update_cli` (
  `NombreOld` varchar(50) NOT NULL,
  `NombreNew` varchar(45) DEFAULT NULL,
  `ApellidosOld` varchar(45) NOT NULL,
  `ApellidosNew` varchar(45) DEFAULT NULL,
  `DNI` varchar(9) NOT NULL,
  `Tipo` varchar(15) NOT NULL,
  `UsuarioOld` varchar(20) NOT NULL,
  `UsuarioNew` varchar(20) DEFAULT NULL,
  `EmailOld` varchar(45) NOT NULL,
  `EmailNew` varchar(45) DEFAULT NULL,
  `Fecha_modif` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_update_cli`
--

LOCK TABLES `historial_update_cli` WRITE;
/*!40000 ALTER TABLE `historial_update_cli` DISABLE KEYS */;
INSERT INTO `historial_update_cli` VALUES ('Manolo','Manolete','Gonzalez','Esteve','48603730S','Administrador','manolo','manolo2','manolo2@gmail.com','manolo@gmail.com','2015-04-26 19:38:13'),('Laura','Laurita','Peralta','Ramos','16426883F','user','laura','laurita','laura@gmail.com','laurara@gmail.com','2015-04-26 19:57:25'),('Paula','Paulita','Santamaria','Sanz','71586317J','user','paulasan','paulasanz','paulasan@gmail.com','paulasanz@gmail.com','2015-04-27 10:50:04'),('Jose','Josete','Gramage','Gramage','45855444E','user','jose','jose','jose2@gmail.com','jose2@gmail.com','2015-04-29 12:25:17'),('Miguel','Miguelin','Gandia','Gandiaa','04677781H','user','miguel','miguel','miguel@gmail.com','miguel@gmail.com','2015-04-29 17:34:31'),('Josete','Jose','Gramage','Gramage','45855444E','user','jose','jose','jose2@gmail.com','jose2@gmail.com','2015-05-03 16:40:50'),('Jose','Jose','Gramage','Gramage','45855444E','user','jose','raul','jose2@gmail.com','jose2@gmail.com','2015-05-04 19:43:45'),('Jose','Jose','Gramage','Gramage','45855444E','user','raul','jose','jose2@gmail.com','jose2@gmail.com','2015-05-04 19:44:10'),('Jose','Josete','Gramage','Gramage','45855444E','user','jose','jose','jose2@gmail.com','jose2@gmail.com','2015-05-04 20:46:44'),('Josete','Joset','Gramage','Gramage','45855444E','user','jose','jose','jose2@gmail.com','jose2@gmail.com','2015-05-04 21:00:34'),('Joset','Josete','Gramage','Gramage','45855444E','user','jose','jose','jose2@gmail.com','jose2@gmail.com','2015-05-05 10:17:52'),('Tomas','Tomas','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-05 10:49:00'),('Tomas','Tomas','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-05 18:46:59'),('Tomas','Tomas','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-05 18:47:26'),('Tomas','Tomas','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-05 18:48:03'),('Maria','Maria','Martinez','Martinez','28056545H','user','maria','maria','maria@gmail.com','maria@gmail.com','2015-05-05 18:50:17'),('Tomas','Tomas','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-05 18:51:53'),('Tomas','Tomas','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-05 18:52:25'),('Tomas','Tomas','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-05 18:53:07'),('Miguelin','Miguelin','Gandiaa','Gandiaa','04677781H','user','miguel','miguel','miguel@gmail.com','miguel@gmail.com','2015-05-05 18:55:05'),('Laurita','Laurita','Ramos','Ramos','16426883F','user','laurita','laurita','laurara@gmail.com','laurara@gmail.com','2015-05-05 18:55:46'),('Sergio','Sergio','Lopez','Lopez','23469776R','user','sergio','sergio','sergio@gmail.com','sergio@gmail.com','2015-05-05 18:55:51'),('Josete','Josete','Gramage','Gramage','45855444E','user','jose','jose','jose2@gmail.com','jose2@gmail.com','2015-05-05 18:57:19'),('Lucia','Lucia','Vidal','Vidal','73484232Z','user','lucia','lucia','lucia@gmail.com','lucia@gmail.com','2015-05-05 18:57:24'),('Paulita','Paulita','Sanz','Sanz','71586317J','user','paulasanz','paulasanz','paulasanz@gmail.com','paulasanz@gmail.com','2015-05-05 18:57:29'),('Raul','Raul','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-05 18:57:34'),('Vicent','Vicent','Albert','Albert','73764391X','user','vicent','vicent','vicent2@gmail.com','vicent2@gmail.com','2015-05-05 18:57:39'),('Raul','Raul','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-05 19:17:10'),('Raul','Raul','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 10:44:23'),('Raul','Raul','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 10:44:32'),('Raul','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 11:06:37'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 11:07:57'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 12:17:58'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 12:19:08'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 12:24:07'),('Tomas','Tomasete','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-06 12:53:45'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 19:10:21'),('Tomasete','Tomasete','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-06 19:11:11'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-06 19:21:48'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-07 12:01:26'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-07 12:04:14'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-07 12:04:21'),('Tomasete','Tomass','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-07 19:07:54'),('Jaume','Jaume','Taure','Taure','25076823S','user','jaume','jaume','jaume@gmail.com','jaume@gmail.com','2015-05-07 19:16:58'),('Tomass','Tomass','Marti','Marti','39192792X','user','tomaas','tomaas','tomaas@gmail.com','tomaas@gmail.com','2015-05-07 19:17:11'),('Miguelin','Miguel','Gandiaa','Gandiaa','04677781H','user','miguel','miguel','miguel@gmail.com','miguel@gmail.com','2015-05-07 19:23:05'),('prueba','prueba','prueba','prueba','10402847Q','user','PIAJ9','PIAJ9','prueba@gmail.com','prueba@gmail.com','2015-05-09 12:26:32'),('pruebbaa','pruebbaa','prueaa','prueaa','60329202H','user','SQOPN','SQOPN','pruebaa@gmail.com','pruebaa@gmail.com','2015-05-09 12:34:27'),('Pepito','Pepito','Pereze','Pereze','91877085C','user','NFW3N','NFW3N','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 09:30:40'),('prueee','prueee','prueaa','prueaa','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 11:28:48'),('prueee','prueee','prueaa','prueaa','57379364E','User','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 11:33:55'),('Juan','Juanito','Antonio','Antonio','16200730J','Administrador','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:14:34'),('Juanito','Juanito','Antonio','Antonio','16200730J','user','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:16:41'),('Juanito','Juanito','Antonio','Antonio','16200730J','user','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:17:37'),('Juanito','Juanit','Antonio','Antonio','16200730J','Administrador','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:20:07'),('Juanit','Juanit','Antonio','Antonio','16200730J','Administrador','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:20:59'),('Juanit','Juanit','Antonio','Antonio','16200730J','Administrador','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:40:56'),('Juanit','Juanit','Antonio','Antonio','16200730J','default','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:43:22'),('Juanit','Juanito','Antonio','Antonio','16200730J','default','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:43:47'),('Juanito','Juanito','Antonio','Antonio','16200730J','default','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:45:32'),('Juanito','Juanit','Antonio','Antonio','16200730J','user','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:45:50'),('Juanit','Juanito','Antonio','Antonio','16200730J','Administrador','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:46:11'),('Juanito','Juanit','Antonio','Antonio','16200730J','user','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:48:15'),('Juanit','Juanito','Antonio','Antonio','16200730J','Administrador','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 12:48:30'),('Juanito','Juanito','Antonio','Antonio','16200730J','user','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 18:54:34'),('Juanito','Juanito','Antonio','Antonio','16200730J',' ','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 19:00:56'),('Juanito','Juanito','Antonio','Antonio','16200730J',' ','AE29I','AE29I','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-10 19:12:54'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 19:55:33'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul1','raul@gmail.com','raul@gmail.com','2015-05-10 19:56:02'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul1','raul1','raul@gmail.com','raul@gmail.com','2015-05-10 20:00:19'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul1','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:01:00'),('Josete','Josete','Gramage','Gramage','45855444E','user','jose','jose','jose2@gmail.com','jose2@gmail.com','2015-05-10 20:08:00'),('Josete','Josete','Gramage','Gramage','45855444E','user','jose','jose','jose2@gmail.com','jose2@gmail.com','2015-05-10 20:10:00'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:32:59'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:40:12'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:43:39'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:43:52'),('Raulet','Raulet','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:46:25'),('Raulet','Raul','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:47:16'),('Raul','Raul','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:49:22'),('Raul','Raul','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:52:34'),('Maria','Maria','Martinez','Martinez','28056545H','user','maria','maria','maria@gmail.com','maria@gmail.com','2015-05-10 20:52:34'),('Miguel','Miguel','Gandiaa','Gandiaa','04677781H','user','miguel','miguel','miguel@gmail.com','miguel@gmail.com','2015-05-10 20:54:30'),('Raul','Raul','Colomer','Colomer','48607190W','Administrador','raul','raul','raul@gmail.com','raul@gmail.com','2015-05-10 20:54:30'),('peeee','peeee','poloee','poloee','16724792C','user','Q50HT','Q50HT','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 11:07:31'),('peeee','peeee','poloee','poloee','16724792C','user','Q50HT','Q50HT','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 11:10:32'),('peeee','peeee','poloee','poloee','16724792C','user','Q50HT','Q50HT','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 11:12:19'),('ploloooo','ploloooo','ldadad','ldadad','95451561C','Administrador','351IG','351IG','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 12:39:58'),('prueee','Jose Miguel','prueaa','Hernandez','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:13:10'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:14:00'),('Laurita','Lauri','Ramos','Ramos','16426883F','user','laurita','laurita','laurara@gmail.com','laurara@gmail.com','2015-05-11 13:19:20'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:23:39'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','user','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:26:32'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:27:21'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','user','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:28:19'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:28:55'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:30:47'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:32:33'),('Jose Miguel','Jose Miguel','Hernandez','Hernandez','57379364E','Administrador','S8DAX','S8DAX','rcolomer3@gmail.com','rcolomer3@gmail.com','2015-05-11 13:33:28');
/*!40000 ALTER TABLE `historial_update_cli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'movilesbbdd'
--
/*!50003 DROP PROCEDURE IF EXISTS `procedure_edad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure_edad`(OUT `cliente_joven` INT, OUT `cliente_mayor` INT)
BEGIN
SELECT MIN(Edad),MAX(Edad) into cliente_joven, cliente_mayor FROM clientes ORDER BY Edad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `procedure_media_edad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure_media_edad`(OUT `Edad_media` DOUBLE)
BEGIN
SELECT ROUND(AVG(Edad)) into Edad_media FROM clientes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-21 23:32:10
