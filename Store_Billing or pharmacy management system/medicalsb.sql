-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2017 at 07:53 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medicalsb`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `delbil` (IN `bcod` INT)  NO SQL
begin
delete from tbbil where bilcod=bcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delbildet` (IN `bdetcod` INT)  NO SQL
begin
delete from tbbildet where bildetcod=bdetcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delmed` (IN `mcod` INT)  NO SQL
begin
delete from tbmed where medcod=mcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delstk` (IN `scod` INT)  NO SQL
begin
delete from tbstk where stkcod=scod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dispbil` ()  NO SQL
begin
select * from tbbil;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dispbildet` ()  NO SQL
begin
select * from tbbildet;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dispmed` ()  NO SQL
begin
select * from tbmed order by mednam;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dispstk` (IN `mcod` INT)  NO SQL
begin
select * from tbstk where stkmedcod=mcod ;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspmedstk` (IN `mcod` INT)  NO SQL
select stkcod,stkexpdat,stkmandat,stkprc,stkqty-(select ifnull(sum(bildetqty),0) from
tbbildet where bildetstkcod=a.stkcod) qtylft from tbstk a where stkmedcod=mcod order by stkexpdat$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findbil` (IN `bcod` INT)  NO SQL
begin
select * from tbbil where bilcod=bcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findbildet` (IN `bdcod` INT)  NO SQL
begin
select * from tbbildet where bildetcod=bdcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findmed` (IN `mcod` INT)  NO SQL
begin
select * from tbmed where medcod=mcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findstk` (IN `scod` INT)  NO SQL
begin
select * from tbstk where stkcod=scod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insbil` (IN `bdat` DATETIME, IN `bcstnam` VARCHAR(100), IN `bcstphn` VARCHAR(100))  NO SQL
begin
insert tbbil values(null,bdat,bcstnam,bcstphn);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insbildet` (IN `bdetbilcod` INT, IN `bdetstkcod` INT, IN `bdetqty` INT)  NO SQL
begin
insert tbbildet values(null,bdetbilcod,bdetstkcod,bdetqty);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insmed` (IN `mnam` VARCHAR(500), IN `mgnrnam` VARCHAR(500), IN `mcpc` VARCHAR(100), IN `mcmp` VARCHAR(100), IN `mprc` VARCHAR(1000), IN `mtyp` VARCHAR(100))  NO SQL
begin
insert tbmed values(null,mnam,mgnrnam,mcpc,mcmp,mprc,mtyp);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insstk` (IN `sdat` DATETIME, IN `smedcod` INT, IN `sqty` INT, IN `sprc` FLOAT, IN `smnfdat` DATETIME, IN `sexpdat` DATETIME)  NO SQL
begin
insert tbstk values(null,sdat,smedcod,sqty,sprc,smnfdat,sexpdat);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updbil` (IN `bcod` INT, IN `bdat` DATETIME, IN `bcstnam` VARCHAR(100), IN `bcstphn` VARCHAR(100))  NO SQL
begin
update tbbil set bildat=bdat,bilcstnam=bcstnam,bilcstphn=bcstphn where bilcod=bcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updbildet` (IN `bdetcod` INT, IN `bdetbilcod` INT, IN `bdetstkcod` INT, IN `bdetqty` INT)  NO SQL
begin
update tbbildet set bildetbilcod=bdetbilcod,bildetstkcod=bdetstkcod,bildetqty=bdetqty where bildetcod=bdetcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updmed` (IN `mcod` INT, IN `mnam` VARCHAR(500), IN `mgnrnam` VARCHAR(500), IN `mcpc` VARCHAR(100), IN `mcmp` VARCHAR(100), IN `mprc` VARCHAR(1000), IN `mtyp` VARCHAR(100))  NO SQL
begin
update tbmed set mednam=mnam,medgnrnam=mgnrnam,medcpc=mcpc,medcmp=mcmp,medprc=mprc,medtyp=mtyp where medcod=mcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updstk` (IN `scod` INT, IN `sdat` DATETIME, IN `smedcod` INT, IN `sqty` INT, IN `sprc` FLOAT, IN `smnfdat` DATETIME, IN `sexpdat` DATETIME)  NO SQL
begin
update tbstk set stkdat=sdat,stkmedcod=smedcod,stkqty=sqty,stkprc=sprc,stkmnfdat=smnfdat,stkexpdat=sexpdat where stkcod=scod;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbbil`
--

