<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send11.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>데이터 송수신 실습 11</h1>
	<hr>
</div>

<!-- ■■■ 포워딩 / 리다이렉트 관련 중요한 실습 ■■■ -->

<!-- ① 사용자 최초 요청 페이지 -->
<!-- 사칙연산 수행을 위한 정수 입력 페이지 구성 -->
<!-- 연산자를 함께 입력받을 수 있도록 처리 -->
<!-- 정수1/ 정수2/ 연산자 -->
<!-- http://localhost:8090/WebApp07/Send11.jsp -->

<!-- ② 연산 전용 페이지 -->
<!-- 스크립트릿 코드만 존재 + jsp:forward 액션태그 -->
<!-- → 추후 이 코드를 java로 분리하여 → Servlet 으로 구성할 예정 -->
<!-- http://localhost:8090/WebApp07/Forward11.jsp -->

<!-- ③ 최종 결과 출력 페이지 -->
<!-- 연산 전용 페이지에서 처리한 결과를 넘겨받아 클라이언트와 대면할 페이지로 구성 -->
<!-- →추후 이 페이지는 jsp view 페이지의 역할을 수행할 예정 -->
<!-- http://localhost:8090/WebApp07/Receive11.jsp -->

1. 정수 2개 입력자 넘겨받을 수 있는 페이지로 구성<br>
2. 클라이언트와 만나지 않는 것이 핵심 스크립 릿 영역만 만들면됨 액션태그하나만 추가하자<br>
3. 보여주는 레이아웃 작성하고 값을 보여주는거 전달만 하면됨<br>
<br><br>



</body>
</html>