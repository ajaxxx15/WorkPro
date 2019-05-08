pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Deploy') {
                    steps {
                       sh 'rsync -rva . ubuntu@13.234.155.75:/home/ubuntu/project/ibm-wave4-workpro'
                       sh "ssh ubuntu@13.234.155.75 'cd ~/project/ibm-wave4-workpro ; docker-compose down'"
                       sh "ssh ubuntu@13.234.155.75 'cd ~/project/ibm-wave4-workpro ; mvn clean package'"
                       sh "ssh ubuntu@13.234.155.75 'cd ~/project/ibm-wave4-workpro ; docker-compose up --build -d'"
                       sh "ssh ubuntu@13.234.155.75 'cd ~/project/ibm-wave4-workpro ; sleep 20 ; docker ps'"
                    }
                }
    }
}
