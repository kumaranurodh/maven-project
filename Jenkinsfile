pipeline {
    agent any

    tools{
    mvn 'LocalMaven'
    }

    stages{
        stage('Build'){
            steps{
                sh 'mvn clean package'
            }
        }
    }
}