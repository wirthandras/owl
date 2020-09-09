pipeline {
    agent any
    //docker { image 'zenika/alpine-maven' }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
