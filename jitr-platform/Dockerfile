FROM maven:3.6.3-jdk-11-slim AS build

WORKDIR /home/app

COPY . .

RUN mvn dependency:resolve

RUN mvn clean install -DskipTests

CMD ["mvn", "spring-boot:run"]