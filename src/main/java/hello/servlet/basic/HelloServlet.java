package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//아래 두개는 같으면 안됨 name="name" ,urlPatterns = "/name"
@WebServlet(name="helloServlet" ,urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    //서블릿이 호출 되면 service 가 호출된다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        String name = req.getParameter("name");
        System.out.println("name = "+ name );

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello ="+ name);
    }
}
