#!groovy

def call(body) {

    MPLInit()

    def MPL = MPLPipelineConfig(body, [
        jdk: 'zulu-8',
        modules: [
            Checkout: [:],
            Build: [:]
        ],
        git: [
            url: 'https://github.com/kalinchan/Java-Samples',
            branch: 'master'
        ]
    ])

    pipeline {
        node {
            stage ('Checkout') {
                MPLModule()
            }
            docker.withTool('docker'){
                def myEnv = docker.build 'java-samples:snapshot'
                mvEnv.inside{
                    stage ('Build') {
                        MPLModule('Maven Build', [
                                maven: [
                                        tool_version: 'maven',
                                        jdk: MPL.config.jdk
                                ]
                        ])
                    }
                }
            }
        }
    }
}