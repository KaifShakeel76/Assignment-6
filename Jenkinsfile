pipeline {
    agent any

    stages {
        stage('Load Configuration') {
            steps {
                script {
                    def config = load 'vars/config.groovy'
                    SLACK_CHANNEL_NAME = config.SLACK_CHANNEL_NAME
                    ENVIRONMENT = config.ENVIRONMENT
                    CODE_BASE_PATH = config.CODE_BASE_PATH
                    ACTION_MESSAGE = config.ACTION_MESSAGE
                    KEEP_APPROVAL_STAGE = config.KEEP_APPROVAL_STAGE
                }
            }
        }

        stage('Clone') {
            steps {
                git 'https://github.com/KaifShakeel76/Assignment-6.git'
            }
        }

        stage('User Approval') {
            when {
                expression { KEEP_APPROVAL_STAGE }
            }
            steps {
                input message: 'Approve to proceed with playbook execution?', ok: 'Deploy'
            }
        }

        stage('Playbook Execution') {
            steps {
                script {
                    def ansibleConfig = [
                        playbook: 'path/to/playbook.yml/home/kaif/Desktop/vidhyarthi/Assignments-Copy/Ansible/Assignment-5/Tool_Manager/test.yml',
                        extraVars: [
                            SLACK_CHANNEL_NAME: SLACK_CHANNEL_NAME,
                            ENVIRONMENT: ENVIRONMENT,
                            CODE_BASE_PATH: CODE_BASE_PATH,
                            ACTION_MESSAGE: ACTION_MESSAGE
                        ]
                    ]
                    ansiblePlaybook ansibleConfig
                }
            }
        }

        stage('Kafka Configuration') {
            steps {
                script {
                    def kafkaConfig = [
                        repositoryURL: 'https://github.com/KaifShakeel76/Assignment-6.git',
                        inventoryPath: '/home/kaif/Desktop/vidhyarthi/Assignments-Copy/Ansible/Assignment-5/Tool_Manager/inventory',
                        playbookPath: '/home/kaif/Desktop/vidhyarthi/Assignments-Copy/Ansible/Assignment-5/Tool_Manager/test.yml'
                    ]
                    kafka(kafkaConfig)
                }
            }
        }

        stage('Notification') {
            steps {
                script {
                    slackSend channel: 'jenkinsintegration', message: Success
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
        }
    }
}