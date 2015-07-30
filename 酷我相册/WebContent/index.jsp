<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,model.Tb_Userinfo" %> 
<!DOCTYPE html>
<html lang="en">
<head>
	<title>é·æç¸å</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>
<%String username=(String)session.getAttribute("account");%>
	<!-- ==== start head ==== -->
	<header class="head" role="banner">
		<img src="images/title.png" tabindex="0" class="titleimg" />
		<div class="inblock nav">
			<input type="search" placeholder="æç´¢æå´è¶£çåå®¹" class="search" />
			<a href="#"><img src="images/search.png" class="searchimg" /></a>
		</div>
		<!-- <form action="IndexToInfo" method="post"> -->
		<div class="inblock info">
			<a href="information.jsp" class="sign"><%out.print("Welcome!&nbsp&nbsp&nbsp&nbsp"+username);session.setAttribute("username",username);%></a>
			<!-- <a href="register.html" class="register">æ³¨å</a>  -->
		</div>
		<!-- </form> -->
	</header>
	<!-- end head -->

	<!-- ==== start main ==== -->
	<main role="main" class="first-main clearfix">
		<div class="pic">	
			<img src="images/main1/1.jpg" class="top-pic"/>
			<span><font>æ¸©é¦¨çæ¤ç©æç»</font></span>
		</div>

		<div class="fl">
			<span class="flt">åç±»</span>
			<ul class="flu">
				<li>ææ¸¸</li>
				<li>äººç©</li>
				<li>å¨æ¼«</li>
				<li>å¨ç©</li>
				<li>ç¾é£</li>
				<li>å»ºç­</li>
				<li>æè£</li>
				<li>å®¶å±</li>
				<li>ææ</li>
				<li>é³ä¹</li>
				<li>çµå½±</li>
				<li>å¾ä¹¦</li>
				<li>æ¸¸æ</li>
				<li>è®¾è®¡</li>
			</ul>
		</div>
	</main>
<!-- end main -->
	<div  class="clearfix div3">
		<div class="second-main">
			<div class="prompt">å¤§å®¶æ­£å¨é</div>
			<div class="content">
				<img src="images/main2/1.jpg" class="main-pic" />
				<span class="description">å°å­©ä¸ç</span>
			</div>
			<div class="content">
				<img src="images/main2/2.jpg" class="main-pic" />
				<span class="description">æ²¹èè±</span>
			</div>
			<div class="content">
				<img src="images/main2/3.jpg" class="main-pic" />
				<span class="description">é»ææµ·è¾¹</span>
			</div>
			<div class="content">
				<img src="images/main2/4.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<div class="content">
				<img src="images/main2/5.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<div class="content">
				<img src="images/main2/6.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<div class="content">
				<img src="images/main2/7.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<div class="content">
				<img src="images/main2/8.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<div class="content">
				<img src="images/main2/9.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<div class="content">
				<img src="images/main2/10.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<div class="content">
				<img src="images/main2/11.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<div class="content">
				<img src="images/main2/12.jpg" class="main-pic" />
				<span class="description">xxxxxxx</span>
			</div>
			<a href="#" class="load">å è½½æ´å¤</a>
		</div>


	<!-- ==== start aside ==== -->
	<aside role="complementary">
		<div class="section">
			<p class="aside-title">ç¤¾åºç­ç¹</p>
			<ul class="aside-content">
				<li>æ¶è£æ­é</li>
				<li>ç¾å¦é å</li>
				<li>ç¾é£èè°±</li>
				<li>æå·¥DIY</li>
				<li>æèºè®¾è®¡</li>
				<li>æ´å¤</li>
			</ul>
		</div>

		<div class="section">
			<p class="aside-title">ä¸ºä½ æ¨è</p>
			<ul class="aside-content">
				<li>åæç¯å·</li>
				<li>æ°´ä¸æå½±</li>
				<li>åå®æç»</li>
				<li>çæ´»ç¾ç§</li>
				<li>å¥èº«èè¹</li>
				<li>æ´å¤</li>
			</ul>
		</div>
	</aside>
	<!-- end aside ====-->
	</div>

	<footer role="contentinfo">
		<div class="foot">
			<p class="ftt">å³äºæä»¬</p>
			<ul class="ftu">
				<li>ç½ç«ç¹ç¹</li>
				<li>å¸®å©ä¸­å¿</li>
				<li>èç³»æä»¬</li>
				<li>ç¨æ·åé¦</li>
			</ul>
		</div>
		<div class="foot">
			<p class="ftt">å³æ³¨æä»¬</p>
			<ul class="ftu">
				<li>æ°æµªå¾®å</li>
				<li>å¾®ä¿¡</li>
				<li>QQ</li>
				<li>äººäººç½</li>
			</ul>
		</div>
	</footer>

</body>
</html>