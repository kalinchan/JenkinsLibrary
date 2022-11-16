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
                    MPLModule('Maven Build', [
                        maven: [
                            tool_version: 'maven'
                        ]
                    ])
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