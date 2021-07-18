package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();

        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v3/members", new MemberListControllerV3());
        handlerMappingMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV5.service");

        String requestURL = request.getRequestURI();
/*
        Object a = handlerMappingMap.get(requestURL);
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
        myView.render(mv.getModel(), req, resp);*/
    }
}
