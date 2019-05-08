FROM openjdk:11

ADD ./target/project-owner-profile-service-0.0.1-SNAPSHOT.jar /usr/src/project-owner-profile-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "project-owner-profile-service-0.0.1-SNAPSHOT.jar"]