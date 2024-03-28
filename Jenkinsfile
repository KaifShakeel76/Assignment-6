pipeline {
    agent any
    
    stages {
        stage('Clone and Execute') {
            steps {
                script {
                    load '/src/kafka/kafka.groovy'
                }
            }
        }
    }
    
    post {
        always {
            echo "Job Name: $JOB_NAME"
            echo "Build Number: $BUILD_NUMBER"
        }
    }
}
