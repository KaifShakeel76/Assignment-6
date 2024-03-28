pipeline {
    agent any

    stages {
        stage('Load Configuration') {
            steps {
                script {
                    // Load config from vars/config.groovy
                    def config = load 'vars/config.groovy'
                    
                    // Define kafkaConfig
                    def kafkaConfig = [
                        repositoryURL: 'https://github.com/KaifShakeel76/Assignment-6.git',
                        inventoryPath: '/var/lib/jenkins/workspace/TestShared/Tool_Manager/inventory',
                        playbookPath: '/var/lib/jenkins/workspace/TestShared/Tool_Manager/test.yml',
                        slackChannel: 'jenkinsintegration',
                        slackTeamDomain: 'bhavneshpvt',
                        slackTokenCredentialId: 'Slack'
                    ]
                    
                    // Call kafka pipeline function with config and kafkaConfig
                    kafka(config, kafkaConfig)
                }
            }
        }
    }
}

