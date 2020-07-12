#!/usr/bin/env bash

echo 'uninstallation started .............................'

oc delete -f ../yaml/3-pipeline/
oc delete -f ../yaml/2-tasks/
oc delete -f ../yaml/1-namespace/

echo 'uninstallation completed .............................'
