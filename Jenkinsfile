pipeline {
    agent {
        docker {
            image 'somasundaram2002/my-maven-chrome:latest'
            args '--shm-size=2g -t'
        }
    }

    options { 
        timestamps()
        timeout(time: 20, unit: 'MINUTES') 
    }

    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
        BASE_URL = 'https://gofillip.in'
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

                    echo "Java version:"
                    java -version

                    echo "Maven version:"
                    mvn -version

                    echo "Chrome version:"
                    google-chrome --version

                    echo "Chromedriver version:"
                    chromedriver --version

                    # Run only AddToCart test headlessly
                    mvn clean test \
                        -Dtest=AddToCart \
                        -Dheadless=true \
                        -Dchrome.options="--headless=new --no-sandbox --disable-dev-shm-usage --window-size=1920,1080" \
                        -DbaseUrl=${BASE_URL}
                '''
            }
        }
    }

    post {
        always {
            // Save test reports and screenshots
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            archiveArtifacts allowEmptyArchive: true, artifacts: 'target/screenshots/**/*.png'
        }
    }
}
