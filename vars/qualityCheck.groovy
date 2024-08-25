def call () {
    stage('Check with SonarQube') {
        // Set JDK tool 
        def jdkTool = tool 'Java17'
        withEnv(["JAVA_HOME=${jdkTool}"]) {
            withSonarQubeEnv('sonarqube-server') {
                sh "./mvnw clean verify sonar:sonar -Dsonar.projectKey=Spring-project-${BRANCH_NAME} -Dsonar.projectName='Spring project ${BRANCH_NAME}'"
            }
        }
    }
}