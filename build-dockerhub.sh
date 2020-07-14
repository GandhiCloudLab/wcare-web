#!/usr/bin/env bash

echo "build Started ...."

docker build -f Dockerfile -t gandhicloudlab/wcareweb:latest . --no-cache

# docker login -u gandhicloudlab

docker push gandhicloudlab/wcareweb:latest

echo "build completed ...."