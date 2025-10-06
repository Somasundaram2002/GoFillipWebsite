pipeline {
    agent {
        docker {
            image 'somasundaram2002/my-maven-chrome:latest'  // Your Docker image with Maven + Chrome + Chromedriver
            args '--shm-size=2g -t'
        }
    }
    environment {
        BASE_URL = 'https://gofillip.in'  // Replace if your site is different
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Run AddToCart Test') {
            steps {
                sh '''
                set -eu
                echo "Chrome version:"
                google-chrome --version
                echo "Chromedriver version:"
                chromedriver --version
                echo "Running Maven test..."
                mvn clean test -Dtest=AddToCart -DbaseUrl=${BASE_URL}
                '''
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
