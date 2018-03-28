<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>반얀트리 클럽 앤 스파 서울</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" link="" src="js/default.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>

</head>

<!-- 세션을 이용한 로그인 처리 -->
<%
	String id = (String) session.getAttribute("id");

	//처음 로그인이 되어 있지 않다면 
	if (id == null) {
		id = "GUEST";
	}
%>
<body>
	<!-- header -->

		<div id="header">
			<div class="wrapper">
				<!--로고 -->
				<h1>
					<a href="HotelMain.jsp"><img src="images/h1_logo.png"alt="호텔메인" /></a>
				</h1>
				<!--유틸메뉴 구현 -->
				<div id="utilMenu">
					<h2 class="none">유틸메뉴</h2>
					<ul>
						<%
							if (id.equals("GUEST")) {
						%>
						<li>
							<a href="HotelMain.jsp?center=MemberLogin.jsp"><img	src="images/m_login.png" alt="LOGIN 로그인" /></a>
						</li>
						<%
							}
						%>

						<li>
							<a href="/web/10_etc/ec05.asp"><img	src="images/m_sitemap.png" alt="SITEMAP 사이트맵" /></a>
						</li>
						<li>
							<a href="/web_eng/" title="영문사이트 바로가기"><img src="images/m_eng.png" alt="ENGLISH 영문" /></a>
						</li>
						<li>
							<a href="https://instagram.com/banyantree_seoul/" target="_blank" title="새창"><img src="images/ico_instagram.png" alt="인스타그램" /></a>
						</li>
						<li class="fin">
							<a	href="https://www.facebook.com/BanyanTreeClubandSpaSeoul"target="_blank" title="새창"><img src="images/ico_facebook.png" alt="Facebook" /></a>
							</li>
						<li class="fin">
							<a	href="http://www.youtube.com/channel/UCNyNM35IeojEk4Yfrkjc6SQ" target="_blank" title="새창"><img src="images/ico_YouTube.png" alt="You Tube" /></a>
						</li>
						<li class="fin">
							<a href="http://www.banyantree.com/" target="_blank" title="새창" class="global"><img 	src="images/ico_brand.png" alt="브랜드사이트 바로가기" /></a>
						</li>
					</ul>
				</div>
				<!--유틸메뉴 구현 -->

				<!--주메뉴 구현 -->
				<div id="gnbMenu">
					<div class="inner">
						<h2 class="none">주메뉴</h2>
						<ul id="gnb">
							<li class="">
								<a	href="HotelMain.jsp?center=HotelReserveMain.jsp"><img src="images/m_gnb01.png" alt="About Banyan 예약하기" /></a>
							</li>
							<li class="">
								<a href="HotelMain.jsp?center=HotelReserveView.jsp"><img src="images/m_gnb07.png" alt="Rooms  예약확인" /></a>
							</li>
							<li class="">
								<a href="/web/02_dining/de01.asp"><img src="images/m_gnb02.png" alt="Dining 다이닝" /></a>
							</li>
							<li class="">
								<a href="/web/03_recreation/rc01000.asp"><img src="images/m_gnb03.png" alt="Recreation 레크레이션" /></a>
							</li>
							<li class="">
								<a href="/web/04_banquet/bw01001.asp"><img	src="images/m_gnb04.png" alt="Banquet &amp; Wedding 연회 &amp; 웨딩" /></a>
							</li>
							<li class="">
								<a href="/web/06_club/cm01.asp"><img src="images/m_gnb06.png" alt="Club Membership 클럽 멤버십" /></a>
							</li>
							<li class="">
								<a href="/web/05_promotions/pm01001.asp"><img src="images/m_gnb05.png" alt="Promotion 프로모션" /></a>
							</li>
						</ul>
					</div>
				</div>
				<!--주메뉴 구현 -->
			</div>
			<!--상단메뉴바 구현 -->
		</div>
		<!-- //header -->
</body>
</html>