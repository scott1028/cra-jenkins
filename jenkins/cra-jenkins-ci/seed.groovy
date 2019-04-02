def folderName = "cra-jenkins-ci"
try {
  pipelineJob(folderName) {
    definition {
      cpsScm {
        scm {
          git(
            "https://github.com/scott1028/cra-jenkins.git",
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
