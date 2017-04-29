<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {

		$('#login-register').click(function() {
			//id为空说明没有登录
			if (!$('#loggin-user-id').text()) {
				window.location.href = "${ctx}user/login";
			}
		})
	});
</script>
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle collapsed" type="button"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand hidden-sm" onclick="">课后辅导讨论系统</a>
			</div>
			<div class="navbar-collapse collapse" role="navigation">
				<ul class="nav navbar-nav">
					<li><a href="${ctx}home" onclick="">首页</a></li>
					<li><a href="${ctx}discuss/discussList" onclick="">我要回答</a></li>
					<li><a href="${ctx}question/ask" onclick="">我要提问</a></li>
					<li><a href="${ctx}discuss/my/ask" onclick="">我提出的</a></li>
					<li><a href="${ctx}discuss/my/answer" onclick="">我回答的</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right hidden-sm"
					id="login-register">
					<li><a href="javascript:void(0)">登录/注册</a></li>
				</ul>
			</div>
		</div>

		<div class="login-user-info">
			<input type="hidden" id="loggin-user-id">${sessionScope.id} <input
				type="hidden" id="loggin-user-name">${sessionScope.name}
		</div>
	</div>
</body>
</html>


