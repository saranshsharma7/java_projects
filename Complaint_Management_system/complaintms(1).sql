-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2017 at 07:55 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `complaintms`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `delacc` (IN `ano` INT)  NO SQL
begin
delete from tbacc where accno=ano;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delcmp` (IN `ccod` INT)  NO SQL
begin
delete from tbcmp where cmpcod=ccod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delemp` (IN `ecod` INT)  NO SQL
begin
delete from tbemp where empcod=ecod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delvst` (IN `vcod` INT)  NO SQL
begin
delete from tbvst where vstcod=vcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspacc` ()  NO SQL
begin
select * from tbacc;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspcmp` ()  NO SQL
begin
select * from tbcmp;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspemp` ()  NO SQL
begin
select * from tbemp;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspempbyloc` (IN `loc` VARCHAR(100))  NO SQL
select * from tbemp where emploc=loc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspvst` ()  NO SQL
begin
select * from tbvst;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findacc` (IN `ano` INT)  NO SQL
begin
select * from tbacc where accno=ano;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findcmp` (IN `ccod` INT)  NO SQL
begin
select * from tbcmp where cmpcod=ccod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findemp` (IN `ecod` INT)  NO SQL
begin
select * from tbemp where empcod=ecod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findvst` (IN `vcod` INT)  NO SQL
begin
select * from tbvst where vstcod=vcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insacc` (IN `anam` VARCHAR(100), IN `acrtdat` DATETIME, IN `aadd` VARCHAR(100), IN `aloc` VARCHAR(100), IN `aphnno` VARCHAR(100), IN `atyp` VARCHAR(100))  NO SQL
begin
insert tbacc values(null,anam,acrtdat,aadd,aloc,aphnno,atyp);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inscmp` (IN `caccno` INT, IN `cdat` DATETIME, IN `cdsc` VARCHAR(1000), IN `casgempcod` INT, IN `csts` CHAR(1), OUT `cod` INT)  NO SQL
begin
insert tbcmp values(null,caccno,cdat,cdsc,casgempcod,csts);
select last_insert_id() into cod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insemp` (IN `enam` VARCHAR(100), IN `epic` VARCHAR(50), IN `eloc` VARCHAR(100), IN `ephnno` VARCHAR(100))  NO SQL
begin
insert tbemp values(null,enam,epic,eloc,ephnno);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insvst` (IN `vdat` DATETIME, IN `vcmpcod` INT, IN `vdsc` VARCHAR(1000), IN `vfed` INT)  NO SQL
begin
insert tbvst values(null,vdat,vcmpcod,vdsc,vfed);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updacc` (IN `ano` INT, IN `anam` VARCHAR(100), IN `acrtdat` DATETIME, IN `aadd` VARCHAR(100), IN `aloc` VARCHAR(100), IN `aphnno` VARCHAR(100), IN `atyp` VARCHAR(100))  NO SQL
begin
update tbacc set accnam=anam,acccrtdat=acrtdat,accadd=aadd,accloc=aloc,accphnno=aphnno,acctyp=atyp where accno=ano;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updcmp` (IN `ccod` INT, IN `csts` CHAR(1))  NO SQL
begin
update tbcmp set cmpsts=csts where cmpcod=ccod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updemp` (IN `ecod` INT, IN `enam` VARCHAR(100), IN `epic` VARCHAR(50), IN `eloc` VARCHAR(100), IN `ephnno` VARCHAR(100))  NO SQL
begin
update tbemp set empnam=enam,emppic=epic,emploc=eloc,empphnno=ephnno where empcod=ecod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updvst` (IN `vcod` INT, IN `vdat` INT, IN `vcmpcod` INT, IN `vdsc` INT, IN `vfet` INT)  NO SQL
begin
update tbvst set vstdat=vdat,vstcmpcod=vcmpcod,vstdsc=vdsc,vstfed=vfed where vstcod=vcod;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbacc`
--

CREATE TABLE `tbacc` (
  `accno` int(11) NOT NULL,
  `accnam` varchar(100) NOT NULL,
  `acccrtdat` datetime NOT NULL,
  `accadd` varchar(100) NOT NULL,
  `accloc` varchar(100) NOT NULL,
  `accphnno` varchar(100) NOT NULL,
  `acctyp` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbacc`
