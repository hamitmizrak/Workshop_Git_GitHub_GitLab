
# Bu Dockerfile, bir Maven projesini derlemek ve daha sonra derlenen JAR dosyasını çalıştırmak için iki aşamalı bir Docker imajından oluşmaktadır(Multi-stage build)
# Multi-stage build'in amaçı: Docker imajlarının boyutlarını optimize etmek ve daha temiz bir yapı oluşturmak için kullanırız.
#
# Bu Dockerfile iki aşamada oluşur.
# 1.Aşamada: Maven projesini derlemek
# 2.Aşamada: Derelenen JAR dosyasını kullanarak çalıştırmak

###################################################
# docker image build -t imageAdi .
# docker image build -f customiseDockerfile -t imageAdi .
# docker container run -d -p 4444:4444 --rm --name my_imageName

# DockerHub push
# 1.adım: Dockerfile ile image oluştur
# 2.adım: Dockerhub üzerinden repository oluştur
# 3.adım: docker ps
# image name: image_spring_react
# 4.adım: docker image tag image_spring_react javahamitmizrak/fullstack11
# 5.adım: docker push javahamitmizrak/fullstack11

###################################################
# 1.AŞAMA @@@@@@@@@@@@@@@@@@@@
# JDK IMAGE
# FROM openjdk:17-jdk-slim
# FROM openjdk:17

# Maven ve OpenJDK'i içeren bir imaj kullanarak build aşamasını başlatıyoruz.
# AS build: Bu ifade build adını verdiğimiz ifade de, build adını daha sonra build aşamasından sonra elde edilen dosyalara erişim sağlayabiliriz.
FROM maven:3.8.5-openjdk-17-slim AS build

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Bilgilendirme

# maintainer: Bakımcı yani bu projei kim yazdı ve yönetiyor.
LABEL maintainer="hamitmizrak@gmail.com"

# Çevresel Değişkenler
ENV DOC_APP_NAME="GitLab Docker"
ENV TECH="Spring Boot, Devops, Docker, SonarQube, Git"
ENV DOC_VERSION="v1.0.0"
ENV DOC_PORT="4444"
ENV AUTHOR="Hamit Mızrak"

# Çıktı Almak
RUN echo "App Name:$DOC_APP_NAME "
RUN echo "App Tech:$TECH "
RUN echo "App Version:$DOC_VERSION "
RUN echo "App Port:$DOC_PORT "
RUN echo "App Author:$AUTHOR "

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Çalışma Dizini Eklemek
# Bundan sonra çalıştırılan komutlar bu dizin içinde çalışacaktır.
WORKDIR /app

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# KOPYALAMA (BAğımlılıkları ve kaynak kodları kopyala)
#COPY . .
# Proje kök dizindeki yer alan `pom.xml` dosyasını, Docker imajındaki mevcut çalışma dizinine(`.`) kopyalamak
COPY pom.xml .

# Proke kök dizinde src, Docker Docker imajındaki mevcut çalışma dizinine(`src`) kopyalamak
COPY src ./src

# Kalıcık
#VOLUME /tmp

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Compiler
# Uygulamayı Derlemek (Compiler)
#COPY mvnw .
#COPY .mvn .mnv
# Maven dependencies indirmek
#RUN ./mvnw dependency:resolve
# Uygulamayı derlemek
#RUN ./mvnw clean package -DskipTests

# Maven ile projeyi derleyin ve testleri atlayarak)
# springboot_react.jar
# clean: maven ile oluşturulmuş target dosyasının içeriğini temizle
RUN mvn clean package -DskipTests

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# 2.AŞAMA @@@@@@@@@@@@@@@@@@@@
# Çalışma Dizini Eklemek
# Son aşamada JDK 17'yi kullanarak derlenen JAR dosyasını çalıştıran imaj oluşturuyoruz.
# Bu imaj, sadece uygulamayı çalıştırmak için gerekli olan JDK'yı içerir.
# Bu aşamada build aşamasında oluşturulan JAR dosyasını çalıştırmak için daha hafif bir imah kullandık.
FROM openjdk:17-jdk-slim

# Çalışma dizini
WORKDIR /app

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# JAR
#ARG JAR_FILE=target/*.jar
# ADD
#ADD ${JAR_FILE} blog.jar
# EntryPoint
#ENTRYPOINT [ "java","-jar","/app/blog.jar" ]


#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Derlenen JAR dosyasını önceki aşamadan kopyalama yapalım.
COPY --from=build /app/target/*.jar /app/app.jar


#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# HEALTHCHECK
# HEALTHCHECK => Bu image dosyasının sağlık durumu (Container Çalışıyor mu)
# --interval=30s  ==> 30 saniyede bir sağlık kontrolü yapılsın
# --timeout=3s  ==>  10 saniyede Sağlık kontrolünü tamamlasın
# --start-periyod=5s  ==> Konteynar başladığında sağlık kontrolünün başlamasın için 5 saniye bekle
# --retries=3  ==>  Sağlık kontrolünü eğer ilk denemede başarısız olursa 3 defa daha  çalışsın.
# Eğer bu 3s komutu belirtilenin dışına çıkarsa Docker sağlıksız olarak işaretlenir
# CMD wget --quiet --tries=1 --spider http://localhost : wget ile localhost istek atmak
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD wget --quiet --tries=1  --spider http://localhost:4444 || exit 1

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# ENTRYPOINT
# EntryPoint: Container başlatıldığında çalışacak komutu belirler.
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Uygulamanın çalışacağı portu açın
# 65536 port
# 0-1023   => 80,23,443
# 1024-49151
# 49152-65535 (bunu kullanabilirisiniz)
EXPOSE 4444

########################################################
# docker container ls
# docker container ls -a
# docker ps
# docker ps -a
# docker container run -p 2222:4444 blog
# docker container run -p 3333:4444 --name malatya blog
# docker container run -d -p 5555:4444 --name malatya2 blog
# docker container run --rm -d -p 6666:4444 --name malatya3 blog
# docker container prune
# docker container exec -it containerID bash
