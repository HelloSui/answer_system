<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/static/css/login.css"
	type="text/css" />
<title>答题系统</title>
</head>
<body>
	<div class="container">
		<form method="post" role="form" action="index.html">

			<ul class="nav nav-tabs">
				<li class="active"><a href="#">登录</a></li>
				<li><a href="#">注册</a></li>
			</ul>

			<div class="form-group">

				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					</div>
					<input type="text" class="form-control" name="username"
						id="username" placeholder="用户名" />
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
					</div>
					<input type="password" class="form-control" name="password"
						id="password" placeholder="密码" />
				</div>
			</div>
			<div class="form-group">
				<button type="button"
					class="btn btn-primary btn-block btn-login btn btn-warning">
					<i class="fa fa-sign-in"></i> 登录
				</button>
			</div>
		</form>
	</div>
</body>
</html>