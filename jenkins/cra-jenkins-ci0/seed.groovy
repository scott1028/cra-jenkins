def folderName = 'cra-jenkins-ci0'
try {
  pipelineJob(folderName) {
    definition {
      cpsScm {
        scm {
          git(
            'https://github.com/Dkra/cra-jenkins',
            'master'
          )
        }
        scriptPath('src/jenkins/folderName/Jenkinsfile')
      }
    }
  }
} catch (err) {
  throw err
}
