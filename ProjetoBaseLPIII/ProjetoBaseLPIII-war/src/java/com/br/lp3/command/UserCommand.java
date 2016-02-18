package com.br.lp3.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class UserCommand implements Command{
    
    public HttpServletRequest request;
    public HttpServletResponse response;
    public String returnPage = "index.jsp";
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        request.getSession().setAttribute("errormsg", "");

        switch(action){
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String check = request.getParameter("checkSave");
                
                if("paulo".equals(username) && "123".equals(password)){
                    returnPage = "index.jsp";
                    request.getSession().setAttribute("username", username);
                    
                    if(check.equals("on")){
                        //Salva cookie
                        Cookie c = new Cookie("usernameCookie", username);
                        c.setMaxAge(60*60*24*7);//vale uma semana
                        response.addCookie(c);
                        Cookie c2 = new Cookie("pwdCookie",password);
                        c2.setMaxAge(60*60*24*7);// 1 semana
                        response.addCookie(c2);
                    } else{
                        //Zera cookie
                        Cookie c = new Cookie("usernameCookie", "");
                        c.setMaxAge(0);//vale uma semana
                        response.addCookie(c);
                        Cookie c2 = new Cookie("pwdCookie","");
                        c2.setMaxAge(0);// 1 semana
                        response.addCookie(c2);
                    }
                } else{
                    request.getSession().setAttribute("errormsg", "Usuario e senha inexistentes ou não conferem!");
                    returnPage = "login.jsp";
                }
                break;
            case "logout":
                request.getSession().setAttribute("username",null);
                returnPage = "index.jsp";
                break;
                
            case "logerror":
                request.getSession().setAttribute("errormsg", "Acesso Restrito! Você deve estar logado!");
                returnPage = "login.jsp";
                break;
                
            case "cookies":
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if(cookie.getName().equals("usernameCookie")){
                        request.getSession().setAttribute("usernameC",cookie.getValue());
                    } else if(cookie.getName().equals("pwdCookie")){
                        request.getSession().setAttribute("passwordC",cookie.getValue());
                    }
                    
                }
                returnPage = "login.jsp";
                break;
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }
    
}
