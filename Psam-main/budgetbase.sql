-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 23 Lis 2024, 15:39
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `budgetbase`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `budget`
--

CREATE TABLE `budget` (
  `Id_budget` int(11) NOT NULL,
  `Id_income` int(11) NOT NULL,
  `Id_expense` int(11) NOT NULL,
  `Limit_budget` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `expense`
--

CREATE TABLE `expense` (
  `Id_expense` int(11) NOT NULL,
  `Amount` float NOT NULL,
  `Repetetive` tinyint(1) NOT NULL,
  `Period` int(11) NOT NULL,
  `Description` text NOT NULL,
  `Category` text NOT NULL,
  `Period_start` date NOT NULL,
  `Period_end` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `income`
--

CREATE TABLE `income` (
  `Id_income` int(11) NOT NULL,
  `Amount` double NOT NULL,
  `Repetetive` tinyint(1) NOT NULL,
  `Period` int(11) NOT NULL,
  `Period_start` date NOT NULL,
  `Period_end` date NOT NULL,
  `Description` text NOT NULL,
  `Category` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `Id_user` int(11) NOT NULL,
  `Login` varchar(28) NOT NULL,
  `Password` varchar(28) NOT NULL,
  `First_name` varchar(11) NOT NULL,
  `Second_name` varchar(20) NOT NULL,
  `Id_budget` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `budget`
--
ALTER TABLE `budget`
  ADD PRIMARY KEY (`Id_budget`),
  ADD KEY `Id_expense` (`Id_expense`),
  ADD KEY `Id_income` (`Id_income`);

--
-- Indeksy dla tabeli `expense`
--
ALTER TABLE `expense`
  ADD PRIMARY KEY (`Id_expense`);

--
-- Indeksy dla tabeli `income`
--
ALTER TABLE `income`
  ADD PRIMARY KEY (`Id_income`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id_user`),
  ADD KEY `Id_budget` (`Id_budget`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `budget`
--
ALTER TABLE `budget`
  MODIFY `Id_budget` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `expense`
--
ALTER TABLE `expense`
  MODIFY `Id_expense` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `income`
--
ALTER TABLE `income`
  MODIFY `Id_income` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `Id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `budget`
--
ALTER TABLE `budget`
  ADD CONSTRAINT `budget_ibfk_1` FOREIGN KEY (`Id_expense`) REFERENCES `expense` (`Id_expense`),
  ADD CONSTRAINT `budget_ibfk_2` FOREIGN KEY (`Id_income`) REFERENCES `income` (`Id_income`);

--
-- Ograniczenia dla tabeli `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`Id_budget`) REFERENCES `budget` (`Id_budget`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
