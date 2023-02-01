# quidditch-be

Individual task for passing design and technological practice.

# Setup

### Install PostgreSQL server from (desirable 15): 
https://www.postgresql.org/download/windows/

Start-up server on port 1234 or change it in: 
    
    application.properties
        spring.datasource.url
    pom.xml
        flyway-maven-plugin config

Create database: "q-db" using:

    CREATE DATABASE "q-db"

Deploy database using:

    mvn flyway:migrate

if something went wrong run: 
    
    mvn flyway:repair

Before start ensure you using JDK 11 or newer and Maven been installed.
Download and install maven from: https://maven.apache.org/download.cgi.
Manual: https://maven.apache.org/install.html.

Run application from main using Idea configuration.

Go to localhost:8080