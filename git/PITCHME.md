---
<!-- .slide: class="center" -->
@title[Introduction to Git]

---
# Git
Distributed **version control system**   
[Install git](https://git-scm.com/)

We only cover commands, necessary for our workflow  

---

### Prepare the local copy
1. Fork repository in github  
Now you have **un-synchronized** copy of https://github.com/rybalkinsd/kotlin-boot-camp named  
https://github.com/MY_NAME/kotlin-boot-camp.git
1. clone your fork
```bash
git clone https://github.com/MY_NAME/kotlin-boot-camp.git
```
Now you have **local copy** of **your fork**

1. Add **course repository** to the list of remote repositories (**remotes**) of **your local copy** to be able to synchronize your changes with **course repo**  
See next slide...

---
### Add upstream
1. Add **course repository** to the list of remote repositories (**remotes**) of **your local copy**
```bash
cd kotlin-boot-camp
git remote add upstream https://github.com/rybalkinsd/kotlin-boot-camp.git
git remote -v
origin  https://github.com/MY_NAME/kotlin-boot-camp.git (fetch)
origin  https://github.com/MY_NAME/kotlin-boot-camp.git (push)
upstream https://github.com/rybalkinsd/kotlin-boot-camp.git (fetch)
upstream https://github.com/rybalkinsd/kotlin-boot-camp.git (push)
```
**your fork** = **origin**  
**course repo** = **upstream**

---
### Theory
**Commit** = state of repository  
Inside git it is represented as tree of files in given state  
  
**HEAD** = current commit or branch  
  
**Branch** = reference to commit  
If your HEAD references branch and you commit, then branch reference moves

---
### Branches
You will do **homeworks** in branches (named **homeworkN**) and make **pull-request**   
All the **class activity** in repository will be in branches (named **lectureN**)  

[[Guide on using branches by Atlassian]](https://www.atlassian.com/git/tutorials/using-branches)
<img src="git/assets/images/branch.png" alt="branches" style="width: 400px; float: left;"/>  


---
### Rebase and merge

Main actions with branches:  
- merge SOME_BRANCH into ANOTHER_BRANCH  
```bash
git checkout ANOTHER_BRANCH
git merge SOME_BRANCH
```
If one file is affected in both branches since common ancestor you will need to resolve conflicts
- rebase SOME_BRANCH onto ANOTHER_BRANCH  
```bash
git checkout SOME_BRANCH
git rebase -i ANOTHER_BRANCH
```
**rebase -i** - interactive rebase. You will be able to changed your branch during rebase.  
Rebase changes history. If you push after rebase, you will need to push with force:
```bash
git push -f
```
Be careful to use **push -f** only when necessary  
Rebase is extremely powerful. Please read [[good rebase guide (rus)]](https://habr.com/post/161009/)

---
### Git pipeline. Make local changes
**course repository** = **upstream**  
**your fork** = **origin**  
1. Create branch from target upstream branch
```bash
git fetch upstream
git checkout -b MY_BRANCH upstream/TARGET_BRANCH
```
1. Make your changes
```bash
git add CHANGED_FILE
git commit CHANGED_FILE
```

---
### Git pipeline. Share changes
**course repository** = **upstream**  
**your fork** = **origin**  

1. Rebase your branch on TARGET_BRANCH and resolve conflicts (synchronize with upstream)
```bash
git rebase -i upstream/TARGET_BRANCH
```

1. Push your changes to **origin**
```bash
git push origin MY_BRANCH
```
1. Go to github and make **pull request** from **origin/MY_BRANCH** to **upstream/TARGET_BRANCH**


---
### git branch commands
See current branch (what is referenced by **HEAD**)
```bash
git branch
master
```
get branches update from **your fork** (it will update origin/... references)
```bash
git fetch origin
```
get branches update from **course repo** (it will update upstream/... references)
```bash
git fetch upstream
```
переключиться на ветку **lecture01** (move **HEAD** to lecture01)
```bash
git checkout lecture01
```
Create **new-branch** referencing current commit and checkout it
```bash
git checkout -b new-branch
```

---
### git commit commands
watch **local copy** status
```bash
git status
```
add file to git index
```bash
git add changed_file
```
create commit in **local copy**
```bash
git commit -m 'Commit message'
```
push new commits to **your fork** on github
```bash
git push origin branch-to-push
```

---
### git update commands
pull changes from **your fork**
```bash
git pull --rebase origin master
```
Rebase your branch on TARGET_BRANCH and resolve conflicts (synchronize with upstream)
```bash
git rebase -i upstream/TARGET_BRANCH
```

---
### Git editor setup
Git uses editor for interactive actions, like **rebase -i**
Default editor - **vim**  
If you are not sure [how to exit vim](https://stackoverflow.com/questions/11828270/how-to-exit-the-vim-editor) and use **windows**, change your editor to notepad:
```bash
git config --global core.editor notepad
```
