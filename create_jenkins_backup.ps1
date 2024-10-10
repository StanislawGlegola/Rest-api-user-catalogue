# Zdefiniuj zmienne
$containerName = "jenkins-blueocean"
$sourcePath = "/var/jenkins_home/jobs/"
$destinationPath = "C:/Users/stagl/IdeaProjects/twitter/jenkins-files/backup-jenkins"

# Upewnij się, że katalog docelowy istnieje
if (-Not (Test-Path $destinationPath)) {
    New-Item -ItemType Directory -Path $destinationPath
}

# Wykonaj polecenie kopiowania
docker cp "${containerName}:${sourcePath}" "$destinationPath"
