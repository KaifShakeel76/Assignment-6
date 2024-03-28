def call(config) {
    // Clone repo
    sh "git clone https://github.com/KaifShakeel76/Assignment-6.git"
    
    // User approval
    input message: 'Do you approve this build?', ok:'Proceed'
    
    // Ansible Playbook
    sh "ansiblePlaybook become: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: '/var/lib/jenkins/workspace/TestShared/Tool_Manager/inventory', playbook: '/var/lib/jenkins/workspace/TestShared/Tool_Manager/test.yml', vaultTmpPath: ''"
    
    // Slack Notification
    slackSend channel: 'jenkinsintegration', color: 'Green', message: 'Build Success', teamDomain: 'bhavneshpvt', tokenCredentialId: 'Slack'
}