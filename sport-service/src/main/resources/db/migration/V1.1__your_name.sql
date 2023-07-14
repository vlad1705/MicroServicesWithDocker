DROP TABLE IF EXISTS `sport_description`;

CREATE TABLE `sport_description` (
                                     `id` int NOT NULL AUTO_INCREMENT,
                                     `sport_name` varchar(45) DEFAULT NULL,
                                     `student_id` varchar(45) DEFAULT NULL,
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `sport_description` (`id`, `sport_name`, `student_id`) VALUES
                                                                       (1, 'swimming', '1'),
                                                                       (2, 'boxing', '2'),
                                                                       (3, 'football', '3'),
                                                                       (4, 'gym', '4'),
                                                                       (8, 'karate', '5'),
                                                                       (10, 'boxing', '3');
