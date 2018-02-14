node {
  dockerfile {
    filename 'build/docker/Dockerfile'
  }
  def scmVars = checkout scm
  echo "${scmVars}"
  scmVars.GIT_COMMIT
  sh "./gradlew clean prepareDocker"
  def image = docker.build("rodrigozc/microservice-base-project:${env.BUILD_ID}")
  customImage.push("latest")
}
