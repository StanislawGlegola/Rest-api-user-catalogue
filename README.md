"# Rest-api-user-catalog is a dojo project realized in spare time to summarize knowledge. <br> It revolve around combining various technologies in single repository.
Notice that it can risk with suboptimal code appliance in this particular project. <br>
But as I mentioned - it's a dojo."

<strong>DB login credentials added in environment variables:</strong>
<em>
<br>DB_USERNAME=root;
<br>DB_PASSWORD=p@55w0rd;
<br>DB_HOST=localhost;
<br>DB_PORT=3306;
<br>DB_SID=twitter;
</em>

<strong>Access to swagger-ui</strong><br>
<em>http://localhost:8080/swagger-ui.html <br></em>

<strong>Docker compose this project</strong><br>
<em>docker-compose up -d </em>

<strong>Installation and lunching mysql database</strong><br>
<em>
docker pull mysql <br>
docker run --name twitter-mysql -e MYSQL_ROOT_PASSWORD=p@55w0rd -d -p 3306:3306 mysql <br>
</em>