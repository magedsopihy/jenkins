def gv

pipeline {
    agent any
    tools {
        maven "Maven"
    }
   
    stages {
        stage("init"){
            steps {
                script {
                  gv = load "script.groovy"
                }
            }
        }
        stage("build jar"){
            steps {
                script {
                    gv.buildJar()
                }
            }
        }

        stage("build image"){
            when {
                expression {
                   BRANCH_NAME == 'main'
                }
            }

            steps {
                script {
                    gv.buildImage()
                }
            }
        }
            

        stage("deploy"){
            when {
                expression {
                   BRANCH_NAME == 'main'
                }
            }

            steps{
                script{
                    gv.deployApp()
                }
            }
        }
    }
    
}
