"# Rest-api-user-catalog"
DB login credentials added by environment variables:

DB_URL=jdbc:mysql://localhost:3306/userCatalog?useSSL=false;
DB_USERNAME=root;
DB_PASSWORD=p@55w0rd;
DB_DRIVER=com.mysql.cj.jdbc.Driver

Instalacja i uruchomienie obrazu bazy danych
docker pull mysql
docker run --name usercatalog-mysql -e MYSQL_ROOT_PASSWORD=p@55w0rd -d -p 3306:3306 mysql

Tworzenie tabeli
CREATE TABLE `userCatalog`.`user` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NULL,
`age` INT NULL,
PRIMARY KEY (`id`));
