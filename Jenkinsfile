pipeline {
    agent any // You can specify an agent here, such as 'docker' or 'label'

    stages {
        stage('Load Configuration') {
            steps {
                node {
                    // Load the config file
                    def config = load 'vars/config.groovy'
                    
                    // Define your kafka configuration
                    def kafkaConfig = [
                        repositoryURL: 'https://github.com/KaifShakeel76/Assignment-6.git',
                        inventoryPath: '/var/lib/jenkins/workspace/TestShared/Tool_Manager/inventory',
                        playbookPath: '/var/lib/jenkins/workspace/TestShared/Tool_Manager/test.yml',
                        slackChannel: 'jenkinsintegration',
                        slackTeamDomain: 'bhavneshpvt',
                        slackTokenCredentialId: 'Slack'
                    ]

                    // Call your kafka step with the configuration
                    kafka(kafkaConfig)
                }
            }
        }
    }
}
