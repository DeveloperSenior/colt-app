-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 22-05-2019 a las 23:05:54
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coltbd`
--
CREATE DATABASE IF NOT EXISTS `coltbd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `coltbd`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alertas`
--

DROP TABLE IF EXISTS `alertas`;
CREATE TABLE IF NOT EXISTS `alertas` (
  `idAlerta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idTipo` int(11) NOT NULL,
  `estado` varchar(25) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idAlerta`),
  KEY `idTipo` (`idTipo`),
  KEY `idUsuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
CREATE TABLE IF NOT EXISTS `ciudades` (
  `idCiudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `departamento` varchar(25) NOT NULL,
  `pais` varchar(25) NOT NULL,
  `fechaCreacion` date NOT NULL,
  PRIMARY KEY (`idCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menus`
--

DROP TABLE IF EXISTS `menus`;
CREATE TABLE IF NOT EXISTS `menus` (
  `idMenu` int(11) NOT NULL AUTO_INCREMENT,
  `idPapa` int(11) DEFAULT NULL,
  `descripcion` varchar(100) NOT NULL,
  `idRecurso` int(11) NOT NULL,
  `activo` char(1) NOT NULL,
  `fechaCreacion` date DEFAULT NULL,
  PRIMARY KEY (`idMenu`),
  KEY `idRecurso` (`idRecurso`),
  KEY `idPapa` (`idPapa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `idPedidos` int(11) NOT NULL AUTO_INCREMENT,
  `idRuta` int(11) NOT NULL,
  `idVehiculo` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `valorFlete` double NOT NULL,
  `valorTotal` double NOT NULL,
  `fechaCreacion` date NOT NULL,
  PRIMARY KEY (`idPedidos`),
  KEY `idVehiculo` (`idVehiculo`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idRuta` (`idRuta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
CREATE TABLE IF NOT EXISTS `perfiles` (
  `idPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePerfil` varchar(100) NOT NULL,
  `activo` char(1) NOT NULL,
  `fechaCreacion` date NOT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfilesxusuarios`
--

DROP TABLE IF EXISTS `perfilesxusuarios`;
CREATE TABLE IF NOT EXISTS `perfilesxusuarios` (
  `idUsuario` int(11) DEFAULT NULL,
  `idPerfil` int(11) DEFAULT NULL,
  KEY `idUsuario` (`idUsuario`),
  KEY `idPerfil` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recursos`
--

DROP TABLE IF EXISTS `recursos`;
CREATE TABLE IF NOT EXISTS `recursos` (
  `idRecurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombreRecurso` varchar(100) NOT NULL,
  `uri` varchar(100) NOT NULL,
  `activo` char(1) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idRecurso`),
  KEY `idPerfil` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

DROP TABLE IF EXISTS `rutas`;
CREATE TABLE IF NOT EXISTS `rutas` (
  `idRuta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `idCiudadOrigen` int(11) NOT NULL,
  `idCiudadDestino` int(11) NOT NULL,
  `fechaCreacion` date NOT NULL,
  PRIMARY KEY (`idRuta`),
  KEY `idCiudadOrigen` (`idCiudadOrigen`),
  KEY `idCiudadDestino` (`idCiudadDestino`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoalertas`
--

DROP TABLE IF EXISTS `tipoalertas`;
CREATE TABLE IF NOT EXISTS `tipoalertas` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `fechaCreacion` date NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `clave` varchar(25) NOT NULL,
  `activo` char(1) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `cedula` varchar(25) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `sexo` char(1) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
CREATE TABLE IF NOT EXISTS `vehiculos` (
  `idVehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(25) NOT NULL,
  `modelo` varchar(25) NOT NULL,
  `capacidad` float NOT NULL,
  `seguro` char(1) NOT NULL,
  `activo` char(1) NOT NULL,
  `fechaCreacion` date NOT NULL,
  PRIMARY KEY (`idVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
