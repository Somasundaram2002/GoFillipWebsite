pipeline {
agent {
docker {
image 'selenium/standalone-chrome:latest'
args '-u 1200:1200'
}
}
options { timestamps(); timeout(time: 20, unit: 'MINUTES') }
environment {
MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
}
stages {
stage('Checkout') {
steps { checkout scm }
}
stage('Build & Test (headless)') {
steps {
sh '''
set -e
google-chrome --version
mvn -B clean test
-Dheadless=true
-Dchrome.options="--headless=new --no-sandbox --disable-dev-shm-usage --window-size=1920,1080"
-DbaseUrl="${BASE_URL:-https://gofillip.in}"
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
