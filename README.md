# shop-server (2023, Musinsa Global Development Team Assignment)

![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white)
![Spring-Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=Spring-Boot&logoColor=white)
![RDS](https://img.shields.io/badge/Amazon_RDS-4285F4?style=flat-square&logo=Amazon-RDS&logoColor=white)
![EC2](https://img.shields.io/badge/Amazon_EC2-FF9900?style=flat-square&logo=Amazon-EC2&logoColor=white)
![S3](https://img.shields.io/badge/Amazon_S3-F25F1F?style=flat-square&logo=Amazon-S3&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-0DB7ED?style=flat-square&logo=Docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-66E851?style=flat-square&logo=Swagger&logoColor=white)

고객에게 최적의 탐색을 제안하는 메뉴 서비스를 제공합니다.  

## 📖 Explanation

- 목적에 맞는 타이틀과 링크를 제공합니다.  
- 상위 메뉴를 이용하여 모든 하위 메뉴를 조회합니다.  
- 최상위 메뉴에는 배너를 추가 노출할 수 있습니다.  
- App 과 Front-end 개발자가 사용할 수 있는 REST API를 제공합니다.

## 💎 Main Features

- Spring Boot 애플리케이션으로 구성된 HTTP REST API 서버
- Amazon EC2와 docker 및 dockerhub를 사용한 배포
- Amazon RDS를 이용한 DB 관리
- Amazon S3를 이용한 이미지 리소스 관리

## 📐 Service Architecture
![무신사 과제 아키텍처](https://github.com/iju1633/shop-server/assets/43805087/9bd9a009-312f-43a7-81ce-aadbbf97c111)
- Gradle로 빌드합니다.  
- Jar 파일을 빌드하고 Docker Image를 만들어 Amazon EC2 인스턴스에서 docker를 사용하여 배포합니다.

## 🖥️ Build Environment

이 프로젝트는 Gradle, Amazon Web Service 및 Docker를 사용합니다.  
이 프로젝트를 빌드하고 실행하려면 먼저 Gradle로 `.jar`을 빌드하고 docker 이미지를 빌드하여 dockerhub에 푸시합니다.  
그런 다음 Amazon EC2에서 이미지를 가져와 도커로 배포합니다.

## 🗄️ ERD

<img width="674" alt="스크린샷 2023-07-03 오전 12 53 38" src="https://github.com/iju1633/shop-server/assets/43805087/8041b78a-47e8-426f-98ac-1ef161c01b3c">

## 📃 API Specification

[Swagger Link](기입 예정)  
이 프로젝트는 클라이언트와의 통신을 위해 swagger Specification 2.0 및 Swagger UI를 활용합니다.  

## 🏛️ Depedency Used
- implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
-	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
-	implementation 'org.springframework.boot:spring-boot-starter-jdbc'
-	implementation 'org.springframework.boot:spring-boot-starter-security'
-	implementation 'org.springframework.boot:spring-boot-starter-validation'
-	implementation 'org.springframework.boot:spring-boot-starter-web'
- implementation 'io.springfox:springfox-boot-starter:3.0.0'
- implementation 'com.amazonaws:aws-java-sdk-s3:1.12.470'
- compileOnly 'org.projectlombok:lombok'
-	runtimeOnly 'com.mysql:mysql-connector-j'
-	annotationProcessor 'org.projectlombok:lombok'
-	testImplementation 'org.springframework.boot:spring-boot-starter-test'
-	testImplementation 'org.springframework.security:spring-security-test'
  
#### Contributor

[Jaeuk Im](https://github.com/iju1633)
|:---:|
|BACKEND|
