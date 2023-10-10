#!/bin/bash

timestamp=$(date +%Y-%m-%d-%T)

git add .

git commit -m "$timestamp"

git push
