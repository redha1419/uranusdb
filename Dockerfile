FROM azul/zulu-openjdk:latest
MAINTAINER Max De Marzi<maxdemarzi@gmail.com>
EXPOSE 8080
COPY $ROOT/target/uranusdb.jar uranusdb.jar
CMD ["java", "-jar", "uranusdb.jar"]
