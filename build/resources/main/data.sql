DROP TABLE IF EXISTS `user`;
CREATE TABLE user(id BIGINT(20) AUTO_INCREMENT, user_name VARCHAR (255), password VARCHAR (255), image VARCHAR (255), history_entrance LONG, entrance_by_day LONG, entrance_by_month LONG, embedding_image VARCHAR (5000));

DROP TABLE IF EXISTS `userEntrance`;
CREATE TABLE userEntrance(id BIGINT(20000) AUTO_INCREMENT, user_id BIGINT(2000000), history_entrance LONGBLOB, entrance_by_day LONGBLOB, entrance_by_month LONGBLOB);

DROP TABLE IF EXISTS `friendshiprequest`;
CREATE TABLE friendshiprequest(id BIGINT(20) AUTO_INCREMENT, user_from VARCHAR (255), user_to VARCHAR (255), status VARCHAR (255), `date_created` DATETIME,`date_last_modified`DATETIME);

DROP TABLE IF EXISTS `recording`;
CREATE TABLE recording(id BIGINT(20) AUTO_INCREMENT, embedding_image VARCHAR (5000) NOT NULL, position VARCHAR (255), image VARCHAR (255), user_id BIGINT(20) );

DROP TABLE IF EXISTS `productIdentifier`;
CREATE TABLE productIdentifier(
 id BIGINT(20) AUTO_INCREMENT,
 urlQrId VARCHAR (500) NOT NULL,
 name VARCHAR (500) ,
 description VARCHAR (500),
 dinamic_url VARCHAR (500),
 `date_created` DATETIME
 );

INSERT INTO productIdentifier (urlQrId, name, description, dinamic_url, date_created)
VALUES ("12343554", "Terreno Carrizal", "terreno Carrizal para la venta",
 "https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109"
 );