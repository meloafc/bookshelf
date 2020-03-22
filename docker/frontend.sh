#!/bin/bash

sudo docker run -d --name frontend-bookshelf \
-p 80:80 \
--restart=always \
meloafc/bookshelf:frontend