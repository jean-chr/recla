-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 12 fév. 2022 à 22:05
-- Version du serveur : 8.0.27
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `reclamation`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `idadmin` int NOT NULL AUTO_INCREMENT,
  `email` char(50) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `contact` int DEFAULT NULL,
  `pswd` char(50) DEFAULT NULL,
  `statut` enum('1','2') DEFAULT NULL,
  PRIMARY KEY (`idadmin`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`idadmin`, `email`, `nom`, `prenom`, `contact`, `pswd`, `statut`) VALUES
(1, 'jeanchristbodjona@gmail.com', 'BODJONA', 'jean-christ', 93096475, '1234', '');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `idenseignant` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) DEFAULT NULL,
  `prenom` varchar(40) DEFAULT NULL,
  `email` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pswd` char(50) DEFAULT NULL,
  `departement` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idenseignant`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`idenseignant`, `nom`, `prenom`, `email`, `pswd`, `departement`) VALUES
(3, 'test', 'BODJONA2', 'jean2@gmail.tg', '1234', 'angl'),
(2, 'christ', 'BODJONA1', 'jean1@gmail.tg', '1234', 'pc'),
(1, 'jean', 'BODJONA', 'jean@gmail.tg', '1234', 'Chimie');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `idetudiant` int NOT NULL AUTO_INCREMENT,
  `pswd` char(50) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `departement` varchar(45) NOT NULL,
  PRIMARY KEY (`idetudiant`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`idetudiant`, `pswd`, `nom`, `prenom`, `departement`) VALUES
(2, '1234', 'BODJO', 'supinfo', 'informatique'),
(1, '1234', 'christ', 'BOD', 'informatique');

-- --------------------------------------------------------

--
-- Structure de la table `reclamer`
--

DROP TABLE IF EXISTS `reclamer`;
CREATE TABLE IF NOT EXISTS `reclamer` (
  `idreclamer` int NOT NULL AUTO_INCREMENT,
  `statut` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idue` int NOT NULL,
  `idenseignant` int NOT NULL,
  `note` int NOT NULL,
  `idetudiant` int NOT NULL,
  `date` text NOT NULL,
  PRIMARY KEY (`idreclamer`),
  KEY `idenseignant` (`idenseignant`),
  KEY `idetudiant` (`idetudiant`),
  KEY `idue` (`idue`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ue`
--

DROP TABLE IF EXISTS `ue`;
CREATE TABLE IF NOT EXISTS `ue` (
  `idue` int NOT NULL AUTO_INCREMENT,
  `idenseignant` int NOT NULL,
  `idetudiant` int NOT NULL,
  `departement` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `note` int DEFAULT NULL,
  PRIMARY KEY (`idue`),
  KEY `idetudiant_idx` (`idetudiant`),
  KEY `idenseignant` (`idenseignant`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `ue`
--

INSERT INTO `ue` (`idue`, `idenseignant`, `idetudiant`, `departement`, `note`) VALUES
(18, 1, 1, 'chimie', 10);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
