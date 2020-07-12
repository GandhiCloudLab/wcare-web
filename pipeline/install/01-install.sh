#!/usr/bin/env bash

echo 'installation started .............................'

oc apply -f ../yaml/1-namespace/
oc apply -f ../yaml/2-tasks/
oc apply -f ../yaml/3-pipeline/

echo 'installation completed .............................'
