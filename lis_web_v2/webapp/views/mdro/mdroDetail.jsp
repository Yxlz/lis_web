<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>耐药菌感染临床治疗指导意见</title>
</head>
<style>
p {
	width: 70%;
	height: 15px auto;
	margin: 20px auto;
	font-size: 14px;
	color: #0a78fa;
	text-align: justify;
	text-justify: inter-ideograph; /*IE*/
}
</style>
<body>
	<h4 align="center"><%=request.getAttribute("mdroName")%>感染的临床治疗指导意见
	</h4>
	<c:forEach var="d" items="${mdroDetail}" varStatus="status">
		<div>
			<p>
				<c:out value="${d}" />
			</p>
		</div>
	</c:forEach>
	<%-- <div><p><%=request.getAttribute("mdroDetail")%></p></div> --%>
</body>
</html>