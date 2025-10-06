pipeline {
    agent any

    environment {
        BASE_URL = "https://gofillip.in" // Replace if your URL is different
        DOCKER_IMAGE = "somasundaram2002/my-maven-chrome:stable"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests in Docker') {
            steps {
                script {
                    docker.image(DOCKER_IMAGE).inside('-u root -v $WORKSPACE:/workspace') {
                        sh '''
                            cd /workspace
                            mvn clean test -Dtest=AddToCart \
                            -Dheadless=true \
                            -Dchrome.options=--headless=new \
                            --no-sandbox \
                            --disable-dev-shm-usage \
                            --window-size=1920,1080 \
                            -DbaseUrl=$BASE_URL
                        '''
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }
    }
}
