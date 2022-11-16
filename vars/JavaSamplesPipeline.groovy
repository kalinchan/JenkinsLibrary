#!groovy

def call(body) {

    MPLInit()

    def MPL = MPLPipelineConfig(body, [
        jdk: 'zulu-8',
        modules: [
            Checkout: [:],
            Build: [:]
        ]
    ])

    pipeline {
        agent any
        stages {
            stage ('Checkout') {
                steps {
                    MPLModule()
                }
            }
            stage ('Build') {
                steps {
                    MPLModule()
                }
            }
        }
        post {
            success {
                MPLPostStepsRun('success')
            }
        }
    }
}