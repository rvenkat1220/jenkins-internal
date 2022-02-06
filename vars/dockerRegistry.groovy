def push(String repoName, String stashName) {
  unstash "$stashName"
  withCredentials([usernamePassword(credentialsId: 'DOCKER_CREDENTIALS', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
    sh"""
      img build . -t $repoName:$env.BUILD_NUMBER
      img login -u ${USERNAME} -p ${PASSWORD}
      img push $repoName:$env.BUILD_NUMBER
      img logout
    """
 }
}
