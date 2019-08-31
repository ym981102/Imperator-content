FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} imperatpr-content.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8800
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
