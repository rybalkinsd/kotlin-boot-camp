# Bomberman ifrastructure

We are going to start our game development. 
Now it's a part to create big part of our infrastructure, including matchmaker and landing page logic.
**game server** will be implemented later

![](top_view.png)

API that our user see:
    `join(name: String)`
	User opens game web page (localhost:8080) and see the landing page (index page)
	with the only button [Play] and a text form to enter his nickname.



Under the hood (**Implement this service**):
1. Matchmaker service.
	Matchmaker should handle `play` button request from user and provide a valid game session id to the user
	User is waiting until Matchmaker will respond with the `game id`.  

	Specification  
	  ```
	    Protocol: HTTP
	    URL: matchmaker/join
	    Method: POST
	    Host: {IP}:8080 (IP = localhost for local server tests)
	    Headers:
		    Content-Type: application/x-www-form-urlencoded
	    Body:
		    name={}
	    Response: 
		    Code: 200
		    Сontent-Type: text/plain
		    Body: gameId (guid)
	  ```

	1.1) Matchmaker is creating a new games when necessary.
	Matchmaker provides same gameId to N client connections(players) 
	Matchmaking algorithm was described in lectures  

	1.2) Monitoring urls

2. Game service (for now it should a stub/mock only)

	API:
	```
	gameId create(playerCount: int): String
	
	connect(name: String, gameId: String)

	start(gameId: String)
	```

	## Services communication
	At some point Matchmaker asks Game service to `create` a new game for `playerCount` users.
	After that Matchmaker will provide this `gameId` to clients and clients will
	`connect` to the exact game using `gameId` and `name`

	At some point Matchmaker starts the game with `gameId`.
	In general it should be when number of connected players equals to number of players that should play in one game.

	Specification  
	```
	    Protocol: HTTP
	    Path: game/create
	    Method: POST
	    Host: {IP}:8090 (IP = localhost for local server tests)
	    Headers:
		    Content-Type: application/x-www-form-urlencoded
	    Body:
		    playerCount={}
	    Response: 
		    Code: 200
		    Сontent-Type: text/plain
		    Body: gameId
	```

	```
	    Protocol: HTTP
	    Path: game/start
	    Method: POST
	    Host: {IP}:8090 (IP = localhost for local server tests)
	    Headers:
		Content-Type: application/x-www-form-urlencoded
	    Body:
		    gameId={}
	    Response: 
		    Code: 200
		    Сontent-Type: text/plain
		    Body: gameId
	```

	```
	    Protocol: WS
	    Path: game/connect?gameId={}&name={}
	    Host: {IP}:8090 (IP = localhost for local server tests)

	    Result: 
		WS connection established
	```



## Deadline and HowTo?
- `git checkout -b matchmaker` and work in this branch
- create `matchmaker` directory in the root of repository and write code in this folder (travis-ci will build this directory)


<!---
title Game infrastructure

Alice->Matchmaker: join(name=Alice) 
note right of Alice: POST matchmaker/join 
note right of Matchmaker: Matchmaker doesn't have vacant games 
note right of Matchmaker: Matchmaker has to ask for a new one 
Matchmaker->GameService: create(playerCount=2) 
note right of Matchmaker: POST create 
note right of GameService: GameService creates new game 
GameService->Matchmaker: gameId: 42 
Matchmaker-> Alice: gameId: 42 
Alice-> GameService: connect(gameId=42, name=Alice) 
note right of Alice: Alice is connected to GameService via websocket 
note right of Matchmaker: now game 42 has 1 out of 2 players 
Bob->Matchmaker: join(name=Bob) 
note right of Matchmaker: Matchmaker has a vacant place in game 42 
Matchmaker->Bob: gameId=42 
Bob->GameService: connect(gameId=42, name=Bob) 
note right of Bob: Bob is connected to GameService via websocket
note right of Matchmaker: now game 42 has 2 out of 2 players 
note right of Matchmaker: time to ask GameService to start game 42 
Matchmaker->GameService: start(gameId=42)
-->
