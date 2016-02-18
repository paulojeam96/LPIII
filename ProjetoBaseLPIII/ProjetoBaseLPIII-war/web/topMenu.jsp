<%-- 
    Document   : topMenu
    Created on : 16/02/2016, 07:50:35
    Author     : 31448471
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        
        <c:set var="menuHome" value="selectedMenu"></c:set>
        <c:set var="menuPage1" value="selectedMenu"></c:set>
        <c:set var="menuLogin" value="selectedMenu"></c:set>
     
        <nav class="topMenu">
            <ul>
                <a href="index.jsp"><li class="${menuHome}">Home</li></a>
                        <c:if test="${username!=null}">
                             <a href="page 1.jsp"><li class="${menuPage1}">Página 1</li></a>
                        </c:if>
                        <c:choose>
                            <c:when test="${username==null}">
                                 <a href="login.jsp"><li class="${menuLogin}">Login</li></a>
                            </c:when>
                            <c:otherwise>
                                 <a href="home?command=User&action=logout"><li class="${menuLogin}">Logout</li></a>
                            </c:otherwise>
                        </c:choose>

            </ul>
        </nav>
    </body>
</html>
