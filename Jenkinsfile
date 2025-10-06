pipeline {
    agent {
        docker {
            image 'somasundaram2002/my-maven-chrome:latest'  // Your custom Docker image with Maven + Chrome + Chromedriver
            args '--shm-size=2g -t'
        }
    }
    options { 
        timestamps() 
        timeout(time: 20, unit: 'MINUTES') 
    }
    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
        BASE_URL = 'https://gofillip.in'   // <-- REPLACE THIS with your site if different
    }
    stages {
        stage('Checkout') {
            steps { 
                checkout scm 
            }
        }
        stage('Run one test') {
            steps {
                sh '''
                set -eu
                google-chrome --version
                chromedriver --version
                mvn -B clean test \
                    -Dtest=AddToCart \
                    -Dheadless=true \
                    -Dchrome.options="--headless=new --no-sandbox --disable-dev-shm-usage --window-size=1920,1080" \
                    -DbaseUrl="${BASE_URL}"
                '''
            }
        }
    }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            archiveArtifacts allowEmptyArchive: true, artifacts: 'target/screenshots/**/*.png'
        }
    }
}
