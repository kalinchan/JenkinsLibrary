#! groovy
docker.withTool('docker') {
    sh """apt-get update"""
    sh """apt-get install sudo"""
    sh """sudo chmod 666 /var/run/docker.sock"""
    sh """docker build -t localhost:5000/java-samples ."""
}
