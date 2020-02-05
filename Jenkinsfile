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
                    sh "docker build -t 9953136/app-test ."
                    }
            }
        stage('--Dockerise--') {
              steps {
                    withDockerRegistry([ credentialsId: "docker-login", url: "" ]) {
                    sh "docker push 9953136/app-test"
                    }
              }
                    
         }
              stage('--Deploy--') {
              steps {
              	withCredentials(bindings: [sshUserPrivateKey(credentialsId: 'back-end-ssh', keyFileVariable: 'SSH-KEY')]) {
              	    sh "ssh -i ${SSH-KEY} ubuntu@ec2-35-176-148-54.eu-west-2.compute.amazonaws.com"
              	sh "touch deploy.sh"
              	sh "echo hello >> deploy.sh"
                 	}
               	}
              }
    }
}