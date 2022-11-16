#! groovy
withMaven(jdk: CFG.maven.jdk, maven: CFG.maven.tool_version) {
    sh """mvn -B -V clean install"""
}