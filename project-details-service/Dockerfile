FROM openjdk:11

ADD ./target/Project-Details-0.0.1-SNAPSHOT.jar /usr/src/Project-Details-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "Project-Details-0.0.1-SNAPSHOT.jar"]
