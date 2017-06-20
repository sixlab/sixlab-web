/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.server.filter;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;

/**
<<<<<<< HEAD
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
=======
 * @author 六楼的雨/Patrick Root
 * @since 2.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
 */
public class MainFilter implements ActionFilter {
    @Override
    public View match(ActionContext actionContext) {
        
        //返回 View : 这个请求有问题，不要继续执行了，马上用这个 View 来渲染 HTTP 输出流吧
        //返回 null : 恩，这个请求没问题，继续吧。
        //
        //Enumeration<String> names = actionContext.getRequest().getParameterNames();
        //Enumeration<String> attributeNames = actionContext.getRequest().getAttributeNames();
        //System.out.println("\n\n\n");
        //while (names.hasMoreElements()){
        //    String element = names.nextElement();
        //    String value = actionContext.getRequest().getParameter(element);
        //    System.out.println("value     :     "+element+"     "+value);
        //}
        //while (attributeNames.hasMoreElements()) {
        //    String element = attributeNames.nextElement();
        //    Object attribute = actionContext.getRequest().getAttribute(element);
        //    System.out.println("attr     :     " + element + "     " + attribute);
        //}
        //System.out.println("\n\n\n");
        //
        return null;
    }
}
