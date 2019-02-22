pipeline {
    agent any
        tools {
            maven 'LocalMaven'
        }

    parameters {
         string(name: 'tomcat_dev', defaultValue: '54.191.88.30', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: '34.222.153.117', description: 'Production Server')
    }

    triggers {
         pollSCM('* * * * *')
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

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        sh "scp -i /Users/anurodhkumar/Desktop/DevOps/jenkins_tomcat.pem **/target/*.war ec2-user@${params.tomcat_dev}:/var/lib/tomcat8/webapps"
                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        sh "scp -i /Users/anurodhkumar/Desktop/DevOps/jenkins_tomcat.pem **/target/*.war ec2-user@${params.tomcat_prod}:/var/lib/tomcat8/webapps"
                    }
                }
            }
        }
    }
}