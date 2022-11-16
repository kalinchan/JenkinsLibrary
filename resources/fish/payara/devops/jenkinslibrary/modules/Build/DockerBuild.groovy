#! groovy
docker.withTool('docker') {
    sh """sudo chmod 666 /var/run/docker.sock"""
    sh """docker run hello-world"""
}
