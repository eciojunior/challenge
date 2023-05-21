FROM openjdk:17-alpine
ADD ./target/*.jar /deployments/
WORKDIR /deployments
ENTRYPOINT ["java", "-jar", "challenge-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080