pipeline {
agent any
options { timestamps(); timeout(time: 20, unit: 'MINUTES') }
stages {
stage('Checkout') { steps { checkout scm } }
stage('Run one test') {
agent {
docker {
image 'selenium/standalone-chrome:latest'
args '--shm-size=2g -t'
}
}
steps {
sh '''
set -eu
google-chrome --version
mvn -B clean test
-Dtest=AddToCart
-Dheadless=true
-Dchrome.options="--headless=new --no-sandbox --disable-dev-shm-usage --window-size=1920,1080"
-DbaseUrl="${BASE_URL:-https://gofillip.in}"
'''
}
post {
always {
junit allowEmptyResults: true, testResults: 'target/surefire-reports/.xml'
archiveArtifacts allowEmptyArchive: true, artifacts: 'target/screenshots/**/.png'
}
}
}
}
}
