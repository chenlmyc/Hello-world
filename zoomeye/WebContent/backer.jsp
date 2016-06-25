<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>后台管理</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="css/metisMenu.min.css" rel="stylesheet">
<!-- Timeline CSS -->
<link href="css/timeline.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/animate.css" rel="stylesheet" type="text/css">
<link href="css/backer.css" rel="stylesheet" type="text/css">
<script src="js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<script src="js/sb-admin-2.js"></script>
<script src="js/bootstrap-datetimepicker.js"></script>
</head>

<body>

	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; background-color: #fff; border: 0px solid">
			<nav class="navbar navbar-default" style="background-color: #fff">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
					</div>

					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav" style="position: absolute; right:200px;margin:10px 20px;">
							<li class="active">
								<a href="search.jsp">
									首页<span class="sr-only">(current)</span>
								</a>
							</li>
							<li>
								<a href="backer.jsp">后台管理</a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="#">动态存储</a>
									</li>
									<li>
										<a href="#"></a>
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
						<ul class="nav navbar-nav navbar-right" style="margin:10px 20px;">
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
			<div class="navbar-default sidebar" role="navigation" style="color: #fff;">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu" style="color: #37a6aa;">
						<li>
							<a id="portset">
								<i class="fa fa-dashboard fa-fw"></i> 端口设置
							</a>
						</li>
						<li>
							<a>
								<i class="fa fa-bar-chart-o fa-fw"></i> 定时设置<span class="fa arrow"></span>
							</a>
							<ul class="nav nav-second-level">
								<li>
									<a id="nmapset">nmap运行时间间隔</a>
								</li>
								<li>
									<a id="dbset">解析运行结果存入数据库时间间隔</a>
								</li>
							</ul>
						</li>
						<li>
							<a id="ipset">
								<i class="fa fa-table fa-fw"></i> 主机网段设置
							</a>
						</li>
						<li>
							<a id="serviceset">
								<i class="fa fa-edit fa-fw"></i> 主机服务设置
							</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-5 col-md-6" id="port">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-star fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<input type="text">
									<div>查询端口号</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">端口</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-5 col-md-6" id="ip">
					<div class="panel panel-danger">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<input type="text">
									<div>查询网段号</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">网段</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-5 col-md-6" id="service">
					<div class="panel panel-warning">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-shopping-cart fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<input type="text">
									<div>查询服务名称</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">服务</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-5 col-md-6" id="dbupdatetime">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-clock-o fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<input size="16" type="text" value="2012-06-15 14:45" readonly class="form_datetime">

									<script type="text/javascript">
										$(".form_datetime").datetimepicker({
											format : 'yyyy-mm-dd hh:ii'
										});
									</script>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">数据库更新定时</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-5 col-md-6" id="nmapupdatetime">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-clock-o fa-5x"></i>
								</div>
								<div class="col-xs-9">
									<input size="16" type="text" value="2012-06-15 14:45" readonly class="form_datetime">

									<script type="text/javascript">
										$(".form_datetime").datetimepicker({
											format : 'yyyy-mm-dd hh:ii'
										});
									</script>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">nmap定时任务</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-5 col-md-6" id="submitbutton">
					<button id="ok" class="btn btn-default">Submit</button>
					<button id="cancel" type="reset" class="btn btn-default">reset</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /#wrapper -->
	<div id="pop">
		<div id="popHeader"></div>
		<div id="popBody">设置完成</div>
	</div>
	<script src="js/backer.js"></script>
</body>

</html>
