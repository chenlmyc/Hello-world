<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果</title>
<link rel="stylesheet" href="css/app.css">
<link rel="stylesheet " href="css/nav.css">
<link rel="stylesheet " href="css/result.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-table-zh-CN.js"></script>
<style>
div {
	border: 0px dashed #2b2b2b;
}
</style>
</head>
<body>
	<div class="global" style="width: 100%">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<!-- <a class="navbar-brand" href="#">Brand</a> -->
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="search.jsp">
								首页 <span class="sr-only">(current)</span>
							</a>
						</li>
						<li>
							<a href="backer.jsp">后台管理</a>
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
								<li role="separator" class="divider"></li>
								<li>
									<a href="#">One more separated link</a>
								</li>
							</ul>
						</li>
					</ul>
					<!-- <form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button class="btn" type="submit" style="border-radius: 5px;">搜索</button>
					</form> -->
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
			<!-- /.container-fluid -->
		</nav>
		<div class="content row">
			<div class="col-md-2 count">
				<div class="panel panel-default">
					<div class="panel-heading">用时</div>
					<div class="panel-body">0.12秒</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">记录总数</h3>
					</div>
				</div>
				<!-- Single button -->
				<div class="btn-group" style="width: 189px;">
					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 100%">
						图形展示${host} <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li>
							<a id="apillar">柱状图</a>
						</li>
						<li>
							<a id="abiscuit">饼状图</a>
						</li>
						<li>
							<a id="amap">地图分布展示</a>
						</li>
						<li>
							<a id="atable">表格</a>
						</li>
					</ul>
				</div>
			</div>
			<div  class="col-md-10 table-result">
				<table  class="table-bordered" data-toggle="table"  data-url="TableServlet" data-show-pagination-switch="true" data-pagination="true" data-page-size="8" data-page-list="[6, 7, 8]">
					<thead>
						<tr>
							<th data-field="ip">IP</th>
							<th data-field="city">位置</th>
							<th data-field="os">系统</th>
							<th data-field="port">端口</th>
							<th data-field="service">服务</th>
						</tr>
					</thead>
				</table>
				<div id="pillar" style="width:1092px;height:500px;"></div>
				<div id="biscuit" style="width:1092px;height:500px;"></div>
				<div id="map" style="width:1092px;height:500px;"></div>
			</div>
		</div>
		<div class="footer">
		${ojb}
		</div>
	</div>
	<script src="js/echarts.js"></script>
	<script src="js/china.js"></script>
	<script src="js/switch.js"></script>
	<!-- <script>
		$(function(){
			$('.table-bordered').attr('data-url','TableServlet?search='+window.location.search.match(/=(\S+$)/)[1]);
			console.log(window.location.search.match(/=(\S+$)/)[1]);
		});
	</script> -->
</body>
</html>