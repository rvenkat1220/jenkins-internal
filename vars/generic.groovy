def checkout(String repoUrl, String credentialId="github-token", String relaticeFolder = "$env.WORKSPACE", String branch="master") {
  checkout([$class: 'GitSCM',
            branches: [[name: "$branch"]],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CheckoutOption',
                          timeout: 30],[$class: 'RelativeTargetDirectory',
                                        relativeTargetDir: "$relaticeFolder"],
                         [$class: 'UserIdentity',
                          email: 'rvenkat1220@gmail.com',
                          name: 'Raghu']],
            submoduleCfg: [],
            userRemoteConfigs: [[credentialsId: "$credentialId",
                                 url: "$repoUrl"]]])
}
