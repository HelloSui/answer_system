<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">答疑论坛</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">我要提问</a></li>
					<li><a href="#">我要解答</a></li>
					<li><a href="#">我要搜索</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>

<script type="text/javascript">
	$(function() {
		$('.nav.navbar-nav li').on('click', function() {
			$(this).closest('ul').find('li').removeClass('active');
			$(this).addClass('active');
		});
	});
</script>
