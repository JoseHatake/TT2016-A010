CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `capitulo`
--

DROP TABLE IF EXISTS `capitulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `capitulo` (
  `idCapitulo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Capitulo` varchar(45) NOT NULL,
  `Libro_idLibro` int(11) NOT NULL,
  `Hora_fecha` datetime NOT NULL,
  PRIMARY KEY (`idCapitulo`),
  KEY `fk_Capitulo_Libro1_idx` (`Libro_idLibro`),
  CONSTRAINT `fk_Capitulo_Libro1` FOREIGN KEY (`Libro_idLibro`) REFERENCES `libro` (`idLibro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capitulo`
--

LOCK TABLES `capitulo` WRITE;
/*!40000 ALTER TABLE `capitulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `capitulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `idComentario` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` datetime NOT NULL,
  `Comentario` varchar(500) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Libro_idLibro` int(11) NOT NULL,
  PRIMARY KEY (`idComentario`),
  KEY `fk_Comentario_Usuario1_idx` (`Usuario_idUsuario`),
  KEY `fk_Comentario_Libro1_idx` (`Libro_idLibro`),
  CONSTRAINT `fk_Comentario_Libro1` FOREIGN KEY (`Libro_idLibro`) REFERENCES `libro` (`idLibro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuenta` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Password` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `foto` varchar(45) NOT NULL,
  `mensaje` varchar(45) DEFAULT NULL,
  `DescripcionP` varchar(100) DEFAULT NULL,
  `NumSeguidores` int(11) NOT NULL,
  `Activada` tinyint(1) NOT NULL,
  `Pseudonimo` varchar(20) NOT NULL,
  `IsAdmin` tinyint(4) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  CONSTRAINT `idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `denuncia`
--

DROP TABLE IF EXISTS `denuncia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `denuncia` (
  `idDenuncia` int(11) NOT NULL AUTO_INCREMENT,
  `Denuncia` varchar(200) NOT NULL,
  `Tipo_Denuncia` varchar(45) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Libro_idLibro` int(11) NOT NULL,
  PRIMARY KEY (`idDenuncia`),
  KEY `fk_Denuncia_Usuario1_idx` (`Usuario_idUsuario`),
  KEY `fk_Denuncia_Libro1_idx` (`Libro_idLibro`),
  CONSTRAINT `fk_Denuncia_Libro1` FOREIGN KEY (`Libro_idLibro`) REFERENCES `libro` (`idLibro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Denuncia_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `denuncia`
--

LOCK TABLES `denuncia` WRITE;
/*!40000 ALTER TABLE `denuncia` DISABLE KEYS */;
/*!40000 ALTER TABLE `denuncia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Clasificacion` varchar(50) NOT NULL,
  `Descripcion` varchar(2000) DEFAULT NULL,
  `idioma` varchar(15) NOT NULL,
  `Portada` varchar(45) NOT NULL,
  `Likes` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Hora_fecha` datetime NOT NULL,
  PRIMARY KEY (`idLibro`),
  KEY `fk_Libro_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Libro_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguir`
--

DROP TABLE IF EXISTS `seguir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seguir` (
  `idSeguir` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario_idUsuario` int(11) NOT NULL,
  `IDSeguido` int(11) NOT NULL,
  `EsAutor` tinyint(4) NOT NULL,
  PRIMARY KEY (`idSeguir`),
  KEY `fk_Seguir_Usuario1` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Seguir_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguir`
--

LOCK TABLES `seguir` WRITE;
/*!40000 ALTER TABLE `seguir` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(15) NOT NULL,
  `aPaterno` varchar(15) NOT NULL,
  `aMaterno` varchar(15) DEFAULT NULL,
  `Pais` varchar(18) NOT NULL,
  `Fecha_Nacimiento` varchar(10) NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-24 18:28:19
