pipeline {
    agent any
    stages {
        stage('--Mvn clean package--') {
                steps {
                    sh "mvn clean package deploy"
                    }
            }
            stage('--Build back-end--') {
                steps {
                    sh "docker build -t app-test ."
                    }
            }
        stage('--Deploy--') {
              steps {
                    sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PSSWRD}"
                    sh "docker tag app-test 9953136/app-test"
                    sh "docker push 9953136/app-test"
                    }
              }
    }
}