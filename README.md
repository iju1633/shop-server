# shop-server (2023, Musinsa Global Development Team Assignment)

고객에게 최적의 탐색을 제안하는 메뉴 서비스를 제공합니다.  

## 💪Skills
### Platforms & Languages
![Java](https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=JAVA&logoColor=white)
![Spring-Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=Spring-Boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1.svg?&style=for-the-badge&logo=MySQL&logoColor=white)
![RDS](https://img.shields.io/badge/Amazon_RDS-4285F4?style=for-the-badge&logo=Amazon-RDS&logoColor=white)
![EC2](https://img.shields.io/badge/Amazon_EC2-FF9900?style=for-the-badge&logo=Amazon-EC2&logoColor=white)
![S3](https://img.shields.io/badge/Amazon_S3-F25F1F?style=for-the-badge&logo=Amazon-S3&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-0DB7ED?style=for-the-badge&logo=Docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-66E851?style=for-the-badge&logo=Swagger&logoColor=white)
![GitHub_Actions](https://img.shields.io/badge/GitHub_Actions-1678D2?style=for-the-badge&logo=GithubActions&logoColor=white)

### 🛠️ Tools
![Git](https://img.shields.io/badge/Git-F05032.svg?&style=for-the-badge&logo=Git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-000000.svg?&style=for-the-badge&logo=Github&logoColor=white)
![IntelliJ IDE](https://img.shields.io/badge/ItelliJ%20IDE-2C2255.svg?&style=for-the-badge&logo=intellij%20IDE&logoColor=white)
![MySQL Workbench](https://img.shields.io/badge/MySQL_Workbench-379483.svg?&style=for-the-badge&logo=mysql_workbench%20IDE&logoColor=white)

## 📖 Explanation

- 목적에 맞는 타이틀과 링크를 제공합니다.  
- 상위 메뉴를 이용하여 모든 하위 메뉴를 조회합니다.  
- 최상위 메뉴에는 배너를 추가 노출할 수 있습니다.  
- App 과 Front-end 개발자가 사용할 수 있는 REST API를 제공합니다.

## 💎 Main Features

- Spring Boot 애플리케이션으로 구성된 HTTP REST API 서버
- Amazon EC2와 docker를 사용한 배포
- Amazon RDS를 이용한 DB 관리
- Amazon S3를 이용한 이미지 리소스 관리
- Docker image 빌드 시 테스트 자동화 구현
- GitHub Actions를 이용한 CI/CD 구성 및 백그라운드 배포 자동화 구현

## 📐 Service Architecture
![무신사 과제 아키텍처](https://github.com/iju1633/shop-server/assets/43805087/9bd9a009-312f-43a7-81ce-aadbbf97c111)
- Gradle로 빌드합니다.  
- Docker Image를 만들어 Amazon EC2 인스턴스에서 docker를 사용하여 배포합니다.

## 🖥️ Build Environment

이 프로젝트는 Amazon Web Service, Docker, GitHub Actions를 사용합니다.  

프로젝트를 실행하려면 먼저 ec2 인스턴스에 접속한 이후 도커 이미지를 생성합니다.  
`docker build -t shop-server:latest .`  
그런 다음 container를 만들며 백그라운드 배포를 실행합니다.  
`docker run -d --name shop-server-container -p 8080:8080 shop-server:latest`

## 🗄️ ERD

<img width="660" alt="스크린샷 2023-07-04 오후 2 59 06" src="https://github.com/iju1633/shop-server/assets/43805087/03f15192-4529-4820-b878-3cfcceeaca4d">

## 📃 API Specification
[Swagger Link](http://3.37.107.107:8080/swagger-ui/#)  
<img width="725" alt="스크린샷 2023-07-03 오전 3 26 21" src="https://github.com/iju1633/shop-server/assets/43805087/7ebba94a-e691-4fb2-aa91-06bee1721c6a">
 
이 프로젝트는 클라이언트와의 통신을 위해 swagger Specification 2.0 및 Swagger UI를 활용합니다.  

## 🏛️ Depedency Used
- implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
- implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
- implementation 'org.springframework.boot:spring-boot-starter-log4j2'
- implementation 'org.springframework.boot:spring-boot-starter-jdbc'
- implementation 'org.springframework.boot:spring-boot-starter-security'
- implementation 'org.springframework.boot:spring-boot-starter-validation'
- implementation 'org.springframework.boot:spring-boot-starter-web'
- implementation 'io.springfox:springfox-boot-starter:3.0.0'
- implementation 'com.amazonaws:aws-java-sdk-s3:1.12.470'
- compileOnly 'org.projectlombok:lombok'
- runtimeOnly 'com.mysql:mysql-connector-j'
- annotationProcessor 'org.projectlombok:lombok'
- testImplementation 'org.springframework.boot:spring-boot-starter-test'
- testImplementation 'org.springframework.security:spring-security-test'
  
#### Contributor

[Jaeuk Im](https://github.com/iju1633)
|:---:|
|BACKEND|
