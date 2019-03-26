package com.yt.web.interceptor;

import com.yt.web.adaptor.AsyncHandlerInterceptorAdapter;
import com.yt.web.annotation.TestAuthenticated;
import com.yt.web.session.SessionContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yantong on 2019/1/8.
        */
public class TestAuthenticateInterceptor extends AsyncHandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TestAuthenticateInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //isAsyncDispatch:判断 是否有异步请求结果
        boolean isFirstRequest = !isAsyncDispatch(request);

        //现注释：其实不太明白这里的原因：如果有异步请求的结果，可能是之前别的interceptor返回了结果？ 或者 是HandlerMethod的子类则直接返回true
        if (!isFirstRequest || !handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            //原注释： only first request, not async dispatch request
            return true;
        }

        TestAuthenticated authenticated = ((HandlerMethod) handler).getMethodAnnotation(TestAuthenticated.class);

        if (authenticated == null) {
            return true;
        }

        if (authenticated.isView() && true) {//TODO true 可以改成 登录后的 验证条件 eg:是否有userId
            logger.info("无效请求");
            //这里 可以记录一些 端的信息：sessionId,userId,uri,clientType，system,clientVersion
            response.sendRedirect(authenticated.redirectToUrl());
            return false;

            //TODO 这里如果还缺少别的信息，可以跳转到别的页面，让登录者补充
        } else {
            //如果所有验证均通过
            // TODO: 2019/3/26 userId, userIp 等信息
            SessionContextHolder.setOperationUserContext(null, null);
        }
        return super.preHandle(request, response, handler);
    }
}
