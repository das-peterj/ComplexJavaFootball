FROM openjdk:15
COPY ./target/ComplexJavaFootball-0.0.1-SNAPSHOT.jar /usr/src/football
WORKDIR /usr/src/football
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ComplexJavaFootball-0.0.1-SNAPSHOT.jar"]