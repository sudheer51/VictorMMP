pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('HealthCheck MMP') {
            steps {
                echo '**********Health Check**************'
                bat 'ping 96.84.175.78 -n 5'
                
            }
        }
         stage('Download the Code From Github') {
            steps {
                
                 git credentialsId: 'GithubCreds', url: 'https://github.com/sudheer51/VictorMMP.git'
            }
        }
         stage('Execute_Tests_QA') {
            steps {
                
               dir('mmp') {
                        bat 'mvn clean test'
                    }
               
            }
        }
    }
}
