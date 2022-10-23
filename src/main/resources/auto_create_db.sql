CREATE TABLE if not exists`log` (
  `event_id` bigint  NOT NULL AUTO_INCREMENT,
  `event_date` datetime DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `logger` text,
  `message` text,
  `throwable` text,
  PRIMARY KEY (`event_id`),
  UNIQUE KEY `event_id` (`event_id`)
);