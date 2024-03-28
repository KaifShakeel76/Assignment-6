def call(config) {
    // Clone repo
    sh "git clone ${config.repositoryURL}"
    
    // User approval
    input message: 'Do you approve this build?', ok:'Proceed'
    
    // Ansible Playbook
    sh "ansiblePlaybook become: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: '${config.inventoryPath}', playbook: '${config.playbookPath}', vaultTmpPath: ''"
    
    // Slack Notification
    slackSend channel: config.slackChannel, color: 'Green', message: 'Build Success', teamDomain: config.slackTeamDomain, tokenCredentialId: config.slackTokenCredentialId
}