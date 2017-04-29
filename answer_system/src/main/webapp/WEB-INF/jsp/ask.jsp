<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html lang="en-US">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style type="text/css">

html {
	/*padding-right:calc(100vw - 100%);*/
}

.ask-input {
	height: 40px;
	line-height: 50px;
}

.container.main{
	padding-top:80px;
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
	margin-top:50px;
}

h4.ask-question {
	height: 42px;
	line-height: 42px;
	background: url("${ctx}/static/img/icon1.png") 0 -90px no-repeat;
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
	border: 2px solid #f01400;
	margin: 4px;
}

form p {
	margin: 10 auto;
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

.btn:hover {
	color: #fff;
}

.btn-red {
	background-color: #f01400;
	border-color: transparent;
}

.right {
	float: right;
}
</style>

<script type="text/javascript">
	$(function() {
		$('.question-tags').bind('click', function() {
			if ($(this).hasClass('save')) {
				$(this).removeClass('save');
			} else {
				$(this).addClass("save");
			}
		});

		$('#ques-sub-btn').click(function() {

			var title = $('#title').val();
			var description = $('#description').val();
			var typeId = getSelectLabelId();
			var postData = {
				'typeId' : typeId,
				'title' : title,
				'description' : description,
				'createUserId' : '${currentUser.id}'
			};
			$.post("${ctx}/question/insert", postData, function(result) {
				if (result.retCode == 0) {
					alert('提问成功');
					document.location.href = "${ctx}/discuss/discussList";
				} else {
					alert('提交失败');
				}
			});
		});

		function getSelectLabelId() {
			var labelIds = '';
			labelIds = $('.question-tags.save').map(function() {
				return $(this).attr('id');
			}).get().join(',');
			alert(labelIds);
			return labelIds;
		}
	});
</script>
</head>
<body>
	<div class="container main">
		
		<div class="container-left">
			<form class="form-horizontal">
				<h1>提问</h1>
				<div class="control-group warning">
					<div class="controls">
						<input id="title" type="text" class="ask-input form-control"
							placeholder="请一句话说明问题，以问号结尾" /> <span class="help-block"><font
							color="red">问题的标题，不得多于64字！</font></span>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<textarea id="description" type="text" class="form-control"
							cols="20" rows="10" placeholder="问题补充"></textarea>
					</div>
				</div>

				<p>请选择问题分类</p>
				<div class="control-group">
					<c:forEach items="${allQuestionType}" var="item">
						<a href="javascript:void(0)" id="${item.id}" class="question-tags"
							id="1">${item.description }</a>
					</c:forEach>
				</div>

				<div class="right">
					<a id="ques-sub-btn" class="btn btn-red">提交</a>
				</div>
			</form>
		</div>


		<div class="container-right">
			<h4 class="ask-question">提问注意</h4>
			<p>1、大家每天都可以提出问题，但是问题不在多而在精，请大家知晓哦；</p>
			<p>2、提问时，标题、补充内容以及问题分类，都不能空下，请大家知晓哦；</p>
			<p>3、问题的标题，不得多于64字，问题的描述，不得多于256字，请大家知晓哦；</p>
			<p>4、如果没有提交成功，可能是因为网络等原因，请稍后重试哦；</p>
		</div>

		<input type="hidden" id="currentUserId" value="${currentUser.id}" />
		<input type="hidden" id="currentUserName" value="${currentUser.name}" />
		
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>
