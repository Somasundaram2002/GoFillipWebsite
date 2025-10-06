pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'   // ✅ Maven + Java ready
            args '--shm-size=2g -t'
        }
    }
    options { 
        timestamps()
        timeout(time: 20, unit: 'MINUTES') 
    }
    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
    }
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Run one test') {
            steps {
                sh '''
                set -eu
                java -version
                mvn -B clean test \
                  -Dtest=AddToCart \
                  -Dheadless=true \
                  -Dchrome.options="--headless=new --no-sandbox --disable-dev-shm-usage --window-size=1920,1080" \
                  -DbaseUrl="${BASE_URL:-https://gofillip.in}"
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
