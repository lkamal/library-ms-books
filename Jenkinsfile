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
                sh './mvnw sonar:sonar -Dsonar.host.url=http://3.230.2.128:9000 -Dsonar.login=c8face3be08e79ac4bf1227a7b02a8a62732561b'
            }
        }
    }
}