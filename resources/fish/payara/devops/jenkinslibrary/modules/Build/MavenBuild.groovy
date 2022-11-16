#! groovy
withMaven(jdk: CFG.jdk, maven: 'maven') {
    sh """mvn -version"""
    sh """mvn -B -V clean install"""
}