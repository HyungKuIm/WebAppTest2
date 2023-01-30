<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-01-30
  Time: 오후 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="appUrl" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>파일 업로드</h4>
<form action="${appUrl}/fileupload/single"
      method="post" enctype="multipart/form-data">
    <input type="file" name="file">

    <input type="submit">
</form>
</body>
</html>
