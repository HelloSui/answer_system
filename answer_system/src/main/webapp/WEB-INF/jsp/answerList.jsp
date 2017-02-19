<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.ques-list-item {
	background-color: #fff;
	overflow: auto; /*margin重叠*/
	margin: 10px 0;
}

.from-tag {
	font-size: 14px;
	text-decoration: none;
}

.classfy-tag {
	color: #fff;
	background-color: #5cb85c;
	height: 40px;
	padding: 5px;
	margin: 5px;
	text-decoration: none !important;
	cursor: pointer;
}

.classfy_tag:hover {
	color: #fff;
}

.ques-title {
	display: block;
	line-height: 28px;
	word-break: break-all;
	font-size: 18px;
	color: #14191e;
	text-decoration: none;
	font-weight: 600;
}

.ques-list-item>div {
	margin: 10px;
}

.ctrl-bar>span {
	display: inline-block;
	height: 24px;
	border: 1px solid #d0d6d9;
	padding: 0 10px;
	cursor: pointer;
}

.agree-with:hover, .answer:hover {
	border: 1px solid #5cb85c;
}

.oppose:hover {
	border: 1px solid #f01400;
}

.page {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">

		<div class="ques-list-item">

			<!-- 由谁提问 -->
			<div class="from-tag">
				<span>由 <span><b>隋雪</b><span> 提问 </span> <span>标签：
							<a href="javascript:void(0)" class="classfy-tag">java</a> <a
							href="javascript:void(0)" class="classfy-tag">python</a>
					</span>
			</div>

			<!-- 提问的标题 -->
			<div>
				<a href="" class="ques-title">我不会学java怎么办！！</a>
			</div>

			<div class="ans-user">
				<span>由 <span><b>邓昌建</b><span> 回答 </span>
			</div>
			<!-- 回答的内容 -->
			<div class="ans-content">
				建议学Java，这个学的人多，遇到问题比较容易找到解决方案这是慕课网推荐的Java工程师学习路径，零基础也可以入门：http://www.imooc.com/course/programdetail/pid/31求采纳！
				建议学Java，这个学的人多，遇到问题比较容易找到解决方案这是慕课网推荐的Java工程师学习路径，零基础也可以入门：http://www.imooc.com/course/programdetail/pid/31求采纳！
			</div>

			<!-- 控制 -->
			<div class="ctrl-bar">
				<span class="agree-with"><b>赞同</b><em>2</em></span> <span
					class="oppose"><b>反对</b><em>3</em></span>
			</div>

		</div>

		<div class="ques-list-item">

			<!-- 由谁提问 -->
			<div class="from-tag">
				<span>由 <span><b>隋雪</b><span> 提问 </span> <span>标签：
							<a href="javascript:void(0)" class="classfy-tag">java</a> <a
							href="javascript:void(0)" class="classfy-tag">python</a>
					</span>
			</div>

			<!-- 提问的标题 -->
			<div>
				<a href="" class="ques-title">我不会学java怎么办！！</a>
			</div>

			<div class="ans-user">
				<span>由 <span><b>邓昌建</b><span> 回答 </span>
			</div>
			<!-- 回答的内容 -->
			<div class="ans-content">
				建议学Java，这个学的人多，遇到问题比较容易找到解决方案这是慕课网推荐的Java工程师学习路径，零基础也可以入门：http://www.imooc.com/course/programdetail/pid/31求采纳！
				建议学Java，这个学的人多，遇到问题比较容易找到解决方案这是慕课网推荐的Java工程师学习路径，零基础也可以入门：http://www.imooc.com/course/programdetail/pid/31求采纳！
			</div>

			<!-- 控制 -->
			<div class="ctrl-bar">
				<span class="agree-with" ask-user-id="" ans-user-id=""><b>赞同</b><em>2</em></span>
				<span class="oppose" ask-user-id="" ans-user-id=""><b>反对</b><em>3</em></span>
				<span class="answer" ask-user-id="" ans-user-id=""><b>我要回答</span>
			</div>
		</div>

		<div class="ques-list-item">

			<!-- 由谁提问 -->
			<div class="from-tag">
				<span>由 <span><b>隋雪</b><span> 提问 </span> <span>标签：
							<a href="javascript:void(0)" class="classfy-tag">java</a> <a
							href="javascript:void(0)" class="classfy-tag">python</a>
					</span>
			</div>

			<!-- 提问的标题 -->
			<div>
				<a href="" class="ques-title">我不会学java怎么办！！</a>
			</div>

			<!-- 控制 -->
			<div class="ctrl-bar">
				<span class="answer" ask-user-id="" ans-user-id=""><b>我要回答</span>
			</div>
		</div>

		<!-- 分页条 -->
		<div class="page">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>


</html>