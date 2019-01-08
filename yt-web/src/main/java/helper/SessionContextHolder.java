package helper;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by yantong on 2019/1/8.
 * 此类实际就是伴随这登录线程，携带一些业务无关的信息
 */
public class SessionContextHolder {

    private static ThreadLocal<UserContext> userContentThreadLocal = new ThreadLocal<>();

    public static String getLoginUserId() {
        UserContext userContext = userContentThreadLocal.get();
        return Optional.ofNullable(userContext).map(t -> t.getLoginUserId()).orElse(null);
    }

    public static void setOperationUserContext(String operationId, String userIp,String logInUserId) {
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
