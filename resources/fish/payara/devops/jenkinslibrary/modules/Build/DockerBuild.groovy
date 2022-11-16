#! groovy
docker.withTool('docker') {
    sh """docker run hello-world"""
}
