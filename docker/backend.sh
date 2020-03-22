#!/bin/bash

sudo docker network create bookshelf

sudo docker run -d --name backend-bookshelf \
-p 8080:8080 \
--network=bookshelf \
--restart=always \
meloafc/bookshelf:backend \
    --spring.datasource.url='jdbc:mysql://mysql-bookshelf/bookshelf?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false' \
    --spring.datasource.username='root' \
    --spring.datasource.password='root'