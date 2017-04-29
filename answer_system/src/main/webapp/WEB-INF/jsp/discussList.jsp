<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛答疑系统</title>
<style>
html {
	/*padding-right:calc(100vw - 100%);*/
	
}

.container.main {
	padding-top: 60px;
}

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

.search-wraper {
	margin-left: auto;
	margin-right: auto;
	max-width: 680px;
	margin-top: 30px;
	margin-bottom: 20px;
}

.form-group {
	text-align: center;
}

.form-group>input {
	height: 45px;
	display: inline-block;
	width: 90%;
	margin-right: 0;
	border: 1px solid #d0d6d9;
	padding-left: 5px;
}

.search-button {
	position: relative;
	display: inline-block;
	background-color: #5cb85c;
	color: #fff;
	height: 45px;
	width: 60px;
	line-height: 45px;
	margin: 0;
	text-align: center;
	padding: 0;
	text-decoration: none;
	left: -1px;
}

.question-tags {
	font-size: 14px;
	padding: 0 9px;
	line-height: 28px;
	background-color: #fff;
	border: 1px solid #d0d6d9;
	display: inline-block;
	cursor: pointer;
	margin: 5px;
	text-decoration: none !important;
}

.save {
	border: 1px solid #5cb85c;
	margin: 5px;
}

.form-group>input:focus {
	border: 1px solid #5cb85c;
	outline: 0 !important;
	box-shadow: none;
}

.classfy-tag:link, .classfy-tag:visited, .classfy-tag:hover,
	.classfy-tag:active {
	color: #fff;
	text-decoration: none;
}

.search-button:link, .search-button:visited, .search-button:hover,
	.search-button:active {
	color: #fff;
	text-decoration: none;
}
</style>
</head>

<script type="text/javascript">
	$(function() {
		$('.question-tags').bind('click', function() {
			if ($(this).hasClass('save')) {
				$(this).removeClass('save');
			} else {
				$(this).addClass("save");
			}
		});
		function getSelectLabelId() {
			var labelIds = '';
			labelIds = $('.question-tags.save').map(function() {
				return $(this).attr('id');
			}).get().join(',');
			alert(labelIds);
			return labelIds;
		}
		$('.list-container').on('click', '.agree-with', function() {
			var agreeNum = $(this).children('em').html();
			agreeNum = agreeNum + 1;
			alert(agreeNum);
			var id = $('#discussId').val();
			alert(id);
			var postData = {
				'id' : id,
				'agreeTimes' : 4
			};
			$.post("${ctx}/discuss/update", postData, function(result) {
				if (result.retCode == 0) {
					alert('点赞成功');
					document.location.href = "${ctx}/discuss/discussList";
				} else {
					alert('点赞失败');
				}
			});
		});

		$('.list-container').on('click', '.oppose', function() {
			var agreeNum = $(this).children('em').html();
			alert(agreeNum);
		});
	});

	String.prototype.format = function() {
		var i = 0, args = arguments;
		var res = this;
		for (i in args) {
			var v = args[i++];
			res = res.replace(/%s/, v);
		}
		return res;

	};

	$(function() {
		getQuestionData(null, 1, 10);
	});

	function getQuestionData(queryParam, pageNo, pageSize) {

		queryParam = queryParam || {};
		pageNo = pageNo || 1;
		pageSize = pageSize || 10;

		queryParam.pageNo = pageNo;
		queryParam.pageSize = pageSize;

		$
				.get(
						"${ctx}question/getQuestionListData",
						queryParam,
						function(result) {
							if (result.retCode == 0) {
								console.log(result);

								var dataHtml = '';

								var pageData = result.value.pageData;

								for (index in pageData) {
									var item = pageData[index];
									var title = item.title;
									var description = item.description;
									var createUserName = item.createUserName;
									var speakerName = item.speakerName;

									var bestDiscuss = item.bestDiscuss;
									if (bestDiscuss) {
										var discussId = bestDiscuss.id;
									}

									var labelTag = '';

									var itemHtml = '';

									var labelArr = item.typeId.split(',');

									for (labelIndex in labelArr) {
										var labelItemArr = labelArr[labelIndex]
												.split(':');

										var itemHtml = '<a href="javascript:void(0)" class="classfy-tag">%s</a>'
												.format(labelItemArr[1]);
										labelTag += itemHtml;
									}

									var fromTag = '<div class="from-tag">'
											+ '<span>由 </span><b>%s</b><span> 提问 </span> <span>标签：'
													.format(createUserName);
									fromTag += labelTag + '</span></div>'

									var titleTag = '<div><a href="" class="ques-title">%s</a></div>'
											.format(title);

									var answerUserTag = '';
									var ansContentTag = '';
									var ctrlBarTag = '<div class="ctrl-bar">';
									if (bestDiscuss) {
										answerUserTag = '<div class="ans-user"><span>由 </span><b>%s</b><span> 回答 </span></div>'
												.format(speakerName);
										ansContentTag = '<div class="ans-content">%s</div>'
												.format(bestDiscuss.content);
										ctrlBarTag += '<span class="agree-with"><b>赞同</b><em>%s</em></span> '
												.format(bestDiscuss.agreeTimes);
										ctrlBarTag += '<span class="oppose"><b>反对</b><em>%s</em></span> '
												.format(bestDiscuss.opposeTimes);
									}
									ctrlBarTag += '<span class="answer" ask-user-id="" ans-user-id=""><b>我要回答</b></span></div>';

									itemHtml = ''
											+ '<div class="ques-list-item">'
											+ fromTag + titleTag
											+ answerUserTag + ansContentTag
											+ ctrlBarTag + '</div>';

									itemHtml += '<input type="hidden" id="discussId" value="%s"/>'
											.format(discussId);
									dataHtml += itemHtml;
									itemHtml = '';

									//break;
								}

								$('.list-container').append(dataHtml);

							} else {
								alert('请求失败');
							}
						});

	}
</script>
<body>
	<div class="container main">
		<form class="search-wraper" role="search">
			<div class="form-group">
				<input class="" id="search-content" placeholder="搜索开源库，例如：jquery" /><a
					href="javascript:void(0)" class="search-button">搜索</a>
			</div>
		</form>
		<div class="control-group" style="text-align: center">
			<c:forEach items="${allQuestionType}" var="item">
				<a href="javascript:void(0)" id="${item.id}" class="question-tags"
					id="1">${item.description }</a>
			</c:forEach>
		</div>
		<div class="list-container">
			<div class="ques-list-item">
				<div class="from-tag">
					<span>由 </span><b>suixue</b><span> 提问 </span> <span>标签：<a
						href="javascript:void(0)" class="classfy-tag">英语</a><a
						href="javascript:void(0)" class="classfy-tag">化学</a><a
						href="javascript:void(0)" class="classfy-tag">政治</a></span>
				</div>
				<div>
					<a class="ques-title">suixueya</a>
				</div>
				<div class="ans-user">
					<span>由 </span><b>lisi 教师</b><span> 回答 </span>
				</div>
				<div class="ans-content">fdad</div>
				<div class="ctrl-bar">
					<span class="agree-with"><b>赞同</b><em>2</em></span> <span
						class="oppose"><b>反对</b><em>1</em></span> <span class="answer"
						ask-user-id="" ans-user-id=""><b>我要回答</b></span>
				</div>
			</div>
		</div>
		<!-- 分页条 -->
		<div class="page">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">首页</a></li>
					<li><a href="#">上一页</a></li>
					<li><a href="#">当前第1页</a></li>
					<li><a href="#">下一页</a></li>
					<li><a href="#">尾页</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>

<%@ include file="footer.jsp"%>
</html>