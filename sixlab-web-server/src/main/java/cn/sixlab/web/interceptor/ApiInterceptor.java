package cn.sixlab.web.interceptor;

import cn.sixlab.web.bean.SixlabUser;
import cn.sixlab.web.dao.SixlabUserDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by patrick on 2017/6/20.
 */
public class ApiInterceptor implements HandlerInterceptor {
    
    @Autowired
    private SixlabUserDao dao;
    
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(">>> 在请求处理之前进行调用（Controller方法调用之前）");
        String username = httpServletRequest.getParameter("v-name");
        String token = httpServletRequest.getParameter("v-token");
    
        SixlabUser user = dao.findByUsername(username);
        if(null!=user && StringUtils.startsWithIgnoreCase(token,user.getToken())){
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(user));
            return true;
        }
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write("auth");
        writer.close();
        return false;
    }
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
            throws Exception {
        // System.out.println(">>> 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
        
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // System.out.println(">>> 在整个请求结束之后被调用，也就是在DispatcherServlet
        // 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
