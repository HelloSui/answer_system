<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
.container {
	width: 400px;
	background-color: #fff;
	text-align: center;
	margin-top: 100px;
}

form {
	margin: 20px;
}

.form-group {
	margin: 20px;
}

.user-type>span{
	margin:0 7px;
}
</style>
<script type="text/javascript">
	$(function() {
		
		$('input[type="radio"]:last').attr('checked', 'checked');
		$('.user-type').css('display', 'none');
		//登录逻辑
		$(".nav.nav-tabs > li:first").click(function() {
			setForm($(this), '${ctx}/user/login', '登录');
			$('.user-type').css('display', 'none');

		});
		//注册逻辑
		$(".nav.nav-tabs > li:last").click(function() {
			setForm($(this), '${ctx}user/register', '注册');
			$('.user-type').css('display', 'block');
		});

		function setForm($this, url, btnValue) {
			$this.siblings().removeClass('active');
			$this.addClass('active');
			$this.closest('form').attr('action', url);
			$this.closest('form').find('button').text(btnValue);
		}
		
		$('#submit').click(function() {
			
			var text = $(this).text();
			var username = $('#username').val();
			var password = $('#password').val();
			checkInput(username, password);
			if(text == '注册') {
				
			}
			//登陆
			else{
				var data = {};
				data.name=username;
				data.password = password;
				$.post('${ctx}user/login', data, function(result) {
					//成功
					if(result.retCode == 0) {
						window.location.href="${ctx}home/home";
					}
					else {
						alert('登陆失败');
					}
				});
			}
		});
		
		function checkInput(username, password) {
			if(username.length!=0 && password.length!=0) {
				alert('success');
			}
			else{
				alert('用户名密码不能为kong');
			}
		}
		
		
	});
</script>
<title>答题系统</title>
</head>
<body>
	<div class="container">
		<form method="post">

			<ul class="nav nav-tabs">
				<li class="active"><a href="javascript:void(0)">登录</a></li>
				<li><a href="javascript:void(0)">注册</a></li>
			</ul>

			<div class="form-group">

				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					</div>
					<input type="text" class="form-control" name="name" id="username"
						placeholder="用户名" />
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
			<div class="user-type">
				<span><input type="radio" name="inputLogType" id="splunk">教师
				</span><span><input type="radio" name="inputLogType" id="pig">学生</span>
			</div>
			<div class="form-group">
				<button id="submit" type="submit" class="btn btn-warning">登录</button>
			</div>
		</form>
	</div>
</body>
</html>