<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/base.jsp" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <table>
        <tr>
            <td>id</td>
            <td>name</td>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
