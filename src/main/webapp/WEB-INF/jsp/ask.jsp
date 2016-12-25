<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.ask-input {
	height: 40px;
	line-height: 50px;
}

.container-left {
	width: 70%;
	float: left;
}

.container-right {
	width: 20%;
	background-color: #fff;
	float: right;
	text-align: center;
	padding-left: 10px;
	padding-right: 10px;
}

h4.ask-question {
	height: 42px;
	line-height: 42px;
	background: url("${ctx}/static/img/icon1.png") 0 -90px no-repeat;
}
</style>
</head>
<body>
	<!-- 包含头部 -->
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="container-left">
			<h1>提问</h1>
			<div class="input-group">
				<span class="input-group-addon">问题：</span> <input type="text"
					class="ask-input form-control" placeholder="请一句话说明问题，以问号结尾" />
			</div>
			<div></div>
		</div>
		<div class="container-right">
			<h4 class="ask-question">提问注意</h4>
			<p>1、大家每天可以免费提出两个问题，从第三个问题起，每个问题扣除2点积分，请知晓哦；</p>
			<p>1、大家每天可以免费提出两个问题，从第三个问题起，每个问题扣除2点积分，请知晓哦；</p>
			<p>1、大家每天可以免费提出两个问题，从第三个问题起，每个问题扣除2点积分，请知晓哦；</p>
			<p>1、大家每天可以免费提出两个问题，从第三个问题起，每个问题扣除2点积分，请知晓哦；</p>
		</div>
	</div>
	<!-- 包含尾部 -->
	<jsp:include page="footer.jsp" />
</body>
</html>