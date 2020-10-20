#!/usr/bin/env bash

echo "build Started ...."

docker login -u gandhicloudlab
docker build -f Dockerfile -t gandhicloudlab/wcareweb:latest . --no-cache
docker push gandhicloudlab/wcareweb:latest

echo "build completed ...."