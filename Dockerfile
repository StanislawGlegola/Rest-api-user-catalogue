FROM jenkins/jenkins:lts-jdk11

USER root

# Zależności, np. curl (opcjonalne w zależności od Twoich potrzeb)
RUN apt-get update && apt-get install -y apt-transport-https ca-certificates curl gnupg-agent software-properties-common

USER jenkins

# Instalacja wtyczek Jenkins
RUN jenkins-plugin-cli --plugins "blueocean docker-workflow"
