def build(String os, String stashName) {
  if (os == "ubuntu") {
    // Install Pre-Req
      sh """
        apt update
        apt install gcc -y
      """
  } else if (os == "archlinux") {
    // Install Pre-Req
      sh """
        yes | pacman -Sy gcc
      """
  } else {
    throw new Exception('[ERROR] OS not supported')
  }
  // Compile Code
    sh "gcc src/program_team_1.c -o program_team"
    stash includes: "program_team", name: "$stashName"
}
