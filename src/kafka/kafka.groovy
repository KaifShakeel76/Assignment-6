// Clone repo
sh "git clone https://github.com/KaifShakeel76/Assignment-6.git"

// User approval
input message: 'Do you approve this build?', ok:'Proceed'

// Ansible Playbook
sh "ansible-playbook -i /home/kaif/Desktop/vidhyarthi/Assignments-Copy/Ansible/Assignment-5/Tool_Manager/inventory /home/kaif/Desktop/vidhyarthi/Assignments-Copy/Ansible/Assignment-5/Tool_Manager/test.yml -e ENVIRONMENT=${ENVIRONMENT} -e CODE_BASE_PATH=${CODE_BASE_PATH}"
