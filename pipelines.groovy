pipelineJob('GCP/create-infra-prod') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/rafstef/demo-gcp')
            scriptPath("pipelines/Jenkinsfile")
          }
          branch('*/master')
        }
      }
      lightweight()
    }
  }
}
pipelineJob('GCP/create-infra-preprod') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/rafstef/demo-gcp')
            scriptPath("pipelines/Jenkinsfile")
          }
          branch('*/release')
        }
      }
      lightweight()
    }
  }
}
pipelineJob('GCP/create-infra-dev') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/rafstef/demo-gcp')
            scriptPath("pipelines/Jenkinsfile.groovy")
          }
          branch('*/develop')
        }
      }
      lightweight()
    }
  }
}


pipelineJob('GCP/destroy-infra-dev') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/rafstef/demo-gcp')
            scriptPath("pipelines/destroy.groovy")
          }
          branch('*/develop')
        }
      }
      lightweight()
    }
  }
}
