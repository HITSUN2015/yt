package com.yt.web.session;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by yantong on 2019/1/8.
 * 此类实际就是伴随这登录线程，携带一些业务无关的信息
 *
 * session、cookie个人认为 主要用来给 无状态的http请求，绑定人员，以免每次请求，都需要登录
 *
 * 用户 注册、登录时生成session，向httpHeader set_cookie 设置session相关信息，
 * 退出时，删除http cookie中的session，并删除服务端session
 */
public class SessionContextHolder {

    private static ThreadLocal<UserContext> userContentThreadLocal = new ThreadLocal<>();

    public static String getLoginUserId() {
        UserContext userContext = userContentThreadLocal.get();
        return Optional.ofNullable(userContext).map(t -> t.getLoginUserId()).orElse(null);
    }

    public static void setOperationUserContext(String userIp,String logInUserId) {
        UserContext context = new UserContext();
        context.setUserIp(userIp);
        context.setLoginUserId(logInUserId);
        userContentThreadLocal.set(context);
    }

    public static void clear() {
        userContentThreadLocal.remove();
    }

    public static class UserContext implements Serializable {

        /**
         * 序列化ID
         */
        private static final long serialVersionUID = 6845353929452751765L;

        private String userIp;

        private String loginUserId;


        public UserContext() {
        }

        public UserContext(String userIp, String loginUserId) {
            this.userIp = userIp;
            this.loginUserId = loginUserId;
        }

        public String getUserIp() {
            return userIp;
        }

        public void setUserIp(String userIp) {
            this.userIp = userIp;
        }

        public String getLoginUserId() {
            return loginUserId;
        }

        public void setLoginUserId(String loginUserId) {
            this.loginUserId = loginUserId;
        }
    }
}
