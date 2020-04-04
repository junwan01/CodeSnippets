#!/bin/bash

# run jun-notebook docker image, which is built using the file /Users/jwan/Documents/ML/jupyter_notebooks/Dockerfile 
docker run --rm -p 8888:8888 --name notebook -e JUPYTER_LAB_ENABLE=yes -v /Users/jwan/Documents/ML/jupyter_notebooks:/home/jovyan/work jun-notebook:1.0
