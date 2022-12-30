pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
        jdk "java"
    }

    parameters{
        choice(choices: ['chrome', 'firefox'], name: 'browser')
        choice(choices: ['src/test/resources/testng-smoke.xml','src/test/resources/testng-SmokeForRelease.xml'], name: 'checklist')
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/AleksandraKarpovich/FinalSurge.git'

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire} clean test"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Reporting') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: 'java',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                            ])
                }
            }
        }
    }
}
