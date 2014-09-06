SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Tabelstructuur voor tabel `class`
--

CREATE TABLE IF NOT EXISTS `class` (
  `class_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `class_name` varchar(10) NOT NULL,
  `teacher_id` int(10) unsigned NOT NULL COMMENT 'Mentor',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Gegevens worden geëxporteerd voor tabel `class`
--

INSERT INTO `class` (`class_id`, `class_name`, `teacher_id`) VALUES
(1, 'IT-Putje', 1),
(2, 'IT-Bagger', 2);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `student_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `student_number` int(7) unsigned zerofill NOT NULL,
  `student_firstname` varchar(30) NOT NULL,
  `student_inserts` varchar(10) DEFAULT NULL,
  `student_surname` varchar(30) NOT NULL,
  `class_id` int(10) unsigned NOT NULL,
  `api_key` varchar(256) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Gegevens worden geëxporteerd voor tabel `students`
--

INSERT INTO `students` (`student_id`, `student_number`, `student_firstname`, `student_inserts`, `student_surname`, `class_id`, `api_key`) VALUES
(1, 0999001, 'Joop', NULL, 'Kopstoot', 1, '0999001'),
(2, 0999002, 'Koos', NULL, 'Klaproos', 1, '0999002'),
(3, 0999003, 'Truus', NULL, 'Molensteen', 2, '0999003'),
(4, 0999004, 'Miep', 'von', 'Truusenstein', 2, '0999004'),
(5, 0999005, 'Wilhem', 'van', 'Hot naar Her', 2, '0999005'),
(6, 0999006, 'Fabiola', NULL, 'Kaaskraker', 1, '0999006');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `teachers`
--

CREATE TABLE IF NOT EXISTS `teachers` (
  `teacher_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_firstname` varchar(30) NOT NULL,
  `teacher_inserts` varchar(10) DEFAULT NULL,
  `teacher_surname` varchar(30) NOT NULL,
  `teacher_abbr` varchar(3) NOT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Gegevens worden geëxporteerd voor tabel `teachers`
--

INSERT INTO `teachers` (`teacher_id`, `teacher_firstname`, `teacher_inserts`, `teacher_surname`, `teacher_abbr`) VALUES
(1, 'Bertus', 'op de', 'Kast', 'KST'),
(2, 'Tinus', '', 'Tranendal', 'TRA');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
