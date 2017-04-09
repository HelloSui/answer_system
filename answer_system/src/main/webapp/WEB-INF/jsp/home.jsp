<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师答疑系统</title>


<style type="text/css">
.container.main {
	padding-top: 80px;
}

.bs-docs-masthead .bs-docs-booticon {
	margin: 0 auto 30px;
}

.bs-docs-booticon-outline {
	background-color: transparent;
	border: 1px solid #cdbfe3;
}

.bs-docs-booticon-lg {
	width: 144px;
	height: 144px;
	font-size: 108px;
	line-height: 140px;
}

.bs-docs-booticon {
	display: block;
	font-weight: 500;
	color: #fff;
	text-align: center;
	cursor: default;
	background-color: #563d7c;
	border-radius: 15%;
}

.bs-docs-masthead {
	position: relative;
	padding: 30px 0;
	color: #cdbfe3;
	text-align: center;
	text-shadow: 0 1px 0 rgba(0, 0, 0, .1);
	background-image: -webkit-gradient(linear, left top, left bottom, from(#563d7c),
		to(#6f5499));
	background-image: -webkit-linear-gradient(top, #563d7c 0, #6f5499 100%);
	background-image: -o-linear-gradient(top, #563d7c 0, #6f5499 100%);
	background-image: linear-gradient(to bottom, #563d7c 0, #6f5499 100%);
}

.col-sm-4>h3 {
	text-align: center;
}
</style>

<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="bs-docs-masthead" id="content" tabindex="-1">
		<div class="container main">
			<span
				class="bs-docs-booticon bs-docs-booticon-lg bs-docs-booticon-outline">SX</span>
			<p class="lead">每个微小的个体， 都有发光的权利</p>
			<p class="lead">
				<a href="getting-started#download"
					class="btn btn-outline-inverse btn-lg"">答疑</a>
			</p>
		</div>
	</div>

	<div class="bs-docs-featurette">
		<div class="container">
			<h2 class="bs-docs-featurette-title">为所有开发者、所有应用场景而设计。</h2>
			<p class="lead">Bootstrap
				让前端开发更快速、简单。所有开发者都能快速上手、所有设备都可以适配、所有项目都适用。</p>

			<hr class="half-rule">

			<div class="row">
				<div class="col-sm-4">
					<h3>我要提问</h3>
					<p>
						虽然可以直接使用 Bootstrap 提供的 CSS 样式表，不要忘记 Bootstrap 的源码是基于最流行的 CSS 预处理脚本
						- <a href="../css/#less">Less</a> 和 <a href="../css/#sass">Sass</a>
						开发的。你可以采用预编译的 CSS 文件快速开发，也可以从源码定制自己需要的样式。
					</p>
				</div>
				<div class="col-sm-4">
					<h3>我要回答</h3>
					<p>你的网站和应用能在 Bootstrap 的帮助下通过同一份代码快速、有效适配手机、平板、PC 设备，这一切都是 CSS
						媒体查询（Media Query）的功劳。</p>
				</div>
				<div class="col-sm-4">
					<h3>个人中心</h3>
					<p>Bootstrap 提供了全面、美观的文档。你能在这里找到关于 HTML 元素、HTML 和 CSS 组件、jQuery
						插件方面的所有详细文档。</p>
				</div>
			</div>
		</div>
	</div>


</body>
<jsp:include page="footer.jsp" />
</html>