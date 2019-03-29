def folderName = "cra-jenkins-ci"
try {
  pipelineJob(folderName) {
    definition {
      cpsScm {
        scm {
          git(
            "https://github.com/Dkra/cra-jenkins",
            "master"
          )
        }
        scriptPath("./jenkins/${folderName}/Jenkinsfile")
      }
    }
  }
} catch (err) {
  throw err
}
