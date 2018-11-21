---
<!-- .slide: class="center" -->
@title[Kotlin]

### Lecture 8
#### WebSocket and Final Project 


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
git checkout -b lecture08 upstream/lecture08
cd lecture08
```

open as new project


---
@title[Agenda]
0. @css[highlight](WebSocket)
0. Game architecture
0. Game client
0. Time model
0. Client-server protocol
0. Project task

---

@title[Architecture overview]
<!-- .slide: class="center" -->
<img src="lecture08/slides/assets/images/Bomberman-architecture.png" alt="exception" style="width: 900px;"/>

---
@title[Client-server communication]
- Why is HTTP @css[highlight](bad) for client-server communication in real-time games?  
- What alternatives do we have?  

---
@title[WebSocket]
- client-server
- full-duplex
- application-layer
- over single TCP connection
- protocol (@css[highlight](ws://) @css[highlight](wss://))

Standartized in 2011 [https://tools.ietf.org/html/rfc6455](https://tools.ietf.org/html/rfc6455)  
Can be used for any extensive client-server communication  
Supported by most modern browsers

---
@title[WebSocket]
### Client-server
client is the one who initializes session

### Full-duplex
exchange data in both directions

---
@title[OSI]
![OSI](lecture08/slides/assets/images/osi2.png) 

---
@title[WebSocket is application on layer]
![WebSocket in OSI](lecture08/slides/assets/images/osi.png) 

---
@title[WebSocket]
### Application layer
WebSocket works over TCP/IP (typically).  
WebSocket is initialized via @css[highlight](HTTP UPGRADE) to websocket

### Over single TCP connection
Single TCP connection is used for communication.
Then no handshakes or headers required. @css[highlight](Only raw data)

---
@title[WebSocket]
![WebSocket](lecture08/slides/assets/images/websocket.png) 

---
@title[WebSocket library]
There are a number of @css[highlight](websocket) implementations. We will use spring boot @css[highlight](websocket implementation)  
> @see build.gradle.kts

---
@title[Websocket library interface]
All communication happen via @css[highlight](WebSocketSession) interface

---
@title[Notes]
- @css[highlight](websocket) allow string data as well as binary data interchange
- @css[highlight](websocket) declares max message length (configurable)
- @css[highlight](websocket) session auto-closes when inactive (configurable)

---
@title[sniff websocket traffic with tcpdump]
[http://www.tcpdump.org/](http://www.tcpdump.org/)  
tcpdump - standard unix tool to fo traffic analysis. It can inspect @css[highlight](websocket) too
```bash
tcpdump -Aq -s0 -i lo0 'tcp port 8090'
```
It can be encrypted

---
@title[Another nice tools]
**tcpflow**  
[tcpflow on github](https://github.com/simsong/tcpflow)  
**wireshark**  
[home page](https://www.wireshark.org/)

---
@title[Example WebSocket chat]
> @see lecture08/io.rybalkinsd.kotlinbootcamp.websocket
1. Launch ChatApplication
2. Go to localhost:8080 in browser
3. You can open multiple tabs to check interaction
@css[highlight](say) and basic @css[highlight](login) are implemented

---
@title[WebSocket chat code]
### Server
> @see io.rybalkinsd.kotlinbootcamp.websocket.ChatApplication.kt

It serves @css[highlight](login) and @css[highlight](say)  WebSocket requests on @css[highlight](/chat) url  

### Client
> @see resources/static/index.html

Client sends @css[highlight](login) and @css[highlight](say) messages


---
@title[Practice]
- Add user name before message
- Implement sending message after login: "user-x logged in"
- Implement login with form, not prompt
- Implement logout button
- Save message history on server


---
@title[Agenda]
0. Websocket
0. @css[highlight](Game architecture)
0. Game client
0. Time model
0. Client-server protocol
0. Project task


---
@title[Architecture overview]
<!-- .slide: class="center" -->
<img src="lecture08/slides/assets/images/Bomberman-architecture.png" alt="exception" style="width: 900px;"/>


---
@title[Game Server]
Game Server is a separate application that do in cycle:
0. get's input from multiple clients
0. play game mechanics
0. send game state to clients (replica)
  
**On the next picture green components are already developed**


---
@title[Architecture]
<!-- .slide: class="center" -->
<img src="lecture08/slides/assets/images/GameServerArchitecture.png" alt="exception" style="width: 900px;"/>


---
@title[Multithreading]
Game server is a multithreaded application  
For each game:  
1. Many threads - get user input
1. One thread - Game mechanics
1. Many threads broadcast replica
  
More details in the next lecture


---
@title[Agenda]
0. Websocket
0. Game architecture
0. @css[highlight](Game client)
0. Time model
0. Client-server protocol
0. Project task


---
@title[Game client]
Game client is a separate HTML5 project (js+canvas)  
https://github.com/rybalkinsd/atom-bomberman-frontend  
Check it out


---
@title[Fork game client]
<!-- .slide: class="center" -->
<img src="lecture08/slides/assets/images/client-actions.jpg" alt="exception" style="width: 800px;"/> 


---
@title[JS components]
1. bootstrap - common purpose [link](http://getbootstrap.com/)
1. PreloadJS - assets upload [link](http://www.createjs.com/preloadjs)
1. EaselJS - canvas operating [link](http://www.createjs.com/easeljs)

---
@title[Canvas]
<!-- .slide: class="center" -->
<img src="lecture08/slides/assets/images/canvas.png" alt="exception" style="width: 600px;"/> 


---
@title[Front instances]
- Player
- Bomb
- Fire
- Tile
- Bonus


---
@title[Front infrastructure]
- GameEngine - basic mechanics and render
- InputEngine - input handling 
- ClusterSettings - infrastructure settings

---
@title[Agenda]
0. Websocket
0. Game architecture
0. Game client
0. @css[highlight](Time model)
0. Client-server protocol
0. Project task


---
@title[Time model with variable tick time]
> @see io.rybalkinsd.kotlinbootcamp.tick.Ticker

In our model tick lasts until all messages from InputQueue are handled  
So every time tick time is different  
**Advantages/Disadvantages?**


---
@title[Time model with variable tick time]
<!-- .slide: class="center" -->
So game mechanics should take **elapsed** as a parameter and use it internally  


---
@title[Agenda]
0. Websocket
0. Game architecture
0. Game client
0. Time model
0. @css[highlight](Client-server protocol)
0. Project task


---
@title[Protocol]
## Client-server communication
Client and server talk via **websocket**  
We use **JSON** for messages  
### Client sends to server:
- MOVE
- PLANT_BOMB

### Server sends to client:
- REPLICA
- POSSESS


---
@title[MOVE]
client -> server
```json
{
  "topic":"MOVE",
  "data":
    {
      "direction":"UP"
    }
}
```
direction values: UP/DOWN/RIGHT/LEFT

---
@title[PLANT_BOMB]
client -> server
```json
{
   "topic": "PLANT_BOMB",
   "data": {}
}
```


---
@title[POSSESS]
server -> client  
(returns player pawn id, once on the start of game)
```json
{
   "topic": "POSSESS",
   "data": 123
}
```


---
@title[REPLICA]
```json
{
   "topic": "REPLICA",
   "data":
   {
       "objects":[{"position":{"x":16.0,"y":12.0},"id":16,"type":"Wall"},{"position":{"x":32.0,"y":32.0},"id":213,"velocity":0.05,"maxBombs":1,"bombPower":1,"speedModifier":1.0,"type":"Pawn"},{"position":{"x":32.0,"y":352.0},"id":214,"velocity":0.05,"maxBombs":1,"bombPower":1,"speedModifier":1.0,"type":"Pawn"}],
       "gameOver":false
   }
}
```

---
@title[Network implementation ideas]
> @see io.rybalkinsd.kotlinbootcamp.network



---
@title[Agenda]
0. Websocket
0. Game architecture
0. Game client
0. Time model
0. @css[highlight](Client-server protocol)
0. Project task


---
@title[Create a branch for game server]
Create the branch from branch lecture09, where you will develop the game server:
```bash
> git checkout -b game-server
```

---
@title[create a directory for game server]
create a directory for game server  
Call it **game_server**  
In this directory you will create game server from scratch


---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
