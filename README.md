## 🖥 프로젝트 소개
![image](https://github.com/choisunghwan/EasyPeasy_LemonSqueezy_AI/assets/33335762/25a2ca75-694a-467e-adcd-fd2476973195)

- 프로젝트명 : EasyPeasy_LemonSqueezy 인공지능 통합 시스템
- 설명 : 'EasyPeasy_LemonSqueezy' 이라는 의미에 맞게 아주 쉽게 접근 할 수 있도록 최신 AI 기술을 접목한 기술 공유 사이트_edu
- 개발기간 <img src="https://img.shields.io/badge/24/03/04 ~ 24/00/00 (진행중) -ffce66?style=flat&logo=java&logoColor=white">
- 타겟층 : -
- 기획배경 : AI 와 Springboot 프레임워크 환경의 웹사이트를 활용하여  
- 기획목적 : 사용자에게 웹캠 비디오 스트림과 인식된 얼굴을 표시하기 위해 웹 인터페이스를 개발
- 개발단계 별 구분
   - 1차 : <u>기본 CRUD 기능(등록,조회,수정,삭제 / AI 기능 등)</u> - 진행중...
   - 2차 : 회원 별 권환 분리 - 진행중...
<br>

## 💡 개발환경 및 기술 세부스택 

* 개발환경(운영체제): windows 11
* 개발도구(IDE): IntelliJ IDEA
* 언어 :
Web part
프론트: HTML5 + Thymeleaf, CSS, JavaScript(jquery), bootstrap + ajax통신
백엔드: JAVA
인공지능 part :  python ,cuda, tensorflow, cudnn , OpenCV
* 프레임워크 : Spring Boot
* DBMS 툴 : DBeaer
* DB: Mysql
* 형상관리: Github , Notion(https://www.notion.so/b4314a5bf5c947c581023877112bb89f?v=dab095626874494d8efd957b7d7c6a86&pvs=4)
* 빌드 도구: Gradle - Groovy
* Packaging: Jar
* JAVA : 17
* spring boot: 3.23


<br>

## 📌 기능 설명
<details>
  <summary>얼굴인식 기능</summary> 
   <strong>웹 캠을 통해 얼굴 인식 기능</strong>을 추가하는 것은 몇 가지 단계로 구성될 수 있습니다. 아래는 <strong>주요 단계</strong>입니다:

   1. **OpenCV 설치**: 웹캠을 사용하여 얼굴을 인식하기 위해서는 OpenCV 라이브러리를 사용해야 합니다. 따라서 먼저 프로젝트에 OpenCV를 설치하고 구성해야 합니다.
   2. **웹 캠 접근**: Java에서 웹캠에 액세스하기 위해 OpenCV를 사용하여 웹캠을 열고 비디오 스트림을 읽어야 합니다. OpenCV는 웹캠에 액세스하기 위한 간단한 인터페이스를 제공합니다.
   3. **얼굴 감지 및 추적**: OpenCV를 사용하여 웹캠 비디오 스트림에서 얼굴을 감지하고 추적하는 코드를 작성해야 합니다. OpenCV에는 얼굴을 감지하는 여러 가지 기술과 알고리즘이 내장되어 있습니다.
   4. **얼굴 인식**: 웹캠에서 감지된 얼굴을 인식하기 위해 얼굴 인식 알고리즘을 구현해야 합니다. OpenCV는 기본적인 얼굴 인식 알고리즘을 제공하며, 필요에 따라 추가적인 훈련된 모델을 사용할 수도 있습니다.
   5. **웹 인터페이스**: 사용자에게 웹캠 비디오 스트림과 인식된 얼굴을 표시하기 위해 웹 인터페이스를 개발해야 합니다. Spring Boot의 경우 웹 페이지를 구성하고 웹캠 비디오를 표시하는 데 Thymeleaf나 Vue.js 등의 프레임워크를 사용할 수 있습니다.
   6. **통합 및 테스트**: 얼굴 감지 및 인식 코드를 Spring Boot 프로젝트에 통합하고, 웹 인터페이스와 함께 동작하도록 구성합니다. 이후 코드를 테스트하여 웹캠을 통한 얼굴 인식이 제대로 작동하는지 확인합니다.
      
   <img src="https://github.com/choisunghwan/RAUM/assets/33335762/d531a062-b13d-4a56-8b5f-eebf520fbc13">
   **위 이미지는 컴퓨터가 우리의 얼굴을 인식하는 단계입니다.** 컴퓨터 비전에서 얼굴 인식은 이와 같은 방식을 기반으로 컴퓨터가 이미지에서 객체를 검출하고 고유 패턴을 추출하게 됩니다.
   자세하게 과정을 이해하고 싶으시면 [아래 사이트](https://www.cubox.ai/board/blog/board_view.php?&page=1&num=121)를 참고해보시면 도움이 되실 것 같습니다.
</details>

<br>

