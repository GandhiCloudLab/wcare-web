#!/usr/bin/env bash

echo "build Started ...."

# mvn clean package

docker build -f Dockerfile -t gandhicloudlab/classic-wcareweb:latest . 

# docker login -u gandhicloudlab

docker push gandhicloudlab/classic-wcareweb:latest

echo "build completed ...."