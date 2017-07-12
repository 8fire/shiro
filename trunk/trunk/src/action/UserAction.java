package action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/login.do")
public class UserAction  extends HttpServlet{
    private int a=0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                        String account=req.getParameter("account");
                        String pwd=req.getParameter("pwd");


        try {


            UsernamePasswordToken token=new UsernamePasswordToken(account,pwd);
            Subject user = SecurityUtils.getSubject();
            user.login(token);
            resp.sendRedirect("admin/main.jsp");
        } catch (AuthenticationException e) {
            resp.sendRedirect("index.jsp");
        }


    }
}
