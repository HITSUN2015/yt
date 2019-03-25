package com.yt.datastructure.datastructure.spring.ioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

/**
 * Created by yantong on 2019/2/28.
 */

@Controller
public class BeanByAnnotation {

    private static final String LABEL = "BeanByAnnotationLabel";

    @Override
    public String toString() {
        return "BeanByAnnotation{}" + LABEL;
    }
}
