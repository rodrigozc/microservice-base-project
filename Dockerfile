FROM rodrigozc/jdk8-application:latest

ENV APPLICATION_NAME microservice-base-project
ENV LOCALE "pt_BR.UTF-8"
ENV LOCALTIME "America/Sao_Paulo"

ADD *.jar /app/app.jar 
ADD application.* /app/
ADD consul/service.* /etc/consul/
