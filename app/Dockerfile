# Step : Test and package
FROM maven:3.8.4-eclipse-temurin-17 as target
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn clean install -DskipTests

# Step : Package image
FROM openjdk:17
EXPOSE 4567
CMD exec java $JAVA_OPTS -jar /app/my-app.jar
COPY --from=target /build/target/application*.jar /app/my-app.jar