DROP TABLE IF EXISTS `user`;
CREATE TABLE user(id BIGINT(20) AUTO_INCREMENT, user_name VARCHAR (255), password VARCHAR (255), image VARCHAR (255), history_entrance LONGTEXT, entrance_by_day LONGTEXT, entrance_by_month LONGTEXT);

DROP TABLE IF EXISTS `userEntrance`;
CREATE TABLE userEntrance(id BIGINT(20000) AUTO_INCREMENT, user_id BIGINT(2000000), history_entrance LONGTEXT, entrance_by_day LONGTEXT, entrance_by_month LONGTEXT);

DROP TABLE IF EXISTS `friendshiprequest`;
CREATE TABLE friendshiprequest(id BIGINT(20) AUTO_INCREMENT, user_from VARCHAR (255), user_to VARCHAR (255), status VARCHAR (255), `date_created` DATETIME,`date_last_modified`DATETIME);

DROP TABLE IF EXISTS `recording`;
CREATE TABLE recording(id BIGINT(20) AUTO_INCREMENT, embedding_image VARCHAR (5000) NOT NULL, position VARCHAR (255), image VARCHAR (255), user_id BIGINT(20) );