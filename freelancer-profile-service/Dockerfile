FROM openjdk:11

ADD ./target/freelancer-profile-service-0.0.1-SNAPSHOT.jar /usr/src/freelancer-profile-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "freelancer-profile-service-0.0.1-SNAPSHOT.jar"]
