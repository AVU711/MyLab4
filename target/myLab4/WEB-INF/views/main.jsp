<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 09.01.2020
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<table>
    <tr>
        <td>Mail</td>
        <td>${mail}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${password}</td>
    </tr>
    <form:form method="post" action="addPoint">
        <tr>
            <td>Координата X</td>
            <td>
                <form:radiobutton path="x" value="-3"/>
                <form:radiobutton path="x" value="-2"/>
                <form:radiobutton path="x" value="-1"/>
                <form:radiobutton path="x" value="0"/>
                <form:radiobutton path="x" value="1"/>
                <form:radiobutton path="x" value="2"/>
                <form:radiobutton path="x" value="3"/>
                <form:radiobutton path="x" value="4"/>
                <form:radiobutton path="x" value="5"/>
            </td>
        </tr>
        <tr>
            <td>Координата Y</td>
            <td><form:input path="y"/></td>
        </tr>
        <tr>
            <td>Параметр R</td>
            <td>
                <form:radiobutton path="r" value="-3"/>
                <form:radiobutton path="r" value="-2"/>
                <form:radiobutton path="r" value="-1"/>
                <form:radiobutton path="r" value="0"/>
                <form:radiobutton path="r" value="1"/>
                <form:radiobutton path="r" value="2"/>
                <form:radiobutton path="r" value="3"/>
                <form:radiobutton path="r" value="4"/>
                <form:radiobutton path="r" value="5"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Отправить">
            </td>
        </tr>
    </form:form>
</table>
</body>
</html>
