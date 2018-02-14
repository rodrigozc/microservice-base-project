node {

  stage "Checkout" {
    def scmVars = checkout scm
    echo "${scmVars}"
  }

  stage "Environment" {
    echo "sh 'printenv'"
  }

  stage "Build" {
    sh "./gradlew clean prepareDocker"
  }

}
