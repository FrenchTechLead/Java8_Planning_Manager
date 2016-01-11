-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Client: sql4.freesqldatabase.com
-- Généré le: Lun 11 Janvier 2016 à 17:28
-- Version du serveur: 5.5.46-0ubuntu0.12.04.2
-- Version de PHP: 5.3.28

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `sql4100703`
--

-- --------------------------------------------------------

--
-- Structure de la table `batiments`
--

CREATE TABLE IF NOT EXISTS `batiments` (
  `batiment_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_batiment` varchar(11) NOT NULL,
  `nombre_etages` int(11) NOT NULL,
  PRIMARY KEY (`batiment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `batiments`
--

INSERT INTO `batiments` (`batiment_id`, `nom_batiment`, `nombre_etages`) VALUES
(1, 'P1', 1),
(2, 'P2', 3),
(3, 'P3', 4),
(4, 'P4', 5);

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE IF NOT EXISTS `cours` (
  `liste_cours_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_cours` varchar(50) NOT NULL,
  `prof_responsable` varchar(50) NOT NULL,
  PRIMARY KEY (`liste_cours_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`liste_cours_id`, `nom_cours`, `prof_responsable`) VALUES
(1, 'Types', 'Varacca'),
(2, 'Python', 'Vanier'),
(3, 'Modelisation', 'Tan');

-- --------------------------------------------------------

--
-- Structure de la table `promos`
--

CREATE TABLE IF NOT EXISTS `promos` (
  `promo_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`promo_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `promos`
--

INSERT INTO `promos` (`promo_id`, `nom`) VALUES
(1, 'M1_Info'),
(2, 'L3_Spi'),
(3, 'L3_Info');

-- --------------------------------------------------------

--
-- Structure de la table `salles`
--

CREATE TABLE IF NOT EXISTS `salles` (
  `salle_id` int(255) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `etage` int(255) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `batiment_id` int(11) NOT NULL,
  `id_voisin_precedent` int(11) NOT NULL,
  `id_voisin_suivant` int(11) NOT NULL,
  PRIMARY KEY (`salle_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `salles`
--

INSERT INTO `salles` (`salle_id`, `type`, `etage`, `nom`, `batiment_id`, `id_voisin_precedent`, `id_voisin_suivant`) VALUES
(1, 'td', 1, '13', 1, 0, 2),
(2, 'td', 1, '20', 1, 1, 3),
(3, 'Tp_Info', 1, '10', 3, 0, 4),
(4, 'Tp_Chimie', 1, '11', 3, 3, 5),
(5, 'cm', 2, '22', 2, 0, 0),
(13, 'cm', 2, '67', 2, 5, 0),
(14, 'td', 1, '43', 1, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `seances`
--

CREATE TABLE IF NOT EXISTS `seances` (
  `seance_id` int(11) NOT NULL AUTO_INCREMENT,
  `heure_debut` datetime NOT NULL,
  `heure_fin` datetime NOT NULL,
  `cours_id` int(11) NOT NULL,
  `salle_id` int(11) NOT NULL,
  `prof_id` int(11) NOT NULL,
  `promo_id` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`seance_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Contenu de la table `seances`
--

INSERT INTO `seances` (`seance_id`, `heure_debut`, `heure_fin`, `cours_id`, `salle_id`, `prof_id`, `promo_id`, `type`) VALUES
(1, '2015-09-17 13:30:00', '2015-09-17 15:30:00', 1, 1, 1, 1, 'cm'),
(2, '2015-09-16 13:00:00', '2015-09-16 16:00:00', 2, 2, 1, 1, 'td'),
(3, '2015-09-17 17:00:00', '2015-09-17 18:00:00', 2, 1, 2, 1, 'td'),
(6, '2016-01-21 00:00:00', '2016-01-21 00:00:00', 1, 1, 1, 1, 'cm'),
(18, '1970-01-01 01:00:00', '1970-01-01 01:00:00', 1, 1, 3, 1, 'toto'),
(19, '2016-01-17 10:00:00', '2016-01-17 11:00:00', 1, 1, 3, 1, 'td'),
(20, '2016-01-20 12:00:00', '2016-01-20 13:00:00', 1, 5, 3, 1, 'cm'),
(21, '2016-01-20 12:00:00', '2016-01-20 13:00:00', 1, 5, 3, 1, 'cm'),
(22, '2016-01-17 18:00:00', '2016-01-17 20:00:00', 2, 5, 6, 1, 'cm'),
(23, '2016-01-18 12:00:00', '2016-01-18 13:00:00', 2, 2, 6, 1, 'td'),
(24, '2016-01-10 02:00:00', '2016-01-10 04:00:00', 2, 1, 6, 1, 'td');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_user` varchar(50) NOT NULL,
  `type_user` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`user_id`, `nom_user`, `type_user`) VALUES
(1, 'MECHERI', 'Etudiant'),
(2, 'Fethi', 'Etudiant'),
(3, 'Varacca', 'Prof'),
(4, 'Rouge', 'Admin'),
(6, 'Vanier', 'Prof'),
(7, 'Tan', 'Prof'),
(8, 'Chris', 'Etudiant'),
(9, 'Verlan', 'Prof');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
