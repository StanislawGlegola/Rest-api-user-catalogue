"# Rest-api-user-catalog is a dojo project realized in spare time to summarize knowledge. <br> It revolve around combining various technologies in single repository.
Notice that it can risk with suboptimal code appliance in this particular project. <br>
But as I mentioned - it's just a dojo."

<strong>DB login credentials added with environment variables:</strong>
<br>
<em>
DB_URL=jdbc:mysql://localhost:3306/userCatalog?allowPublicKeyRetrieval=true&useSSL=false; <br>
DB_USERNAME=root; <br>
DB_PASSWORD=p@55w0rd; <br>
DB_DRIVER=com.mysql.cj.jdbc.Driver; <br>
DB_HOST=localhost; <br>
DB_PORT=3306; <br>
DB_SID=userCatalog <br>
</em>

<strong>Instalation and lunching data base</strong><br>
<em>
docker pull mysql <br>
docker run --name usercatalog-mysql -e MYSQL_ROOT_PASSWORD=p@55w0rd -d -p 3306:3306 mysql <br>
</em>

<strong>Creating sql table</strong><br>
<em>
CREATE TABLE `userCatalog`.`user` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NULL,
`age` INT NULL,
PRIMARY KEY (`id`));
</em>
<br>

<strong>Access to swagger-ui</strong><br>
<em>http://localhost:8080/swagger-ui.html <br></em>