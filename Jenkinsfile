pipeline {
  agent any
  options { timestamps(); timeout(time: 20, unit: 'MINUTES'); ansiColor('xterm') }

  // Optional: set BASE_URL here, or pass from the job as a parameter/environment variable
  environment {
    MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    // BASE_URL = "https://gofillip.in"
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Set up Tools') {
      steps {
        script {
          // Ensure Maven and JDK are configured in Global Tool Configuration with these names
          def mvnHome = tool name: 'M3', type: 'maven'
          def jdkHome = tool name: 'JDK17', type: 'jdk'
          env.PATH = "${mvnHome}/bin:${jdkHome}/bin:${env.PATH}"
        }
      }
    }

    stage('Install Chrome (Linux agents)') {
      when { expression { isUnix() } }
      steps {
        sh '''
          set -e
          if ! command -v google-chrome >/dev/null 2>&1; then
            echo "[CI] Installing Google Chrome..."
            sudo apt-get update -y
            sudo apt-get install -y wget gnupg --no-install-recommends
            wget -qO- https://dl.google.com/linux/linux_signing_key.pub | sudo gpg --dearmor -o /usr/share/keyrings/google-linux-signing-keyring.gpg
            echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux-signing-keyring.gpg] http://dl.google.com/linux/chrome/deb/ stable main" | sudo tee /etc/apt/sources.list.d/google-chrome.list
            sudo apt-get update -y
            sudo apt-get install -y google-chrome-stable --no-install-recommends
          fi
          google-chrome --version || true
        '''
      }
    }

    stage('Build & Test (headless)') {
      steps {
        withEnv([
          'CHROME_OPTS=--headless=new --no-sandbox --disable-dev-shm-usage --window-size=1920,1080',
        ]) {
          sh '''
            set -e
            mvn -B -e clean test \
              -Dheadless=true \
              -Dchrome.options="$CHROME_OPTS" \
              -DbaseUrl="${BASE_URL:-https://gofillip.in}"
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
