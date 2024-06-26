pipeline {
    agent any

    environment {
        SLACK_CHANNEL_NAME = 'jenkinsintegration'
        ENVIRONMENT = 'prod'
        CODE_BASE_PATH = 'env/prod'
        ACTION_MESSAGE = 'Success'
        KEEP_APPROVAL_STAGE = true
    }

    stages {
        stage('Load Configuration') {
            steps {
                script {
                    echo 'Config loaded successfully.'
                }
            }
        }

        stage('Clone') {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/KaifShakeel76/Assignment-6.git'
                }
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
                    ansiblePlaybook become: true, 
                                   disableHostKeyChecking: true, 
                                   installation: 'Ansible', 
                                   inventory: '/var/lib/jenkins/workspace/TestShared/Tool_Manager/inventory.ini', 
                                   playbook: '/var/lib/jenkins/workspace/TestShared/Tool_Manager/test.yml', 
                                   vaultTmpPath: ''
                }
            }
        }

        stage('Notification') {
            steps {
                script {
                    slackSend channel: 'build-status', 
                              color: 'Green', 
                              message: 'Build Success', 
                              teamDomain: 'testenv', 
                              tokenCredentialId: 'Slack-2'
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