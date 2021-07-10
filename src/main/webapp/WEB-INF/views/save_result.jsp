<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member"%>
<html>
<head>
 <title>Title</title>
</head>
<body>
성공
<ul>
<!-- 이 부분은 getAttribute가 객체 형태로 리턴  >> Member 로 받기
    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
-->
        <li>id=${member.id}</li>
        <li>name=${member.username}</li>
        <li>age=${member.age}</li>

    <a href="/index.html">메인</a>
</ul>

</body>
</html>