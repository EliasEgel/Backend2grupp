FROM amazoncorretto:17-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/demo-0.1-boot.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
