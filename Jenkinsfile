pipeline {
    agent {
        docker {
            image 'somasundaram2002/my-maven-chrome:latest'
            args '--shm-size=2g'
        }
    }
    options { 
        timestamps() 
        timeout(time: 20, unit: 'MINUTES') 
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
                    set -e
                    mvn clean test -Dtest=AddToCart \
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
