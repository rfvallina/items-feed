### Description

Items Feed which returns items in real time using Java, SSE and Spring. As soon as the server finds a new item it has to push it to the client. The client simply opens a channel and keeps listening the stream of updates. Since the client doesn’t need to send any data, we don’t need bi-directional communication, so SSE becomes a very good solution.

This application is basically a REST API built using Spring Boot 1.5.3.

### How to run

- mvn clean install
- java -jar target/*.jar

### Test

Open file html/feed.html in a browser and you will see the items coming in