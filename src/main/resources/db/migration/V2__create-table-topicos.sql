DROP TABLE IF EXISTS `topicos`;
CREATE TABLE `topicos` (
  `id` bigint NOT NULL,
  `uid_usuario` bigint DEFAULT NULL,
  `nombre_curso` varchar(100) DEFAULT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `mensaje` varchar(255) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid_usuario` (`uid_usuario`),
  CONSTRAINT `topicos_ibfk_1` FOREIGN KEY (`uid_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
