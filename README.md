# DistributedSystem
Try Dubbo, Spring Cloud / Netflix OSS, docker

|     | Dubbo | Spring Cloud | Netflix OSS |
| --- | --- | --- | --- |
| Service Call | RPC (Hessian, HTTP, RMI, Thrift, Memcached, Redis, etc) | REST API | ? |
| Service Registration and Discovery | Zookeeper | Spring Cloud Netflix Eureka | Netflix Eureka | 
| Client Side Load balancer | Yes | Spring Cloud Netflix Ribbon | Netflix Ribbon |
| Circuit Breaker | Yes | Spring Cloud Netflix Hystrix | Netflix Hystrix |
| Intelligent Routing / Service Gateway | ? | Spring Cloud Netflix Zuul | Netflix Zuul |
| Distributed Configuration | Yes | Spring Cloud Config ? Netflix Archaius ? |  Netflix Archaius |

Other technologies: Html, JQuery, Bootstrap

## Server
Calculate24Service provides an RESTful service

## Client
GameCentre is the API gateway and sends HTTP requests to the services

# Release Notes

### 1.0.1
There's only one server of Calculate24Service (localhost:8090)

GameCentre calls the REST interface of Calculate24Sevice with static IP address via JQuery ajax
