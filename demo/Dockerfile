FROM openjdk:17-jdk-alpine as build
# FROM openjdk:17-jdk-alpine
WORKDIR /srv

COPY gradle gradle
COPY build.gradle settings.gradle gradlew ./
COPY src src

RUN ./gradlew build -x test
RUN mkdir -p build/libs/dependency && (cd build/libs/dependency; jar -xf ../*.jar)

FROM openjdk:17-jdk-alpine

EXPOSE 8080

RUN mkdir /app

COPY --from=build /srv/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-jar","/app/spring-boot-application.jar"]

