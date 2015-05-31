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
  `Nombre` varchar(50) DEFAULT NULL,
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
  `Tipo` varchar(45) NOT NULL DEFAULT 'cliente',
  `Avatar` varchar(45) DEFAULT NULL,
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
INSERT INTO `clientes` VALUES ('Martha','Pla','00000001R',23,'658962369','8-6-1991','11-6-2013','KQV53','01ebcd44f44c0a08b6fa65fcad5fafa8','rcolomer3@gmail.com',0,'Cliente','src/TPV_Moviles/Img/empleado.png',1,700),('Juanjo','Lopez','06571095H',22,'685693365','20-5-1993','8-5-2011','juan','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com',0,'Cliente','src/TPV_Moviles/Img/empleado.png',4,500),('Manolo','Martinez','25645074M',42,'650236958','20-5-1973','7-5-2010','manolo','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com',0,'Cliente','src/TPV_Moviles/Img/0EQ2IAS4ZP.jpg',5,900),('Raul','Colomer','48607190W',22,'665538067','14-3-1993','8-5-2010','raul','827ccb0eea8a706c4c34a16891f84e7b','rcolomer3@gmail.com',0,'Administrador','src/TPV_Moviles/Img/FKMZHURYO7.jpg',5,501),('Lucia','Sanchez','52352718A',32,'658963658','7-5-1983','11-5-2008','lucia','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com',0,'Cliente','src/TPV_Moviles/Img/empleado.png',7,500);
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_registro_clientes` AFTER INSERT ON `clientes` FOR EACH
ROW BEGIN
insert into registro_clientes(Nombre, Apellidos, DNI, Tipo, Usuario, Email, Fecha_creacion)
values( new.Nombre, new.Apellidos, new.DNI, new.Tipo, new.Usuario, new.Email, Now());
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_update_clientes` AFTER UPDATE ON `clientes` FOR EACH
ROW BEGIN
insert into update_clientes(NombreOld, NombreNew, ApellidosOld, ApellidosNew, DNI, UsuarioOld, UsuarioNew, Fecha_modif)
values( old.Nombre, new.Nombre, old.Apellidos, new.Apellidos, new.DNI, old.Usuario, new.Usuario, Now());
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_delete_clientes` AFTER DELETE ON `clientes` FOR EACH
ROW BEGIN
insert into delete_clientes(Nombre, Apellidos, DNI, Usuario, Email, Tipo, Fecha_delete)
values( old.Nombre, old.Apellidos, old.DNI, old.Usuario, old.Email, old.Tipo, Now());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `delete_clientes`
--

DROP TABLE IF EXISTS `delete_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delete_clientes` (
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `DNI` varchar(9) DEFAULT NULL,
  `Usuario` varchar(40) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  `fecha_delete` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delete_clientes`
--

