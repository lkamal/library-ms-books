pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('SonarQube analysis') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://3.230.2.128:9000 -Dsonar.login=87e3d858a81dc7c4435a44a487db6374494d0a08'
            }
        }
    }
}