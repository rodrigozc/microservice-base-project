node {

  def scmVars = checkout scm
  echo "${scmVars}"

  echo "sh 'printenv'"

  sh "./gradlew clean prepareDocker"

}
