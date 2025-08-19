pipeline {
    agent any

    environment {
        IMAGE_NAME = "miapp:latest"
        CONTAINER_NAME = "miapp_container"
        PORT = "8081"
    }

    stages {
        stage('Checkout') {
            steps {
                // Clona tu repositorio
                git branch: 'main', url: 'https://github.com/ElCharlieBrownie/micro.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Construye la imagen usando el Dockerfile multi-stage
                    docker.build("${IMAGE_NAME}")
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    // Detener contenedor previo si existe
                    sh "docker rm -f ${CONTAINER_NAME} || true"
                    
                    // Levantar contenedor con la nueva imagen
                    sh "docker run -d --name ${CONTAINER_NAME} -p ${PORT}:8080 ${IMAGE_NAME}"
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline terminado."
        }
    }
}