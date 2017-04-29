<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛答疑系统</title>
<style>
.container.main {
	padding-top: 60px;
}

.main-text {
	font-size: 16px;
}

.right {
	float: right;
}

.container.main {
	content: "";
	clear: both;
}

.ans-submit {
	overflow: hidden;
}

.container-left {
	background-color: #fff;
	float: left;
	width: 70%;
	padding-left: 20px;
	padding-right: 20px;
}

.container-right {
	background-color: #fff;
	float: right;
	width: 20%;
	text-align: center;
	padding: 0 20px;
}

.ques-title {
	display: block;
	line-height: 28px;
	word-break: break-all;
	font-size: 24px;
	color: #14191e;
	text-decoration: none;
	font-weight: 600;
}

.questoin-detail {
	margin: 20px auto;
	font-size: 16px;
	line-height: 36px;
	work-brea: break-all;
}

.detail-provider {
	padding: 2px 4px 2px 5px;
	background-color: #e5f3fa;
	margin: 0 5px;
}

.ask-username {
	font-weight: bold;
}

.answer-container {
	background-color: #f6f6f6;
}

.answer-content {
	border: 1px solid #d0d6d9;
	min-height: 100px;
	margin: 20px;
	overflow: auto;
	padding: 10px;
}

.answer-content:focus {
	border: 1px solid green !important;
}

.btn {
	color: #fff;
	font-size: 14px;
	line-height: 40px;
	padding: 0;
	display: inline-block;
	cursor: pointer;
	margin: 5px;
	text-decoration: none !important;
	width: 100px;
	height: 40px;
	border-width: 0;
	background-color: #fff;
	border-width: 0;
}

.btn-red {
	background-color: #f01400;
	border-color: transparent;
}

.ques-answer {
	border: 1px solid #ccc;
	background-color: #fff;
	overflow: auto;
	margin-top: 20px;
	margin-bottom: 20px;
}

.ques-answer>div {
	margin: 10px;
}

.time {
	float: right;
	color: #000;
	font-size: 12px;
	margin: 15px;
}

.ans-name {
	font-weight: bold;
	font-size: 14px;
}

.clear {
	overflow: hidden;
}

.reply {
	margin-left: 40px;
}

.reply li {
	background-color: #ccc;
	padding: 5px;
	margin: 5px 0;
}
</style>
</head>

<script type="text/javascript">
	$(function() {

		$(function() {
			$
					.get(
							'${ctx}discuss/answerQuestion?questionId=1',
							function(result) {
								var data = result.value;
								var question = data.question;
								console.log(data);
								if (result.retCode == 0) {

									//填充基本信息
									$('.ques-title').text(question.title);
									$('.questoin-detail').text(
											question.description);
									$('.ask-username').text(
											question.createUserName);
									$('.answer-num>span:first').text(
											data.answerNum);

									var answerList = data.answerList;

									for (i in answerList) {

										var answer = answerList[i];
										var ansDetailTag = '<li class="ques-answer"><div class="detail-r clear"><div class="clear"><span class="ans-name">%s</span><span>的回答</span> <span class="time">%s</span></div><div class="ans-content"><p>%s</p></div></div>';
										ansDetailTag = ansDetailTag.format(
												answer.answerUserName,
												answer.createTime,
												answer.answerContent);

										var ctrlTag = '<div class="ctrl-bar">'
												+ '<span class="agree-with"><b>赞同</b><em>%s</em></span>'
												+ '<span class="oppose"><b>反对</b><em>%s</em></span>'
												+ '<span class="reply"><em>%s</em><b>个回复</b></span></div></li>';

										ctrlTag = ctrlTag.format(
												answer.agreeTimes,
												answer.opposeTimes,
												answer.answerNum);
										
										

										$('.ans-list>ul').append(ansDetailTag +ctrlTag);
									}
									//填充回答

								} else {
									alert('请求失败');
								}

							});

		});

		$('.ctrl-bar>span[class="reply"]').click(function() {

			var ansCount = $(this).children('em').text();
			//说明有人回答
			if (ansCount !== 0) {
				//从后台查询
				var $replayPanel = $(this).closest('.ques-answer').children('.reply');
				if ($replayPanel.css('display') == 'none') {
					$replayPanel.css('display', 'block');
				} else {
					$replayPanel.css('display', 'none');
				}
			}
		});

	});
</script>
<body>
	<div class="container main">
		<div class="container-left">
			<h1 class="ques-title"></h1>
			<div class="questoin-detail"></div>

			<div class="detil-asker">
				<span class="detail-provider">提问者</span><span class="ask-username"></span>
			</div>

			<div class="answer-container">
				<div class="answer-content" contentEditable="true"></div>
			</div>
			<div class="ans-submit">
				<a id="ans-submit" class="btn btn-red right">回答</a>
			</div>

			<div class="answer-num main-text">
				<span class=""></span><span>个回答</span>
			</div>

			<!-- 回答的list列表 -->
			<div class="ans-list">
				<ul>
					<li class="ques-answer">
						<div class="detail-r clear">
							<div class="clear">
								<span class="ans-name">隋雪</span><span>的回答</span> <span
									class="time">5小时前</span>
							</div>
							<div class="ans-content">
								<p>不加标签就用js实现吧不加标签就用js实现吧不加标签就用js实现吧</p>
							</div>
						</div>
						<div class="ctrl-bar">
							<span class="agree-with"><b>赞同</b><em>10</em></span> <span
								class="oppose"><b>反对</b><em>2</em></span> <span class="reply"><em>2</em><b>个回复</b></span>
						</div>

						<div class="reply" style="display: none">
							<ul class="reply-list">
								<li>
									<div class="detail-r clear">
										<div class="clear">
											<span class="ans-name">隋雪</span><span>的回答</span> <span
												class="time">5小时前</span>
										</div>
										<div class="ans-content">
											<p>不加标签就用js实现吧不加标签就用js实现吧不加标签就用js实现吧</p>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</div>

		<div class="container-right">
			<h4 class="ask-question">提问注意</h4>
			<p>1、大家每天可以免费提出两个问题，从第三个问题起，每个问题扣除2点积分，请知晓哦；</p>
			<p>1、大家每天可以免费提出两个问题，从第三个问题起，每个问题扣除2点积分，请知晓哦；</p>
			<p>1、大家每天可以免费提出两个问题，从第三个问题起，每个问题扣除2点积分，请知晓哦；</p>
			<p>1、大家每天可以免费提出两个问题，从第三个问题起，每个问题扣除2点积分，请知晓哦；</p>
		</div>
	</div>
</body>

<%@ include file="footer.jsp"%>
</html>