LOCK TABLES `delete_clientes` WRITE;
/*!40000 ALTER TABLE `delete_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `delete_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delete_prod`
--

DROP TABLE IF EXISTS `delete_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delete_prod` (
  `Referencia` varchar(45) DEFAULT NULL,
  `Modelo` varchar(45) DEFAULT NULL,
  `Marca` varchar(45) DEFAULT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  `Fecha_delete` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delete_prod`
--

LOCK TABLES `delete_prod` WRITE;
/*!40000 ALTER TABLE `delete_prod` DISABLE KEYS */;
/*!40000 ALTER TABLE `delete_prod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `Referencia` varchar(500) NOT NULL,
  `Modelo` varchar(45) DEFAULT NULL,
  `Marca` varchar(45) DEFAULT NULL,
  `Descrip` varchar(500) DEFAULT NULL,
  `FechaMercado` varchar(45) NOT NULL DEFAULT '00-00-0000',
  `Antiguedad` int(11) DEFAULT '0',
  `Precio` float DEFAULT '0',
  `Stock` int(11) DEFAULT '0',
  `Tipo` varchar(45) NOT NULL DEFAULT 'Smartphone',
  `Avatar` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('001','G2','LGs','Movil Gama Alta','10-11-2013',1,489,10,'Smartphone','src/TPV_Moviles/Img/9E8RICMEQ9.jpg'),('002','5','Nexus','Gama Alta','11-5-2013',2,350,15,'Smartphone','src/TPV_Moviles/Img/ZINMPR0J1M.jpg'),('003','Funda Ae5','BQ','Funda de alta calidad','9-5-2014',1,10,15,'Smartphone','src/TPV_Moviles/Img/WQAE2UMNAV.jpg'),('004','Funda G3','LG','Funda LG','4-5-2013',2,10,15,'Smartphone','src/TPV_Moviles/Img/0UJI1UVCTR.jpg'),('005','Cargador LG','LG','Cargador para LG','9-5-2014',1,20,15,'Accesorio','src/TPV_Moviles/Img/FI5EI56MVX.jpg'),('006','Player','Nexus','SmartBox Nexus Player','22-5-2014',1,100,15,'Accesorio','src/TPV_Moviles/Img/K7FGOAWO4F.jpg'),('007','S6','Samsung','Nuevo Samsung','7-5-2014',1,600,15,'Smartphone','src/TPV_Moviles/Img/QGX9IM6AK3.jpg');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_registro_prod` AFTER INSERT ON `productos` FOR EACH
ROW BEGIN
insert into registro_prod(Referencia, Modelo, Marca, Precio, Tipo, Fecha_creacion)
values( new.Referencia, new.Modelo, new.Marca, new.Precio, new.Tipo, Now());
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_update_prod` AFTER UPDATE ON `productos` FOR EACH
ROW BEGIN
insert into update_prod(Referencia, ModeloOld, ModeloNew, MarcaOld, MarcaNew, TipoOld, TipoNew, Fecha_modif)
values( new.Referencia, old.Modelo, new.Modelo, old.Marca, new.Marca, old.Tipo, new.Tipo, Now());
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_delete_prod` AFTER DELETE ON `productos` FOR EACH
ROW BEGIN
insert into delete_prod(Referencia, Modelo, Marca, Tipo, Fecha_delete)
values( old.Referencia, old.Modelo, old.Marca, old.Tipo, Now());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `registro_clientes`
--

DROP TABLE IF EXISTS `registro_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_clientes` (
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Tipo` varchar(15) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Fecha_creacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_clientes`
--

LOCK TABLES `registro_clientes` WRITE;
/*!40000 ALTER TABLE `registro_clientes` DISABLE KEYS */;
INSERT INTO `registro_clientes` VALUES ('Juan','Lopez','06571095H','Cliente','juan','rcolomer3@gmail.com','2015-05-22 10:04:36'),('Lucia','Sanchez','52352718A','Cliente','UWQ51','rcolomer3@gmail.com','2015-05-22 10:06:45'),('Manolo','Sanz','25645074M','Cliente','5PLP0','rcolomer3@gmail.com','2015-05-28 08:34:30'),('Martha','Pla','00000001R','Cliente','KQV53','rcolomer3@gmail.com','2015-06-01 01:28:02');
/*!40000 ALTER TABLE `registro_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_prod`
--

DROP TABLE IF EXISTS `registro_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_prod` (
  `Referencia` varchar(500) DEFAULT NULL,
  `Modelo` varchar(45) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Precio` float NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Fecha_creacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_prod`
--

LOCK TABLES `registro_prod` WRITE;
/*!40000 ALTER TABLE `registro_prod` DISABLE KEYS */;
INSERT INTO `registro_prod` VALUES ('001','G2','LG',489,'Smartphone','2015-05-28 20:40:23'),('002','5','Nexus',0,'Smartphone','2015-05-28 20:47:48'),('003','Aquaris E5','BQ',600,'Accesorio','2015-05-29 20:35:21'),('004','Funda G3','LG',600,'Accesorio','2015-05-29 21:12:16'),('005','Cargador LG','LG',600,'Accesorio','2015-05-29 21:14:34'),('006','Player','Nexus',600,'Accesorio','2015-05-29 21:21:39'),('007','S6','Samsung',600,'Smartphone','2015-06-01 01:15:30');
/*!40000 ALTER TABLE `registro_prod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `update_clientes`
--

DROP TABLE IF EXISTS `update_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `update_clientes` (
  `NombreOld` varchar(50) NOT NULL,
  `NombreNew` varchar(45) DEFAULT NULL,
  `ApellidosOld` varchar(45) NOT NULL,
  `ApellidosNew` varchar(45) DEFAULT NULL,
  `DNI` varchar(9) NOT NULL,
  `UsuarioOld` varchar(45) NOT NULL,
  `UsuarioNew` varchar(45) DEFAULT NULL,
  `Fecha_modif` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `update_clientes`
--

LOCK TABLES `update_clientes` WRITE;
/*!40000 ALTER TABLE `update_clientes` DISABLE KEYS */;
INSERT INTO `update_clientes` VALUES ('Raul','Raul','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 08:24:03'),('Raul','Raul','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 08:47:44'),('Raul','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 08:48:13'),('Raulet','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 09:09:47'),('Raulet','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 09:37:40'),('Raulet','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 09:50:18'),('Raulet','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 09:53:30'),('Raulet','Raulet','Colomer','Colomeret','48607190W','MJ2UF','raul','2015-05-22 09:53:59'),('Juan','Juan','Lopez','Lopez','06571095H','juan','juan','2015-05-22 10:05:33'),('Lucia','Lucia','Sanchez','Sanchez','52352718A','UWQ51','UWQ51','2015-05-23 08:22:38'),('Juan','Juan','Lopez','Lopez','06571095H','juan','juan','2015-05-23 08:27:37'),('Raulet','Raulet','Colomeret','Colomeret','48607190W','raul','raul','2015-05-23 09:59:15'),('Raulet','Raulet','Colomeret','Colomeret','48607190W','raul','raul','2015-05-23 09:59:43'),('Raulet','Raulet','Colomeret','Colomeret','48607190W','raul','raul','2015-05-23 10:01:02'),('Raulet','Raulet','Colomeret','Colomeret','48607190W','raul','raul','2015-05-23 10:03:32'),('Juan','Juan','Lopez','Lopez','06571095H','juan','juan','2015-05-23 21:12:48'),('Raulet','Raul','Colomeret','Colomer','48607190W','raul','raul','2015-05-24 13:18:53'),('Manolo','Manolo','Sanz','Sanz','25645074M','5PLP0','5PLP0','2015-05-28 08:38:04'),('Juan','Juanjo','Lopez','Lopez','06571095H','juan','juan','2015-05-29 19:44:10'),('Raul','Raul','Colomer','Colomer','48607190W','raul','raul','2015-05-29 20:32:35'),('Manolo','Manoloo','Sanz','Sanz','25645074M','5PLP0','5PLP0','2015-05-30 08:42:46'),('Manoloo','Manolo','Sanz','Sanz','25645074M','5PLP0','manolo','2015-05-30 08:43:38'),('Lucia','Lucia','Sanchez','Sanchez','52352718A','UWQ51','lucia','2015-05-30 08:45:49'),('Manolo','Manolo','Sanz','Martinez','25645074M','manolo','manolo','2015-05-30 09:10:12'),('Manolo','Manoloo','Martinez','Martinez','25645074M','manolo','manolo','2015-05-30 10:02:12'),('Manoloo','Manolo','Martinez','Martinez','25645074M','manolo','manolo','2015-05-30 10:03:30'),('Manolo','Manolo','Martinez','Martinez','25645074M','manolo','manoloo','2015-05-30 10:05:24'),('Manolo','Manolo','Martinez','Martinez','25645074M','manoloo','manolo','2015-05-30 10:06:27');
/*!40000 ALTER TABLE `update_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `update_prod`
--

DROP TABLE IF EXISTS `update_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `update_prod` (
  `Referencia` varchar(45) NOT NULL,
  `ModeloOld` varchar(50) NOT NULL,
  `ModeloNew` varchar(50) DEFAULT NULL,
  `MarcaOld` varchar(50) NOT NULL,
  `MarcaNew` varchar(50) DEFAULT NULL,
  `TipoOld` varchar(45) NOT NULL,
  `TipoNew` varchar(45) DEFAULT NULL,
  `Fecha_modif` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `update_prod`
--

LOCK TABLES `update_prod` WRITE;
/*!40000 ALTER TABLE `update_prod` DISABLE KEYS */;
INSERT INTO `update_prod` VALUES ('002','5','5','Nexus','Nexus','Smartphone','Smartphone','2015-05-28 21:07:30'),('002','5','5','Nexus','Nexus','Smartphone','Smartphone','2015-05-29 08:51:46'),('001','G2','G2','LG','LG','Smartphone','Smartphone','2015-05-29 08:51:46'),('001','G2','G2','LG','LG','Smartphone','Smartphone','2015-05-29 08:52:24'),('002','5','5','Nexus','Nexus','Smartphone','Smartphone','2015-05-29 08:54:40'),('001','G2','G2','LG','LGs','Smartphone','Smartphone','2015-05-29 20:30:32'),('002','5','5','Nexus','Nexuss','Smartphone','Smartphone','2015-05-29 20:31:16'),('003','Aquaris E5','Aquaris E5','BQ','BQ','Accesorio','Smartphone','2015-05-29 20:38:45'),('001','G2','G2','LGs','LGs','Smartphone','Smartphone','2015-05-29 20:41:34'),('001','G2','G2','LGs','LGs','Smartphone','Smartphone','2015-05-29 20:41:50'),('001','G2','G2','LGs','LGs','Smartphone','Smartphone','2015-05-29 20:43:32'),('001','G2','G2','LGs','LGs','Smartphone','Smartphone','2015-05-29 20:49:00'),('002','5','5','Nexuss','Nexuss','Smartphone','Smartphone','2015-05-29 20:49:58'),('003','Aquaris E5','Aquaris E5 Funda','BQ','BQ','Smartphone','Accesorio','2015-05-29 20:50:34'),('003','Aquaris E5 Funda','Aquaris E5','BQ','BQ','Accesorio','Accesorio','2015-05-29 20:51:41'),('003','Aquaris E5','Aquaris E5','BQ','BQ','Accesorio','Accesorio','2015-05-29 20:52:59'),('003','Aquaris E5','Aquaris E5','BQ','BQ','Accesorio','Accesorio','2015-05-29 20:56:37'),('003','Aquaris E5','Aquaris E5','BQ','BQ','Accesorio','Accesorio','2015-05-29 21:05:24'),('003','Aquaris E5','Funda Ae5','BQ','BQ','Accesorio','Accesorio','2015-05-29 21:13:58'),('004','Funda G3','Funda G3','LG','LG','Accesorio','Accesorio','2015-05-29 21:14:56'),('005','Cargador LG','Cargador LG','LG','LG','Accesorio','Accesorio','2015-05-29 21:14:56'),('004','Funda G3','Funda G3','LG','LG','Accesorio','Accesorio','2015-05-29 21:17:18'),('005','Cargador LG','Cargador LG','LG','LG','Accesorio','Accesorio','2015-05-29 21:17:30'),('006','Player','Player','Nexus','Nexus','Accesorio','Accesorio','2015-05-29 21:26:02'),('006','Player','Player','Nexus','Nexus','Accesorio','Accesorio','2015-05-29 21:28:01'),('001','G2','G2','LGs','LG','Smartphone','Smartphone','2015-05-30 08:47:11'),('002','5','5','Nexuss','Nexus','Smartphone','Smartphone','2015-05-30 08:47:22'),('003','Funda Ae5','Funda Ae5','BQ','BQs','Accesorio','Smartphone','2015-06-01 01:04:34'),('002','5','5','Nexus','Nexuss','Smartphone','Smartphone','2015-06-01 01:05:34'),('003','Funda Ae5','Funda Ae5','BQs','BQ','Smartphone','Smartphone','2015-06-01 01:06:04'),('001','G2','G2','LG','LGs','Smartphone','Smartphone','2015-06-01 01:08:22'),('004','Funda G3','Funda G3','LG','LGs','Accesorio','Smartphone','2015-06-01 01:09:18'),('003','Funda Ae5','Funda Ae5','BQ','BQs','Smartphone','Smartphone','2015-06-01 01:11:50'),('007','S6','S6','Samsung','Samsung','Smartphone','Smartphone','2015-06-01 01:16:50'),('007','S6','S6','Samsung','Samsungs','Smartphone','Smartphone','2015-06-01 01:17:42'),('007','S6','S6','Samsungs','Samsung','Smartphone','Smartphone','2015-06-01 01:17:55'),('002','5','5','Nexuss','Nexus','Smartphone','Smartphone','2015-06-01 01:21:02'),('004','Funda G3','Funda G3','LGs','LG','Smartphone','Smartphone','2015-06-01 01:23:18'),('003','Funda Ae5','Funda Ae5','BQs','BQ','Smartphone','Smartphone','2015-06-01 01:23:28');
/*!40000 ALTER TABLE `update_prod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'movilesbbdd'
--
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
/*!50003 DROP PROCEDURE IF EXISTS `procedure_precio_medio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure_precio_medio`(OUT `Precio_medio` DOUBLE)
BEGIN
SELECT ROUND(AVG(Precio)) into Precio_medio FROM productos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proce_edad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proce_edad`(OUT `cliente_joven` INT, OUT `cliente_mayor` INT)
BEGIN
SELECT MIN(Edad),MAX(Edad) into cliente_joven, cliente_mayor FROM clientes ORDER BY Edad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proce_precio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proce_precio`(OUT `producto_barato` INT, OUT `producto_caro` INT)
BEGIN
SELECT MIN(Precio),MAX(Precio) into producto_barato, producto_caro FROM productos ORDER BY Precio;
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

-- Dump completed on 2015-06-01  1:29:52
