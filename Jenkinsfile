pipeline {
agent any

options { timestamps(); timeout(time: 20, unit: 'MINUTES') }

environment {
BASE_URL = 'https://gofillip.in'
DOCKER_IMAGE = 'somasundaram2002/my-maven-chrome:stable'
}

stages {
stage('Checkout') {
steps { checkout scm }
}

text
stage('Run one test') {
  agent {
    docker {
      image "${DOCKER_IMAGE}"
      args '--shm-size=2g -t -u 1000:1000'
    }
  }
  steps {
    sh '''
      set -eu
      google-chrome --version
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
junit allowEmptyResults: true, testResults: 'target/surefire-reports/.xml'
archiveArtifacts allowEmptyArchive: true, artifacts: 'target/screenshots/**/.png'
}
}
}
