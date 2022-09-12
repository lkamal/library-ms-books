pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                sh './mvnw compile'
            }
        }

        stage('SonarQube analysis') {
            steps {
                sh './mvnw sonar:sonar \
                    -Dsonar.host.url=http://3.230.2.128:9000 \
                    -Dsonar.login=c8face3be08e79ac4bf1227a7b02a8a62732561b'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Docker build') {
            steps {
                sh 'docker build --tag library-ms-books:1.0.2 .'
                sh 'docker tag library-ms-books:1.0.2 lkamal/library-ms-books:1.0.2'
            }
        }
        stage('Docker push') {
            withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerpwd')]) {
                sh 'echo ${dockerpwd} | docker login -u lkamal --password-stdin'
                sh 'docker push lkamal/library-ms-books:1.0.2'
            }
        }

        stage('Deploy to EKS with Helm') {
            sh 'sudo helm upgrade library-ms-books helm/library-ms-books/.'
        }
    }
}