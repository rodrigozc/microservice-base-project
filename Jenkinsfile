node {
  stage 'Stage Checkout'
  checkout scm

  stage 'Stage Build'

  echo "My branch is: ${env.BRANCH_NAME}"

  def flavor = flavor(env.BRANCH_NAME)
  echo "Building flavor ${flavor}"

  sh "./gradlew clean prepareDocker"
}
