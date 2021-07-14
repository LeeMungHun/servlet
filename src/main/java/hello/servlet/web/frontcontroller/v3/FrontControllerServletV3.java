package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public FrontControllerServletV3() {
        controllerV3Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v3/members", new MemberListControllerV3());
        controllerV3Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String requestURL = req.getRequestURI();

        ControllerV3 a = controllerV3Map.get(requestURL);
        if(a == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paraMap

        Map<String, String> paraMap = createParamMap(req);
        ModelView mv = a.process(paraMap);

        String viewName = mv.getViewName();// 논리값만 가져올 수 있음. new-form
        //절대경로 변환 
        MyView myView = viewResolver(viewName);
        myView.render(mv.getModel(), req, resp);

    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paraMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paraMap.put(paramName, req.getParameter(paramName)));
        return paraMap;
    }


}
