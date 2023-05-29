FROM amazoncorretto:17-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT-boot.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/app.jar"]