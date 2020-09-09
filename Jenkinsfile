pipeline {
    agent {
        //docker { image 'zenika/alpine-maven' }
        any        
    }
    stages {
        stage('Checkout') {
          steps{
            checkout scm
          }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
