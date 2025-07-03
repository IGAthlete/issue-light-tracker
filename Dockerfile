# Use Java 17 base image
FROM eclipse-temurin:17-jdk as build

# Set workdir
WORKDIR /app

# Copy all project files
COPY . .

# Make gradlew executable (important!)
RUN chmod +x ./gradlew

# Build the project skipping tests
RUN ./gradlew clean build -x test

# Create runtime image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]