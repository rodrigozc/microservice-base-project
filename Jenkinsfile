node {

    notify('Started')
    try {
        stage 'checkout'
        checkout scm
        //git 'https://github.com/rodrigozc/microservice-base-project.git'
        def docker_build_path = 'build/docker'

        stage 'compiling, testing and packaging'
        def gradle_version = 'GRADLE4'
        withEnv( ["PATH+GRADLE=${tool gradle_version}/bin"] ) {
            sh 'gradle clean prepareDocker'
        }
    } catch (err) {
        notify("Error ${err}")
        currentBuild.result = 'FAILURE'
    }

    stage 'archival'
    publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'build/reports/jacoco/test/html', reportFiles: 'index.html', reportName: 'Code Coverage', reportTitles: ''])
    step([$class: 'JUnitResultArchiver', testResults: 'build/test-results/test/TEST*.xml'])
    archiveArtifacts 'build/libs/*.jar'
}

stage "Build Image"
node {
    sh "docker build -t test/microservice-base-project:latest build/docker"
}

node {
    notify("Deploy to staging?")
}

input 'Deploy to staging?'

stage "Run Container"
node {
    sh "docker run -d -p '8088:8080' test/microservice-base-project:latest"
}

notify "Application is Running!!!"

def notify(status){
    emailext (
      to: "rodrigo.zampieri@gmail.com",
      subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )
}
