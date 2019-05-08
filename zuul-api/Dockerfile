FROM openjdk:11

WORKDIR /app

COPY . .

WORKDIR /app/target

RUN ls -la

CMD ["java","-jar", "zuul-api-0.0.1-SNAPSHOT.jar"]



