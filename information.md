

for docker we can connect them by using selenium grid and container concept but we 
deleivered open mrs project locally so, container can't connect to local network
and we are coonecting selenium grid to openMRS network >networks:
openmrs-network:
external: true
name: openmrs-distro-referenceapplication-main_default