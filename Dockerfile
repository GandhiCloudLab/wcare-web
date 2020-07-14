FROM maven:3.6.3-jdk-11-slim as builder
RUN ls -l 
COPY . .
RUN ls -l 
RUN mvn clean package
RUN ls -l 
RUN ls -l target

FROM anapsix/alpine-java:8
WORKDIR /
COPY --from=builder /target/wcareweb-service-0.0.1-SNAPSHOT.war app.war
RUN ls -l
RUN sh -c 'touch /app.war'
EXPOSE 9020
ENTRYPOINT ["java","-jar","/app.war"]