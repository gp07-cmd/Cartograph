# Build stage: compile and package with Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn -B --no-transfer-progress dependency:go-offline
COPY src ./src
RUN mvn -B --no-transfer-progress package -DskipTests

# Runtime stage: JRE only
FROM eclipse-temurin:17-jre
WORKDIR /app
RUN mkdir -p /app/data
COPY --from=build /build/target/cartograph-*.jar app.jar
EXPOSE 8080
ENV CARTOGRAPH_SQLITE_PATH=/app/data/cartograph.db
ENTRYPOINT ["java", "-jar", "app.jar"]
