# 👕 2023, Shop-server

[API Documentation](https://shop-server.kro.kr/swagger-ui/#/)  
고객에게 최적의 탐색을 제안하는 메뉴 서비스를 제공합니다.  

## 💪 Skill Stack
![Java](https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=JAVA&logoColor=white)
![Spring-Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=Spring-Boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1.svg?&style=for-the-badge&logo=MySQL&logoColor=white)
![RDS](https://img.shields.io/badge/Amazon_RDS-4285F4?style=for-the-badge&logo=Amazon-RDS&logoColor=white)
![EC2](https://img.shields.io/badge/Amazon_EC2-FF9900?style=for-the-badge&logo=Amazon-EC2&logoColor=white)
![S3](https://img.shields.io/badge/Amazon_S3-F25F1F?style=for-the-badge&logo=Amazon-S3&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-0DB7ED?style=for-the-badge&logo=Docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-66E851?style=for-the-badge&logo=Swagger&logoColor=white)
![Linux](https://img.shields.io/badge/linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)
![GitHub_Actions](https://img.shields.io/badge/GitHub_Actions-1678D2?style=for-the-badge&logo=GithubActions&logoColor=white)
![Nginx](https://img.shields.io/badge/Nginx-65AC6C?style=for-the-badge&logo=nginx&logoColor=white)

## 🛠️ Tool
![Git](https://img.shields.io/badge/Git-F05032.svg?&style=for-the-badge&logo=Git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-000000.svg?&style=for-the-badge&logo=Github&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/ItelliJ%20IDEA-4A93D7.svg?&style=for-the-badge&logo=intellij-idea&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000.svg?&style=for-the-badge&logo=Notion&logoColor=white)
![MySQL Workbench](https://img.shields.io/badge/MySQL_Workbench-379483.svg?&style=for-the-badge&logo=mysql-workbench&logoColor=white)
![FileZilla](https://img.shields.io/badge/FileZilla-000000.svg?&style=for-the-badge&logo=FileZilla&logoColor=white)
![Draw.io](https://img.shields.io/badge/Draw.io-FF9900.svg?&style=for-the-badge&logo=Draw-io&logoColor=white)
![Let's Encrypt](https://img.shields.io/badge/Let's_Encrypt-452B67.svg?&style=for-the-badge&logo=Let's_Encrypt&logoColor=white)

## 📖 Explanation
- 목적에 맞는 타이틀과 링크를 제공합니다.  
- 상위 메뉴를 이용하여 모든 하위 메뉴를 조회합니다.  
- 최상위 메뉴에는 배너를 추가 노출할 수 있습니다.  
- App 과 Front-end 개발자가 사용할 수 있는 REST API를 제공합니다.
  - 인증이 필요한 요청과 인증이 필요하지 않은 요청을 적절하게 처리하며, 허용된 메서드와 헤더에 대한 접근을 제공합니다.

## 🔙 Requirements / Solution
- 메뉴를 등록/수정/삭제 할 수 있어야 합니다.
  - 상위 메뉴와 하위 메뉴에 대해 등록/수정/삭제할 수 있는 REST API를 제공합니다.
    <img width="721" alt="스크린샷 2023-07-06 오후 7 36 15" src="https://github.com/iju1633/shop-server/assets/43805087/82961acf-fd56-4c8d-a850-28c46900bfed">  
- 상위 메뉴를 이용해, 해당 메뉴의 모든 하위 메뉴를 조회 가능해야 합니다.
  - (방법 1) 상위 메뉴의 고유값을 통해 해당 메뉴의 모든 하위 메뉴 리스트를 조회할 수 있습니다.
    <img width="715" alt="스크린샷 2023-07-06 오후 7 38 59" src="https://github.com/iju1633/shop-server/assets/43805087/339a7a54-78ef-49e4-89a9-c07497560e2b">
  - (방법 2) 상위 메뉴를 조회하면 해당 메뉴와 연결된 하위 메뉴의 정보를 포함한 상위 메뉴 정보를 확인할 수 있습니다.
    <img width="715" alt="스크린샷 2023-07-06 오후 7 38 50" src="https://github.com/iju1633/shop-server/assets/43805087/0b5f7451-1acf-401f-91b5-9b823b7d234a">  
    <img width="716" alt="스크린샷 2023-07-06 오후 7 38 42" src="https://github.com/iju1633/shop-server/assets/43805087/755c7a1f-18c6-4587-a6c2-603227d1efe0">  
- 최상위 메뉴에는 배너를 등록하여 추가 노출할 수 있습니다.
  - 배너 등록 시 필요한 배너 이미지, 배너 설명, 연결될 링크를 활용하여 추가 노출이 가능합니다.
    <img width="719" alt="스크린샷 2023-07-06 오후 7 43 31" src="https://github.com/iju1633/shop-server/assets/43805087/1b0db139-3e62-4a3e-9dce-163d3f6fda89">

## 💎 Main Features
- `Spring Boot` 애플리케이션으로 구성된 HTTP REST API 서버
- `Amazon EC2`와 `Docker`를 사용한 배포
- `Amazon RDS`를 이용한 DB 관리
- `Amazon S3`를 이용한 이미지 리소스 관리
- Docker image 빌드 시 **테스트 자동화** 구현
- `GitHub Actions`를 이용한 CI/CD 파이프라인 구성 및 백그라운드 **배포 자동화** 구현
- Docker를 활용한 배포 및 이에 따른 환경 설정 코드 관리 용이
  - **[시스템 아키텍처 설계 개선]** ec2 인스턴스에서 바로 jar 파일 배포 → ec2 내의 docker를 통해 배포
- 서비스 플로우 설명 및 Issue에 문서화한 내용을 기반으로한 피드백을 수용하여 **UX 개선**
- `Nginx`, Let's Encrypt를 활용한 `https` 적용

## 📐 Service Architecture
<img src="https://github.com/iju1633/shop-server/assets/43805087/9bd9a009-312f-43a7-81ce-aadbbf97c111" width="400" height="400">  

- Gradle로 빌드합니다.  
- Spring Boot 프로젝트 내에 Dockerfile을 만들고 Amazon EC2 인스턴스 내의 Docker를 사용하여 배포합니다.

## 🖥️ Build Method
- 해당 [링크](https://www.notion.so/fa997457cd2444a8848d7e68ec80dec2?pvs=4)는 운영체제별(Mac, Windows) 웹서버를 로컬에서 실행시키는 방법을 설명하고 있습니다.  
or  
- 예시 데이터가 포함된 웹서버를 **배포**해놨으니 [API Documentation Link](https://shop-server.kro.kr/swagger-ui/#/)로 구현된 기능을 **프로젝트 빌드 과정 없이** 바로 테스트해보실 수 있습니다.
  - [테스트 방법 가이드](https://cyclic-baboon-a84.notion.site/674f32b8473242cba96064bafa282af0?pvs=4)
 
## 📝 Documentation (#Issue)
- [구현한 기능](https://github.com/iju1633/shop-server/issues/1)
- [Log 관리](https://github.com/iju1633/shop-server/issues/7)
- [브랜치 & 코드 & PR 관리 전략](https://github.com/iju1633/shop-server/issues/26)
- [에러 핸들링](https://github.com/iju1633/shop-server/issues/27)
- [Amazon Web Service](https://github.com/iju1633/shop-server/issues/30)

## 🗄️ ERD
<img width="660" alt="스크린샷 2023-07-04 오후 2 59 06" src="https://github.com/iju1633/shop-server/assets/43805087/03f15192-4529-4820-b878-3cfcceeaca4d" width="400" height="250">

## 📃 API Documentation
[API Documentation Link](https://shop-server.kro.kr/swagger-ui/#/)  
<img width="723" alt="스크린샷 2023-07-06 오후 7 28 53" src="https://github.com/iju1633/shop-server/assets/43805087/42997bb2-957b-4cea-ad72-7f9a531d8170">
- [테스트 방법 가이드](https://cyclic-baboon-a84.notion.site/674f32b8473242cba96064bafa282af0?pvs=4)
 
이 프로젝트는 클라이언트와의 통신을 위해 swagger Specification 2.0 및 Swagger UI를 활용합니다.  

## 🏛️ Depedency Used
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
