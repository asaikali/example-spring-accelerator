# Multistage docker build that splits the spring boot app into three layers
# Layer with all the libraries which are likely to be the same between
# mutliple builds of the container which means better layer caching
# Layer with the app META-INF
# layer with the actualy app code

# in the first stage we extract the executable boot jar into /app
# so that the following stage can copy it
FROM adoptopenjdk:11-jre-hotspot as builder
WORKDIR application
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# in this stage we produce the four layer spring boot image
FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
VOLUME /tmp
EXPOSE 8080
USER nobody
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
