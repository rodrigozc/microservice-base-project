node {
  stage 'Stage Checkout'
  checkout scm

  stage 'Stage Build'

  echo "Environment: ${env}"

  sh "./gradlew clean prepareDocker"
}
