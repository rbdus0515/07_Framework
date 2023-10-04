<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>프로젝트</title>
	
	<link rel="stylesheet" href="/resources/css/main-style.css" type="text/css">
	
	<script src="https://kit.fontawesome.com/eb7f8e3a35.js" crossorigin="anonymous"></script>
</head>
<body>

	<main>

		<%-- header.jsp 추가 
		
		<%--
			<jsp:include page="jsp파일경로"/>
			
			-jsp 파일경로는 wevapp폴더 기준으로 작성
			- JSP액션 태그 (jsp에 기본 내장됨)
			- 다른 jsp파일을 코드를 현재 위치에 추가
		
		--%>
		
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>

		<section class="content">
			<section class="content-1"></section>
			<!-- 아이디, 비밀번호, 로그인 버튼 영역 -->
			<section class="content-2">
			
				<c:choose>
					<%-- 로그인이 안되었을때 --%>
					<%-- EL empty : 비어있거나 null이면 true --%>
					<c:when test="${empty sessionScope.loginMember}">
					
					<form action="/member/login" method="post" name="login-form" id="loginFrm">

					<fieldset class="id-pw-area">
						<section>
							<input type="text" name="memberEmail" placeholder="이메일"
								autocomplete="off"
								value="${cookie.saveId.value}"
							> <input
								type="password" name="memberPw" placeholder="비밀번호">
						</section>

						<section>
							<button>로그인</button>
						</section>
					</fieldset>

					<label>
						
						<c:if test="${not empty cookie.saveId.value}">
							<%-- 쿠키에 저장된 이메일이 있으면 변수 선언 : save --%>
						
							<c:set var="save" value="checked"/>
						</c:if>
						
						<input type="checkbox" name="saveId" ${save}> 아이디 저장
						
					</label>

					<!-- 회원가입 / Id / Pw 찾기 영역 -->
					<section class="signup-find-area">
						<a href="#">회원가입</a> <span>|</span> <a href="#">ID/PW 찾기</a>
					</section>

				</form>
					</c:when>
					
					<%-- 로그인이 되었을때 --%>
					<c:otherwise>
						<article class="login-area">
						
							<a href="#">
								<img id="memberProfile" src="/resources/images/user.png">
							</a>
							
							<div class="my-info">
								<div>
									<a href="#" id="nickname">${sessionScope.loginMember.memberNickname}</a>
									<a href="/member/logout" id="logoutBtn">로그아웃</a>
								</div>
							
								<p></p>
							</div>
							
						</article>
						
					</c:otherwise>
				</c:choose>
			
				


			</section>
		</section>

	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>