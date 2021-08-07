#FROM adoptopenjdk/openjdk11:ubi
#ARG JAR_FILE=target/*.jar
#ENV BOT_NAME=test_vs_javarush_bot
#ENV BOT_TOKEN=1883782541:AAFDGBvChlIlJlMWEe_mufZIwgwYGGI7qsU
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]


FROM adoptopenjdk/openjdk8:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_vs_javarush_bot
ENV BOT_TOKEN=1883782541:AAFDGBvChlIlJlMWEe_mufZIwgwYGGI7qsU
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.username=${BOT_NAME}","-Dbot.token=${BOT_TOKEN}","-jar","/app.jar"]

#RUN mkdir /opt/app
#COPY japp.jar /opt/app
#CMD ["java", "-jar", "/opt/app/japp.jar"]