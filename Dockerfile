FROM eclipse-temurin:17-jre-focal

EXPOSE 8080

COPY /ori-infrastructure/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "/app.jar"]
