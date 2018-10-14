---
<!-- .slide: class="center" -->
@title[Introduction to Web]

---?image=web/assets/images/welcome-to-internet.jpg&size=50% auto

---
@title[Agenda]
1. **[Bomberman project]**
1. HTTP
1. REST API
1. cURL
1. Kotlin HTTP Client (kohttp)

---

@title[Project - server for multi-player game]
**Original project by Matt Scala:**  
https://github.com/MattSkala/html5-bombergirl  
http://bombergirl.matousskala.cz/  
  
**Adopted version for our project:**  
https://github.com/rybalkinsd/atom-bomberman-frontend

---?image=web/assets/images/Bomberman-arch.png&size=70% auto
@title[Architecture overview]
---

@title[Bomberman stack]
Bomberman is actually a **web application** with client-server architecture
- Front-end is HTML5 + js (is ready)
- Back-end is kotlin

---

@title[Agenda]
1. Bomberman project
1. **[HTTP]**
1. cURL
1. REST API
1. Kotlin HTTP Client (kohttp)

---
@title[How do remote programs communicate?]
Like browser and remote server  
Or one service with another service  
  
A whole stack of protocols can be involved  
You know the OSI model, don't you?

---?image=web/assets/images/osi2.png&size=70% auto

---
@title[HTTP over TCP/IP]
In practice in modern web applications you will most of the time work with **HTTP** over **TCP/IP**.  

|                      |                     |
|----------------------|---------------------|
|**Application layer** | HTTP+DNS            |  
|**Transport layer**   | TCP/UDP             |
|**Internet layer**    |IP                   |
|**Link layer**        |Ethernet, IEEE 802.11|
|                      |                     |
---

@title[HTTP - Application layer client-server protocol]
What happens when we request example.org?  
![HTTP](web/assets/images/HTTP.png)

---

@title[HTTP Server]
Aka **Web Server**.
Serves HTTP requests. (By default on **80 TCP port**)
- Apache
- NGINX
- embedded (as a library) - Jetty/Embedded Tomcat

Web servers have different functionality and can be extensible  
  
We can extend server functionality by custom logic and respond with dynamic content  
That's what we use to implement game

---

@title[HTTP Client]
- web browser
- cURL
- libraries (e.g. **libcurl**)
- telnet

---

@title[HTTP via browser]
When you enter address line in browser, in creates **GET** request  
So we can do previous example just by typing in browser:
> example.org

---

@title[HTTP via telnet]
```bash
> telnet example.org 80
```
request:
```http
GET /index.html HTTP/1.1
host: example.com
```
response:
```
HTTP/1.1 200 OK
Cache-Control: max-age=604800
Content-Type: text/html
Date: Wed, 14 Mar 2018 11:27:16 GMT
Etag: "1541025663+ident"
Expires: Wed, 21 Mar 2018 11:27:16 GMT
Last-Modified: Fri, 09 Aug 2013 23:54:35 GMT
Server: ECS (dca/53DB)
Vary: Accept-Encoding
X-Cache: HIT
Content-Length: 1270

<!doctype html>
<html>
    <head>
    ...
```

---

@title[HTTP Request]
**Request consists of**
1. Request method 
1. Request headers
1. Request body

**Methods:**
- **GET**
Request resource. **GET** must not change resource
- **POST**
Creates new resource
- **PUT**
Changes resource
- **DELETE**
removes resource
- ...

---

@title[HTTP Response]
**Response consists of**
1. Status code
1. Response headers
1. Response body

[rfc2616](https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html)  
[wiki](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)

---
@title[HTTP Basics]
[https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html](https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html)
- **Resource** - any entity
- **URI** - (Universal Resource Identifiers)
- **Method** - what to do with **resource**


---

@title[When to use HTTP for inter-program communication?]
**When we want:**
- simplicity (easy to develop and test)
- scalability (just use load balancer, i.e. **nginx**)

**under restrictions:**
- mediocre performance (not real time)
- initiated by client only - no push requests from server

---

@title[Agenda]
1. Bomberman project
1. HTTP
1. **[cURL]**
1. REST API
1. Kotlin HTTP Client (kohttp)

---

@title[cURL]
Super popular command line tool for multiple protocols testing (including **HTTP**)   
[https://curl.haxx.se/](https://curl.haxx.se/)  
it wraps **libcurl** library, which is available for all major languages

---

@title[GET Example]
Request from cURL:
```bash
> curl -i -X GET example.org
```
Response:
```http
HTTP/1.1 200 OK
Accept-Ranges: bytes
Cache-Control: max-age=604800
Content-Type: text/html
Date: Wed, 14 Mar 2018 11:30:27 GMT
Etag: "1541025663"
Expires: Wed, 21 Mar 2018 11:30:27 GMT
Last-Modified: Fri, 09 Aug 2013 23:54:35 GMT
Server: ECS (dca/24A0)
Vary: Accept-Encoding
X-Cache: HIT
Content-Length: 1270

<!doctype html>
<html>
  <head>
    ...
```

---

@title[POST Example]
Raw HTTP:
```http
POST /chat/say HTTP/1.1
Content-Type: application/x-www-form-urlencoded
Host: localhost:8080

name=sasha&msg=Hi everyone in this chat!
```
cURL:
```bash
> curl -X POST \
-d 'name=sasha&msg=Hi everyone in this chat!' \
http://localhost:8080/chat/say
```
response:
```http
HTTP/1.1 200 OK
Date: Wed, 11 Oct 2017 14:17:11 GMT
Content-Length: 0
Server: Jetty(9.4.z-SNAPSHOT)

```

---

@title[Agenda]
1. Bomberman project
1. HTTP
1. cURL
1. **[REST API]**
1. Kotlin HTTP Client (kohttp)

---

@title[REST]
**REST** (Representational State Transfer) architecture style, where services communicate over **HTTP**.  
There are also some restrictions on how services must use HTTP for communication

---

@title[REST API]
REST API is a common way for services to publish their functionality for other services.  
### REST API Examples:
**Twitter:** [https://dev.twitter.com/rest/public](https://dev.twitter.com/rest/public)  
**Github:** [https://developer.github.com/v3/](https://developer.github.com/v3/)

---

@title[Chat REST API]
We got a chat REST service open for you on my machine (will be sent to the chat) 
  
Further you have description of it's REST API

---

@title[Chat REST API. View Online]
online:
```
    URL: chat/online
    Method: GET
    Response:
      Success code: 200
```

---

@title[Chat REST API. Login]
login:
```
    URL: chat/login
    Method: POST
    Query params:
        name
    Response:
      Success code: 200
      Fail code:
        400 - Name is too short (less than 2 symbols)
        400 - Name is too long (more than 30 symbols)
```
---

@title[Chat REST API. View history]
chat:
```
    URL: chat/history
    Method: GET
    Response:
      Success code: 200
```

---

@title[Chat REST API. Say]
say:
```
    URL: chat/say
    Method: POST
    QueryParam: name
    Body params:
      name
      msg
    Response:
      Success code: 200
      Fail code:
        403 - User not online
        400 - Message is too long (longer than 140 symbols)
```


---
