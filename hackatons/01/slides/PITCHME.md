---
<!-- .slide: class="center" -->
@title[Kotlin]

#### Web hackaton


---
@title[Sign in]
<!-- .slide: class="center" -->

Please [**sign in**](https://sphere.mail.ru/)
 
*For off-line students only*

---

### get ready
```bash
git fetch upstream
git checkout -b web_hackaton upstream/web_hackaton
cd web_hackaton
```
open as new project

---

Разделитесь на группы по **3**

---

- Реализуйте сервер для **чата**
- Реализуйте как можно больше фич (следующий слайд)
Подумайте, за какие фичи стоит взяться, а какие вам не под силу
- 20.30 - заканчиваем реализацию и показываете нам **список фичей** и ссылку на сервер, по которой мы можем получить ваш **index.html**
- группы с наибольшим количеством фичей показывают свой сервис

---

**Features:**
1. chat/say, chat/online, chat/logout - 4p
1. save history to file on server - 2p
1. message timestamp - 2p
1. different colors for name and timestamp - 2p
1. hrefs highlighting - 2p
1. anti-spam - 2p
1. anti-injection - 2p
1. test fixes - 2p
1. deploy to aws - 3p
1. test with server startup inside - 3p
1. list of online users in side panel - 3p
1. authentication - 3p
1. pretty frontend - 2p each feature

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
    Body params:
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

@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
