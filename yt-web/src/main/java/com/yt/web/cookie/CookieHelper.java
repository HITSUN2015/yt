package com.yt.web.cookie;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yantong on 2019/3/26.
 */
public class CookieHelper {

    public static Map<String, Cookie> getCookieMap(HttpServletRequest request) {
        return getCookieMap(request.getCookies());
    }

    public static Map<String, Cookie> getCookieMap(Cookie[] cookies) {
        int len = cookies == null ? 0 : cookies.length;
        Map<String, Cookie> ret = new HashMap<String, Cookie>(len);
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getValue() == null || "null".equals(cookie.getValue())) { // IE fix
                    continue;
                }
                ret.put(cookie.getName(), cookie);
            }
        }
        return ret;
    }

    public static void addCookie(HttpServletResponse resp, String key, String value, int maxAge, boolean httpOnly,
                                 String domain) {
        Map<String, String> map = new HashMap<String, String>(1);
        map.put(key, value);
        addCookie(resp, map, maxAge, httpOnly, domain);
    }

    public static void clrCookie(HttpServletResponse resp, boolean httpOnly, String domain, String... keys) {
        Map<String, String> map = new HashMap<String, String>(keys.length);
        for (String key : keys) {
            map.put(key, null);
        }
        addCookie(resp, map, 0, httpOnly, domain);
    }

    public static void addCookie(HttpServletResponse resp, Map<String, String> map, int maxAge, boolean httpOnly,
                                 String domain) {
        Cookie ck;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ck = new Cookie(entry.getKey(), entry.getValue());
            if (httpOnly) {
                resp.addHeader("Set-Cookie",
                        String.format("%s=%s%s%s; path=/; HttpOnly", ck.getName(),
                                StringUtils.containsAny(ck.getValue(), "()<>@,;:\\\"/[]?={} \t")
                                        ? String.format("\"%s\"", ck.getValue()) : ck.getValue(),
                                maxAge == -1 ? "" : String.format("; Max-Age=%s", maxAge),
                                StringUtils.isBlank(domain) ? "" : String.format("; domain=%s", domain)));
            } else {
                ck.setPath("/");
                ck.setMaxAge(maxAge);
                if (!StringUtils.isBlank(domain)) {
                    ck.setDomain(domain);
                }
                resp.addCookie(ck);
            }
        }
    }

}
