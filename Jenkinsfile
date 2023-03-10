pipeline{
  agent any
  stages{
  stage('Clean') { 
    steps{
      bat "mvn clean"
    }
    }
    stage('Test') {
       steps{
      bat "mvn test"
    }
    }
    stage('Package') {
        steps{
      bat "mvn package"
    }
    }
    stage("Consolidated Result"){
      steps{
        input("Do you want to test result?")
        junit"**/target/surefire-reports/Test-*.xml"
        archive "target/*.jar"
      }
    }
    stage('Run') {
        steps{
      bat "mvn spring-boot:run"
    }
    }
  }
}
