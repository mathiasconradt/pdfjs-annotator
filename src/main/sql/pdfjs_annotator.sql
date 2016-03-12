SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `annotation`;
CREATE TABLE `annotation` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `annotator_schema_version` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `consumer` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `quote` longtext COLLATE utf8_bin,
  `end` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `end_offset` int(11) DEFAULT NULL,
  `start` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `start_offset` int(11) DEFAULT NULL,
  `tags` tinyblob,
  `text` longtext COLLATE utf8_bin,
  `updated` datetime DEFAULT NULL,
  `uri` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  `user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
