#!groovy
docker.withTool('docker') {
    sh """docker push localhost.localdomain:5000/java-samples"""
}