pipeline {
    agent any

    tools{
            maven 'LocalMaven'
            docker 'LocalDocker'
    }

    stages{
        stage('Build'){
            steps{
                sh 'mvn clean package'
                sh "docker build . -t tomcatwebapps:${env.BUILD_ID}"
            }
        }
    }
}