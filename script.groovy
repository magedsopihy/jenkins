def buildJar(){
    echo "building the application"
    sh 'mvn package'
}

def buildImage(){
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]){
    sh 'docker build -t magedsopihy/maven_project:1.0 .'
    sh 'echo $PASS | docker login -u $USERNAME --password-stdin'
    sh 'docker push magedsopihy/maven_project:1.0'
    }
}

def deployApp() {
    echo "deploying the application"
}
return this
