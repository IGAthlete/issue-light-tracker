# Use Java 17 base image
FROM eclipse-temurin:17-jdk as build

# Set workdir
WORKDIR /app

# Copy project files
COPY . .

# Build using Maven wrapper
RUN ./mvnw clean package -DskipTests

# Create runtime image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy built JAR
COPY --from=build /app/target/*.jar app.jar

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
