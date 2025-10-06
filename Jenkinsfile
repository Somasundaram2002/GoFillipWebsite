pipeline {
agent {
docker {
image 'selenium/standalone-chrome:latest'
args '--shm-size=2g -t'
}
}

options { timestamps(); timeout(time: 20, unit: 'MINUTES') }

environment {
BASE_URL = 'https://gofillip.in'
MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
}

stages {
stage('Checkout') {
steps { checkout scm }
}

text
stage('Run one test') {
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
