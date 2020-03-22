#!/bin/bash

docker build -t meloafc/bookshelf:frontend .
docker push meloafc/bookshelf:frontend