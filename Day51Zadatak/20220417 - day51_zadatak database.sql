/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 8.0.23 : Database - day51_zadatak
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`day51_zadatak` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `day51_zadatak`;

/*Table structure for table `city_table` */

DROP TABLE IF EXISTS `city_table`;

CREATE TABLE `city_table` (
  `zip_code` int unsigned NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`zip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `city_table` */

insert  into `city_table`(`zip_code`,`name`) values (11000,'Beograd');
insert  into `city_table`(`zip_code`,`name`) values (15000,'Sabac');
insert  into `city_table`(`zip_code`,`name`) values (18000,'Nis');
insert  into `city_table`(`zip_code`,`name`) values (21000,'Novi Sad');
insert  into `city_table`(`zip_code`,`name`) values (34000,'Kragujevac');
insert  into `city_table`(`zip_code`,`name`) values (37000,'Krusevac');

/*Table structure for table `korisnik_tabela` */

DROP TABLE IF EXISTS `korisnik_tabela`;

CREATE TABLE `korisnik_tabela` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `korisnik_tabela` */

insert  into `korisnik_tabela`(`username`,`password`) values ('admin','admin1');
insert  into `korisnik_tabela`(`username`,`password`) values ('pera','pera1');
insert  into `korisnik_tabela`(`username`,`password`) values ('user','user1');

/*Table structure for table `proizvodjac_table` */

DROP TABLE IF EXISTS `proizvodjac_table`;

CREATE TABLE `proizvodjac_table` (
  `pib` varchar(20) NOT NULL,
  `mat_br` varchar(20) NOT NULL,
  `adresa` varchar(20) DEFAULT NULL,
  `zip_code_FK` int unsigned DEFAULT NULL,
  PRIMARY KEY (`pib`),
  KEY `fk_proizvodjac_city` (`zip_code_FK`),
  CONSTRAINT `fk_proizvodjac_city` FOREIGN KEY (`zip_code_FK`) REFERENCES `city_table` (`zip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `proizvodjac_table` */

insert  into `proizvodjac_table`(`pib`,`mat_br`,`adresa`,`zip_code_FK`) values ('123456','222222','Oslobodjenja 10',15000);
insert  into `proizvodjac_table`(`pib`,`mat_br`,`adresa`,`zip_code_FK`) values ('234567','5555555','Brankova 15 c',37000);
insert  into `proizvodjac_table`(`pib`,`mat_br`,`adresa`,`zip_code_FK`) values ('555555','77777','Pariska 51',18000);
insert  into `proizvodjac_table`(`pib`,`mat_br`,`adresa`,`zip_code_FK`) values ('654321','222222','Beogradska 5 b',11000);
insert  into `proizvodjac_table`(`pib`,`mat_br`,`adresa`,`zip_code_FK`) values ('6666666','6666666','Novogradska 1',37000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