CREATE TABLE `tbbil` (
  `bilcod` int(11) NOT NULL,
  `bildat` datetime NOT NULL,
  `bilcstnam` varchar(100) NOT NULL,
  `bilcstphn` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbbildet`
--

CREATE TABLE `tbbildet` (
  `bildetcod` int(11) NOT NULL,
  `bildetbilcod` int(11) NOT NULL,
  `bildetstkcod` int(11) NOT NULL,
  `bildetqty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbmed`
--

CREATE TABLE `tbmed` (
  `medcod` int(11) NOT NULL,
  `mednam` varchar(500) NOT NULL,
  `medgnrnam` varchar(500) NOT NULL,
  `medcpc` varchar(100) NOT NULL,
  `medcmp` varchar(100) NOT NULL,
  `medprc` varchar(1000) NOT NULL,
  `medtyp` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmed`
--

INSERT INTO `tbmed` (`medcod`, `mednam`, `medgnrnam`, `medcpc`, `medcmp`, `medprc`, `medtyp`) VALUES
(1, 'Disprin', '#aaa', '10mcg', 'Abbott', 'wefwefwe', 'Tablet'),
(2, 'Combiflam', 'Ibrufeen', '100 mcg', 'Cipla', 'none', 'Tablet'),
(3, 'Calpol', 'Paracematol', '250mg', 'Cipla', 'none', 'Syrup');

-- --------------------------------------------------------

--
-- Table structure for table `tbstk`
--

CREATE TABLE `tbstk` (
  `stkcod` int(11) NOT NULL,
  `stkdat` datetime NOT NULL,
  `stkmedcod` int(11) NOT NULL,
  `stkqty` int(11) NOT NULL,
  `stkprc` float NOT NULL,
  `stkmandat` datetime NOT NULL,
  `stkexpdat` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbstk`
--

INSERT INTO `tbstk` (`stkcod`, `stkdat`, `stkmedcod`, `stkqty`, `stkprc`, `stkmandat`, `stkexpdat`) VALUES
(1, '2017-07-08 00:00:00', 2, 100, 30, '2017-07-08 00:00:00', '2017-07-08 00:00:00'),
(2, '2017-07-08 00:00:00', 1, 100, 10, '2016-06-05 00:00:00', '2017-07-05 00:00:00'),
(4, '2017-07-10 00:00:00', 1, 23, 23, '2017-08-21 00:00:00', '2018-08-21 00:00:00'),
(5, '2017-07-10 00:00:00', 2, 23, 23, '2017-08-21 00:00:00', '2018-08-21 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbbil`
--
ALTER TABLE `tbbil`
  ADD PRIMARY KEY (`bilcod`);

--
-- Indexes for table `tbbildet`
--
ALTER TABLE `tbbildet`
  ADD PRIMARY KEY (`bildetcod`);

--
-- Indexes for table `tbmed`
--
ALTER TABLE `tbmed`
  ADD PRIMARY KEY (`medcod`);

--
-- Indexes for table `tbstk`
--
ALTER TABLE `tbstk`
  ADD PRIMARY KEY (`stkcod`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbbil`
--
ALTER TABLE `tbbil`
  MODIFY `bilcod` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbbildet`
--
ALTER TABLE `tbbildet`
  MODIFY `bildetcod` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbmed`
--
ALTER TABLE `tbmed`
  MODIFY `medcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbstk`
--
ALTER TABLE `tbstk`
  MODIFY `stkcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
