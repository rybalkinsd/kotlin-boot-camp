---
<!-- .slide: class="center" -->
@title[Bulls and Cows]

---

@title[Bulls and Cows]
- Implement [Bulls and Cows game](https://en.wikipedia.org/wiki/Bulls_and_Cows)  
- make pull request to **assignment04** branch  
- use dictionary from **[assignment04/assignments/04/task/dictionary.txt](https://github.com/rybalkinsd/kotlin-boot-camp/blob/assignment04/assignments/04/task/dictionary.txt)**  
- **deadline**: october 16  
- **mark**: 7 max  
  

---
@title[Game stages]
1. Game prints **welcome text**
2. Game gets random word from **dictionary.txt** and prints **greeting with word length**
3. The game asks user for guess until user wins or **10 attempts** looses
4. If **win**, print congratulations; if **loose**, print loose text
5. Player is suggested to **start new game**

---
@title[Example game]
```text
Welcome to Bulls and Cows game!        //welcome text
I offered a 4-letter word, your guess? //greeting, hidden word is 'java'
> atom                                 //your guess
Bulls: 0   
Cows: 1
> lava
Bulls: 3
Cows: 0
> java
You won!                                // win text
Wanna play again? Y/N                   // suggest for new game
> N
```

---
@title[Implementation details]
0. You need to develop a standalone kotlin application  
0. Your application should work with console input/output  
0. Application should be able to run from console with
```bash
java -jar BullsAndCows.jar  
```
0. You need to check all the exceptional situations (wrong input...)

