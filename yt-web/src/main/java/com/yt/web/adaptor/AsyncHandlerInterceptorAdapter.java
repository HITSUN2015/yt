package com.yt.web.adaptor;

import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yantong on 2019/1/8.
 */
public abstract class AsyncHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    /**
     * The dispatcher type {@code javax.servlet.DispatcherType.ASYNC} introduced
     * in Servlet 3.0 means a filter can be invoked in more than one thread over
     * the course of a single request. This method returns {@code true} if the
     * filter is currently executing within an asynchronous dispatch.
     * @param request the current request
     * @since 3.2
     * @see WebAsyncManager#hasConcurrentResult()
     */
    protected boolean isAsyncDispatch(HttpServletRequest request) {
        return WebAsyncUtils.getAsyncManager(request).hasConcurrentResult();
    }

    /**
     * Whether request processing is in asynchronous mode meaning that the
     * response will not be committed after the current thread is exited.
     * @param request the current request
     * @since 3.2
     * @see WebAsyncManager#isConcurrentHandlingStarted()
     */
    protected boolean isAsyncStarted(HttpServletRequest request) {
        return WebAsyncUtils.getAsyncManager(request).isConcurrentHandlingStarted();
    }

}
