package com.yt.design.pattern.action.template;/**
 * Created by SUN on 19/3/23.
 */

import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-23 下午9:31
 * @desc
 */
public class TemplateTest {

    @Test
    public void test() {

        Template template = new Cricket();
        template.play();

        System.out.println();

        template = new Football();
        template.play();
    }
}
