---
<!-- .slide: class="center" -->
@title[Kotlin]

### Lecture 4
#### Kotlin web


---
@title[Sign in]
<!-- .slide: class="center" -->

Please [**sign in**](https://sphere.mail.ru/)
 
*For off-line students only*


---
@title[Get ready]
<!-- .slide: class="center" -->
```bash
git fetch upstream
git checkout -b lecture05 upstream/lecture05
cd lecture05
```

open as new project


---
@title[Agenda]
1. @css[highlight](Annotations)
1. Spring Boot
1. Inversion of Control, Dependency Injection
1. Beans, ApplicationContext

---
TODO

---

@title[Agenda]
1. Annotations
1. @css[highlight](Spring Boot)
1. Inversion of Control, Dependency Injection
1. Beans, ApplicationContext

---
### Web server
**Spring boot** starts application  
that starts embedded **tomcat**  
that runs **spring**

---
### Spring
<img src="lecture05/presentation/assets/img/spring-by-pivotal.png" alt="exception" style="width: 300px;"/>  
is a universal open-source framework, used to develop web applications  
https://spring.io/  
  
First version - **2002**

---
### Spring modules
It includes a number of modules for different functionality:
- Spring MVC for building Web Applications
- Working with Databases
- Messaging
- RPC
- Security
- Testing
  
Today we will build web application with **Spring MVC** module

---
### Spring Boot
Spring is a powerful tool and has a lot of configuration options.  
**Spring Boot** is a project, that makes working with Spring easier:
- embedded tomcat included with servlet container
- minimum configuration, sane defaults
- metrics, health checks and externalized configuration
https://projects.spring.io/spring-boot/  
  
First version: **2014**
  
**With Spring Boot our life is much easier :)**


---
### Spring boot distribution
TODO
```groovy
    // dependencies, necessary for building generic web applicaitons
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-web', version: '2.0.0.RELEASE'
    // actuator
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-actuator', version: '2.0.0.RELEASE'
```

---

### Spring boot actuator
Spring boot actuator - useful dependency, providing web interface to meta data of application and even interact with it  
  
**Actuator endpoints:**
https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html  
By default most endpoints are disabled. To enable them we need to enable them in **application.properties**

---

### application.properties
The standard way to configure java application - **application.properties** should appear in classpath  
To enable actuator endpoints:
```properties
management.endpoints.web.exposure.include=*
```
We also can configure actuator and server ports there:
```properties
#server port:
server.port = 8080
#actuator port:
management.server.port = 7001
```

---
### Useful actuator endpoints
**/actuator/health**  
overall application status  
  
**/actuator/mappings**  
available mappings  
  
**/actuator/beans**  
all beans in context
---

@title[Agenda]
1. Annotations)
1. Spring Boot
1. @css[highlight](Inversion of Control, Dependency Injection)
1. Beans, ApplicationContext

---

### Inversion of Control
**Principle:** control flow is transferred to external framework  
**Why:** loose coupling, easier to develop, easier to test

---

### Dependency Injection
Objects lifecycle is managed by external framework (**IoC container**)
- instantiation
- wiring
- removal

---

### Spring provides IoC container
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans  
Interface of **IoC Container** in Spring:  
**org.springframework.context.ApplicationContext**  
- methods for accessing application components. **ListableBeanFactory**
- methods to load file resources in a generic fashion. **ResourceLoader**
- methods to publish events to registered listeners. **ApplicationEventPublisher**
- methods to resolve messages, supporting internationalization. **MessageSource**

---

@title[Agenda]
1. Annotations)
1. Spring Boot
1. Inversion of Control, Dependency Injection)
1. @css[highlight](Beans, ApplicationContext)

---

### Beans
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-definition  
Beans are java objects, that are managed by **IoC Container**  
  
How to make **bean** out of **POJO** (Plain Old Java Object)?  
With bean definition configuration

---
### Spring configuration
There are several options for beans configuration:
- XML Description
- Groovy Description
- Annotations
  
We will use annotations as this is the cleanest one

---

### Beans Detection
For spring to create and manage beans, we must provide bean definitions  
**How to create bean definition with annotations:**
- mark class with **@Configuration**/**@Component**/**@Controller**/**@Service**/**@Repository** or annotations, inheriting their semantics
- mark any method inside such class with **@Bean** (config method)

---

### Beans autowiring
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation  
Once we have beans definitions, we can inject those beans with **@Autowired**  
Possible targets:
- constructor
- field
- setter method
- config method

---

## ByType and ByName autowiring
```java
@Service
public class MatchMaker implements Runnable {
    @Autowired //How do spring know which bean to inject?
    private ConnectionQueue connectionQueue;
}
```
- ByType: it will search the bean with type **ConnectionQueue** or implementation in ApplicationContext
- ByName: with **@Qualifier** annotation we can autowire bean by name  
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation-qualifiers
---

### Bean scopes
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-scopes
Beans can have different life span depending on requirements.  
  
**[Common scopes:]**  
- singleton (default)
- prototype: single bean definition to any number of object instances
- request: single bean definition to the lifecycle of a single HTTP reques
- websocket: single bean definition to the lifecycle of a WebSocket
...

---

### Spring: see documentation
Both basic concepts and details are fully covered in spring documentation.
https://docs.spring.io/spring/docs/current/spring-framework-reference/index.html


---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
