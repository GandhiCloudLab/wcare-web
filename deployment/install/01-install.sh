#!/usr/bin/env bash

cd ..

kubectl apply -f ./yaml --validate=false

kubectl apply -f ./yaml/30-mysql8 --validate=false
