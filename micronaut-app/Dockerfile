FROM openjdk:21-slim
COPY micronaut-app/build/libs/micronaut-app.jar app.jar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
