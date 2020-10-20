# WCare Web 

## Installation via Tekton

## Manual Installation 


### 1. Build Docker Images

1. Download this project from git

2. Open the file `build-dockerhub.sh` 

3. Modify the dockerhub id accordingly at line nos. 5,6 and 7.

4. Run the sh file to create docker image.

```
sh ./build-dockerhub.sh
``` 

-------------

### 2. Installation Steps

1. Open the file `/deployment/yaml/02-deployment/yaml`

2. Update the line no. `23` with the appropriate image name from the previous section.

3. Goto `/deployment/install` folder in command prompt

4. Login into OCP Cluster with ` oc login`  command in command prompt

5. Run the below command.

```
sh 01-install.sh
```
-------------

### 3. Accessing the installed application

1. Run the below command to find the routes installed.

```
oc get route -n wcare-ns
```

2. Copy the route from the above output and open the url in the browser.

----------



