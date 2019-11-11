-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2019 at 05:40 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bpay`
--

-- --------------------------------------------------------

--
-- Table structure for table `continents`
--

CREATE TABLE `continents` (
  `con_id` tinyint(3) UNSIGNED NOT NULL,
  `con_title` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `continents`
--

INSERT INTO `continents` (`con_id`, `con_title`) VALUES
(1, 'EU'),
(2, 'NA');

-- --------------------------------------------------------

--
-- Table structure for table `currencies`
--

CREATE TABLE `currencies` (
  `cur_id` tinyint(3) UNSIGNED NOT NULL,
  `cur_title` varchar(3) NOT NULL,
  `cur_rate` decimal(5,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `currencies`
--

INSERT INTO `currencies` (`cur_id`, `cur_title`, `cur_rate`) VALUES
(1, 'EUR', '1.00');

-- --------------------------------------------------------

--
-- Table structure for table `custom_products_filters_values`
--

CREATE TABLE `custom_products_filters_values` (
  `csp_id` int(10) UNSIGNED NOT NULL,
  `csp_selling_id` int(10) UNSIGNED NOT NULL,
  `csp_filter_id` int(10) UNSIGNED NOT NULL,
  `csp_value` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `prod_id` int(10) UNSIGNED NOT NULL,
  `prod_title` varchar(255) NOT NULL,
  `prod_category_id` mediumint(8) UNSIGNED NOT NULL DEFAULT '1',
  `prod_descr` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`prod_id`, `prod_title`, `prod_category_id`, `prod_descr`) VALUES
(1, 'Harry Potter og vises stein', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `products_categories`
--

CREATE TABLE `products_categories` (
  `cat_id` mediumint(8) UNSIGNED NOT NULL,
  `cat_title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products_categories`
--

INSERT INTO `products_categories` (`cat_id`, `cat_title`) VALUES
(1, 'All'),
(2, 'Books');

-- --------------------------------------------------------

--
-- Table structure for table `products_filters`
--

CREATE TABLE `products_filters` (
  `fil_id` int(10) UNSIGNED NOT NULL,
  `fil_title` varchar(55) NOT NULL,
  `fil_product_category` mediumint(8) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products_filters`
--

INSERT INTO `products_filters` (`fil_id`, `fil_title`, `fil_product_category`) VALUES
(1, 'Cover', 2),
(2, 'Status', 1),
(3, 'Language', 2);

-- --------------------------------------------------------

--
-- Table structure for table `products_filter_values`
--

