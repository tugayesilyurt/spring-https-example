# Docker Compose HTTPS using Self-Signed Certificate in Spring Boot example

## Run the System
We can easily run the whole with only a single command:

* `docker-compose up -d`


# Generating a Keystore

First of all create a keystore.

``` properties
keytool -genkeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -ext "SAN:c=DNS:https-server-service,IP:127.0.0.1" -keystore tugayesilyurt.p12 -validity 365
```


### EndPoints ###

| Service      	       | EndPoint                           	 | Method | Description                                     |
| -------------------- | --------------------------------------- | :-----:| ------------------------------------------------|
| client-service       | http://localhost:8020/v1/https/call     | GET    | http client call            	                |
| https-server-service | https://localhost:8090/v1/https/example | GET    | https server call            	                |


### SS ###

- **Keytool**

![Keytool](https://github.com/tugayesilyurt/spring-zipkin-cassandra/blob/main/assets/keytool.PNG)

- **Bad Requet**

![Badrequest](https://github.com/tugayesilyurt/spring-zipkin-cassandra/blob/main/assets/badrequest.PNG)

- **Docker**

![Docker](https://github.com/tugayesilyurt/spring-zipkin-cassandra/blob/main/assets/docker.PNG)
	
- **Postman**

![Postman](https://github.com/tugayesilyurt/spring-zipkin-cassandra/blob/main/assets/postman.PNG)