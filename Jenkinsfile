pipeline {
    agent any

    tools{
            maven 'LocalMaven'
    }

    stages{
        stage('Build'){
            steps{
                sh 'mvn clean package'
                sh "sudo /usr/local/bin/docker build . -t tomcatwebapps:${env.BUILD_ID}"
            }
        }
    }
}