#!/usr/bin/env bash

echo "build Started ...."

docker login -u $(oc whoami) -p $(oc whoami -t) docker-registry.default.svc:5000
docker build -f Dockerfile -t docker-registry.default.svc:5000/wcare-ns/wcareweb:latest . --no-cache
docker push docker-registry.default.svc:5000/wcare-ns/wcareweb:latest

echo "build completed ...."