FROM openjdk:21
COPY target/clibank-1.0.0.jar clibank-1.0.0.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/clibank-1.0.0.jar"]