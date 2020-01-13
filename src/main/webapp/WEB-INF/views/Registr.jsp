<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 13.01.2020
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
    <table>
        <form:form action="/registration" method="post" modelAttribute="users">
            <tr>
                <td>
                    <form:label path="mail">Mail</form:label>
                    <form:input path="mail"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="name">Password</form:label>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit">
                </td>
            </tr>
        </form:form>
    </table>
</body>
</html>
