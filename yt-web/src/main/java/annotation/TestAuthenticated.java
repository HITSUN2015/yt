package annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by yantong on 2019/1/8.
 */

/**
 * TODO
 *
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface TestAuthenticated {

    //本请求是否 需要页面展示
    boolean isView() default false;

    //默认跳转到的 地址
    String redirectToUrl() default "/yt-web/view/login";

    boolean checkAccount() default true;

//    // 插件类别认证
//    PluginCategory value() default PluginCategory.UNKNOWN;
}
