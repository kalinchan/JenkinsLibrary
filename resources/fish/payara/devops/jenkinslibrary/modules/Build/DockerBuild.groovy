#! groovy
withTool(docker){
    sh """docker build ."""
}