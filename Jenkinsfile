pipeline {
    agent any

    tools {
            maven 'LocalMaven'
        }

    stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }

        }

        stage ('Deploy to Stage'){
            steps{
                build job:'deploy-job'
            }
        }

        stage ('Deploy to Production'){
                    steps{
                        timeout(time:5, unit:'DAYS'){
                            input message:'Approve PRODUCTION Deployment?'
                        }

                        build job: 'deploy-prod-job'
                    }
                    post {
                        success {
                            echo 'Code deployed to Production.'
                        }

                        failure {
                            echo ' Deployment failed.'
                        }
                    }
        }
    }
}