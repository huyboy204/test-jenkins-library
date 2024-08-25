def call () {
    stage('Unit Test with JUnit') {
        // Set JDK tool 
        def jdkTool = tool 'Java17'
        try {
            withEnv(["JAVA_HOME=${jdkTool}"]) {
                sh './mvnw test' 
            }
        } finally {
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }
}