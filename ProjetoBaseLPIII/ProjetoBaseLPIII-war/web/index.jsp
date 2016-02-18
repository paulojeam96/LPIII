<%-- 
    Document   : index
    Created on : 16/02/2016, 07:48:55
    Author     : 31448471
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="menu" scope="session" value="home"></c:set>
        <%@include file="topMenu.jsp" %>
        <c:choose>
            <c:when test="${username==null}">
                <h1>Hello World!</h1>
            </c:when>
            <c:otherwise>
                <h1>Hello ${username}!</h1>
                <p>qualquer coisa</p>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
