1-first we created our eureka server for service registry

1.1 modify application.yml

1.2 enable eureka server annotation on main method

2-we created first business service which is department service

2.1 modify application.yml

2.2 mark it as EnableDiscoveryClient annotation on main method

3-create config server with only 1 dependency which is config server

3.1 modify application.yml

3.2 created new folder "config" under resources folder

3.3 here we moved the config (application.yml) properties of department service to config server/resources/department-service.yml

3.4 and we should define config server path in department-service application.yml as:

config:
import: "optional:configserver:http://localhost:8088"

3.5 run projects and see department-service is getting properties from config server instead of its own application.yml

4-we will add zipkin.

4.1 search on google: docker zipkin

4.2 copy the command docker run -d -p 9411:9411 openzipkin/zipkin and run it so it will pull and run zipkin

4.3 add zipkin dependencies to department service

4.4 add property to config-server/resources/config/department-service that "management.tracing.sampling.probability=1.0" so all logs of department service will go to zipkin

5-add business logic to department service (simple repository model and controller and we didn't use db for simplicity)

5.1 add and get some departments and then go to zipkin dashboard to check requests