node {
  def scmVars = checkout scm
  echo "${scmVars}"
  scmVars.GIT_COMMIT
  sh "./gradlew clean prepareDocker"
  def image = docker.build("rodrigozc/microservice-base-project:latest", "build/docker")
  image.push()
}
