<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课后辅导讨论系统</title>


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
					class="btn btn-outline-inverse btn-lg"">课后辅导讨论</a>
			</p>
		</div>
	</div>

	<div class="bs-docs-featurette">
		<div class="container">
			<h2 class="bs-docs-featurette-title">为所有教师、学生而设计。</h2>
			<p class="lead">AS-tutoring System    让学习更快速、简单。给教师与学生之间搭建一座及时沟通的桥梁。</p>

			<hr class="half-rule">

			<div class="row">
				<div class="col-sm-4">
					<h3>我要回答</h3>
					<p>
						用户在主界面可以看到所有人的发表的问题，如果你想对某一个问题发表自己的看法与见解，点击“我要回答”按钮就会跳转到回答该问题的界面，然后输入回答内容，点击发表，就可以成功发表自己的看法。
					</p>
				</div>
				<div class="col-sm-4">
					<h3>我要提问</h3>
					<p>用户可以根据需要提出问题，在主界面中点击“我要提问”按钮就可以跳转到提出问题的界面，在界面中，输入问题的标题、内容，选择类型标签后即可发表，发布成功后所有用户就可以在问题列表中查看到该问题。</p>
				</div>
				<div class="col-sm-4">
					<h3>与我相关</h3>
					<p>该模块分为“我提出的”、“我回答的”两个子模块，用户可以查看自己所提出的所有问题列表或者所作出回答的问题列表。</p>
				</div>
			</div>
		</div>
	</div>


</body>
<jsp:include page="footer.jsp" />
</html>