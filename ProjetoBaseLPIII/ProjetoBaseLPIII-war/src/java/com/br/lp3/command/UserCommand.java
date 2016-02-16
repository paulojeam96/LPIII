package com.br.lp3.command;

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
        
        switch(action){
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                
                if("paulo".equals(username) && "123".equals(password)){
                    returnPage = "index.jsp";
                } else{
                    returnPage = "login.jsp";
                }
                break;
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }
    
}
