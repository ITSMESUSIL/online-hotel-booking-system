-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 09, 2022 at 09:25 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `luton`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `Billing_ID` int(11) NOT NULL,
  `bookingid` int(11) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `VAT` int(10) DEFAULT NULL,
  `Service_Charge` int(11) NOT NULL,
  `Room_Price` int(10) DEFAULT NULL,
  `Total_Bill` double(20,1) DEFAULT NULL,
  `Biiling_Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`Billing_ID`, `bookingid`, `Name`, `VAT`, `Service_Charge`, `Room_Price`, `Total_Bill`, `Biiling_Status`) VALUES
(1, 34, 'Hancie', 13, 500, 0, 500.0, 'Paid'),
(2, 36, 'Sushil Kathayat', 13, 500, -2000, -1760.0, 'Paid'),
(3, 49, 'Sushil Kathayat', 13, 500, 4000, 5020.0, 'Paid'),
(4, 50, 'Sushil Kathayat', 13, 500, 2000, 2760.0, 'Paid'),
(5, 48, 'Sushil Kathayat', 13, 300, 14000, 16320.0, 'Paid'),
(6, 35, 'Hancie', 13, 300, 0, 500.0, 'Paid'),
(7, 37, 'Sushil Kathayat', 13, 300, -1000, -630.0, 'Paid'),
(8, 51, 'Sushil Kathayat', 13, 300, 0, 500.0, 'Paid'),
(9, 53, 'Sushil Kathayat', 13, 300, 16000, 18580.0, 'Paid');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingid` int(11) NOT NULL,
  `bookingdate` varchar(50) NOT NULL,
  `checkindate` varchar(50) NOT NULL,
  `checkoutdate` varchar(50) NOT NULL,
  `BookingType` varchar(50) NOT NULL,
  `bookingstatus` varchar(50) NOT NULL,
  `Custid` int(11) DEFAULT NULL,
  `roomno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingid`, `bookingdate`, `checkindate`, `checkoutdate`, `BookingType`, `bookingstatus`, `Custid`, `roomno`) VALUES
(34, '2022-09-06', '2022-09-08', '2022-09-08', 'Single bed ', 'Inactive', 2, 11),
(35, '2022-09-06', '2022-09-07', '2022-09-07', 'Single bed ', 'Inactive', 2, 11),
(36, '2022-09-21', '2022-09-22', '2022-09-21', 'Single bed ', 'Inactive', 1, 22),
(37, '2022-09-15', '2022-09-22', '2022-09-21', 'Single bed ', 'Inactive', 1, 11),
(48, '2022-09-08', '2022-09-08', '2022-09-15', 'Single bed ', 'Inactive', 1, 22),
(49, '2022-09-07', '2022-09-07', '2022-09-09', 'Single bed ', 'Inactive', 1, 22),
(50, '2022-09-07', '2022-09-07', '2022-09-09', 'Double bed', 'Inactive', 1, 20),
(51, '2022-09-08', '2022-09-09', '2022-09-09', 'Single bed ', 'Inactive', 1, 11),
(53, '2022-09-21', '2022-09-22', '2022-09-30', 'Double bed', 'Inactive', 1, 14);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustId` int(10) NOT NULL,
  `Customer_Name` varchar(50) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Create_password` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `Creaditcard_Number` varchar(50) NOT NULL,
  `Gender` varchar(60) NOT NULL,
  `CustomerType` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustId`, `Customer_Name`, `Country`, `Address`, `Email`, `Create_password`, `phone`, `Creaditcard_Number`, `Gender`, `CustomerType`) VALUES
(1, 'Sushil Kathayat', 'Nepal', 'KTM', 'sushil@gmail.com', '1234', '9876545454', '12345678', 'Male', 'Customer'),
(2, 'Rahul', 'nepal', 'kupandole', 'hancie@gmail.com', '1234', '9825915122', '12345', 'Male', 'Customer'),
(3, 'Nikisha', 'Nepal', 'KTM', 'nikisha@gmail.com', '1234', '9835654324', '53455654657578', 'Male', 'Receptionist'),
(74, 'nitesh', 'nepal', 'ktm', 'nitesh@gmail.com', 'nitesh', '987654', '123456', 'Male', 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomno` int(10) NOT NULL,
  `roomtype` varchar(50) NOT NULL,
  `rate` int(10) DEFAULT NULL,
  `roomstatus` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomno`, `roomtype`, `rate`, `roomstatus`) VALUES
(10, 'double', 1000, 'Available'),
(11, 'Single Bed', 1000, 'Available'),
(12, 'Double Bed', 1000, 'Available'),
(14, 'Double Bed', 2000, 'Available'),
(15, 'Double Bed', 1000, 'Available'),
(20, 'Double Bed', 1000, 'Available'),
(22, 'Single Bed', 2000, 'Available'),
(110, 'Single Bed', 1000, 'Available'),
(205, 'Single Bed', 1000, 'Available'),
(206, 'Single Bed', 3000, 'Available'),
(207, 'Single Bed', 1000, 'Available'),
(211, 'Single Bed', 1000, 'Available');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`Billing_ID`),
  ADD KEY `bookingid` (`bookingid`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingid`),
  ADD KEY `Custid` (`Custid`),
  ADD KEY `roomno` (`roomno`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustId`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billing`
--
ALTER TABLE `billing`
  MODIFY `Billing_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `roomno` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=212;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billing`
--
ALTER TABLE `billing`
  ADD CONSTRAINT `billing_ibfk_1` FOREIGN KEY (`bookingid`) REFERENCES `booking` (`bookingid`);

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`Custid`) REFERENCES `customer` (`CustId`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`roomno`) REFERENCES `room` (`roomno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
