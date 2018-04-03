-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le :  mar. 03 avr. 2018 à 05:47
-- Version du serveur :  5.7.21
-- Version de PHP :  7.1.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `inspiration`
--

-- --------------------------------------------------------

--
-- Structure de la table `pensee`
--

CREATE TABLE `pensee` (
  `idPensee` int(11) NOT NULL,
  `auteur` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `annee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `pensee`
--

INSERT INTO `pensee` (`idPensee`, `auteur`, `message`, `annee`) VALUES
(1, 'Douglas Kennedy', 'L\'expérience est le mot par lequel les hommes désignent leurs erreurs.', NULL),
(2, 'George Orwell', 'The Truth is Heresy in the Empire of lies.', NULL),
(3, 'St-Exupéry', 'Faites que le rêve dévore votre vie afin que la vie ne dévore pas votre rêve.', NULL),
(4, 'Leonardo da Vinci', 'Once you have tasted the taste of sky, you will forever look up.\r\n', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `pensee`
--
ALTER TABLE `pensee`
  ADD PRIMARY KEY (`idPensee`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `pensee`
--
ALTER TABLE `pensee`
  MODIFY `idPensee` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
