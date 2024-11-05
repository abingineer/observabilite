FROM openjdk:21
LABEL authors="aboubacar diallo" email="aboubacard659@gmail.com"
VOLUME /tem
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]