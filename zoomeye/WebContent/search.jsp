<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网络空间搜索</title>
<link rel="stylesheet" href="css/app.css">
<link rel="stylesheet" href="css/nav.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="ng-scope" style="height: 100%; width: 100%">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="search.jsp">
								 首页<span class="sr-only">(current)</span>
							</a>
						</li>
						<li>
							<a href="backer.jsp">后台管理</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#">Link</a>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
								Dropdown <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Action</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li role="separator" class="divider"></li>
								<li>
									<a href="#">Separated link</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="landing-page ng-scope">
			<div class="first-fold">
				<div class="container">
					<div class="row">
						<h1>欢迎来到网络空间搜索引擎</h1>
						<!-- <div class="live-here">
							<h5>请注意输入格式</h5>
						</div> -->
						<form class="ng-pristine ng-invalid ng-invalid-required search" name="lookup" autocomplete="off" action="TableServlet" method="post">
							<span style="display: none; width: 0px; height: 0px;" id="transmark"></span> 
							<input class="ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required" name="searchString" placeholder="搜索一下，你就知道" autocomplete="on">
							<button class="btn btn-primary btn-lg" type="submit">搜索</button>
						</form>
						<a href="javascript:void(0)" class="play-link">
							<span>用户手册</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>