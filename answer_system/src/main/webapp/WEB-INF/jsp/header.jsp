<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" type="button"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand hidden-sm"
				onclick="">课后辅导讨论系统</a>
		</div>
		<div class="navbar-collapse collapse" role="navigation">
			<ul class="nav navbar-nav">
				<li><a href="${ctx}home/home" onclick="">首页</a></li>
				<li><a href="${ctx}discuss/discussList" onclick="">我要回答</a></li>
				<li><a href="${ctx}question/ask" onclick="">我要提问</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right hidden-sm">
				<li><a href="http://mb.bootcss.com" onclick="" target="_blank">登录/注册</a></li>
			</ul>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(function() {
		$('.nav.navbar-nav li').on('click', function() {
			$(this).closest('ul').find('li').removeClass('active');
			$(this).addClass('active');
		});
	});
</script>
