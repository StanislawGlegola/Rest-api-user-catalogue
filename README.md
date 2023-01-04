"# Rest-api-user-catalogue"
DB login credentials added by environment variables:

DB_URL=jdbc:mysql://localhost:3306/userCatalogue?useSSL=false;
DB_USERNAME=root;
DB_PASSWORD=p@55w0rd

Instalacja i uruchomienie obrazu bazy danych
docker pull mysql
docker run --name usercatalogue-mysql -e MYSQL_ROOT_PASSWORD=p@55w0rd -d -p 3306:3306 mysql

Tworzenie tabeli
CREATE TABLE `usercatalogue`.`user` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NULL,
`age` INT NULL,
PRIMARY KEY (`id`));
