-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.41


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bdmunipo
--

CREATE DATABASE IF NOT EXISTS bdmunipo;
USE bdmunipo;

--
-- Definition of table `dentrada_materialpro`
--

DROP TABLE IF EXISTS `dentrada_materialpro`;
CREATE TABLE `dentrada_materialpro` (
  `id_dentrada_materpo` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_material` int(11) NOT NULL,
  `id_detalle_proveedor` char(8) NOT NULL,
  `cod_articulo` char(8) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `precio_articulo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_dentrada_materpo`),
  KEY `Reftbl_articulo` (`cod_articulo`),
  KEY `Refdetalle_solicitud_proveedor` (`id_detalle_proveedor`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `dentrada_materialpro`
--

/*!40000 ALTER TABLE `dentrada_materialpro` DISABLE KEYS */;
INSERT INTO `dentrada_materialpro` (`id_dentrada_materpo`,`cantidad_material`,`id_detalle_proveedor`,`cod_articulo`,`fecha_entrada`,`precio_articulo`) VALUES 
 (2,4,'SO000001','AR000007','2012-11-21','16.65'),
 (3,92,'SO000002','AR000001','2012-12-11','408.00'),
 (4,2,'SO000001','AR000005','2012-12-13','1.20'),
 (5,1,'SO000006','AR000002','2012-12-14','12.20');
/*!40000 ALTER TABLE `dentrada_materialpro` ENABLE KEYS */;


--
-- Definition of table `detalle_almacen`
--

DROP TABLE IF EXISTS `detalle_almacen`;
CREATE TABLE `detalle_almacen` (
  `id_detalle_almacen` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_responsable` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_almacen` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_articulo` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `id_proyecto` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `id_proveedor` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `id_inventario` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  PRIMARY KEY (`id_detalle_almacen`),
  KEY `Reftbl_responsable24` (`cod_responsable`),
  KEY `Reftbl_almacen25` (`cod_almacen`),
  KEY `Reftbl_articulo26` (`cod_articulo`),
  KEY `Reftbl_proyecto27` (`id_proyecto`),
  KEY `Reftbl_proveedor28` (`id_proveedor`),
  KEY `Reftbl_inventario29` (`id_inventario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `detalle_almacen`
--

/*!40000 ALTER TABLE `detalle_almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_almacen` ENABLE KEYS */;


--
-- Definition of table `detalle_solicitud_empresa`
--

DROP TABLE IF EXISTS `detalle_solicitud_empresa`;
CREATE TABLE `detalle_solicitud_empresa` (
  `id_detalle_solicitud_empresa` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_empresa` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_solicitud` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `cod_responsable` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `id_proyecto` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_articulo` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_solicitud_empresa` date NOT NULL,
  `estado_solicitud_empresa` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_solicitud_empresa`),
  KEY `Reftbl_empresa31` (`cod_empresa`),
  KEY `Reftbl_responsable33` (`cod_responsable`),
  KEY `Reftbl_proyecto34` (`id_proyecto`),
  KEY `Reftbl_articulo35` (`cod_articulo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `detalle_solicitud_empresa`
--

/*!40000 ALTER TABLE `detalle_solicitud_empresa` DISABLE KEYS */;
INSERT INTO `detalle_solicitud_empresa` (`id_detalle_solicitud_empresa`,`cod_empresa`,`nombre_solicitud`,`cod_responsable`,`id_proyecto`,`cod_articulo`,`fecha_solicitud_empresa`,`estado_solicitud_empresa`) VALUES 
 ('SE000004','EM000008','Solicitud De Carreteras De Paita','RE000005','PR000001','AR000005','2012-11-23',0),
 ('SE000003','EM000002','Solicitud De Mantenimeinto De Veredas En La Calle Grau','RE000004','PR000004','AR000006','2012-11-25',1),
 ('SE000002','EM000007','Solicitud Reaparacion De Veredas','RE000001','PR000003','AR000002','2012-11-25',1),
 ('SE000001','EM000002','Amenidades','RE000001','PR000004','AR000004','2012-12-13',0),
 ('SE000005','EM000002','Solcitud De Carreteras','RE000001','PR000005','AR000004','2012-11-21',0),
 ('SE000006','EM000008','Mantenimiento De Pisos','RE000001','PR000005','AR000004','2012-11-21',0),
 ('SE000007','EM000009','Parque Zonal','RE000005','PR000001','AR000004','2012-11-11',1),
 ('SE000008','EM000013','Reserva Nacional','RE000001','PR000001','AR000004','2012-12-11',0),
 ('SE000009','EM000002','Mantenimiento De Veredas','RE000002','PR000007','AR000001','2012-12-13',1);
/*!40000 ALTER TABLE `detalle_solicitud_empresa` ENABLE KEYS */;


--
-- Definition of table `detalle_solicitud_persona_juridica`
--

DROP TABLE IF EXISTS `detalle_solicitud_persona_juridica`;
CREATE TABLE `detalle_solicitud_persona_juridica` (
  `id_detalle_solicitud_persona_juridica` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_persona` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_solicitud` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `id_proyecto` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_articulo` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_responsable` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_solicitud_persona` date NOT NULL,
  `estado_solicitud_persona` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_solicitud_persona_juridica`),
  KEY `Reftbl_persona_juridica36` (`cod_persona`),
  KEY `Reftbl_proyecto38` (`id_proyecto`),
  KEY `Reftbl_articulo39` (`cod_articulo`),
  KEY `Reftbl_responsable40` (`cod_responsable`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `detalle_solicitud_persona_juridica`
--

/*!40000 ALTER TABLE `detalle_solicitud_persona_juridica` DISABLE KEYS */;
INSERT INTO `detalle_solicitud_persona_juridica` (`id_detalle_solicitud_persona_juridica`,`cod_persona`,`nombre_solicitud`,`id_proyecto`,`cod_articulo`,`cod_responsable`,`fecha_solicitud_persona`,`estado_solicitud_persona`) VALUES 
 ('SP000001','PJ000002','Reparacion De Colegio','PR000001','AR000004','RE000002','2012-12-13',1),
 ('SP000002','PJ000006','Reparacion De Plazas','PR000006','AR000007','RE000005','2012-11-22',1),
 ('SP000003','PJ000005','Construccion de Vias','PR000003','AR000005','RE000004','2012-11-24',1),
 ('SP000004','PJ000002','Construccion de Lomas','PR000001','AR000003','RE000005','2012-11-16',0),
 ('SP000005','PJ000005','Probando','PR000003','AR000005','RE000001','2012-11-14',0),
 ('SP000006','PJ000001','Reserva Internacional','PR000004','AR000003','RE000004','2012-12-11',1),
 ('SP000007','PJ000002','Reparacion De Vias','PR000007','AR000001','RE000001','2012-12-13',0);
/*!40000 ALTER TABLE `detalle_solicitud_persona_juridica` ENABLE KEYS */;


--
-- Definition of table `detalle_solicitud_proveedor`
--

DROP TABLE IF EXISTS `detalle_solicitud_proveedor`;
CREATE TABLE `detalle_solicitud_proveedor` (
  `id_detalle_proveedor` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `id_proveedor` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_articulo` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_solicitud` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_solicitud_proveedor` date NOT NULL,
  `estado_solicitud_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_proveedor`),
  KEY `Reftbl_proveedor41` (`id_proveedor`),
  KEY `Reftbl_articulo43` (`cod_articulo`),
  KEY `Rftbl_solicitud79` (`cod_solicitud`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `detalle_solicitud_proveedor`
--

/*!40000 ALTER TABLE `detalle_solicitud_proveedor` DISABLE KEYS */;
INSERT INTO `detalle_solicitud_proveedor` (`id_detalle_proveedor`,`id_proveedor`,`cod_articulo`,`cod_solicitud`,`fecha_solicitud_proveedor`,`estado_solicitud_proveedor`) VALUES 
 ('SO000001','PD000001','AR000002','ST000003','2012-12-13',1),
 ('SO000002','PD000002','AR000001','ST000001','2012-11-16',1),
 ('SO000003','PD000003','AR000004','ST000004','2012-12-21',0),
 ('SO000004','PD000001','AR000003','ST000003','2012-12-21',0),
 ('SO000005','PD000001','AR000002','ST000003','2012-12-18',1),
 ('SO000006','PD000002','AR000002','ST000003','2012-12-11',0),
 ('SO000007','PD000001','AR000003','ST000005','2012-12-14',0);
/*!40000 ALTER TABLE `detalle_solicitud_proveedor` ENABLE KEYS */;


--
-- Definition of table `dsalida_materialemp`
--

DROP TABLE IF EXISTS `dsalida_materialemp`;
CREATE TABLE `dsalida_materialemp` (
  `id_salida_mateemp` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_material` int(11) NOT NULL,
  `id_detalle_solicitud_empresa` char(8) NOT NULL,
  `cod_articulo` char(8) NOT NULL,
  `fecha_salida` date NOT NULL,
  PRIMARY KEY (`id_salida_mateemp`),
  KEY `Refdetalle_solicitud_empresa` (`id_detalle_solicitud_empresa`),
  KEY `Refdetalle_articulo` (`cod_articulo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dsalida_materialemp`
--

/*!40000 ALTER TABLE `dsalida_materialemp` DISABLE KEYS */;
INSERT INTO `dsalida_materialemp` (`id_salida_mateemp`,`cantidad_material`,`id_detalle_solicitud_empresa`,`cod_articulo`,`fecha_salida`) VALUES 
 (1,40,'SE000002','AR000002','2012-05-01'),
 (2,20,'SE000002','AR000006','2012-05-01'),
 (3,13,'SE000003','AR000002','2012-05-05'),
 (4,4,'SE000001','AR000001','2012-12-19'),
 (5,1,'SE000003','AR000006','2012-12-05'),
 (6,10,'SE000007','AR000004','2012-12-10'),
 (7,10,'SE000009','AR000001','2012-12-12');
/*!40000 ALTER TABLE `dsalida_materialemp` ENABLE KEYS */;


--
-- Definition of table `dsalida_materialpj`
--

DROP TABLE IF EXISTS `dsalida_materialpj`;
CREATE TABLE `dsalida_materialpj` (
  `id_salida_matepj` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_material` int(11) NOT NULL,
  `id_detalle_solicitud_persona_juridica` char(8) CHARACTER SET latin1 NOT NULL,
  `cod_articulo` char(8) CHARACTER SET latin1 NOT NULL,
  `fecha_salida` date NOT NULL,
  PRIMARY KEY (`id_salida_matepj`),
  KEY `Refdetalle_solicitud_persona_juridica48` (`id_detalle_solicitud_persona_juridica`),
  KEY `Refdetalle_articulo` (`cod_articulo`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `dsalida_materialpj`
--

/*!40000 ALTER TABLE `dsalida_materialpj` DISABLE KEYS */;
INSERT INTO `dsalida_materialpj` (`id_salida_matepj`,`cantidad_material`,`id_detalle_solicitud_persona_juridica`,`cod_articulo`,`fecha_salida`) VALUES 
 (1,2,'SP000004','AR000003','2012-11-23'),
 (2,2,'SP000002','AR000007','2012-12-13'),
 (3,1,'SP000001','AR000004','2012-12-05'),
 (4,20,'SP000006','AR000003','2012-12-10');
/*!40000 ALTER TABLE `dsalida_materialpj` ENABLE KEYS */;


--
-- Definition of table `tbl_almacen`
--

DROP TABLE IF EXISTS `tbl_almacen`;
CREATE TABLE `tbl_almacen` (
  `cod_almacen` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `telefono_almacen` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `direccion_almacen` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `fax_almacen` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `estado_almacen` int(11) NOT NULL,
  PRIMARY KEY (`cod_almacen`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_almacen`
--

/*!40000 ALTER TABLE `tbl_almacen` DISABLE KEYS */;
INSERT INTO `tbl_almacen` (`cod_almacen`,`nombre`,`telefono_almacen`,`direccion_almacen`,`fax_almacen`,`estado_almacen`) VALUES 
 ('AL000001','Almacen Uno','35-21-41','Jr. Lambor 24 Mz-F Lt-10','234-5645',1),
 ('AL000002','Almacen Dos','12-45-78','Calle Norte S/N Mz-F Lt-10','634-5647',1),
 ('AL000003','Amacen Tres','58-79-88','Panamericana S/N Mz-F Lt-10','666-6644',0),
 ('AL000004','Almacen Cuatro','32-25-24','Jr. Villar 1007','254-5587',1),
 ('AL000005','Almacen Cinco','65-22-22','Av. Brazil 210','654-2221',0);
/*!40000 ALTER TABLE `tbl_almacen` ENABLE KEYS */;


--
-- Definition of table `tbl_articulo`
--

DROP TABLE IF EXISTS `tbl_articulo`;
CREATE TABLE `tbl_articulo` (
  `cod_articulo` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_articulo` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `marca_articulo` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion_articulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `cantidad_articulo` int(11) NOT NULL,
  `tipo_material` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `precio_articulo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`cod_articulo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_articulo`
--

/*!40000 ALTER TABLE `tbl_articulo` DISABLE KEYS */;
INSERT INTO `tbl_articulo` (`cod_articulo`,`nombre_articulo`,`marca_articulo`,`descripcion_articulo`,`cantidad_articulo`,`tipo_material`,`precio_articulo`) VALUES 
 ('AR000007','Tijerales','Forte','Tijetra De Triple Varilla',38,'Acero','2500.41'),
 ('AR000006','Palanas','Azteca','Acero',44,'Acero','957.54'),
 ('AR000001','Cementa','Forta','Antisalitra',21,'Construccios','444.70'),
 ('AR000005','Varillas','Tortuga','Acero',42,'Acero','453.29'),
 ('AR000004','Ceramica','Celima','Corrugado',25,'Arcillosa','500.15'),
 ('AR000003','Fragua','Celima','Pegamento para lozetas',20,'Pegamento','10.20'),
 ('AR000002','Vidrio','Umbro','Laminado',31,'Plastificado','1262.70'),
 ('AR000008','Estaño','Cautin','Soldadura',11,'Soldar','12.20');
/*!40000 ALTER TABLE `tbl_articulo` ENABLE KEYS */;


--
-- Definition of table `tbl_cargo`
--

DROP TABLE IF EXISTS `tbl_cargo`;
CREATE TABLE `tbl_cargo` (
  `id_cargo` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion_cargo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_cargo`
--

/*!40000 ALTER TABLE `tbl_cargo` DISABLE KEYS */;
INSERT INTO `tbl_cargo` (`id_cargo`,`descripcion_cargo`) VALUES 
 ('CA000001','Jefe Area'),
 ('CA000002','Jefe De Almacen'),
 ('CA000003','Jefe Defensa Civil'),
 ('CA000004','Jefe De Almacen'),
 ('CA000005','Secretaria'),
 ('CA000006','Jefe Transportes');
/*!40000 ALTER TABLE `tbl_cargo` ENABLE KEYS */;


--
-- Definition of table `tbl_empresa`
--

DROP TABLE IF EXISTS `tbl_empresa`;
CREATE TABLE `tbl_empresa` (
  `cod_empresa` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ruc_empresa` char(11) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_empresa` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono_empresa` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `direccion_empresa` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `estado_empresa` int(11) NOT NULL,
  PRIMARY KEY (`cod_empresa`),
  UNIQUE KEY `ruc_empresa` (`ruc_empresa`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_empresa`
--

/*!40000 ALTER TABLE `tbl_empresa` DISABLE KEYS */;
INSERT INTO `tbl_empresa` (`cod_empresa`,`ruc_empresa`,`nombre_empresa`,`telefono_empresa`,`direccion_empresa`,`estado_empresa`) VALUES 
 ('EM000001','25425545545','Toñito S.A','32-51-42','Jr. Villar 1007',1),
 ('EM000002','65412712722','Tuncho S.0','64-58-13','AHH. Humano Mz 4 Lt10',0),
 ('EM000003','74125896345','Cobresol S.A','03-58-16','Jr.Villar 1007 F-10',1),
 ('EM000004','32546982715','AlonMaterial S.A','30-25-14','Urb. Las Mercedes F-10 1007',1),
 ('EM000005','54895123457','Genius','20-14-06','Jr. Villar 1024',1),
 ('EM000006','32546332715','AlonFuker S.A','30-25-14','Urb. Las Mercedes F-10 1008',0),
 ('EM000007','65487512354','Cro E&M','25-14-48','Urb. Los Angeles 1007 F-10',0),
 ('EM000008','23154875216','Constructora E&E','21-23-25','Urb. Montero 890 Mz10 Lt10',0),
 ('EM000009','36521446584','Creampie','23-54-56','Av. Las Torres 555',0),
 ('EM000010','25531165684','Doc Center','32-52-45','Av. Pallares S/N Lt-8',0),
 ('EM000011','45454645645','web Paint','45-67-89','Av. Morropon',1),
 ('EM000012','65767905734','Español','34-53-45','Av. Francia 321',0),
 ('EM000013','11111111111','Distrital S.A','44-44-44','Jr. Lopez Alrbujar S/N',0),
 ('EM000014','25799885226','Las dos torres','65-22-45','Jr. Los Andes 32',0);
/*!40000 ALTER TABLE `tbl_empresa` ENABLE KEYS */;


--
-- Definition of table `tbl_inventario`
--

DROP TABLE IF EXISTS `tbl_inventario`;
CREATE TABLE `tbl_inventario` (
  `id_inventario` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_inventario` date NOT NULL,
  PRIMARY KEY (`id_inventario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_inventario`
--

/*!40000 ALTER TABLE `tbl_inventario` DISABLE KEYS */;
INSERT INTO `tbl_inventario` (`id_inventario`,`fecha_inventario`) VALUES 
 ('IN000001','2012-05-12'),
 ('IN000002','2012-05-11'),
 ('IN000003','2004-12-11'),
 ('IN000004','2001-12-12'),
 ('IN000005','2020-12-11'),
 ('IN000006','2012-10-31'),
 ('IN000007','2012-10-22');
/*!40000 ALTER TABLE `tbl_inventario` ENABLE KEYS */;


--
-- Definition of table `tbl_persona_juridica`
--

DROP TABLE IF EXISTS `tbl_persona_juridica`;
CREATE TABLE `tbl_persona_juridica` (
  `cod_persona` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ruc_persona` char(11) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_persona` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_persona` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `direccion_persona` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `celular_persona` char(20) COLLATE utf8_spanish_ci NOT NULL,
  `sexo_persona` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `edad_persona` char(2) COLLATE utf8_spanish_ci NOT NULL,
  `estado_persona` int(11) NOT NULL,
  PRIMARY KEY (`cod_persona`),
  UNIQUE KEY `ruc_persona` (`ruc_persona`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_persona_juridica`
--

/*!40000 ALTER TABLE `tbl_persona_juridica` DISABLE KEYS */;
INSERT INTO `tbl_persona_juridica` (`cod_persona`,`ruc_persona`,`nombre_persona`,`apellido_persona`,`direccion_persona`,`celular_persona`,`sexo_persona`,`edad_persona`,`estado_persona`) VALUES 
 ('PJ000003','33251752421','Mirella','Mariño Lopez','Jr. Arena 204','(95) 353-5224','Femenino','28',0),
 ('PJ000002','28142999991','Maria Lopez','Torres Culkicondor','Calle Sen Jose 302 Mz-4','(96) 258-8491','Femenino','20',0),
 ('PJ000001','32423423523','Joel','Gonzales Perez','AV. La Primavera','(67) 867-8678','Masculino','21',0),
 ('PJ000004','24444444441','Joel','Agramonte Rey','Calle Piura 291','(96) 545-6784','Masculino','20',1),
 ('PJ000005','32515545452','Bulen','Rafael Gomez','Calle Piura 111','(96) 252-4123','Masculino','29',0),
 ('PJ000006','65489511224','Oscar','Lopez Areas','Jr. Villar 1007 F-10','(96) 258-4755','Masculino','24',0),
 ('PJ000007','88888888888','Junior','Carrasco Martin','Jr. La Torre 554','(96) 345-6787','Masculino','23',0),
 ('PJ000008','32152852425','Jeison','Cruz Yesan','Av. Los Ordenales 2125','(96) 585-4444','Masculino','21',0);
/*!40000 ALTER TABLE `tbl_persona_juridica` ENABLE KEYS */;


--
-- Definition of table `tbl_proveedor`
--

DROP TABLE IF EXISTS `tbl_proveedor`;
CREATE TABLE `tbl_proveedor` (
  `id_proveedor` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ruc_proveedor` char(11) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_proveedor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono_proveedor` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `direccion_proveedor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `ciudad_proveedor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `servicio_proveedor` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `fax_proveedor` char(10) COLLATE utf8_spanish_ci NOT NULL,
  `estado_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  UNIQUE KEY `ruc_proveedor` (`ruc_proveedor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_proveedor`
--

/*!40000 ALTER TABLE `tbl_proveedor` DISABLE KEYS */;
INSERT INTO `tbl_proveedor` (`id_proveedor`,`ruc_proveedor`,`nombre_proveedor`,`telefono_proveedor`,`direccion_proveedor`,`ciudad_proveedor`,`servicio_proveedor`,`fax_proveedor`,`estado_proveedor`) VALUES 
 ('PD000001','21454564564','Sodimac','34-56-75','Panamericana Sur Km 23','Piura','Tecnica','326-5908',0),
 ('PD000002','98765432354','Celima','45-64-58','Jr. Masav 1265','Piura','Reparacion','976-7564',0),
 ('PD000003','32521554574','Holiday N.A','35-28-52','Jr. Tacala 210 ','Piura','Tecnico','251-2454',0);
/*!40000 ALTER TABLE `tbl_proveedor` ENABLE KEYS */;


--
-- Definition of table `tbl_proyecto`
--

DROP TABLE IF EXISTS `tbl_proyecto`;
CREATE TABLE `tbl_proyecto` (
  `id_proyecto` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_proyecto` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_proyecto` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estado_proyecto` int(11) NOT NULL,
  PRIMARY KEY (`id_proyecto`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_proyecto`
--

/*!40000 ALTER TABLE `tbl_proyecto` DISABLE KEYS */;
INSERT INTO `tbl_proyecto` (`id_proyecto`,`nombre_proyecto`,`tipo_proyecto`,`estado_proyecto`) VALUES 
 ('PR000001','Construccion De Carreteras','Mantenimiento',0),
 ('PR000002','Reparacion De Via','Reparacion',1),
 ('PR000003','Construccion Colegio Miguel Cortes','Construcciones',0),
 ('PR000004','Mantenimiento De Veredas','Reparacion',0),
 ('PR000005','Proyeto De Alcantarillado','Reparacion',1),
 ('PR000006','Remodelamiento La Plaza De Armas','Obras publicas',0),
 ('PR000007','Chira Piura','Calle Comercio',0);
/*!40000 ALTER TABLE `tbl_proyecto` ENABLE KEYS */;


--
-- Definition of table `tbl_responsable`
--

DROP TABLE IF EXISTS `tbl_responsable`;
CREATE TABLE `tbl_responsable` (
  `cod_responsable` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_responsable` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_responsable` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `sexo_responsable` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `edad_responsable` char(2) COLLATE utf8_spanish_ci NOT NULL,
  `celular_responsable` char(20) COLLATE utf8_spanish_ci NOT NULL,
  `direccion_responsable` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `responsable_estado` int(11) NOT NULL,
  `id_cargo` char(8) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_responsable`),
  KEY `Reftbl_cargo` (`id_cargo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_responsable`
--

/*!40000 ALTER TABLE `tbl_responsable` DISABLE KEYS */;
INSERT INTO `tbl_responsable` (`cod_responsable`,`nombre_responsable`,`apellido_responsable`,`sexo_responsable`,`edad_responsable`,`celular_responsable`,`direccion_responsable`,`responsable_estado`,`id_cargo`) VALUES 
 ('RE000002','Brayano','Turkes Soze','Masculino','32','(99)556-4875','Av. Grau 5021',0,'CA000005'),
 ('RE000001','Joel','Agramonte Rey','Masculino','20','(32)423-4234','asdasd',0,'CA000001'),
 ('RE000003','Marjorie','Villavicencio Roque','Femenino','24','(95)478-8952','Panamericana Sur Km.20',1,'CA000003'),
 ('RE000004','Victor','Cahuani Yumanco','Masculino','27','(96)541-1322','Jr. Lopez Albujar Lt-10',0,'CA000001'),
 ('RE000005','Martina','Peres Alburqueque','Femenino','30','(95)143-2414','Panamericana Km.1000',0,'CA000005'),
 ('RE000006','dfdf','dfdfwer','Masculino','34','(46)476-5867','tyrtyewr5',0,'CA000005');
/*!40000 ALTER TABLE `tbl_responsable` ENABLE KEYS */;


--
-- Definition of table `tbl_solicitud`
--

DROP TABLE IF EXISTS `tbl_solicitud`;
CREATE TABLE `tbl_solicitud` (
  `cod_solicitud` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_solicitud` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_solicitud`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_solicitud`
--

/*!40000 ALTER TABLE `tbl_solicitud` DISABLE KEYS */;
INSERT INTO `tbl_solicitud` (`cod_solicitud`,`nombre_solicitud`) VALUES 
 ('ST000001','Solicitudes Para Obra De Alcantarillado'),
 ('ST000002','Solicitud Para Repacion De Carreteras'),
 ('ST000003','Agua Para Todos'),
 ('ST000004','Construyendo Parques De Recreacion'),
 ('ST000005','Implementacion De Cerco Perimetrico-Estadio'),
 ('ST000006','Remodelacion Del Teatro Municipal'),
 ('ST000007','Solictud Para El Mantenimiento De Parques');
/*!40000 ALTER TABLE `tbl_solicitud` ENABLE KEYS */;


--
-- Definition of table `tbl_usuarios`
--

DROP TABLE IF EXISTS `tbl_usuarios`;
CREATE TABLE `tbl_usuarios` (
  `id_login` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `clave` text COLLATE utf8_spanish_ci NOT NULL,
  `clave_vi` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `id_cargo` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion_cargo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `usuestado` int(11) NOT NULL,
  PRIMARY KEY (`id_login`),
  KEY `Reftbl_cargo` (`id_cargo`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_usuarios`
--

/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
INSERT INTO `tbl_usuarios` (`id_login`,`login`,`clave`,`clave_vi`,`id_cargo`,`descripcion_cargo`,`usuestado`) VALUES 
 (1,'ajoel','d8434f144ce269aa34f82822f1b6c614','ucv123','CA000002','Jefe De Almacen',0),
 (2,'brayanoT','10bd16fb18b21ccbd60bbe6727b8c115','hielo','CA000005','Secretario',0),
 (3,'victorC','b8b41c35259f3482a433eb5b5dcaafb0','web123','CA000001','Jefe De Defensa Civil',0);
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;


--
-- Definition of procedure `sp_activosxsolicitudxproveedor`
--

DROP PROCEDURE IF EXISTS `sp_activosxsolicitudxproveedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_activosxsolicitudxproveedor`(
in id_proveedor_e char(8))
BEGIN
select id_detalle_proveedor,
a.cod_articulo, a.nombre_articulo,ds.cod_solicitud, ds.nombre_solicitud, pro.id_proveedor, pro.nombre_proveedor,
fecha_solicitud_proveedor, estado_solicitud_proveedor from detalle_solicitud_proveedor dsp


inner join tbl_articulo a on (dsp.cod_articulo=a.cod_articulo)
inner join tbl_solicitud ds on (dsp.cod_solicitud=ds.cod_solicitud)
inner join tbl_proveedor pro on (dsp.id_proveedor=pro.id_proveedor)

where dsp.id_proveedor=id_proveedor_e and estado_solicitud_proveedor=0
order by id_detalle_proveedor asc;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarAlmacen`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarAlmacen`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarAlmacen`(in cod_almacen_e char(8), in nombre_e varchar(40), in telefono_e char(8),in direccion_e varchar(50),in fax_e char(8),in estado_almacen_e int)
BEGIN
UPDATE tbl_almacen set nombre=nombre_e, telefono_almacen=telefono_e,direccion_almacen=direccion_e,fax_almacen=fax_e,estado_almacen=estado_almacen_e where cod_almacen=cod_almacen_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarArticulo`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarArticulo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarArticulo`(in cod_articulo_e char(8), in nombre_articulo_e varchar(40), in marca_articulo_e  varchar(60), in descripcion_articulo_e varchar(50), in cantidad_articulo_e int, in tipo_material_e varchar(50), in precio_articulo_e decimal(10,2))
BEGIN
UPDATE tbl_articulo set nombre_articulo=nombre_articulo_e, marca_articulo=marca_articulo_e,descripcion_articulo=descripcion_articulo_e,cantidad_articulo=cantidad_articulo_e,tipo_material=tipo_material_e,precio_articulo=precio_articulo_e where cod_articulo=cod_articulo_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarCargo`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarCargo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarCargo`(in id_cargo_e char(8), in descripcion_cargo_e varchar(50))
BEGIN
UPDATE tbl_cargo set descripcion_cargo=descripcion_cargo_e where id_cargo=id_cargo_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_actualizardetallearticulo`
--

DROP PROCEDURE IF EXISTS `sp_actualizardetallearticulo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizardetallearticulo`(
in cod_articulo_e char(8),
in marca_articulo_e varchar(40),
in descripcion_articulo_e varchar(50),
in cantidad_articulo_e int,
in tipo_material_e varchar(50),
in precio_articulo_e decimal(10,2),
in id_articulo_e char(8))
BEGIN
update detalle_articulo set cod_articulo=cod_articulo_e,
marca_articulo=marca_articulo_e,
descripcion_articulo=descripcion_articulo_e,
cantidad_articulo=cantidad_articulo_e,
tipo_material=tipo_material_e,
precio_articulo=precio_articulo_e


where id_articulo=id_articulo_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_actualizardsalida_materialpj`
--

DROP PROCEDURE IF EXISTS `sp_actualizardsalida_materialpj`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizardsalida_materialpj`(
in cantidad_material_e int,
in fecha_salida_e date,
in cod_responsable_e char(8),
in id_detalle_solicitud_persona_e char(8),
in cod_articulo_e char(8),
in id_salida_matepj char(8))
BEGIN

update dsalida_materialpj set cantidad_material=cantidad_material_e,
fecha_salida=fecha_salida_e,
cod_responsable=cod_responsable_e,
id_detalle_solicitud_persona=id_detalle_solicitud_persona_e,
cod_articulo=cod_articulo_e

where id_salida_matepj=id_salida_matepj_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarEmpresa`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarEmpresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarEmpresa`(in ruc_e char(11), in nombre_e varchar(50), in telef_e char(8),in direccion_e varchar(60),in estado_e int,in cod_e char(8))
BEGIN
UPDATE tbl_empresa set ruc_empresa=ruc_e, nombre_empresa=nombre_e, telefono_empresa=telef_e, direccion_empresa=direccion_e,estado_empresa=estado_e
where cod_empresa=cod_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarInventario`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarInventario`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarInventario`(in id_inventario_e char(8), in fecha_e date)
BEGIN
UPDATE tbl_inventario set fecha_inventario=fecha_e where id_inventario=id_inventario_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarPersonaJuridica`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarPersonaJuridica`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarPersonaJuridica`(in cod_p char(8),in ruc_p char(11), in nombre_p varchar(30), in apellido_p varchar(50),in direccion_p varchar(50), in celular_p char(20),in sexo_p varchar(15),edad_p char(2),in estado_p int)
BEGIN
UPDATE tbl_persona_juridica set ruc_persona=ruc_p,nombre_persona=nombre_p,apellido_persona=apellido_p,direccion_persona=direccion_p,celular_persona=celular_p,sexo_persona=sexo_p,edad_persona=edad_p,estado_persona=estado_p where cod_persona=cod_p;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarProveedor`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarProveedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarProveedor`(in id_proveedor_e char(8),in ruc_proveedor_e char(11),in nombre_proveedor_e varchar(50),in telefono_proveedor_e char(8),in direccion_proveedor_e varchar(50),in ciudad_proveedor_e varchar(50), in servicio_proveedor_e varchar(60),in fax_proveedor_e char(10), in estado_proveedor_e int)
BEGIN
UPDATE tbl_proveedor set ruc_proveedor=ruc_proveedor_e, nombre_proveedor=nombre_proveedor_e,telefono_proveedor=telefono_proveedor_e,direccion_proveedor=direccion_proveedor_e,ciudad_proveedor=ciudad_proveedor_e,servicio_proveedor=servicio_proveedor_e,fax_proveedor=fax_proveedor_e, estado_proveedor=estado_proveedor_e where id_proveedor=id_proveedor_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarProyecto`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarProyecto`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarProyecto`(in id_proyecto_e char(8), in nombre_proyecto_e varchar(50),in tipo_proyecto_e varchar(50), in estado_pro int)
BEGIN
UPDATE tbl_proyecto set nombre_proyecto=nombre_proyecto_e, tipo_proyecto=tipo_proyecto_e, estado_proyecto=estado_pro where id_proyecto=id_proyecto_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarResponsable`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarResponsable`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarResponsable`(in cod_responsable_e char(8), in nombre_e varchar(30),in apellido_e varchar(40),in sexo_e varchar(10),in edad_e char(2),in celular_e char(20),in direccion_e varchar(50),in estado_e int,in id_cargo_e char(8))
BEGIN
UPDATE tbl_responsable set nombre_responsable=nombre_e,apellido_responsable=apellido_e,sexo_responsable=sexo_e,edad_responsable=edad_e,celular_responsable=celular_e,direccion_responsable=direccion_e,responsable_estado=estado_e,id_cargo=id_cargo_e where cod_responsable=cod_responsable_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarSolempresa`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarSolempresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarSolempresa`(in id_detalle_solicitud_empresa_e char(8),in cod_empresa_e char(8),in nombre_solicitud_e varchar(60), in cod_responsable_e char(8),in id_proyecto_e char(8),in cod_articulo_e char(8),in fecha_solicitud_empresa_e date,in estado_solicitud_empresa_e int)
BEGIN
update detalle_solicitud_empresa set cod_empresa=cod_empresa_e,nombre_solicitud=nombre_solicitud_e,cod_responsable=cod_responsable_e,id_proyecto=id_proyecto_e,cod_articulo=cod_articulo_e,fecha_solicitud_empresa=fecha_solicitud_empresa_e,estado_solicitud_empresa=estado_solicitud_empresa_e
where id_detalle_solicitud_empresa=id_detalle_solicitud_empresa_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarSolicitud`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarSolicitud`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarSolicitud`(in cod_solicitud_e char(8),in nombre_solicitud_e varchar(80))
BEGIN
UPDATE tbl_solicitud set nombre_solicitud=nombre_solicitud_e  where cod_solicitud=cod_solicitud_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarSolpj`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarSolpj`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarSolpj`(in id_detalle_solicitud_persona_juridica_e char(8),in cod_persona_e char(8),in nombre_solicitud_e varchar(60), in id_proyecto_e char(8),in cod_articulo_e char(8),in cod_responsable_e char(8),in fecha_solicitud_persona_e date,in estado_solicitud_persona_e int)
BEGIN
update detalle_solicitud_persona_juridica set cod_persona=cod_persona_e,nombre_solicitud=nombre_solicitud_e,id_proyecto=id_proyecto_e,cod_articulo=cod_articulo_e,cod_responsable=cod_responsable_e,fecha_solicitud_persona=fecha_solicitud_persona_e,estado_solicitud_persona=estado_solicitud_persona_e
where id_detalle_solicitud_persona_juridica=id_detalle_solicitud_persona_juridica_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ActualizarSolpro`
--

DROP PROCEDURE IF EXISTS `sp_ActualizarSolpro`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarSolpro`(in id_detalle_proveedor_e char(8),in id_proveedor_e char(8),in cod_articulo_e char(8),in cod_solicitud_e char(8), in fecha_solicitud_proveedor_e date,in estado_solicitud_proveedor_e int)
BEGIN
update detalle_solicitud_proveedor set id_proveedor=id_proveedor_e,cod_articulo=cod_articulo_e,cod_solicitud=cod_solicitud_e,fecha_solicitud_proveedor=fecha_solicitud_proveedor_e,estado_solicitud_proveedor=estado_solicitud_proveedor_e
where id_detalle_proveedor=id_detalle_proveedor_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_agregararticulo`
--

DROP PROCEDURE IF EXISTS `sp_agregararticulo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_agregararticulo`(
in cod_articulo_e char(8),
in cantidad_articulo_e int)
BEGIN


  update detalle_articulo

    set cantidad_articulo=cantidad_articulo + cantidad_articulo_e
    where cod_articulo =cod_articulo_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ArticulosxSoliEmpresaxMonto`
--

DROP PROCEDURE IF EXISTS `sp_ArticulosxSoliEmpresaxMonto`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ArticulosxSoliEmpresaxMonto`(in cod_empresa_e char(8), in monto Decimal(10,2))
BEGIN
select dse.id_detalle_solicitud_empresa as id_detalle_solicitud_empresa,dse.nombre_solicitud as nombre_solicitud,ar.cod_articulo as cod_articulo,ar.nombre_articulo as nombre_articulo,ar.cantidad_articulo as StockActual
from detalle_solicitud_empresa dse
inner join tbl_empresa emp on(emp.cod_empresa=dse.cod_empresa)
inner join tbl_articulo ar on(ar.cod_articulo=dse.cod_articulo)
where emp.cod_empresa=cod_empresa_e and ar.precio_articulo<monto;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscarArticulosxDsalidaemp`
--

DROP PROCEDURE IF EXISTS `sp_buscarArticulosxDsalidaemp`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarArticulosxDsalidaemp`(in fecha1 date,
in fecha2 date,
in cod_empresa_e char(8))
BEGIN
select dsme.id_salida_mateemp,dsme.cantidad_material,ar.cod_articulo,ar.nombre_articulo from dsalida_materialemp dsme
inner join detalle_solicitud_empresa dse on(dsme.id_detalle_solicitud_empresa=dse.id_detalle_solicitud_empresa)
inner join tbl_articulo ar on(dsme.cod_articulo=ar.cod_articulo)
where cod_empresa_e=cod_empresa and dsme.fecha_salida between fecha1 and fecha2;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscarArticuloxnombre`
--

DROP PROCEDURE IF EXISTS `sp_buscarArticuloxnombre`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarArticuloxnombre`(
in cod_articulo_e char(8),
out  nombrearticulo varchar(40),
out idarticulo char(8),
out marcaarticulo varchar(40),
out descripcionarticulo varchar(50),
out cantidadarticulo int,
out tipomaterial varchar(50),
out precioarticulo decimal(10,2))
BEGIN
declare nombre_articulo_e varchar(40);
declare id_articulo_e char(8);
declare marca_articulo_e varchar(40);
declare descripcion_articulo_e varchar(50);
declare cantidad_articulo_e int;
declare tipo_material_e varchar(50);
declare precio_articulo_e decimal(10,2);


select nombre_articulo,id_articulo,marca_articulo,descripcion_articulo,cantidad_articulo,tipo_material,precio_articulo
into nombre_articulo_e,id_articulo_e,marca_articulo_e,descripcion_articulo_e,cantidad_articulo_e,tipo_material_e,precio_articulo_e

from tbl_articulo as ar
inner join detalle_articulo as dar on(dar.cod_articulo=ar.cod_articulo)
where ar.cod_articulo=cod_articulo_e;


set nombrearticulo=nombre_articulo_e;
set idarticulo=id_articulo_e;
set marcaarticulo=marca_articulo_e;
set descripcionarticulo=descripcion_articulo_e;
set cantidadarticulo=cantidad_articulo_e;
set tipomaterial=tipo_material_e;
set precioarticulo= precio_articulo_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_BuscarCreditoxEmpresaFecha`
--

DROP PROCEDURE IF EXISTS `sp_BuscarCreditoxEmpresaFecha`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_BuscarCreditoxEmpresaFecha`(IN fecha1 date, IN fecha2 date,
in cod_empresa_e char(4) )
BEGIN

SELECT c.cod_credito, c.cod_docente,
dni,apellidos,nombres,
c.cod_empresa,nombre,ruc,
c.importe, c.fecha, c.referencia,c.estado as estado
FROM credito c
inner join docente d on (c.cod_docente=d.cod_docente)
inner join persona p on(d.cod_persona=p.cod_persona)
inner join empresa e on(c.cod_empresa=e.cod_empresa)
where cod_empresa_e=c.cod_empresa and
c.fecha between fecha1 and fecha2;



END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscarDetalleSolicitudxEmpresaFecha`
--

DROP PROCEDURE IF EXISTS `sp_buscarDetalleSolicitudxEmpresaFecha`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarDetalleSolicitudxEmpresaFecha`(
in fecha1 date,
in fecha2 date,
in cod_empresa_e char(8))
BEGIN

select d.id_detalle_solicitud_empresa, emp.cod_empresa,emp.nombre_empresa,nombre_solicitud,
r.cod_responsable,r.nombre_responsable, po.id_proyecto,po.nombre_proyecto,ar.cod_articulo,ar.nombre_articulo,d.fecha_solicitud_empresa,
d.estado_solicitud_empresa
from detalle_solicitud_empresa d
inner join tbl_empresa emp on (d.cod_empresa=emp.cod_empresa)
inner join tbl_responsable r on (d.cod_responsable=r.cod_responsable)
inner join tbl_proyecto po on (d.id_proyecto=po.id_proyecto)
inner join tbl_articulo ar on (d.cod_articulo=ar.cod_articulo)
where cod_empresa_e=d.cod_empresa and
d.fecha_solicitud_empresa between fecha1 and fecha2;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscarDetalleSolicitudxPersoJuridicaFecha`
--

DROP PROCEDURE IF EXISTS `sp_buscarDetalleSolicitudxPersoJuridicaFecha`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarDetalleSolicitudxPersoJuridicaFecha`(
in fecha1 date,
in fecha2 date,
in cod_persona_e char(8))
BEGIN

select d.id_detalle_solicitud_persona_juridica,d.cod_persona,pj.nombre_persona,d.nombre_solicitud, d.id_proyecto,po.nombre_proyecto,d.cod_articulo,ar.nombre_articulo,
d.cod_responsable,r.nombre_responsable,d.fecha_solicitud_persona,
d.estado_solicitud_persona
from detalle_solicitud_persona_juridica d
inner join tbl_persona_juridica pj on (d.cod_persona=pj.cod_persona)
inner join tbl_responsable r on (d.cod_responsable=r.cod_responsable)
inner join tbl_proyecto po on (d.id_proyecto=po.id_proyecto)
inner join tbl_articulo ar on (d.cod_articulo=ar.cod_articulo)
where cod_persona_e=d.cod_persona and
d.fecha_solicitud_persona between fecha1 and fecha2;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscarEmpresaxnombre`
--

DROP PROCEDURE IF EXISTS `sp_buscarEmpresaxnombre`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarEmpresaxnombre`(
in nombre_empresa_e varchar(50),
out cod_empresa_e char(8),
out ruc_empresa_e char(11),
out telefono_empresa_e char(6),
out direccion_empresa_e varchar(60))
BEGIN
declare cod_empresa_s char(8);
declare ruc_empresa_s char(11);
declare telefono_empresa_s char(6);
declare direccion_empresa_s varchar(60);
select cod_empresa,ruc_empresa,telefono_empresa,direccion_empresa
into cod_empresa_s,ruc_empresa_s,telefono_empresa_s,direccion_empresa_s
from tbl_empresa where nombre_empresa=nombre_empresa_e;

set cod_empresa_e=cod_empresa_s;
set ruc_empresa_e=ruc_empresa_s;
set telefono_empresa_e=telefono_empresa_s;
set direccion_empresa_e=direccion_empresa_s;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscarResponsablexcodigocargo`
--

DROP PROCEDURE IF EXISTS `sp_buscarResponsablexcodigocargo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarResponsablexcodigocargo`(
in id_cargo_e char(8),
out nombreresponsable varchar(30),
out apellidoresponsable varchar(40),
out sexo_s char(1),
out celular_s char(9),
out direccionresponsable varchar(50),
out responsableestado int,
out descripcioncargo varchar(50),
out codresponsable char(8))
BEGIN
declare nombre_responsable_e varchar(30);
declare apellido_responsable_e varchar(40);
declare sexo_e char(1);
declare celular_e char(9);
declare direccion_responsable_e varchar(50);
declare responsable_estado_e int;
declare descripcion_cargo_e varchar(50);
declare cod_responsable_e char(8);


select nombre_responsable,apellido_responsable,sexo,celular,direccion_responsable,responsable_estado,ca.descripcion_cargo,cod_responsable
into nombre_responsable_e,apellido_responsable_e,sexo_e,celular_e,direccion_responsable_e,responsable_estado_e,descripcion_cargo_e,cod_responsable_e

from tbl_responsable as re
inner join tbl_cargo as ca on(ca.id_cargo=re.id_cargo)
where re.id_cargo=id_cargo_e;

set nombreresponsable=nombre_responsable_e;
set apellidoresponsable=apellido_responsable_e;
set sexo_s=sexo_e;
set celular_s=celular_e;
set direccionresponsable=direccion_responsable_e;
set responsableestado=responsable_estado_e;
set descripcioncargo=descripcion_cargo_e;
set codresponsable=cod_responsable_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscar_persjuridicaxnombre`
--

DROP PROCEDURE IF EXISTS `sp_buscar_persjuridicaxnombre`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_persjuridicaxnombre`(
in nombre_persona_e varchar(30),
out cod_persona_e char(8),
out ruc_persona_e char(11),
out apellido_persona_e varchar(50),
out direccion_persona_e varchar(50))
BEGIN
declare cod_persona_s char(8);
declare ruc_persona_s char(11);
declare apellido_persona_s varchar(50);
declare direccion_persona_s varchar(50);
select cod_persona,ruc_persona,apellido_persona,direccion_persona into cod_persona_s,ruc_persona_s,apellido_persona_s,direccion_persona_s
from tbl_persona_juridica where nombre_persona=nombre_persona_e;

set cod_persona_e=cod_persona_s;
set ruc_persona_e=ruc_persona_s;
set apellido_persona_e=apellido_persona_s;
set direccion_persona_e=direccion_persona_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_cambiarEstadoPjuridica`
--

DROP PROCEDURE IF EXISTS `sp_cambiarEstadoPjuridica`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cambiarEstadoPjuridica`(in id_detalle_solicitud_persona_juridica_e char(8),
in estado_e int)
BEGIN

update detalle_solicitud_persona_juridica set estado_solicitud_persona=estado_e where id_detalle_solicitud_persona_juridica=id_detalle_solicitud_persona_juridica_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_cambiarEstadoSolicitudEmpresa`
--

DROP PROCEDURE IF EXISTS `sp_cambiarEstadoSolicitudEmpresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cambiarEstadoSolicitudEmpresa`(in id_detalle_solicitud_empresa_e char(8),
in estado_e int)
BEGIN

update detalle_solicitud_empresa set estado_solicitud_empresa=estado_e where id_detalle_solicitud_empresa=id_detalle_solicitud_empresa_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_cambiarEstadoSolicitudProveedor`
--

DROP PROCEDURE IF EXISTS `sp_cambiarEstadoSolicitudProveedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cambiarEstadoSolicitudProveedor`(in id_detalle_proveedor_e char(8),
in estado_e int)
BEGIN

update detalle_solicitud_proveedor set estado_solicitud_proveedor=estado_e where id_detalle_proveedor=id_detalle_proveedor_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_eliminarEmpresa`
--

DROP PROCEDURE IF EXISTS `sp_eliminarEmpresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminarEmpresa`(in cod_e char(8))
BEGIN
delete from tbl_empresa where cod_empresa=cod_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_eliminarPersonaJuridica`
--

DROP PROCEDURE IF EXISTS `sp_eliminarPersonaJuridica`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminarPersonaJuridica`(cod_p char(8))
BEGIN
delete from tbl_persona_juridica where cod_persona=cod_p;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_FiltrarAlmacen`
--

DROP PROCEDURE IF EXISTS `sp_FiltrarAlmacen`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_FiltrarAlmacen`(in filtro varchar(100))
BEGIN

select * from tbl_almacen where upper (CONCAT(nombre,telefono_almacen,direccion_almacen,fax_almacen,estado_almacen))
like upper(CONCAT('%',filtro,'%'));
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_FiltrarArticulos`
--

DROP PROCEDURE IF EXISTS `sp_FiltrarArticulos`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_FiltrarArticulos`(IN filtro varchar(100))
BEGIN
select * from tbl_articulo
where upper(concat (nombre_articulo,marca_articulo,descripcion_articulo,cantidad_articulo,tipo_material,precio_articulo))
like upper(concat('%',filtro,'%'));


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_filtrararticuloxsolicitud`
--

DROP PROCEDURE IF EXISTS `sp_filtrararticuloxsolicitud`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_filtrararticuloxsolicitud`(in id_detalle_solicitud_persona_juridica_e char(8))
BEGIN

select distinct a.cod_articulo,nombre_articulo
from detalle_solicitud_persona_juridica spj
inner join tbl_articulo a on (a.cod_articulo=spj.cod_articulo)
where spj.id_detalle_solicitud_persona_juridica=id_detalle_solicitud_persona_juridica_e;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_filtrararticuloxsolicitud2`
--

DROP PROCEDURE IF EXISTS `sp_filtrararticuloxsolicitud2`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_filtrararticuloxsolicitud2`(in id_detalle_solicitud_empresa_e char(8))
BEGIN

select distinct a.cod_articulo,nombre_articulo
from detalle_solicitud_empresa emp
inner join tbl_articulo a on (a.cod_articulo=emp.cod_articulo)
where emp.id_detalle_solicitud_empresa=id_detalle_solicitud_empresa_e;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_FiltrarEmpresas`
--

DROP PROCEDURE IF EXISTS `sp_FiltrarEmpresas`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_FiltrarEmpresas`(IN filtro varchar(240))
BEGIN
SELECT * FROM  tbl_empresa where upper(CONCAT(nombre_empresa,ruc_empresa,telefono_empresa,direccion_empresa,estado_empresa))
like upper(CONCAT('%',filtro,'%'));


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_FiltrarEmpresaxDocente`
--

DROP PROCEDURE IF EXISTS `sp_FiltrarEmpresaxDocente`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_FiltrarEmpresaxDocente`(IN cod_empresa_e char(4))
BEGIN

SELECT distinct d.cod_docente,dni,apellidos,nombres
FROM credito c
inner join docente d on (c.cod_docente=d.cod_docente)
inner join persona p on(d.cod_persona=p.cod_persona)
inner join empresa e on(c.cod_empresa=e.cod_empresa)
where e.cod_empresa=cod_empresa_e;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_FiltrarPersonaJuridica`
--

DROP PROCEDURE IF EXISTS `sp_FiltrarPersonaJuridica`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_FiltrarPersonaJuridica`(IN filtro varchar(240))
BEGIN
SELECT * FROM  tbl_persona_juridica where upper(CONCAT(nombre_persona,ruc_persona,apellido_persona,direccion_persona,celular_persona,sexo_persona,edad_persona,estado_persona))
like upper(CONCAT('%',filtro,'%'));


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_FiltrarProveedor`
--

DROP PROCEDURE IF EXISTS `sp_FiltrarProveedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_FiltrarProveedor`(IN filtro varchar(100))
BEGIN
SELECT * FROM  tbl_proveedor where upper(CONCAT(ruc_proveedor,nombre_proveedor,telefono_proveedor,direccion_proveedor,ciudad_proveedor,servicio_proveedor,fax_proveedor,estado_proveedor))
like upper(CONCAT('%',filtro,'%'));


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_filtrar_articuloxsoliprovedor`
--

DROP PROCEDURE IF EXISTS `sp_filtrar_articuloxsoliprovedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_filtrar_articuloxsoliprovedor`(in id_detalle_proveedor_e char(8))
BEGIN
select distinct a.cod_articulo,nombre_articulo
from detalle_solicitud_proveedor spj
inner join tbl_articulo a on (a.cod_articulo=spj.cod_articulo)
where spj.id_detalle_proveedor=id_detalle_proveedor_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_almacen`
--

DROP PROCEDURE IF EXISTS `sp_listar_almacen`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_almacen`()
BEGIN

select * from tbl_almacen
order by cod_almacen asc;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_almacenxactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_almacenxactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_almacenxactivo`()
BEGIN
select * from tbl_almacen

where estado_almacen=1
order by cod_almacen asc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_articulos`
--

DROP PROCEDURE IF EXISTS `sp_listar_articulos`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_articulos`()
BEGIN

select * from tbl_articulo
order by cod_articulo asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_cargos`
--

DROP PROCEDURE IF EXISTS `sp_listar_cargos`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_cargos`()
BEGIN

select * from tbl_cargo;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_dentreadamatepro`
--

DROP PROCEDURE IF EXISTS `sp_listar_dentreadamatepro`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_dentreadamatepro`()
BEGIN

select id_dentrada_materpo, cantidad_material,t.precio_articulo,d.id_detalle_proveedor,
d.id_proveedor, p.nombre_proveedor,t.cod_articulo,t.nombre_articulo, fecha_entrada
from dentrada_materialpro dmpr
inner join detalle_solicitud_proveedor d on (d.id_detalle_proveedor = dmpr.id_detalle_proveedor)
inner join tbl_proveedor p  on (p.id_proveedor=d.id_proveedor)
inner join tbl_articulo t on (t.cod_articulo=dmpr.cod_articulo)
order by id_dentrada_materpo asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_detalle_almacen`
--

DROP PROCEDURE IF EXISTS `sp_listar_detalle_almacen`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_almacen`()
BEGIN

select ta.id_detalle_almacen as id_detalle_almacen,ta.cod_responsable as cod_responsable,ta.cod_almacen as cod_almacen,
ta.cod_articulo as cod_articulo, ta.id_proyecto as id_proyecto, ta.id_proveedor as id_proveedor,
ta.id_inventario as id_inventario, fecha_entrada,fecha_salida from detalle_almacen ta
inner join tbl_responsable re on (ta.cod_responsable=re.cod_responsable)
inner join tbl_almacen al on (ta.cod_almacen=al.cod_almacen)
inner join tbl_articulo ar on (ta.cod_articulo=ar.cod_articulo)
inner join tbl_proyecto pr on (ta.id_proyecto=pr.id_proyecto)
inner join tbl_proveedor po on (ta.id_proveedor=po.id_proveedor)
inner join tbl_inventario iv on (ta.id_inventario=iv.id_inventario)

order by ta.id_detalle_almacen desc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_detalle_solicitud_empresas`
--

DROP PROCEDURE IF EXISTS `sp_listar_detalle_solicitud_empresas`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_solicitud_empresas`()
BEGIN

select id_detalle_solicitud_empresa, se.cod_empresa as cod_empresa,nombre_empresa,nombre_solicitud,
se.cod_responsable as cod_responsable,nombre_responsable, apellido_responsable,se.id_proyecto as id_proyecto, nombre_proyecto,se.cod_articulo as cod_articulo,nombre_articulo,
fecha_solicitud_empresa,estado_solicitud_empresa from detalle_solicitud_empresa se
inner join tbl_empresa em on (se.cod_empresa=em.cod_empresa)
inner join tbl_responsable re on (se.cod_responsable=re.cod_responsable)
inner join tbl_proyecto po on (se.id_proyecto=po.id_proyecto)
inner join tbl_articulo ar on (se.cod_articulo=ar.cod_articulo)
order by id_detalle_solicitud_empresa asc;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_detalle_solicitud_empresasxactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_detalle_solicitud_empresasxactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_solicitud_empresasxactivo`()
BEGIN
select id_detalle_solicitud_empresa, se.cod_empresa as cod_empresa,nombre_empresa,nombre_solicitud,
se.cod_responsable as cod_responsable,nombre_responsable, se.id_proyecto as id_proyecto, nombre_proyecto,se.cod_articulo as cod_articulo,nombre_articulo,
fecha_solicitud_empresa,estado_solicitud_empresa from detalle_solicitud_empresa se
inner join tbl_empresa em on (se.cod_empresa=em.cod_empresa)
inner join tbl_responsable re on (se.cod_responsable=re.cod_responsable)
inner join tbl_proyecto po on (se.id_proyecto=po.id_proyecto)
inner join tbl_articulo ar on (se.cod_articulo=ar.cod_articulo)
where estado_solicitud_empresa=0
order by id_detalle_solicitud_empresa asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_detalle_solicitud_persojuridica`
--

DROP PROCEDURE IF EXISTS `sp_listar_detalle_solicitud_persojuridica`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_solicitud_persojuridica`()
BEGIN

select id_detalle_solicitud_persona_juridica,sp.cod_persona as cod_persona,nombre_persona,apellido_persona,nombre_solicitud,
sp.id_proyecto as id_proyecto,nombre_proyecto, sp.cod_articulo as cod_articulo, nombre_articulo,sp.cod_responsable as cod_responsable,nombre_responsable,
apellido_responsable,
fecha_solicitud_persona,estado_solicitud_persona from detalle_solicitud_persona_juridica sp
inner join tbl_persona_juridica pe on (sp.cod_persona=pe.cod_persona)
inner join tbl_proyecto pr on (sp.id_proyecto=pr.id_proyecto)
inner join tbl_articulo ar on (sp.cod_articulo=ar.cod_articulo)
inner join tbl_responsable re on (sp.cod_responsable=re.cod_responsable)

order by id_detalle_solicitud_persona_juridica asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_detalle_solicitud_persojuridicaxactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_detalle_solicitud_persojuridicaxactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_solicitud_persojuridicaxactivo`()
BEGIN
select id_detalle_solicitud_persona_juridica,sp.cod_persona as cod_persona,nombre_persona,apellido_persona,nombre_solicitud,
sp.id_proyecto as id_proyecto,nombre_proyecto, sp.cod_articulo as cod_articulo, nombre_articulo,sp.cod_responsable as cod_responsable,nombre_responsable,apellido_responsable,
fecha_solicitud_persona,estado_solicitud_persona from detalle_solicitud_persona_juridica sp
inner join tbl_persona_juridica pe on (sp.cod_persona=pe.cod_persona)
inner join tbl_proyecto pr on (sp.id_proyecto=pr.id_proyecto)
inner join tbl_articulo ar on (sp.cod_articulo=ar.cod_articulo)
inner join tbl_responsable re on (sp.cod_responsable=re.cod_responsable)
where estado_solicitud_persona=0
order by id_detalle_solicitud_persona_juridica asc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_detalle_soli_proveedor`
--

DROP PROCEDURE IF EXISTS `sp_listar_detalle_soli_proveedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_soli_proveedor`()
BEGIN

select id_detalle_proveedor, po.id_proveedor as id_proveedor,nombre_proveedor,
po.cod_articulo as cod_articulo,nombre_articulo, ds.cod_solicitud,ds.nombre_solicitud,fecha_solicitud_proveedor,
estado_solicitud_proveedor from detalle_solicitud_proveedor po
inner join tbl_proveedor pr on (po.id_proveedor=pr.id_proveedor)
inner join tbl_articulo ar on (po.cod_articulo=ar.cod_articulo)
inner join tbl_solicitud ds on (po.cod_solicitud=ds.cod_solicitud)
order by id_detalle_proveedor asc;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_detalle_soli_proveedorxactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_detalle_soli_proveedorxactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_soli_proveedorxactivo`()
BEGIN
select id_detalle_proveedor, po.id_proveedor as id_proveedor,nombre_proveedor,
po.cod_articulo as cod_articulo,nombre_articulo, ds.cod_solicitud,ds.nombre_solicitud,fecha_solicitud_proveedor,
estado_solicitud_proveedor from detalle_solicitud_proveedor po
inner join tbl_proveedor pr on (po.id_proveedor=pr.id_proveedor)
inner join tbl_articulo ar on (po.cod_articulo=ar.cod_articulo)
inner join tbl_solicitud ds on (po.cod_solicitud=ds.cod_solicitud)
where estado_solicitud_proveedor=0
order by id_detalle_proveedor asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_dsalidamatepj`
--

DROP PROCEDURE IF EXISTS `sp_listar_dsalidamatepj`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_dsalidamatepj`()
BEGIN
select id_salida_matepj, cantidad_material, d.id_detalle_solicitud_persona_juridica,
d.cod_persona, p.nombre_persona,o.id_proyecto,o.nombre_proyecto,a.cod_articulo,a.nombre_articulo, fecha_salida
from dsalida_materialpj dsp
inner join detalle_solicitud_persona_juridica d on (d.id_detalle_solicitud_persona_juridica = dsp.id_detalle_solicitud_persona_juridica)
inner join tbl_persona_juridica p  on (p.cod_persona=d.cod_persona)
inner join tbl_articulo a on (a.cod_articulo=dsp.cod_articulo)
inner join tbl_proyecto o on (o.id_proyecto=d.id_proyecto)
order by id_salida_matepj asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_dsalida_mateemp`
--

DROP PROCEDURE IF EXISTS `sp_listar_dsalida_mateemp`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_dsalida_mateemp`()
BEGIN
select id_salida_mateemp, cantidad_material, d.id_detalle_solicitud_empresa,
p.cod_empresa,p.nombre_empresa,pro.id_proyecto,pro.nombre_proyecto,t.cod_articulo,t.nombre_articulo, fecha_salida
from dsalida_materialemp dsp
inner join detalle_solicitud_empresa d on (d.id_detalle_solicitud_empresa = dsp.id_detalle_solicitud_empresa)
inner join tbl_empresa p  on (p.cod_empresa=d.cod_empresa)
inner join tbl_articulo t on (t.cod_articulo=dsp.cod_articulo)
inner join tbl_proyecto pro on (pro.id_proyecto=d.id_proyecto);

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_empresas`
--

DROP PROCEDURE IF EXISTS `sp_listar_empresas`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_empresas`()
BEGIN

select * from tbl_empresa
order by cod_empresa asc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_empresasxactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_empresasxactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_empresasxactivo`()
BEGIN
select * from tbl_empresa
where estado_empresa=0
order by cod_empresa asc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_inventario`
--

DROP PROCEDURE IF EXISTS `sp_listar_inventario`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_inventario`()
BEGIN
select * from tbl_inventario;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_personasjuridicas`
--

DROP PROCEDURE IF EXISTS `sp_listar_personasjuridicas`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_personasjuridicas`()
BEGIN

select *from tbl_persona_juridica
order by cod_persona asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_personasjuridicasxactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_personasjuridicasxactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_personasjuridicasxactivo`()
BEGIN
select *from tbl_persona_juridica
where estado_persona=0
order by cod_persona asc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_proveedor`
--

DROP PROCEDURE IF EXISTS `sp_listar_proveedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_proveedor`()
BEGIN

select * from tbl_proveedor
order by id_proveedor asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_proveedorxactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_proveedorxactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_proveedorxactivo`()
BEGIN
select * from tbl_proveedor
where estado_proveedor=0
order by id_proveedor asc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_proyecto`
--

DROP PROCEDURE IF EXISTS `sp_listar_proyecto`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_proyecto`()
BEGIN

select * from tbl_proyecto
order by id_proyecto asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_proyectoxactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_proyectoxactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_proyectoxactivo`()
BEGIN
select * from tbl_proyecto
where estado_proyecto=0
order by id_proyecto asc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_responsable`
--

DROP PROCEDURE IF EXISTS `sp_listar_responsable`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_responsable`()
BEGIN

select cod_responsable,nombre_responsable,apellido_responsable,sexo_responsable,edad_responsable,
celular_responsable, direccion_responsable,responsable_estado, re.id_cargo as id_cargo, descripcion_cargo
from tbl_responsable re
inner join tbl_cargo ca on (re.id_cargo=ca.id_cargo)
order by cod_responsable asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_responsablexactivo`
--

DROP PROCEDURE IF EXISTS `sp_listar_responsablexactivo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_responsablexactivo`()
BEGIN
select cod_responsable,nombre_responsable,apellido_responsable,sexo_responsable,edad_responsable,
celular_responsable, direccion_responsable,responsable_estado, re.id_cargo as id_cargo, descripcion_cargo
from tbl_responsable re
inner join tbl_cargo ca on (re.id_cargo=ca.id_cargo)
where responsable_estado=0
order by cod_responsable asc;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_solicitud`
--

DROP PROCEDURE IF EXISTS `sp_listar_solicitud`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_solicitud`()
BEGIN

select * from tbl_solicitud
order by cod_solicitud asc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_usuarios`
--

DROP PROCEDURE IF EXISTS `sp_listar_usuarios`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_usuarios`()
BEGIN

select id_login,login,clave,clave_vi,ca.id_cargo,ca.descripcion_cargo
from tbl_usuarios us
inner join tbl_cargo ca on (us.id_cargo=ca.id_cargo);

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_proyectoxempresa`
--

DROP PROCEDURE IF EXISTS `sp_proyectoxempresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_proyectoxempresa`(
in id_proyecto_e char(8))
BEGIN
select dse.id_detalle_solicitud_empresa, e.cod_empresa, e.nombre_empresa,nombre_solicitud, ar.nombre_articulo,
 fecha_solicitud_empresa,
estado_solicitud_empresa, p.id_proyecto, p.nombre_proyecto from detalle_solicitud_empresa dse

inner join tbl_empresa e on (dse.cod_empresa=e.cod_empresa)
inner join tbl_proyecto p on (dse.id_proyecto=p.id_proyecto)
inner join tbl_articulo ar on (dse.cod_articulo=ar.cod_articulo)


where dse.id_proyecto=id_proyecto_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_almacen`
--

DROP PROCEDURE IF EXISTS `sp_registrar_almacen`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_almacen`(
in nombre_e varchar(40),
in telefono_almacen_e char(8),
in direccion_almacen_e varchar(50),
in fax_almacen_e char(8),
in estado_almacen_e int,
out cod_almacen_e char(8))
BEGIN

declare cod_almacen_s char(8);

Select concat('AL',Lpad(ifnull(Max(SUBSTR(cod_almacen,3,8)),0)+1,6,'0')) into cod_almacen_s
FROM tbl_almacen;

insert into tbl_almacen(cod_almacen,nombre,telefono_almacen,direccion_almacen,fax_almacen,estado_almacen)
values(cod_almacen_s,nombre_e,telefono_almacen_e,direccion_almacen_e,fax_almacen_e,estado_almacen_e);

set cod_almacen_e=cod_almacen_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_articulo`
--

DROP PROCEDURE IF EXISTS `sp_registrar_articulo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_articulo`(
in nombre_articulo_e varchar(40),
in marca_articulo_e varchar(60),
in descripcion_articulo_e varchar(50),
in cantidad_articulo_e int,
in tipo_material_e varchar(50),
in precio_articulo_e decimal(10,2),

out cod_articulo_e char(8))
BEGIN

declare cod_articulo_s char(8);

Select concat('AR',Lpad(ifnull(Max(SUBSTR(cod_articulo,3,8)),0)+1,6,'0')) into cod_articulo_s
FROM tbl_articulo;

insert into tbl_articulo (cod_articulo,nombre_articulo,marca_articulo,descripcion_articulo,cantidad_articulo,tipo_material,precio_articulo)
values (cod_articulo_s,nombre_articulo_e,marca_articulo_e,descripcion_articulo_e,cantidad_articulo_e,tipo_material_e,precio_articulo_e);


set cod_articulo_e=cod_articulo_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_cargo`
--

DROP PROCEDURE IF EXISTS `sp_registrar_cargo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_cargo`(
in descripcion_cargo_e varchar(50),
out id_cargo_e char(8))
BEGIN

declare id_cargo_s char(8);

Select concat('CA',Lpad(ifnull(Max(SUBSTR(id_cargo,3,8)),0)+1,6,'0')) into id_cargo_s
FROM tbl_cargo;


insert into tbl_cargo(id_cargo,descripcion_cargo)
values(id_cargo_s,descripcion_cargo_e);


set id_cargo_e=id_cargo_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_dentradamaterial`
--

DROP PROCEDURE IF EXISTS `sp_registrar_dentradamaterial`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_dentradamaterial`(

in cantidad_material_e int,
in id_detalle_proveedor_e char(8),
in cod_articulo_e char(8),
in fecha_entrada_e date,
in precio_articulo_e decimal(10,2),

out mensaje varchar(200))
BEGIN
declare estado_solicitud_proveedor_s int;
declare stock_producto int;
declare subtotal_a decimal(10,2);
declare can int;
declare id int;

select estado_solicitud_proveedor into estado_solicitud_proveedor_s from detalle_solicitud_proveedor
where id_detalle_proveedor=id_detalle_proveedor_e;

if estado_solicitud_proveedor_s=0 then
    select cantidad_articulo
      into stock_producto
        from tbl_articulo
          where cod_articulo=cod_articulo_e;

      set subtotal_a=cantidad_material_e * precio_articulo_e;
        select count(*),id_dentrada_materpo into can,id
          from dentrada_materialpro
            where id_detalle_proveedor=id_detalle_proveedor_e and cod_articulo=cod_articulo_e;
      if (can=0) then
            INSERT INTO dentrada_materialpro
              (cantidad_material,id_detalle_proveedor,cod_articulo,fecha_entrada,precio_articulo)
              VALUES(cantidad_material_e,id_detalle_proveedor_e,cod_articulo_e,fecha_entrada_e,precio_articulo_e);
      else
          update dentrada_materialpro
            set cantidad_material=cantidad_material+cantidad_material_e, fecha_entrada=fecha_entrada_e, precio_articulo=precio_articulo+subtotal_a
              where id_dentrada_materpo=id;

      end if;
  update detalle_solicitud_proveedor
            set estado_solicitud_proveedor=1
              where id_detalle_proveedor=id_detalle_proveedor_e;
        update tbl_articulo
          set cantidad_articulo=cantidad_articulo + cantidad_material_e, precio_articulo=precio_articulo+subtotal_a
            where cod_articulo=cod_articulo_e;
              set mensaje='DETALLE REGISTRADO CORRECTAMENTE';
 
else
  set mensaje='NO VALIDO PARA SOLICITUDES INACTIVAS';
end if;



END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_detalle_almacen`
--

DROP PROCEDURE IF EXISTS `sp_registrar_detalle_almacen`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_detalle_almacen`(
in cod_responsable_e char(8),
in cod_almacen_e char(8),
in cod_articulo_e char(8),
in id_proyecto_e char(8),
in id_proveedor_e char(8),
in id_inventario_e char(8),
in fecha_entrada_e date,
in fecha_salida_e date,
out id_detalle_almacen_e char(8))
BEGIN

declare id_detalle_almacen_s char(8);

Select concat('DA',Lpad(ifnull(Max(SUBSTR(id_detalle_almacen,3,8)),0)+1,6,'0')) into id_detalle_almacen_s
FROM detalle_almacen;

insert into detalle_almacen (id_detalle_almacen,cod_responsable,cod_almacen,cod_articulo,id_proyecto, id_proveedor,
id_inventario,fecha_entrada,fecha_salida)
values (id_detalle_almacen_s,cod_responsable_e,cod_almacen_e,cod_articulo_e,id_proyecto_e, id_proveedor_e,
id_inventario_e,fecha_entrada_e,fecha_salida_e);

set id_detalle_almacen_e=id_detalle_almacen_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_detalle_soli_empresa`
--

DROP PROCEDURE IF EXISTS `sp_registrar_detalle_soli_empresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_detalle_soli_empresa`(
in cod_empresa_e char(8),
in nombre_solicitud_e varchar(60),
in cod_responsable_e char(8),
in id_proyecto_e char(8),
in cod_articulo_e char(8),
in fecha_solicitud_empresa_e date,
in estado_solicitud_empresa_e int,
out id_detalle_solicitud_empresa_e char(8))
BEGIN

declare id_detalle_solicitud_empresa_s char(8);

Select concat('SE',Lpad(ifnull(Max(SUBSTR(id_detalle_solicitud_empresa,3,8)),0)+1,6,'0')) into id_detalle_solicitud_empresa_s
FROM detalle_solicitud_empresa;

insert into detalle_solicitud_empresa (id_detalle_solicitud_empresa,cod_empresa,nombre_solicitud,
cod_responsable,id_proyecto,cod_articulo,fecha_solicitud_empresa,estado_solicitud_empresa)
values (id_detalle_solicitud_empresa_s,cod_empresa_e,nombre_solicitud_e,
cod_responsable_e,id_proyecto_e,cod_articulo_e,fecha_solicitud_empresa_e,estado_solicitud_empresa_e);

set id_detalle_solicitud_empresa_e=id_detalle_solicitud_empresa_s;



END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_detalle_soli_proveedor`
--

DROP PROCEDURE IF EXISTS `sp_registrar_detalle_soli_proveedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_detalle_soli_proveedor`(
in id_proveedor_e char(8),
in cod_articulo_e char(8),
in cod_solicitud_e char(8),
in fecha_solicitud_proveedor_e date,
in estado_solicitud_proveedor_e int,
out id_detalle_proveedor_e char(8))
BEGIN

declare id_detalle_proveedor_s char(8);


Select concat('SO',Lpad(ifnull(Max(SUBSTR(id_detalle_proveedor,3,8)),0)+1,6,'0')) into id_detalle_proveedor_s
FROM detalle_solicitud_proveedor;


insert into detalle_solicitud_proveedor(id_detalle_proveedor,id_proveedor,
cod_articulo,cod_solicitud,fecha_solicitud_proveedor,estado_solicitud_proveedor)
values (id_detalle_proveedor_s,id_proveedor_e,
cod_articulo_e,cod_solicitud_e,fecha_solicitud_proveedor_e,estado_solicitud_proveedor_e);

set id_detalle_proveedor_e=id_detalle_proveedor_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_dsalida_mateemp`
--

DROP PROCEDURE IF EXISTS `sp_registrar_dsalida_mateemp`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_dsalida_mateemp`(
in cantidad_material_e int,
in id_detalle_solicitud_empresa_e char(8),
in cod_articulo_e char (8),



out mensaje varchar (200))
BEGIN

declare estado_solicitud_empresa_s int;
declare stock_producto int;
declare can int;
declare id int;

select estado_solicitud_empresa into estado_solicitud_empresa_s from detalle_solicitud_empresa
where id_detalle_solicitud_empresa=id_detalle_solicitud_empresa_e;

if estado_solicitud_empresa_s=0 then
    select cantidad_articulo
    into stock_producto
    from tbl_articulo
    where cod_articulo=cod_articulo_e;

  if (stock_producto>=cantidad_material_e) then
    select count(*),id_salida_mateemp into can,id
    from dsalida_materialemp
    where id_detalle_solicitud_empresa=id_detalle_solicitud_empresa_e and cod_articulo=cod_articulo_e;
      if (can=0) then
        INSERT INTO dsalida_materialemp
          (cantidad_material,id_detalle_solicitud_empresa,cod_articulo,fecha_salida)
          VALUES(cantidad_material_e,id_detalle_solicitud_empresa_e,cod_articulo_e,now());
       else
    update dsalida_materialemp
    set cantidad_material=cantidad_material+cantidad_material_e, fecha_salida =now()
    where id_salida_mateemp=id;

  end if;
update detalle_solicitud_empresa
  set estado_solicitud_empresa=1
  where id_detalle_solicitud_empresa=id_detalle_solicitud_empresa_e;
  update tbl_articulo
  set cantidad_articulo=cantidad_articulo - cantidad_material_e
  where cod_articulo=cod_articulo_e;
    set mensaje='DETALLE REGISTRADO CORRECTAMENTE';
  else
    set mensaje='NO HAY STOCK';
  end if;

else
set mensaje='NO VALIDO PARA SOLICITUDES INACTIVAS';
end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_dsalida_materialpj`
--

DROP PROCEDURE IF EXISTS `sp_registrar_dsalida_materialpj`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_dsalida_materialpj`(
in cantidad_material_e int,
in id_detalle_solicitud_persona_juridica_e char(8),
in cod_articulo_e char (8),



out mensaje varchar (200))
BEGIN

declare estado_solicitud_persona_s int;
declare stock_producto int;
declare can int;
declare id int;

select estado_solicitud_persona into estado_solicitud_persona_s from detalle_solicitud_persona_juridica
where id_detalle_solicitud_persona_juridica=id_detalle_solicitud_persona_juridica_e;

if estado_solicitud_persona_s=0 then
    select cantidad_articulo
    into stock_producto
    from tbl_articulo
    where cod_articulo=cod_articulo_e;

  if (stock_producto>=cantidad_material_e) then
    select count(*),id_salida_matepj into can,id
    from dsalida_materialpj
    where id_detalle_solicitud_persona_juridica=id_detalle_solicitud_persona_juridica_e and cod_articulo=cod_articulo_e;
      if (can=0) then
        INSERT INTO dsalida_materialpj
          (cantidad_material,id_detalle_solicitud_persona_juridica,cod_articulo,fecha_salida)
          VALUES(cantidad_material_e,id_detalle_solicitud_persona_juridica_e,cod_articulo_e,now());
       else
    update dsalida_materialpj
    set cantidad_material=cantidad_material+cantidad_material_e, fecha_salida =now()
    where id_salida_matepj=id;
    
  end if;
 update detalle_solicitud_persona_juridica
  set estado_solicitud_persona=1
  where id_detalle_solicitud_persona_juridica=id_detalle_solicitud_persona_juridica_e;
  update tbl_articulo
  set cantidad_articulo=cantidad_articulo - cantidad_material_e
  where cod_articulo=cod_articulo_e;
    set mensaje='DETALLE REGISTRADO CORRECTAMENTE';
  else
    set mensaje='NO HAY STOCK DISPONIBLE';
  end if;

else
set mensaje='NO VALIDO PARA SOLICITUDES INACTIVAS';
end if;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_empresa`
--

DROP PROCEDURE IF EXISTS `sp_registrar_empresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_empresa`(
in ruc_empresa_e char(11),
in nombre_empresa_e varchar(50),
in telefono_empresa_e char(8),
in direccion_empresa_e varchar(60),
in estado_empresa_e int,
out cod_empresa_e char(8))
BEGIN

declare cod_empresa_s char (8);
Select concat('EM',Lpad(ifnull(Max(SUBSTR(cod_empresa,3,8)),0)+1,6,'0')) into cod_empresa_s
FROM tbl_empresa;

insert into tbl_empresa(cod_empresa,ruc_empresa,nombre_empresa,telefono_empresa,direccion_empresa,estado_empresa)
values(cod_empresa_s,ruc_empresa_e,nombre_empresa_e,telefono_empresa_e,direccion_empresa_e,estado_empresa_e);

set cod_empresa_e=cod_empresa_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_inventario`
--

DROP PROCEDURE IF EXISTS `sp_registrar_inventario`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_inventario`(
in fecha_inventario_e date,
out id_inventario_e char(8))
BEGIN

declare id_inventario_s char(8);

Select concat('IN',Lpad(ifnull(Max(SUBSTR(id_inventario,3,8)),0)+1,6,'0')) into id_inventario_s
FROM tbl_inventario;

insert into tbl_inventario (id_inventario,fecha_inventario)
values (id_inventario_s,fecha_inventario_e);
set id_inventario_e=id_inventario_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_persona_juridica`
--

DROP PROCEDURE IF EXISTS `sp_registrar_persona_juridica`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_persona_juridica`(
in ruc_persona_e char(11),
in nombre_persona_e longtext,
in apellido_persona_e varchar(50),
in direccion_persona_e varchar(50),
in celular_persona_e char(20),
in sexo_persona_e varchar(15),
in edad_persona_e char(2),
in estado_persona_e int,
out cod_persona_e char (8))
BEGIN

declare cod_persona_s char(8);

Select concat('PJ',Lpad(ifnull(Max(SUBSTR(cod_persona,3,8)),0)+1,6,'0')) into cod_persona_s
FROM tbl_persona_juridica;


insert into tbl_persona_juridica (cod_persona,ruc_persona,nombre_persona,apellido_persona,direccion_persona, celular_persona,sexo_persona,edad_persona,estado_persona)
values (cod_persona_s,ruc_persona_e,nombre_persona_e,apellido_persona_e,direccion_persona_e,celular_persona_e,sexo_persona_e,edad_persona_e,estado_persona_e);


set cod_persona_e=cod_persona_s;
delete from tbl_persona_juridica where cod_persona=cod_persona_s and nombre_persona like '%[0-9]%';

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_proveedor`
--

DROP PROCEDURE IF EXISTS `sp_registrar_proveedor`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_proveedor`(
in ruc_proveedor_e char(11),
in nombre_proveedor_e varchar(50),
in telefono_proveedor_e char(8),
in direccion_proveedor_e varchar(50),
in ciudad_proveedor_e varchar(50),
in servicio_proveedor_e varchar(60),
in fax_proveedor_e char(10),
in estado_proveedor_e int,
out id_proveedor_e char(8))
BEGIN

declare id_proveedor_s char (8);
Select concat('PD',Lpad(ifnull(Max(SUBSTR(id_proveedor,3,8)),0)+1,6,'0')) into id_proveedor_s
FROM tbl_proveedor;

insert into tbl_proveedor(id_proveedor,ruc_proveedor,nombre_proveedor,telefono_proveedor,direccion_proveedor,ciudad_proveedor,servicio_proveedor,fax_proveedor,estado_proveedor)
values(id_proveedor_s,ruc_proveedor_e,nombre_proveedor_e,telefono_proveedor_e,direccion_proveedor_e,ciudad_proveedor_e,servicio_proveedor_e,fax_proveedor_e,estado_proveedor_e);

set id_proveedor_e=id_proveedor_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_proyecto`
--

DROP PROCEDURE IF EXISTS `sp_registrar_proyecto`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_proyecto`(

in nombre_proyecto_e varchar(50),
in tipo_proyecto_e varchar(50),
in estado_proyecto_e int,
out id_proyecto_e char(8))
BEGIN

declare id_proyecto_s char (8);
Select concat('PR',Lpad(ifnull(Max(SUBSTR(id_proyecto,3,8)),0)+1,6,'0')) into id_proyecto_s
FROM tbl_proyecto;

insert into tbl_proyecto(id_proyecto,nombre_proyecto,tipo_proyecto, estado_proyecto)
values(id_proyecto_s,nombre_proyecto_e,tipo_proyecto_e, estado_proyecto_e);

set id_proyecto_e=id_proyecto_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_responsable`
--

DROP PROCEDURE IF EXISTS `sp_registrar_responsable`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_responsable`(
in nombre_responsable_e varchar(30),
in apellido_responsable_e varchar(40),
in sexo_e varchar(10),
in edad_e char(2),
in celular_e char(20),
in direccion_responsable_e varchar(50),
in responsable_estado_e int,
in id_cargo_e char(8),
out cod_responsable_e char(8))
BEGIN

declare cod_responsable_s char(8);


Select concat('RE',Lpad(ifnull(Max(SUBSTR(cod_responsable,3,8)),0)+1,6,'0')) into cod_responsable_s
FROM tbl_responsable;

insert into tbl_responsable (cod_responsable,nombre_responsable,apellido_responsable,sexo_responsable,edad_responsable,celular_responsable,direccion_responsable,responsable_estado,id_cargo)
values (cod_responsable_s,nombre_responsable_e,apellido_responsable_e,sexo_e,edad_e,celular_e,direccion_responsable_e,responsable_estado_e,id_cargo_e);
set cod_responsable_e=cod_responsable_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_solicitud`
--

DROP PROCEDURE IF EXISTS `sp_registrar_solicitud`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_solicitud`(
in nombre_solicitud_e varchar(80),
out cod_solicitud_e char(8))
BEGIN
declare cod_solicitud_s char (8);
Select concat('ST',Lpad(ifnull(Max(SUBSTR(cod_solicitud,3,8)),0)+1,6,'0')) into cod_solicitud_s
FROM tbl_solicitud;

insert into tbl_solicitud(cod_solicitud,nombre_solicitud)
values(cod_solicitud_s,nombre_solicitud_e);

set cod_solicitud_e=cod_solicitud_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_solicitud_perso_juridica`
--

DROP PROCEDURE IF EXISTS `sp_registrar_solicitud_perso_juridica`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_solicitud_perso_juridica`(
in cod_persona_e char (8),
in nombre_solicitud_e varchar(60),
in id_proyecto_e char(8),
in cod_articulo_e char(8),
in cod_responsable_e char(8),
in fecha_solicitud_persona_e date,
in estado_solicitud_persona_e int,
out id_detalle_solicitud_persona_juridica_e char(8))
BEGIN

declare id_detalle_solicitud_persona_juridica_s char(8);

Select concat('SP',Lpad(ifnull(Max(SUBSTR(id_detalle_solicitud_persona_juridica,3,8)),0)+1,6,'0')) into id_detalle_solicitud_persona_juridica_s
FROM detalle_solicitud_persona_juridica;


insert into detalle_solicitud_persona_juridica(id_detalle_solicitud_persona_juridica,cod_persona,
nombre_solicitud,id_proyecto,cod_articulo,cod_responsable,fecha_solicitud_persona,
estado_solicitud_persona)
values (id_detalle_solicitud_persona_juridica_s,cod_persona_e,
nombre_solicitud_e,id_proyecto_e,cod_articulo_e,cod_responsable_e,fecha_solicitud_persona_e,
estado_solicitud_persona_e);

set id_detalle_solicitud_persona_juridica_e=id_detalle_solicitud_persona_juridica_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_usuarios`
--

DROP PROCEDURE IF EXISTS `sp_registrar_usuarios`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_usuarios`(
in login_e varchar(30),
in clave_vi_e varchar(100),
in id_cargo_e char(8),
in descripcion_cargo_e varchar(50),
in usuestado_e int,

out id_login_e int)
BEGIN

declare id_login_s int;

insert into  tbl_usuarios (id_login,login,clave_vi,id_cargo,descripcion_cargo,usuestado)
values (id_login_s,login_e,clave_vi_e,id_cargo_e,descripcion_cargo,usuestado_e);

set id_login_e=id_login_s;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_TotalArticulosxSolixEmpresa`
--

DROP PROCEDURE IF EXISTS `sp_TotalArticulosxSolixEmpresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TotalArticulosxSolixEmpresa`()
BEGIN

select concat (e.nombre_empresa,' - ',ruc_empresa) as nombre, sum(a.precio_articulo)
precio_articulo, count(c.cod_empresa) as cantidad

from detalle_solicitud_empresa c

inner join tbl_empresa e on (c.cod_empresa=e.cod_empresa)
inner join tbl_articulo a on (c.cod_articulo=a.cod_articulo)
group by c.cod_empresa;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_TotalArticulosxSolixPersonaJuridica`
--

DROP PROCEDURE IF EXISTS `sp_TotalArticulosxSolixPersonaJuridica`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TotalArticulosxSolixPersonaJuridica`()
BEGIN
select concat (pj.nombre_persona,' - ',pj.ruc_persona) as nombre, sum(a.precio_articulo) as
precio_articulo, count(dsp.cod_persona) as cantidad

from detalle_solicitud_persona_juridica dsp

inner join tbl_persona_juridica pj on (dsp.cod_persona=pj.cod_persona)
inner join tbl_articulo a on (dsp.cod_articulo=a.cod_articulo)
group by dsp.cod_persona;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_TotalCreditosxEmpresa`
--

DROP PROCEDURE IF EXISTS `sp_TotalCreditosxEmpresa`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TotalCreditosxEmpresa`()
BEGIN
SELECT concat(e.nombre,' - ',ruc) as nombre,sum(importe)
totalimporte, count(c.cod_empresa) as cantidad
FROM credito c
inner join empresa e on
 c.cod_empresa=e.cod_empresa
group by c.cod_empresa;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_TotalSolicitudEmpresaxResponsable`
--

DROP PROCEDURE IF EXISTS `sp_TotalSolicitudEmpresaxResponsable`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TotalSolicitudEmpresaxResponsable`(in cod_responsable_e varchar(30))
BEGIN
select dse.id_detalle_solicitud_empresa as id_detalle_solicitud_empresa, dse.nombre_solicitud as nombre_solicitud, ar.nombre_articulo as nombre_articulo,pr.nombre_proyecto as nombre_proyecto
from detalle_solicitud_empresa dse
inner join tbl_articulo ar on(dse.cod_articulo=ar.cod_articulo)
inner join tbl_proyecto pr on(dse.id_proyecto=pr.id_proyecto)
where dse.cod_responsable=cod_responsable_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ulimasxsolicitudxpj`
--

DROP PROCEDURE IF EXISTS `sp_ulimasxsolicitudxpj`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ulimasxsolicitudxpj`(
in cod_persona_e varchar(30))
BEGIN
select id_detalle_solicitud_persona_juridica,nombre_solicitud, fecha_solicitud_persona,
estado_solicitud_persona, pj.cod_persona, pj.nombre_persona
from detalle_solicitud_persona_juridica dpj
inner join tbl_persona_juridica pj on (dpj.cod_persona=pj.cod_persona)
where dpj.cod_persona=cod_persona_e
order by fecha_solicitud_persona desc LIMIT  0 , 3;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_validar_usuario2`
--

DROP PROCEDURE IF EXISTS `sp_validar_usuario2`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validar_usuario2`(In login_e char(20), in clave_e text)
BEGIN
select * from  tbl_usuarios where login=login_e
and clave_vi=clave_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_validar_usuarios`
--

DROP PROCEDURE IF EXISTS `sp_validar_usuarios`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validar_usuarios`(
IN login_e varchar(30),
IN clave_e text)
BEGIN
declare estado_g int;

select usuestado  into estado_g from tbl_usuarios

where login=login_e;



if estado_g=0 then
  select id_login, login,clave,clave_vi,t.id_cargo,t.descripcion_cargo,
  usuestado from tbl_usuarios u
  inner join tbl_cargo t on t.id_cargo= u.id_cargo
where login= login_e

and clave=clave_e;
end if;





END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
