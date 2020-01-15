<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 09.01.2020
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="user" action="login/process">
        <tr>
            <td>
                <form:label path="mail">Mail</form:label>
                <form:input path="mail"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password</form:label>
                <form:input path="password"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input  type="submit">
            </td>
        </tr>
    </form:form>
    <form:form action="registration" method="get">
        <input type="submit" value="Регистрация"/>
    </form:form>
</table>
</body>
</html>
