#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

# Add environment variables
export BOT_NAME=test_vs_javarush_bot
export BOT_TOKEN=1883782541:AAFDGBvChlIlJlMWEe_mufZIwgwYGGI7qsU

# Start new deployment
docker-compose up --build -d
