pipeline {
    agent any
    environment {
    	DOCKER_USER = credentials('docker-login')
    	}
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
                    sh "docker login -u ${DOCKER_USER_USR} -p ${DOCKER_USER_PSW}"
                    sh "docker tag app-test 9953136/app-test"
                    sh "docker push 9953136/app-test"
                    }
              }
    }
}