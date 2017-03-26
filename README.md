# DistributedSystem
Try Dubbo, Spring Cloud / Netflix OSS, docker

    | Dubbo | Spring Cloud | Netflix OSS
--- | --- | --- | ---
Service Call | RPC (Hessian, HTTP, RMI, Thrift, Memcached, Redis, etc) | REST API | ?
--- | --- | --- | ---
Service Registration and Discovery | Zookeeper | Spring Cloud Netflix Eureka | Netflix Eureka 
--- | --- | --- | ---
Client Side Load balancer | Yes | Spring Cloud Netflix Ribbon | Netflix Ribbon
--- | --- | --- | ---
Circuit Breaker | Yes | Spring Cloud Netflix Hystrix | Netflix Hystrix
--- | --- | --- | ---
Intelligent Routing / Service Gateway | ? | Spring Cloud Netflix Zuul | Netflix Zuul
--- | --- | --- | ---
Distributed Configuration | Yes | Spring Cloud Config |  Netflix Archaius

Other technologies: Html, JQuery, Bootstrap

## Server
Calculate24Service provides an RESTful service

## Client
GameCentre is the API gateway and sends HTTP requests to the services
