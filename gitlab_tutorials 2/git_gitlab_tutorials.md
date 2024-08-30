# Git Tutorials
git --version
git status
git log
---

## Git Config
```sh
git config --global -l 
git config --global user.name 
git config --global user.name "Hamit Mızrak" 
git config --global user.email  
git config --global user.email "hamitmizrak@outlook.com" 

Öncelikle notepad++ => Çevre ortamına eklemeliyiz.
git config --global core.editor "notepad++"
```

## Staging Area (ADD)
git add Readme.md
git add Readme.md deneme.txt
git add .
git add jav*

---
## Commit(ADD)
git commit -m "commit mesajı anlaşılır"

git add .
git commit -m "mesaj"
git commit -a -m "commit "
---

## Push
> **git push -u gitlab main**
> **git push --set-upstream gitlab main**
> **git push**
---

## Pull (Hemen dosyaları ekle)
> **git pull**
> **git pull main**
> **git pull backend**
> **git pull frontend**
---

## Fetch (dosyalara ekleme ancak ben istersem ekle)
> **git fetch**
> **git branch --all**
> **git branch -a**
> **git checkout remotes/gitlab/main**
> **git checkout main**
> **git merge gitlab/main**
---

## Clone / Diff
> **git clone URL**
---

##  Diff
> git log
> **git diff commitID1 commitID2**
> **git difftool commitID1 commitID2**
---

## Remote
- git remote add aliasName GitLabURL
- git remote set-url remoteAliasName git@gitlab.com:devops-engineering3/offline-gitlab.git
- git remote set-url gitlab git@gitlab.com:devops-engineering3/offline-gitlab.git

---
## Config
git config --global alias.hamit "log --all --graph --decorate --oneline"
git hamit
--

## BRANCH
git branch -M main
git branch
git branch --all
git branch -a

- Dikkat: Branch oluşturmadan önce `git commit` yapmalıyız
git status
git branch frontend
git branch
git checkout frontend

cat >> frontend.txt
git add .
git commit -m "frontend"
git push -u gitlab frontend
git switch main
git merge frontend  (fast forward)

git branch -D frontend


- Dikkat: Branch oluşturmadan önce `git commit` yapmalıyız
git status
git checkout -b backend
git branch

cat >> backend.txt
git add .
git commit -m "backend"
git push -u gitlab backend
git switch main
git merge --no-ff backend  (fast forward)

git branch -D backend
---

## GitLab Tag
```sh
Projemize etiketler vererek versiyonlamayı sağlamak

git add .
git tag v1.0.0

git tag
git tag v1.0.0
git show v1.0.0
git checkout  v1.0.0
git checkout main
git remote -v
git push remoteNAME v1.0.0
git push gitlab v1.0.0
git tag --delete v1.0.0

```


## GitLab Stash
```sh

```

## GitLab Conflict
```sh
  git status
  git reset HEAD~1
  git pull
  git status
  git add .
  git commit -m "conflict data"
  git push
```



---
# Offline GitLab
[GitLab Offline](https://gitlab.com/devops-engineering3/offline-gitlab.git)
---

## GitLab Config
```sh
Git global setup
git config --global user.name "Hamit Mizrak"
git config --global user.email "hamitmizrak@outlook.com"
```

## GitLab Create a new repository
```sh
Create a new repository
git clone https://gitlab.com/devops-engineering3/offline-gitlab.git
cd offline-gitlab
git switch --create main
touch README.md
git add README.md
git commit -m "add README"
git push --set-upstream origin main
```

## GitLab Push an existing folder
```sh
cd existing_folder
1.YOL (git branch -M main)


2.YOL (git init --initial-branch=main)
git remote add gitlab https://gitlab.com/devops-engineering3/offline-gitlab.git
git add .
git commit -m "Initial commit"
git push --set-upstream gitlab main
```
---

## GitLab SSH (Eğer Yüklemede permission denied yazarsa SSH ile bağlantı kurabilirsiniz.)
```sh
ssh-keygen -t rsa -b 4096 -C "hamitmizrak@outlook.com"

Your identification has been saved in /c/Users/Hamit-Mizrak/.ssh/id_rsa
Your public key has been saved in /c/Users/Hamit-Mizrak/.ssh/id_rsa.pub

$ ls ~/.ssh  ==> (id_rsa  id_rsa.pub  known_hosts)
$ cat ~/.ssh/id_rsa.pub
$ ssh -T git@gitlab.com   ==>(Welcome to GitLab, @Hamit_Mizrak!)
$ git remote set-url gitlab git@gitlab.com:devops-engineering3/offline-gitlab.git
$ git push --set-upstream gitlab main

```


## GitLab GPG (GitLab için GPG anahtarını oluşturursak, kimliğimizi doğrulamak ve commitlerimizi imzalamak için önemlidir)
```sh
Step-1-) https://gpg4win.org/thanks-for-download.html
Step-2-) Kurulumu => Next =< Next => Kurulum sırasında tüm bileşenlere izin vereceğim.
Step-3-) Kurulum sonrasında GPG key oluşturmak için Terminal aç (Yönetici Modda => CMD, powershell)

Step-4-) GPG Anahtarını Oluştur => gpg --full-generate-key
Step-5-) Anahtar türü RSA =1
Step-6-) Anahtar uzunluğu  default: 3072 bit ancak biz 4096
Step-7-) Anahtar saklama süresi: 0 (sonsuz ) => y
Step-8-) isim, email vs bilgiler giriyorum
Step-9-) Şifre giriyorsunuz.

Step-10-) GPG Anahtar ID almak için => gpg --list-secret-keys --keyid-format LONG
Step-11-) GPG Anahtarını Dışa Aktarın => gpg --armor --export 653D40E11DD65C3261DDD04379081CCC9884EA24
Step-12-) GitLab => https://gitlab.com/-/user_settings/gpg_keys
```


## GitLab Runner Windowsta Register
```sh
https://docs.gitlab.com/runner/install/windows.html => 64 bit veya 32 bit indir

cd C:\GitLab-Runner
./gitlab-runner.exe register
the GitLab instance       : https://gitlab.com/
registration token        : GR1348941-sv-3j-avgerJ2YBUk8Y
description for the runner: Devops Engineering
tags for the runner       :windows,gitlab
an executor: shell

Runner registered successfully. Feel free to start it, but if it's running already the config should be automatically reloaded!
Configuration (with the authentication token) was saved in "C:\\GitLab-Runner\\config.toml"
```
