#!/bin/bash

sudo docker network create bookshelf

sudo docker run -d --name mysql-bookshelf \
-p 3306:3306 \
--network=bookshelf \
--restart=always \
-e MYSQL_DATABASE=bookshelf \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_USER=root \
-e MYSQL_PASSWORD=root \
mysql/mysql-server:5.7