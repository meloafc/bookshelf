#!/bin/bash

mvn clean install -DskipTests
docker build -t meloafc/bookshelf:backend .
docker push meloafc/bookshelf:backend