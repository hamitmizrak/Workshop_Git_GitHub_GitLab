#!/bin/bash

# Geri Sayım süresini belirleyin (saniye cinsinden)
countdown_time=3

# Geri sayım döngüsünde
while [ $countdown_time -gt 0 ]; do
    echo "$countdown_time saniye kaldı..."
    sleep 1
    countdown_time=$((countdown_time - 1))
done

# -e echo komut dizilerini yorumlama
# \n=Yeni satır
# \r=satır başı
echo -e "\aİşlem başlıyor ...\n\r"
