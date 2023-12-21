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
<br>
docker run -d --name userCatalog-oracle -e ORACLE_SID=userCatalog -e ORACLE_PDB=root -e ORACLE_PWD=p@55w0rd -p 1521:1521 --shm-size="8g" container-registry.oracle.com/database/enterprise:21.3.0.0
<br>
https://container-registry.oracle.com
https://www.youtube.com/watch?v=56dSXI2PbCQ
docker pull container-registry.oracle.com/database/enterprise:21.3.0.0
docker tag container-registry.oracle.com/database/enterprise:21.3.0.0 oracle:21.3.0.0
docker run -d -p 1521:1521 -p 5500:5500 -e ORACLE_SID=oracleCata -e ORACLE_PWD=p@55w0rd --name oracle-std --shm-size="5g" oracle:21.3.0.0
</em>