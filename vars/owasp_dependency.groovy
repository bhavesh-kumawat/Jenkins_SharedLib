def call() {

  sh '''
    rm -rf dependency-check-data
    mkdir -p dependency-check-data
    chmod -R 777 dependency-check-data
  '''

  dependencyCheck(
    odcInstallation: 'OWASP',
    additionalArguments: '''
      --scan .
      --format XML
      --data dependency-check-data
      --noupdate
    '''
  )

  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
