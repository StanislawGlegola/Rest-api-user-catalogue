"# Rest-api-user-catalog is a dojo project realized in spare time to summarize knowledge. <br> It revolve around combining various technologies in single repository.
Notice that it can risk with suboptimal code appliance in this particular project. <br>
But as I mentioned - it's a dojo."

<strong>DB login credentials added in environment variables:</strong>
<br>
<em>
MYSQL_DB_URL=jdbc:mysql://localhost:3306/userCatalog?allowPublicKeyRetrieval=true&useSSL=false;
<br>MYSQL_DB_USERNAME=root;
<br>MYSQL_DB_PASSWORD=p@55w0rd;
<br>MYSQL_DB_DRIVER=com.mysql.cj.jdbc.Driver;
<br>MYSQL_DB_HOST=localhost;
<br>MYSQL_DB_PORT=3306;
<br>MYSQL_DB_SID=userCatalog;
<br>ORACLE_DB_URL=jdbc:oracle://localhost:1521/userCatalog;
<br>ORACLE_DB_USERNAME=root;
<br>ORACLE_DB_PASSWORD=p@55w0rd;
<br>ORACLE_DB_DRIVER=oracle.jdbc.OracleDriver;
<br>ORACLE_DB_HOST=localhost;
<br>ORACLE_DB_PORT=1521;
<br>ORACLE_DB_SID=userCatalog-oracle
</em>

<strong>Access to swagger-ui</strong><br>
<em>http://localhost:8080/swagger-ui.html <br></em>

<strong>Docker compose this project</strong><br>
<em>docker-compose up -d </em>

<--      Below deprecated. Will soon be deleted    --!>

<strong>Installation and lunching mysql database</strong><br>
<em>
docker pull mysql <br>
docker run --name userCatalog-mysql -e MYSQL_ROOT_PASSWORD=p@55w0rd -d -p 3306:3306 mysql <br>
</em>

<strong>Installation and lunching oracle database</strong><br>
<em>
docker login container-registry.oracle.com <br>
https://container-registry.oracle.com/ords/f?p=113:4:115147643125591:::4:P4_REPOSITORY,AI_REPOSITORY,AI_REPOSITORY_NAME,P4_REPOSITORY_NAME,P4_EULA_ID,P4_BUSINESS_AREA_ID:9,9,Oracle%20Database%20Enterprise%20Edition,Oracle%20Database%20Enterprise%20Edition,1,0&cs=3qvhOCzFe_YFthGH4ePyb0rMp0SLlP222RUJM1IJja8DYckLVkPdOhrKQpOmF3VnfIOo3choGVKQWffs12MPPsA
<br>
docker run -d --name userCatalog-oracle -e ORACLE_SID=userCatalog -e ORACLE_PDB=root -e ORACLE_PWD=p@55w0rd -p 1521:1521 --shm-size="8g" container-registry.oracle.com/database/enterprise:21.3.0.0
<br></em>
