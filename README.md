# Workshop Git,GitHub,GitLab
[GitHub]()
[GitLab]()
---

> Git
> GitHub
> GitLab

- Git: Versiyon kontrol sistemi
- GitHub: **Git** Repository

## Git Version
```sh
git -v
git --version

git --help

git config --global user.name
git config --global user.name "Hamit Mızrak"
git config --global user.email
git config --global user.email "hamitmizrak@gmail.com"
git config --global core.editor "notepad++"
git config --global -l
git config core.autocrlf true
```
---


## Git Sıklıkla Kullanılanlar Komutlar
```sh
clear
git status
git log

```
---


## Git
```sh

git init
git add .
git add dosyaAdi1 dosyaAdi2
git commit -m "initial commit"
git remote add origin gitHubURL
git remote
git branch -M main 
git push -u origin 

```
---


## Git Commit 
```sh
git add .
git commit -m "mesaj adını"
git push

NOT: Eğer önceden ilgili dosya "git add" ile eklenmişse
git commit -a -m "commit adı"
git push


```
---


## Git Hakkında
```sh
Git Nedir ? 
- Global Information Tracked kısaltmasıdır
- VCS Version Control System
- Repository: GitHub, GitLab, vs
- En önemli özelliği: Dağıtık olması. Aynı anda birden fazla kişiyle çalışabiliriz.
- Ücretsiz
- Açık kaynak kodludur.
- Git yazarı Linux çekirdeğini yazan Linus Torvalds 2005 yılında yazıyorlar
- Eski kodlarımıza erişim sağlıyabiliyoruz.
- Dosya değişliğini önceki sürümlere geçerek sağlıyabiliyoruz.

```
---


## Git Clone
```sh
git clone https://github.com/hamitmizrak/Workshop_Git_GitHub_GitLab.git
```
---


## Git Alias
```sh
git log --decorate --oneline --graph --all
git config --global alias.graph "log --decorate --oneline --graph --all"
git graph

```
---


## Git Remote
```sh
git remote
git remote set-url yeniRemoteAdi URLYazıyoruz

```
---


## Git Diff
```sh
git log
git diff commitID1 commitID2
git diff  dad5338a1bc2109e93dc89b26dbab5f75485f521 fe795f46ba672

```
---


## Git
````sh

```
---


## Git
````sh

```
---


## Git
````sh

```
---


## Git
````sh

```
---


