#!groovy
docker.withTool('docker') {
    sh """docker push localhost:5000/java-samples"""
}