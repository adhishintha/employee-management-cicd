pipeline {
    agent any

    environment {
        IMAGE_NAME = "employee-management"
        CONTAINER_NAME = "employee-management-app"
        APP_PORT = "8081"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/adhishintha/employee-management-cicd.git'
            }
        }

        stage('Maven Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$BUILD_NUMBER .'
            }
        }

        stage('Stop Previous Container') {
            steps {
                sh '''
                    docker stop $CONTAINER_NAME || true
                    docker rm $CONTAINER_NAME || true
                '''
            }
        }

        stage('Deploy New Container') {
            steps {
                sh 'docker run -d --name $CONTAINER_NAME -p $APP_PORT:$APP_PORT $IMAGE_NAME:$BUILD_NUMBER'
            }
        }
    }
}
