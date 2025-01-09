-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Jan 2025 pada 17.48
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_uas_1123019`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `category`
--

INSERT INTO `category` (`category_id`, `category_type`) VALUES
(1, 'Regular'),
(2, 'Fast'),
(3, 'Super Fast');

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `cust_id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`cust_id`, `password`, `name`, `address`, `phone`) VALUES
(1, 'abcd', 'alfons', 'jl hehe', '08123'),
(2, 'abcde', 'reivel', 'jlhihi', '0821'),
(3, 'abcde', 'Steven', 'jlaiueo', '081234'),
(4, 'abcdef', 'mario', 'jlmario', '0855');

-- --------------------------------------------------------

--
-- Struktur dari tabel `shipment_details`
--

CREATE TABLE `shipment_details` (
  `shipment_id` int(11) NOT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `status` enum('pending','transit','delivered') DEFAULT NULL,
  `current_position` varchar(255) DEFAULT NULL,
  `evidence` varchar(255) DEFAULT NULL,
  `date` date DEFAULT curdate(),
  `updated_by` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `shipment_details`
--

INSERT INTO `shipment_details` (`shipment_id`, `transaction_id`, `status`, `current_position`, `evidence`, `date`, `updated_by`) VALUES
(1, 1, 'pending', 'gudang', 'C:/steven/UAS PBO-1123019-StevenPangestu/src/logo.jpg', '2025-01-09', 'ADMIN'),
(2, 2, 'pending', 'gudang', 'C:/steven/logo.png', '2025-01-09', 'ADMIN');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `cust_id` int(11) DEFAULT NULL,
  `package_type` int(11) DEFAULT NULL,
  `package_weight` double DEFAULT NULL,
  `total_cost` int(11) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `receipt_name` varchar(255) DEFAULT NULL,
  `receipt_address` varchar(255) DEFAULT NULL,
  `receipt_phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaction`
--

INSERT INTO `transaction` (`id`, `cust_id`, `package_type`, `package_weight`, `total_cost`, `created_at`, `receipt_name`, `receipt_address`, `receipt_phone`) VALUES
(1, 2, 3, 2.5, 3, '2025-01-09', 'reivelzz', 'jlhihi', '0821'),
(2, 4, 2, 4.5, 5, '2025-01-09', 'marioooo', 'jlmario123', '0855');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cust_id`);

--
-- Indeks untuk tabel `shipment_details`
--
ALTER TABLE `shipment_details`
  ADD PRIMARY KEY (`shipment_id`),
  ADD KEY `transaction_id` (`transaction_id`);

--
-- Indeks untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cust_id` (`cust_id`),
  ADD KEY `package_type` (`package_type`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `cust_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `shipment_details`
--
ALTER TABLE `shipment_details`
  MODIFY `shipment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `shipment_details`
--
ALTER TABLE `shipment_details`
  ADD CONSTRAINT `shipment_details_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`);

--
-- Ketidakleluasaan untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`package_type`) REFERENCES `category` (`category_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
