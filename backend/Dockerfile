FROM openjdk:8u191-jre-alpine3.8
WORKDIR /app
ENV TZ=America/Manaus
RUN apk add tzdata
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY ./target/ .
ENTRYPOINT ["java", "-jar", "bookshelf.jar"]
CMD []

# execution example sending parameters:
# docker run -p 8080:8080 meloafc/bookshelf:backend --spring.datasource.url=jdbc:mysql://localhost/bookshelf?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false --spring.datasource.username=root --spring.datasource.password=root