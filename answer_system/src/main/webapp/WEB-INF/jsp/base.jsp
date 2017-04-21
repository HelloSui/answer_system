<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ctx" value="<%=basePath %>" scope="session"/>
<link href="<%=basePath%>static/bootstrap/css/bootstrap.css"
	type="text/css" rel="stylesheet" />
<link href="${ctx}static/css/base.css" rel="stylesheet" type="text/css" />
<script src="${ctx}static/bootstrap/js/jquery-2.1.1.js"></script>
<script src="${ctx}static/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}static/bootstrap/js/jquery.validate.js"></script>
<script src="${ctx}static/js/grid.js"></script>


