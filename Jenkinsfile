node {

  stage "Stage Checkout" {
    def scmVars = checkout scm
    echo "${scmVars}"
  }

  stage "Show Environment" {
    echo "sh 'printenv'"
  }

  stage "Stage Build" {
    sh "./gradlew clean prepareDocker"
  }

}
