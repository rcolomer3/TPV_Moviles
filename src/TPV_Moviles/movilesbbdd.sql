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
INSERT INTO `clientes` VALUES ('Juan','Lopez','06571095H',22,'685693365','20-5-1993','8-5-2011','juan','4dd5dbcf08fcce332740989256e8fd53','rcolomer3@gmail.com',0,'Cliente','src/TPV_Moviles/Img/empleado.png',4,500),('Raul','Colomer','48607190W',22,'665538067','14-3-1993','8-5-2010','raul','827ccb0eea8a706c4c34a16891f84e7b','rcolomer3@gmail.com',0,'Administrador','src/TPV_Moviles/Img/empleado.png',5,501),('Lucia','Sanchez','52352718A',32,'658963658','7-5-1983','11-5-2008','UWQ51','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com',0,'Cliente','src/TPV_Moviles/Img/empleado.png',7,500);
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
values( new.Referencia, new.Modelo, newm.Marca, new.Precio, new.Tipo, Now());
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
INSERT INTO `registro_clientes` VALUES ('Juan','Lopez','06571095H','Cliente','juan','rcolomer3@gmail.com','2015-05-22 10:04:36'),('Lucia','Sanchez','52352718A','Cliente','UWQ51','rcolomer3@gmail.com','2015-05-22 10:06:45');
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
INSERT INTO `update_clientes` VALUES ('Raul','Raul','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 08:24:03'),('Raul','Raul','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 08:47:44'),('Raul','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 08:48:13'),('Raulet','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 09:09:47'),('Raulet','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 09:37:40'),('Raulet','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 09:50:18'),('Raulet','Raulet','Colomer','Colomer','48607190W','MJ2UF','MJ2UF','2015-05-22 09:53:30'),('Raulet','Raulet','Colomer','Colomeret','48607190W','MJ2UF','raul','2015-05-22 09:53:59'),('Juan','Juan','Lopez','Lopez','06571095H','juan','juan','2015-05-22 10:05:33'),('Lucia','Lucia','Sanchez','Sanchez','52352718A','UWQ51','UWQ51','2015-05-23 08:22:38'),('Juan','Juan','Lopez','Lopez','06571095H','juan','juan','2015-05-23 08:27:37'),('Raulet','Raulet','Colomeret','Colomeret','48607190W','raul','raul','2015-05-23 09:59:15'),('Raulet','Raulet','Colomeret','Colomeret','48607190W','raul','raul','2015-05-23 09:59:43'),('Raulet','Raulet','Colomeret','Colomeret','48607190W','raul','raul','2015-05-23 10:01:02'),('Raulet','Raulet','Colomeret','Colomeret','48607190W','raul','raul','2015-05-23 10:03:32'),('Juan','Juan','Lopez','Lopez','06571095H','juan','juan','2015-05-23 21:12:48'),('Raulet','Raul','Colomeret','Colomer','48607190W','raul','raul','2015-05-24 13:18:53');
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-26  9:06:52
