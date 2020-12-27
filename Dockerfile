FROM openjdk:14-jdk AS app-build

ENV GRADLE-OPTS -Dorg.gradle.deamon=false;
COPY . /build
WORKDIR /build
RUN ./gradlew build