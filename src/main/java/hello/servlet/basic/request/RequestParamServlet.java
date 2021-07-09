package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 1.파라미터 전송기능
 * http://localhost:8080/request-param?name=hello&age=20
 */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("RequestParamServlet.service");
        System.out.println("전체 파라미터 조회 ---------");
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName+" = " + req.getParameter(paramName)));
        System.out.println("전체 파라미터 조회 ---------");

        System.out.println("단일 파라미터");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println(age);
/**
        System.out.println("복수 파라미터 조회");
        String[] names = req.getParameterValues("name");
        for (String s : names) {
            System.out.println("s = " + s);
        }
 */
    }
}
