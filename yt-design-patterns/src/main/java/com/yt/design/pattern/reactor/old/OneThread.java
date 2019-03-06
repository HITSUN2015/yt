package com.yt.design.pattern.reactor.old;

import com.yt.design.pattern.reactor.AbstractNetHandler;
import com.yt.design.pattern.reactor.NetHandler;

/**
 * Created by yantong on 2019/3/6.
 *
 * 显而易见的缺点：阻塞，无法支持并发，第二个请求就得等第一个请求干完才能执行
 */
public class OneThread extends AbstractNetHandler implements NetHandler{

    @Override
    public String handle() {
        return work() + "";
    }

}
