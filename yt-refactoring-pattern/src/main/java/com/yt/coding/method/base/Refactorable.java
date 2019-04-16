package com.yt.coding.method.base;/**
 * Created by SUN on 19/4/16.
 */

/**
 * @author SUN
 * @create 2019-04-16 下午9:49
 * @desc
 */
public interface Refactorable {

    String motivation();

    Object badCode(Object...params);

    Object goodCode(Object...params);
}
