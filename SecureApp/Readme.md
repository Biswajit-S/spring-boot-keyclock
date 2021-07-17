## Build Docker Image

docker build -f Dockerfile -t secureapp:latest .

## Run Stand-alone docker image 

(Docker Compose should run to start keycloak as well)

docker run -p 9090:9090 secureapp:latest
  
  
  
  
