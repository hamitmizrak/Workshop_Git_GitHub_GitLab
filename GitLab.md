# GitLab
[]()
---

## Git Config
```sh
## GitLab Lesson
```sh
git config --global user.name "Hamit Mizrak"
git config --global user.email "hamitmizrak@outlook.com"
```

git remote -v
git remote set-url gitlab git@gitlab.com:workshop644935/workshop_git_github_gitlab.git
git push gitlab main
git push --force gitlab main
git remote -v



## GitLab Git Repository Create 
```sh
cd existing_folder
git init --initial-branch=main
git switch --create main
git branch -M main
git remote add gitlab git@gitlab.com:workshop644935/workshop_git_github_gitlab.git
git remote set-url gitlab https://gitlab.com/workshop644935/workshop_git_github_gitlab.git
git remote add gitlab https://gitlab.com/workshop644935/workshop_git_github_gitlab.git
git add .
git commit -m "Initial commit"



git push -u "git@gitlab.com:workshop644935/workshop_git_github_gitlab" main
git push -u "https://gitlab.com/workshop644935/workshop_git_github_gitlab.git" main
git push --set-upstream git@gitlab.com:workshop644935/workshop_git_github_gitlab main

git clone git@gitlab.com:workshop644935/workshop_git_github_gitlab

```

## GitLab Access token(API key) 
```sh
https://gitlab.com/-/user_settings/personal_access_tokens
```
---


## GitLab SSH-KEY
```sh
ssh-keygen -t rsa -b 4096 -C "hamitmizrak@outlook.com"
enter*3
cd C:\Users\your-windows-name\.ssh
cat ~/.ssh/id_rsa.pub

```
---


## GitLab Runner Windows Install
```sh
https://docs.gitlab.com/runner/install/windows.html => 64 bit

```
---


## GitLab Runner Install (Windows)
```sh
NOT: cmd açarken yönetici moddaki terminali açmalıyız.

cd C:\GitLab-Runner
.\gitlab-runner.exe install
.\gitlab-runner.exe start
.\gitlab-runner.exe stop
```
---

## GitLab Runner Install (Linux)
```sh
cd C:\GitLab-Runner
./gitlab-runner.exe install
./gitlab-runner.exe start
./gitlab-runner.exe stop
```
---


## GitLab Registration Token Aktifleştirmek (Group)
```sh
Aşağıdaki linte => Runner => Allow member aktifleştir
https://gitlab.com/groups/workshop644935/-/settings/ci_cd

```
---

## GitLab Registration Token Görmek (Project)
```sh
Aşağıdaki linte => Runner => Registration Görmek
https://gitlab.com/workshop644935/workshop_git_github_gitlab/-/settings/ci_cd
```
---



## GitLab Runner Register
```sh
cd C:\GitLab-Runner
./gitlab-runner.exe register
GitLab Instance    : https://gitlab.com
Registration Token : Project => Runner => Registration Token
Description        : GitLab Devops Enegineering
tags               : windows,gitlab,cicd
Enter optional maintenance note for the runner: gitlab runner ok

executor           : docker+machine
Enter the default Docker image (for example, ruby:2.7): alpine



executor           : shell
executor           : docker
executor           : docker-windows
executor           : virtualbox
executor           : ssh
executor           : kubernates k8s

```
---


## GitLab Access token
```sh

```
---
## GitLab Access token
```sh

```
---

## GitLab Access token
```sh

```
---

## GitLab Access token
```sh

```
---
## GitLab Access token
```sh

```
---

## GitLab Access token
```sh

```
---
## GitLab Access token
```sh

```
---

## GitLab Access token
```sh

```
---

## GitLab Access token
```sh

```
---
## GitLab Access token
```sh

```
---

## GitLab Access token
```sh

```
---
## GitLab Access token
```sh

```
---





