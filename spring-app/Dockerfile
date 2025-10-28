FROM openjdk:21-slim
COPY spring-app/build/libs/spring-app.jar app.jar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
