pipeline {
    agent any
    //docker { image 'zenika/alpine-maven' }

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
