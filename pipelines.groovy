pipelineJob('GCP/PROD/create-infra-prod') {
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
pipelineJob('GCP/PREPROD/create-infra-preprod') {
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
pipelineJob('GCP/DEV/create-infra-dev') {
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


pipelineJob('GCP/DEV/destroy-infra-dev') {
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


pipelineJob('GCP/PREPROD/destroy-infra-preprod') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/rafstef/demo-gcp')
            scriptPath("pipelines/destroy.groovy")
          }
          branch('*/release')
        }
      }
      lightweight()
    }
  }
}
pipelineJob('GCP/PROD/destroy-infra-prod') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/rafstef/demo-gcp')
            scriptPath("pipelines/destroy.groovy")
          }
          branch('*/master')
        }
      }
      lightweight()
    }
  }
}