CREATE TABLE `products_filter_values` (
  `pfv_id` int(10) UNSIGNED NOT NULL,
  `pfv_filter_id` int(10) UNSIGNED NOT NULL,
  `pfv_value` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products_filter_values`
--

INSERT INTO `products_filter_values` (`pfv_id`, `pfv_filter_id`, `pfv_value`) VALUES
(1, 2, 'Hardcover'),
(2, 2, 'Paperback'),
(3, 2, 'Brand New'),
(4, 2, 'Used'),
(5, 3, 'Greek'),
(6, 3, 'English'),
(7, 3, 'French'),
(8, 3, 'Italian'),
(9, 3, 'German'),
(10, 3, 'Russian'),
(11, 3, 'Danish'),
(12, 3, 'Norwegian'),
(13, 3, 'Sweedish');

-- --------------------------------------------------------

--
-- Table structure for table `sellers`
--

CREATE TABLE `sellers` (
  `sel_id` int(10) UNSIGNED NOT NULL,
  `seller_usr_id` bigint(20) UNSIGNED NOT NULL,
  `sel_country` varchar(2) NOT NULL,
  `sel_title` varchar(125) NOT NULL,
  `sel_ssn` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sellers`
--

INSERT INTO `sellers` (`sel_id`, `seller_usr_id`, `sel_country`, `sel_title`, `sel_ssn`) VALUES
(1, 1, 'DK', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `selling`
--

CREATE TABLE `selling` (
  `sll_id` int(10) UNSIGNED NOT NULL,
  `sll_product_id` int(10) UNSIGNED NOT NULL,
  `sll_price` decimal(10,2) UNSIGNED NOT NULL,
  `sll_currency_id` tinyint(3) UNSIGNED NOT NULL,
  `sll_from` date NOT NULL,
  `sll_to` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `selling`
--

INSERT INTO `selling` (`sll_id`, `sll_product_id`, `sll_price`, `sll_currency_id`, `sll_from`, `sll_to`) VALUES
(1, 1, '35.00', 1, '2019-11-11', '2019-11-21');

-- --------------------------------------------------------

--
-- Table structure for table `shipping_costs`
--

CREATE TABLE `shipping_costs` (
  `shc_id` int(10) UNSIGNED NOT NULL,
  `shc_selling_id` int(10) UNSIGNED NOT NULL,
  `shc_continent_id` tinyint(3) UNSIGNED NOT NULL,
  `shc_cost` decimal(10,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shipping_costs`
--

INSERT INTO `shipping_costs` (`shc_id`, `shc_selling_id`, `shc_continent_id`, `shc_cost`) VALUES
(1, 1, 1, '7.00'),
(2, 1, 2, '12.00');

-- --------------------------------------------------------

--
-- Table structure for table `shipping_costs_exceptions`
--

CREATE TABLE `shipping_costs_exceptions` (
  `shc_id` int(10) UNSIGNED NOT NULL,
  `shc_selling_id` int(10) UNSIGNED NOT NULL,
  `shc_country_id` tinyint(3) UNSIGNED NOT NULL,
  `shc_cost` decimal(10,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shipping_country_forbidden`
--

CREATE TABLE `shipping_country_forbidden` (
  `shf_id` int(11) NOT NULL,
  `shf_selling_id` int(11) NOT NULL,
  `shf_contry_id` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `email_verified_at`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'Nordic World', '', NULL, '', NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `continents`
--
ALTER TABLE `continents`
  ADD PRIMARY KEY (`con_id`),
  ADD UNIQUE KEY `con_title` (`con_title`);

--
-- Indexes for table `currencies`
--
ALTER TABLE `currencies`
  ADD PRIMARY KEY (`cur_id`),
  ADD UNIQUE KEY `cur_title` (`cur_title`);

--
-- Indexes for table `custom_products_filters_values`
--
ALTER TABLE `custom_products_filters_values`
  ADD PRIMARY KEY (`csp_id`),
  ADD KEY `csp_selling_id` (`csp_selling_id`),
  ADD KEY `csp_filter_id` (`csp_filter_id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`prod_id`),
  ADD KEY `prod_category_id` (`prod_category_id`);

--
-- Indexes for table `products_categories`
--
ALTER TABLE `products_categories`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indexes for table `products_filters`
--
ALTER TABLE `products_filters`
  ADD PRIMARY KEY (`fil_id`),
  ADD UNIQUE KEY `fil_title` (`fil_title`),
  ADD KEY `fil_product_category` (`fil_product_category`);

--
-- Indexes for table `products_filter_values`
--
ALTER TABLE `products_filter_values`
  ADD PRIMARY KEY (`pfv_id`),
  ADD KEY `pfv_filter_id` (`pfv_filter_id`);

--
-- Indexes for table `sellers`
--
ALTER TABLE `sellers`
  ADD PRIMARY KEY (`sel_id`),
  ADD KEY `seller_usr_id` (`seller_usr_id`);

--
-- Indexes for table `selling`
--
ALTER TABLE `selling`
  ADD PRIMARY KEY (`sll_id`),
  ADD KEY `sll_currency_id` (`sll_currency_id`),
  ADD KEY `sll_product_id` (`sll_product_id`);

--
-- Indexes for table `shipping_costs`
--
ALTER TABLE `shipping_costs`
  ADD PRIMARY KEY (`shc_id`),
  ADD KEY `shc_selling_id` (`shc_selling_id`),
  ADD KEY `shc_continent_id` (`shc_continent_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `currencies`
--
ALTER TABLE `currencies`
  MODIFY `cur_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `custom_products_filters_values`
--
ALTER TABLE `custom_products_filters_values`
  MODIFY `csp_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `prod_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `products_categories`
--
ALTER TABLE `products_categories`
  MODIFY `cat_id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `products_filters`
--
ALTER TABLE `products_filters`
  MODIFY `fil_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `products_filter_values`
--
ALTER TABLE `products_filter_values`
  MODIFY `pfv_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `sellers`
--
ALTER TABLE `sellers`
  MODIFY `sel_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `selling`
--
ALTER TABLE `selling`
  MODIFY `sll_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `shipping_costs`
--
ALTER TABLE `shipping_costs`
  MODIFY `shc_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `custom_products_filters_values`
--
ALTER TABLE `custom_products_filters_values`
  ADD CONSTRAINT `custom_products_filters_values_ibfk_1` FOREIGN KEY (`csp_filter_id`) REFERENCES `products_filters` (`fil_id`),
  ADD CONSTRAINT `custom_products_filters_values_ibfk_2` FOREIGN KEY (`csp_selling_id`) REFERENCES `selling` (`sll_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`prod_category_id`) REFERENCES `products_categories` (`cat_id`);

--
-- Constraints for table `products_filters`
--
ALTER TABLE `products_filters`
  ADD CONSTRAINT `products_filters_ibfk_1` FOREIGN KEY (`fil_product_category`) REFERENCES `products_categories` (`cat_id`);

--
-- Constraints for table `products_filter_values`
--
ALTER TABLE `products_filter_values`
  ADD CONSTRAINT `products_filter_values_ibfk_1` FOREIGN KEY (`pfv_filter_id`) REFERENCES `products_filters` (`fil_id`);

--
-- Constraints for table `sellers`
--
ALTER TABLE `sellers`
  ADD CONSTRAINT `sellers_ibfk_1` FOREIGN KEY (`seller_usr_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `selling`
--
ALTER TABLE `selling`
  ADD CONSTRAINT `selling_ibfk_1` FOREIGN KEY (`sll_product_id`) REFERENCES `products` (`prod_id`),
  ADD CONSTRAINT `selling_ibfk_2` FOREIGN KEY (`sll_currency_id`) REFERENCES `currencies` (`cur_id`);

--
-- Constraints for table `shipping_costs`
--
ALTER TABLE `shipping_costs`
  ADD CONSTRAINT `shipping_costs_ibfk_1` FOREIGN KEY (`shc_continent_id`) REFERENCES `continents` (`con_id`),
  ADD CONSTRAINT `shipping_costs_ibfk_2` FOREIGN KEY (`shc_selling_id`) REFERENCES `selling` (`sll_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
