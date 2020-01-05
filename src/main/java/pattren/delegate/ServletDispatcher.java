package pattren.delegate;

import pattren.delegate.mvc.MemberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 相当于项目经理的角色
 */
public class ServletDispatcher {

    private static List<Handler> handlerMapping = new ArrayList<Handler>();

    public ServletDispatcher(){
        Class<?> memberActionClass = MemberAction.class;
        try {
            handlerMapping.add(new Handler()
                    .setController(memberActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doService(HttpServletRequest request, HttpServletResponse response){
        doDispatch(request,response);
    }

    private void doDispatch(HttpServletRequest request,HttpServletResponse response){
        //1.获取用户请求的url
        //如果按照j2ee的标准,每个url对应一个servlet,url由浏览器输入
        String uri = request.getRequestURI();

        //2.servlet拿到url以后,要做权衡(要做判断,要做选择)
        //  根据用户请求的url,,去找到这个url对应的某个java类的方法

        //3.通过拿到的url去handlerMapping(我们把它认为是策略常量)
        Handler handle = null;
        for(Handler h: handlerMapping){
            if(request.equals(uri)){
                handle = h;
                break;
            }
        }

        //4.将具体的任务分发给method(通过反射区调用其他对应的方法)
        Object object = null;
        try {
            object = handle.getMethod().invoke(handle.getController(),request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //5.获取到method执行的结果,通过Response返回出去
//        response.getWriter().write();
    }

    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}

