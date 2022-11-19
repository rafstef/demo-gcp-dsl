import javaposse.jobdsl.plugin.GlobalJobDslSecurityConfiguration
import jenkins.model.GlobalConfiguration

// disable Job DSL script approval

GlobalConfiguration.all().get(GlobalJobDslSecurityConfiguration.class).useScriptSecurity=false
GlobalConfiguration.all().get(GlobalJobDslSecurityConfiguration.class).save()

pipeline {
    agent any
    stages {
        stage('FolderRoot') {
            steps {
                jobDsl scriptText: 'job("folders-root")'
                jobDsl targets: ['foldersRoot.groovy'].join('\n'),
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB'
            }
        }




        ////////// MONOLITHIC ///////
        stage('FolderMonolithic') {
            steps {
                jobDsl scriptText: 'job("DSL/folders-monolithic")'
                jobDsl targets: ['foldersMonolithic.groovy'].join('\n'),
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB'
            }
        }
        stage('pipelines-monolithic') {
            steps {
                jobDsl scriptText: 'job("DSL/pipelines-monolithic")'
                jobDsl targets: ['pipelinesMonolithic.groovy'].join('\n'),
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB'
            }
       }
          
        
        //////// MODULAR////////
        stage('FolderModular') {
            steps {
                jobDsl scriptText: 'job("DSL/folders-modular")'
                jobDsl targets: ['foldersModular.groovy'].join('\n'),
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB'
            }
        }
        stage('pipelines-modular') {
            steps {
                jobDsl scriptText: 'job("DSL/pipelines-modular")'
                jobDsl targets: ['pipelinesModular.groovy'].join('\n'),
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB'
            }
       }

       
       
       
         //////// MICRO //////////
        stage('FolderMicro') {
            steps {
                jobDsl scriptText: 'job("DSL/folders-micro")'
                jobDsl targets: ['foldersMicro.groovy'].join('\n'),
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB'
            }
        }
        stage('pipelines-networking') {
            steps {
                jobDsl scriptText: 'job("DSL/pipelines-networking")'
                jobDsl targets: ['pipelinesNetworking.groovy'].join('\n'),
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB'
            }
       }
        stage('pipelines-infra') {
            steps {
                jobDsl scriptText: 'job("DSL/pipelines-infra")'
                jobDsl targets: ['pipelinesInfra.groovy'].join('\n'),
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB'
            }
       }
       
       //////////////// close micro //////
       
    }
    
    post {
        // Clean after build
        always {
            cleanWs(cleanWhenNotBuilt: false,
            deleteDirs: true,
            disableDeferredWipeout: true,
            notFailBuild: true,
            patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
            [pattern: '.propsfile', type: 'EXCLUDE']])
            //Send email always
        }
    }
}