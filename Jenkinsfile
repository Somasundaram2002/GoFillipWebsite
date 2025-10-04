pipeline {
  agent any
  options { timestamps(); timeout(time: 20, unit: 'MINUTES'); ansiColor('xterm') }

  environment {
    MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    # Optional: set BASE_URL at job level or here
    # BASE_URL = "https://your-app-url"
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Set up JDK & Maven') {
      steps {
        tool name: 'M3', type: 'maven'    // configure in Jenkins > Global Tool Configuration
        tool name: 'JDK17', type: 'jdk'   // or JDK11 based on your pom
      }
    }

    stage('Install Chrome/Driver (Linux)') {
      when { expression { isUnix() } }
      steps {
        sh '''
          set -e
          if ! command -v google-chrome >/dev/null 2>&1; then
            echo "Installing Chrome..."
            sudo apt-get update -y
            sudo apt-get install -y wget gnupg --no-install-recommends
            wget -qO- https://dl.google.com/linux/linux_signing_key.pub | sudo gpg --dearmor -o /usr/share/keyrings/google-linux-signing-keyring.gpg
            echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux-signing-keyring.gpg] http://dl.google.com/linux/chrome/deb/ stable main" | sudo tee /etc/apt/sources.list.d/google-chrome.list
            sudo apt-get update -y
            sudo apt-get install -y google-chrome-stable --no-install-recommends
          fi
        '''
      }
    }

    stage('Build & Test (headless)') {
      steps {
        withEnv([
          'CHROME_OPTS=--headless=new --no-sandbox --disable-dev-shm-usage --window-size=1920,1080',
        ]) {
          sh '''
            mvn -B -e clean test \
              -Dheadless=true \
              -Dchrome.options="$CHROME_OPTS" \
              -DbaseUrl="${BASE_URL:-https://example.com}"
          '''
        }
      }
      post {
        always {
          junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
          archiveArtifacts allowEmptyArchive: true, artifacts: 'target/screenshots/**/*.png'
        }
      }
    }
  }
}
