"# Twitter is a dojo project realized in spare time to summarize knowledge. <br> It revolve around combining various technologies in single repository.
Notice that it can risk with suboptimal code appliance in this particular project. <br>
But as I mentioned - it's a dojo."

<strong>Project includes technologies like</strong><br>
<em>Jenkins<br></em>
<em>Docker<br></em>
<em>Swagger<br></em>

<h1>To run Jenkis:</h1>
1. Build Jenkins image: <br>
    docker build -t myjenkins-blueocean . <br>

2. Run jenkins network: <br>
    docker network create jenkins <br>

3. Start Jenkins container: <br>
   docker run --name jenkins-blueocean --restart=on-failure --detach `
    --network jenkins --env DOCKER_HOST=tcp://docker:2376 `
    --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 `
    --volume jenkins-data:/var/jenkins_home `
    --volume jenkins-docker-certs:/certs/client:ro `
    --publish 8080:8080 --publish 50000:50000 myjenkins-blueocean

4. Get initial password: <br>
   docker exec jenkins-blueocean cat /var/jenkins_home/secrets/initialAdminPassword
   
<h2>Or follow the tutorial</h2>
<strong>Configure jenkins using this tutorial</strong><br>
<em>https://www.youtube.com/watch?v=6YZvp2GwT0A </em>
