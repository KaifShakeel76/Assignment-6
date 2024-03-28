pipeline {
    agent any

    stages {
        stage('Load Configuration') {
            steps {
                script {
                    // Load config from vars/config.groovy
                    def config = load 'vars/config.groovy'
                    
                    // Implement any logic related to the loaded config here
                    echo "Config loaded successfully."
                }
            }
        }
    }
}