--

INSERT INTO `tbacc` (`accno`, `accnam`, `acccrtdat`, `accadd`, `accloc`, `accphnno`, `acctyp`) VALUES
(2, 'abc', '2017-07-08 00:00:00', 'ashuydgwehj', 'Chandigarh', '3223', 'BroadBand'),
(3, 'asdasfsf', '2017-07-09 00:00:00', 'qwrwqeterter', 'Panchkula', '9815701003', 'DTH');

-- --------------------------------------------------------

--
-- Table structure for table `tbcmp`
--

CREATE TABLE `tbcmp` (
  `cmpcod` int(11) NOT NULL,
  `cmpaccno` int(11) NOT NULL,
  `cmpdat` datetime NOT NULL,
  `cmpdsc` varchar(1000) NOT NULL,
  `cmpasgempcod` int(11) NOT NULL,
  `cmpsts` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbcmp`
--

INSERT INTO `tbcmp` (`cmpcod`, `cmpaccno`, `cmpdat`, `cmpdsc`, `cmpasgempcod`, `cmpsts`) VALUES
(1, 2, '2017-07-12 00:00:00', 'asd f asdf s fdas df asgf adf g adfg df gd fg dfg', 1, 'A'),
(2, 2, '2017-07-12 00:00:00', 'asdasf asdf sd df asff sdf sdf', 1, 'C');

-- --------------------------------------------------------

--
-- Table structure for table `tbemp`
--

CREATE TABLE `tbemp` (
  `empcod` int(11) NOT NULL,
  `empnam` varchar(100) NOT NULL,
  `emppic` varchar(50) NOT NULL,
  `emploc` varchar(100) NOT NULL,
  `empphnno` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbemp`
--

INSERT INTO `tbemp` (`empcod`, `empnam`, `emppic`, `emploc`, `empphnno`) VALUES
(1, 'Amit Sharma', 'team2.jpg', 'Chandigarh', '9779261111'),
(2, 'Suman', 'FilledStar.png', 'Mohali', '3454578');

-- --------------------------------------------------------

--
-- Table structure for table `tbvst`
--

CREATE TABLE `tbvst` (
  `vstcod` int(11) NOT NULL,
  `vstdat` datetime NOT NULL,
  `vstcmpcod` int(11) NOT NULL,
  `vstdsc` varchar(1000) NOT NULL,
  `vstfed` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbvst`
--

INSERT INTO `tbvst` (`vstcod`, `vstdat`, `vstcmpcod`, `vstdsc`, `vstfed`) VALUES
(1, '2016-12-12 00:00:00', 2, 'as fas dfa sdff asdg asf gadf gd', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbacc`
--
ALTER TABLE `tbacc`
  ADD PRIMARY KEY (`accno`);

--
-- Indexes for table `tbcmp`
--
ALTER TABLE `tbcmp`
  ADD PRIMARY KEY (`cmpcod`);

--
-- Indexes for table `tbemp`
--
ALTER TABLE `tbemp`
  ADD PRIMARY KEY (`empcod`);

--
-- Indexes for table `tbvst`
--
ALTER TABLE `tbvst`
  ADD PRIMARY KEY (`vstcod`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbacc`
--
ALTER TABLE `tbacc`
  MODIFY `accno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbcmp`
--
ALTER TABLE `tbcmp`
  MODIFY `cmpcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbemp`
--
ALTER TABLE `tbemp`
  MODIFY `empcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbvst`
--
ALTER TABLE `tbvst`
  MODIFY `vstcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
