def call() {

  sh '''
    mkdir -p dependency-check-data
    chmod -R 777 dependency-check-data
  '''

  dependencyCheck(
    odcInstallation: 'OWASP',
    additionalArguments: '''
      --scan .
      --format XML
      --data dependency-check-data
      --nvdApiDelay 10000
    '''
  )

  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
