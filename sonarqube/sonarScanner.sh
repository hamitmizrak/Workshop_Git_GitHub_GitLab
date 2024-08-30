#!/bin/bash

mvn clean verify sonar:sonar \
  -Dsonar.projectKey=spring_boot_sonar \
  -Dsonar.projectName='spring_boot_sonar' \
  -Dsonar.host.url=http://localhost:1111 \
  -Dsonar.token=sqp_0cb769951c5098856ae37c8f064a27fc3aaee7b4