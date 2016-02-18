<%-- 
    Document   : login
    Created on : 16/02/2016, 08:17:22
    Author     : 31448471
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto Base</title>
    </head>
    <body>
        
        <%@include file="topMenu.jsp" %>
        
        <p>${errormsg}</p>
        
        <c:set var="errormsg" scope="session" value=""></c:set>

        <h1>LOGIN</h1>
        
        <form method="POST" action="home">
            <p><input type="text" name="username" value="${cookie.usernameCookie.value}" placeholder="username"/></p>
        <p><input type="password" name="password" placeholder="password" value="${cookie.pwdCookie.value}"/></p>
            <p><input type="checkbox" name="checkSave" checked="checked"/>Salvar usuario e senha!</p>
            <p><input type="submit" value="LOGIN"/></p>
            <input type="hidden" name="command" value="User"/>
            <input type="hidden" name="action" value="login"/>
        </form>
    </body>
</html>

