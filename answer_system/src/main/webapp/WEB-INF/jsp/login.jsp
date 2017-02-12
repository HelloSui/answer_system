<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/static/css/login.css"
	type="text/css" />
<script type="text/javascript">
$(function(){
	
	//登录逻辑
	 $(".nav.nav-tabs > li:first").click(function(){
		 setForm($(this),'${ctx}/user/login','登录');
	 	
	 });
	//注册逻辑
	 $(".nav.nav-tabs > li:last").click(function(){
		 setForm($(this),'${ctx}user/register','注册');
	 });
	 
	 function setForm($this,url,btnValue) {
		$this.siblings().removeClass('active');
		$this.addClass('active');
		$this.closest('form').attr('action', url);
		$this.closest('form').find('button').text(btnValue);
	 }
});
</script>
<title>答题系统</title>
</head>
<body>
	<div class="container">
		<form method="post">

			<ul class="nav nav-tabs">
				<li class="active"><a href="#">登录</a></li>
				<li><a href="#">注册</a></li>
			</ul>

			<div class="form-group">

				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					</div>
					<input type="text" class="form-control" name="name"
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
				<button type="submit"
					class="btn btn-primary btn-block btn-login btn btn-warning">
					 登录
				</button>
			</div>
		</form>
	</div>
</body>
</html>