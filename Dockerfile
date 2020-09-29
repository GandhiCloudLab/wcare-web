FROM maven:3.6.3-jdk-11-slim as builder
COPY . .
RUN mvn clean package

FROM anapsix/alpine-java:8
WORKDIR /
COPY --from=builder /target/wcareweb-service-0.0.1-SNAPSHOT.war app.war
RUN sh -c 'touch /app.war'
EXPOSE 9020
ENTRYPOINT ["java","-jar","/app.war"]
