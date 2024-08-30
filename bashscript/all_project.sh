#!/bin/bash
echo "Genel Kurulumlar"

# User Variable
UPDATED="Güncelleme"
CLEANER="Temizleme"
INSTALL="Yükleme"
DELETED="Silme"
CHMOD="Erişim İzni"
INFORMATION="Genel Bilgiler Ports | NETWORKING"
UFW="Uncomplicated Firewall Ggüvenlik duvarı Yöentim Araçı"
LOGOUT="Sistemi Tekrar Başlatmak"
CHECK="Yüklenecek Paket bağımlılıkları"
TECH="Diğer Teknolojiler"
MAVEN="Jar veya War dosyasının maven ile oluşturmak"
BACKEND="Backend Kurulumu Başlıyor"
FRONTEND="Frontend Kurulumu Başlıyor"
SONARQUBE="SonarQube Kurulumu Başlıyor"

###################################################################
###################################################################

# Bash scriptlere izin vermek
chmod +x ./countdown.sh
chmod +x ./reboot.sh
chmod +x ./_2_dockerize/_1_backend/_3_POSTGRES/backend.sh
chmod +x ./_2_dockerize/_2_frontend/frontend.sh

###################################################################
###################################################################
# Access Permission
accessPermission() {
    sleep 2
    echo -e "\n###### ${CHMOD} ######  "
    read -p "Dosya İzinleri Vermek İstiyor musunuz ? e/h " permissionResult
    if [[ $permissionResult == "e" || $permissionResult == "E" ]]; then
        echo -e "Dosya izinleri Başladı ... "

        # chmod: Dosya ve dizinlerin erişimi için izinler
        # r: Okuma(read) 2^2=4
        # w: Yazma(Write) 2^1=2
        # x: Çalıştırma(Execute) 2^0=1

        # Kullanıcı Kategorileri
        # u: Dosya sahibi(user)
        # g: Grup Üyeleri(group)
        # o: Diğer Kullanıcılar (others)
        # a: Tüm kullancıılar (all)
        ls -al
        ls -l countdown.sh
        ls -l reboot.sh

        # İzinleri Sembolik Mod olarak değiştirmek
        # chmod u+rwx,g+rx,o+rx ../script

        # İzinleri Sayısal Mod olarak değiştirmek
        # chmod 755 ../script

         # Geriye Say
         ./countdown.sh
    else
        echo -e "Dosya İzinleri Yapılmadı..."
    fi
}
# Function Calling
accessPermission

###################################################################
###################################################################
maven() {
    sleep 2
    echo -e "\n###### ${MAVEN} ######  "
    read -p "Maven ile projeyi build almak istiyor musunuz ? e/h " mavenResult
    if [[ $mavenResult == "e" || $mavenResult == "E" ]]; then
        echo -e "Maven Dockerize Başladı ... "

        # Bash scriptlere izin vermek
         #chmod +x countdown.sh
         #chmod +x reboot.sh

        # mvn clean package
        mvn clean

         # Geriye Say
         ./countdown.sh

        # Version
        echo -e "Version ... "
        echo -e "Java Version"
        echo -e "Java Version => $(java --version)\n"
        echo -e "javac Version => $(javac --version)\n"
        echo -e "adb Version => $(adb --version)\n"
        echo -e "node Version => $(node -v)\n"
        #echo -e "nvm Version => $(nvm --version)\n"
        echo -e "npm Version => $(npm -v)\n"
        echo -e "mvn Version => $(mvn)\n"
        echo -e "choco Version => $(choco --version)\n"
        echo -e "git Version => $(git -v)\n"

        # Maven
        # mvn clean package
        mvn clean package -DskipTests
    else
        echo -e "Maven çalıştırılmadı ..."
    fi
}
# Function Calling (maven)
maven

###################################################################
###################################################################
# Backend Project
backend() {
    sleep 2
    echo -e "\n###### ${BACKEND} ######  "
    read -p "Backend çalıştırmak istiyor musunuz ? e/h " backendResult
    if [[ $backendResult == "e" || $backendResult == "E" ]]; then
        echo -e "Backend Dockerize Başladı ... "

        # Bash scriptlere izin vermek
         #chmod +x countdown.sh
         #chmod +x reboot.sh

         # Geriye Say
         ./countdown.sh

        # Listelemek
        ls -al
        pwd
        ./countdown.sh

        # Dockerize dosya path
        cd ./_2_dockerize/_1_backend/_3_POSTGRES/
        chmod +x backend.sh
        ./backend.sh
    else
        echo -e "Backend çalıştırılmadı ..."
    fi
}
# Function Calling (Backend)
backend


###################################################################
###################################################################
# Frontend Project
frontend() {
    sleep 2
    echo -e "\n###### ${FRONTEND} ######  "
    read -p "Frontend çalıştırmak istiyor musunuz ? e/h " frontendResult
    if [[ $frontendResult == "e" || $frontendResult == "E" ]]; then
        echo -e "frontend Dockerize Başladı ... "

        # Bash scriptlere izin vermek
         #chmod +x ./countdown.sh
         #chmod +x ./reboot.sh

         # Geriye Say
         ./countdown.sh

         # Listelemek
        ls -al
        pwd
        ./countdown.sh

        # Dockerize dosya path
        cd ../../
        pwd
         cd ./_2_frontend
         ls -al
         chmod +x frontend.sh
         ./frontend.sh
    else
        echo -e "Frontend çalıştırılmadı ..."
    fi
}
# Function Calling (frontend)
frontend


###################################################################
###################################################################
# SonarQube Project
sonarQube() {
    sleep 2
    echo -e "\n###### ${SONARQUBE} ######  "
    read -p "sonarQube çalıştırmak istiyor musunuz ? e/h " sonarQubeResult
    if [[ $sonarQubeResult == "e" || $sonarQubeResult == "E" ]]; then
        echo -e "sonarQube Dockerize Başladı ... "

        # Bash scriptlere izin vermek
         #chmod +x ./countdown.sh
         #chmod +x ./reboot.sh

         # Geriye Say
         ./countdown.sh

         # Path
         cd ../_2_dockerize/_3_sonarqube

        # Dockerize dosya path
         chmod +x sonar_deployment.sh
         ./sonar_deployment.sh
    else
        echo -e "sonarQube çalıştırılmadı ..."
    fi
}
# Function Calling (sonarQube)
sonarQube


