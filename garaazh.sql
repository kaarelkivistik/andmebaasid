--
-- Table structure for table `kauba_kategooria`
--

DROP TABLE IF EXISTS `kauba_kategooria`;
CREATE TABLE `kauba_kategooria` (
  `kauba_kategooria_kood` int(11) NOT NULL,
  `kirjeldus` varchar(255) DEFAULT NULL,
  `nimetus` varchar(255) NOT NULL,
  `ylem_kategooria` int(11) DEFAULT NULL,
  PRIMARY KEY (`kauba_kategooria_kood`),
  KEY `FK_kauba_ylemkategooria` (`ylem_kategooria`),
  CONSTRAINT `FK_kauba_ylemkategooria` FOREIGN KEY (`ylem_kategooria`) REFERENCES `kauba_kategooria` (`kauba_kategooria_kood`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `kauba_staatus`
--

DROP TABLE IF EXISTS `kauba_staatus`;
CREATE TABLE `kauba_staatus` (
  `kauba_staatuse_kood` smallint(6) NOT NULL,
  `kirjeldus` varchar(255) DEFAULT NULL,
  `nimetus` varchar(255) NOT NULL,
  PRIMARY KEY (`kauba_staatuse_kood`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `kaup`
--

DROP TABLE IF EXISTS `kaup`;
CREATE TABLE `kaup` (
  `kauba_kood` varchar(20) NOT NULL,
  `hind` decimal(19,2) NOT NULL,
  `korgus` int(11) DEFAULT NULL,
  `laius` int(11) DEFAULT NULL,
  `nimetus` varchar(255) NOT NULL,
  `pikkus` int(11) DEFAULT NULL,
  `pildi_aadress` varchar(255) DEFAULT NULL,
  `kauba_kategooria` int(11) NOT NULL,
  `kauba_staatus` smallint(6) NOT NULL,
  `tarnija` int(11) NOT NULL,
  `tootaja` int(11) NOT NULL,
  `tootja` int(11) NOT NULL,
  PRIMARY KEY (`kauba_kood`),
  KEY `FK_kauba_kategooria` (`kauba_kategooria`),
  KEY `FK_kauba_staatus` (`kauba_staatus`),
  KEY `FK_kauba_tarnija` (`tarnija`),
  KEY `FK_kauba_tootaja` (`tootaja`),
  KEY `FK_kauba_tootja` (`tootja`),
  CONSTRAINT `FK_kauba_tootja` FOREIGN KEY (`tootja`) REFERENCES `organisatsioon` (`organisatsiooni_kood`),
  CONSTRAINT `FK_kauba_kategooria` FOREIGN KEY (`kauba_kategooria`) REFERENCES `kauba_kategooria` (`kauba_kategooria_kood`),
  CONSTRAINT `FK_kauba_staatus` FOREIGN KEY (`kauba_staatus`) REFERENCES `kauba_staatus` (`kauba_staatuse_kood`),
  CONSTRAINT `FK_kauba_tarnija` FOREIGN KEY (`tarnija`) REFERENCES `organisatsioon` (`organisatsiooni_kood`),
  CONSTRAINT `FK_kauba_tootaja` FOREIGN KEY (`tootaja`) REFERENCES `tootaja` (`tootaja_kood`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `organisatsioon`
--

DROP TABLE IF EXISTS `organisatsioon`;
CREATE TABLE `organisatsioon` (
  `dtype` varchar(31) NOT NULL,
  `organisatsiooni_kood` int(11) NOT NULL AUTO_INCREMENT,
  `aadress` varchar(255) NOT NULL,
  `e_mail` varchar(255) NOT NULL,
  `nimi` varchar(255) NOT NULL,
  `registri_kood` varchar(255) NOT NULL,
  `tarneaeg` float NOT NULL,
  `hinne` float NOT NULL,
  `riik` smallint(6) NOT NULL,
  PRIMARY KEY (`organisatsiooni_kood`),
  KEY `FK_organisatsiooni_riik` (`riik`),
  CONSTRAINT `FK_organisatsiooni_riik` FOREIGN KEY (`riik`) REFERENCES `riik` (`riigi_kood`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Table structure for table `riik`
--

DROP TABLE IF EXISTS `riik`;
CREATE TABLE `riik` (
  `riigi_kood` smallint(6) NOT NULL,
  `identifikaator2tahte` varchar(2) NOT NULL,
  `identifikaator3tahte` varchar(3) NOT NULL,
  `nimi` varchar(255) NOT NULL,
  PRIMARY KEY (`riigi_kood`),
  UNIQUE KEY `UK_riik_on_unikaalne` (`nimi`,`identifikaator2tahte`,`identifikaator3tahte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `tootaja`
--

DROP TABLE IF EXISTS `tootaja`;
CREATE TABLE `tootaja` (
  `tootaja_kood` int(11) NOT NULL AUTO_INCREMENT,
  `e_mail` varchar(255) NOT NULL,
  `eesnimi` varchar(255) NOT NULL,
  `isikukood` varchar(255) NOT NULL,
  `parool` varchar(255) NOT NULL,
  `perenimi` varchar(255) NOT NULL,
  PRIMARY KEY (`tootaja_kood`),
  UNIQUE KEY `UK_e_mail_on_unikaalne` (`e_mail`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
