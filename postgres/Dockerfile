# Sử dụng Maven 3.9.9 với Amazon Corretto 21 làm base image
FROM maven:3.9.9-amazoncorretto-21 AS builder

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Copy tệp pom.xml vào container
COPY pom.xml .

# Tải dependencies với Maven
RUN mvn dependency:go-offline

# Copy mã nguồn vào container
COPY src ./src

# Build ứng dụng Spring Boot
RUN mvn clean package -DskipTests

# Sử dụng Amazon Corretto 21 cho phần runtime
FROM amazoncorretto:21

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Copy JAR file đã build từ bước trước
COPY --from=builder /app/target/*.jar postgres.jar

# Expose cổng 8080
EXPOSE 8080

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "postgres.jar"]