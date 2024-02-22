FROM maven:3.8.4-openjdk-17-slim as builder
WORKDIR /workspace/app
COPY pom.xml .
COPY src src
RUN mvn install -DskipTests

FROM maven:3.8.4-openjdk-17-slim as extracter
WORKDIR /workspace/app
ARG VERSION=-0.0.1-SNAPSHOT
ARG JAR_FILE=whats-next${VERSION}.jar
COPY --from=builder /workspace/app/target/${JAR_FILE} .
RUN java -Djarmode=layertools -jar ${JAR_FILE} extract

FROM amazoncorretto:17.0.7-alpine
WORKDIR /workspace/app
COPY --from=extracter /workspace/app/dependencies/ ./
COPY --from=extracter /workspace/app/spring-boot-loader/ ./
COPY --from=extracter /workspace/app/snapshot-dependencies/ ./
COPY --from=extracter /workspace/app/application ./
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]