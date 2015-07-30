<!DOCTYPE html>
<html lang="en">

<head>
	<title>我的酷我相册</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/information.css" />
</head>

<body>
<%String username=(String)session.getAttribute("username");%>
	<!-- ==== start header ====-->
	<header role="banner">
		<img src="images/title.png" class="htpic" />
		<div>
			<a href="information.jsp"><span class="account"><%out.print(username); %></span></a>
			<a href="set.html"><img src="pics/set.png" /></a>
		</div>
	</header>
	<!-- end header -->

	<main role="main">

	<div class="intro clearfix">
		<div class="first-intro">
			<img src="pics/big.jpg" />
			<ul>
				<li>
					<a href="#">10</a>
					<p>关注</p>
				</li>
				<li>
					<a href="#">20</a>
					<p>粉丝</p>
				</li>
			</ul>
		</div>

		<div class="second-intro">
			<span>Bamboo</span>
			<ul>
				<li>Alice</li>
				<li>女</li>
				<li>1993-06-12</li>
				<li>中国-湖北省-武汉市</li>
			</ul>
			<span class="signature">心情总是晴朗</span>
		</div>
		<div class="third-intro">
			<a href="set.html"><img src="pics/modify.png" /></a>
		</div>
	</div>

	<div class="content">
		<nav>
			<ul>
				<li class="special"><a href="#album">我的相册</a></li>
				<li><a href="#dynamic">动态</a></li>
				<li><a href="#relationship">我的关系</a></li>
				<li><a href="#collection">我的收藏</a></li>
			</ul>
		</nav>

		<section id="album">
			<ul class="ct">
				<li><a href="" class="file">上传照片<input type="file" name="album" /></a></li>
				<li id="create"><a href="#form"><span>创建相册</span></a></li>
			</ul>
			<!-- creat album -->
			<div class="background"></div>
			<div id="form">
				<div class="fh">
					<h1>创建相册</h1>
					<a href="javascript:;" class="close"><img src="pics/close.png" /></a>
				</div>
			<form method="post" action="">
			<fieldset>
				<div class="row">
					<label for="name">相册名称:</label>
					<input type="text" id="name" name="name" autofocus required />
				</div>
				<div class="row">
					<label for="description">相册描述:</label>
					<textarea id="description" name="description" cols="30" rows="3"></textarea>
				</div>
				<div class="row">
					<fieldset class="radios">
						<legend>主题:</legend>
						<p class="row">
							<input type="radio" id="putong" name="putong" value="putong" />
							<label for="putong">普通</label>
						</p>
						<p class="row">
							<input type="radio" id="lvyou" name="lvyou" value="lvyou" />
							<label for="lvyou">旅游</label>
						</p>
						<p class="row">
							<input type="radio" id="meishi" name="meishi" value="meishi" />
							<label for="meishi">美食</label>
						</p>
						<p class="row">
							<input type="radio" id="haoyou" name="haoyou" value="haoyou" />
							<label for="haoyou">好友</label>
						</p>
					</fieldset>
				</div>
				<div class="row btn">
					<a href="create-album.html"><input type="button" value="确定" /></a>
					<span class="close">取消</span>
				</div>
			</fieldset>	
			</form>
			</div>
			<!--end album-->
		</section>

		<section id="dynamic">
			<ul class="ct">
				<li>我自己的</li>
				<li>我关注人的</li>
			</ul>
		</section>

		<section id="relationship">
			<ul class="ct">
				<li>我关注的</li>
				<li>关注我的</li>
				<li>相互关注</li>
			</ul>
		</section>

		<section id="collection">
			<ul class="ct">
				<li>全部</li>
			</ul>
		</section>
	</div>

	</main>
<script type="text/javascript" src="js/information.js"></script>
</body>
</html>