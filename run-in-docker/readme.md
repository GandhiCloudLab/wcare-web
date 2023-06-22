# Inter communication between two docker Containers in a VM

The objective of this document is to explain about how two docker Containers are communicating in the same VM.

There are two services called `Wcare-User` and `Wcare-Web` are available. The `Wcare-Web` service depends on `Wcare-user` service. Lets see how to make `Wcare-Web` service calls the `Wcare-User` service.

## Steps

#### Run WCare-User service

1. Run the below command

```
docker run -p 9021:9021 gandhicloudlab/wcareuser
```

This should start the `wcareuser` service in docker.

#### Get the IP Address of the WCare-User service

2. Run the below command to get the container id.

```
docker ps
```

You may get the result like this.

```
gandhi@Jeyas-MacBook-Pro ~ % docker ps
CONTAINER ID   IMAGE                      COMMAND                CREATED          STATUS          PORTS                              NAMES
b0b881b098b4   gandhicloudlab/wcareuser   "java -jar /app.jar"   33 minutes ago   Up 33 minutes   0.0.0.0:9021->9021/tcp, 9030/tcp   quizzical_leavitt
```

Here `b0b881b098b4` is the container-id.


3. Run the below command to get the IP Address

Note : The <CONTAINER_ID> should have been replaced with the container id retrived above.

```
docker inspect <CONTAINER_ID> | grep IPAddress
```

You may get the result like this.

```
            "SecondaryIPAddresses": null,
            "IPAddress": "172.17.0.4",
                    "IPAddress": "172.17.0.4",
```

Here `172.17.0.4` is the IP Address of the docker container.


#### Run WCare-Web service

4. Run the below command

Note : The <IP_ADDRESS> should have been replaced with the ip address retrived above.

```
USER_URL=http://<IP_ADDRESS>:9021

docker run --publish 9020:9020 -e PROP_API_SERVER_URL_USER=$USER_URL gandhicloudlab/wcareweb
```

This should start the `wcareweb` service in docker.

Here we have passed `wcareuser` service url in `PROP_API_SERVER_URL_USER` parameter.

#### Access the app.

5. Access the application using this link http://localhost:9020

    You need to give sam/sam as user/pwd


