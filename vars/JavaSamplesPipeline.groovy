#!groovy

def call(body) {

    MPLInit()

    def MPL = MPLPipelineConfig(body, [
        jdk: 'zulu-8',
        modules: [
            Checkout: [:],
            Build: [:],
            PushDocker[:]
        ],
        git: [
            url: 'https://github.com/kalinchan/Java-Samples',
            branch: 'master'
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
                    MPLModule('Build', [
                        maven: [
                            tool_version: 'maven',
                            jdk: MPL.config.jdk
                        ]
                    ])
                }
            }
            stage ('PushDocker'){
                when {expression { return fileExists('Dockerfile') }}
                steps {
                    MPLModule();
                }
            }
        }
    }
}