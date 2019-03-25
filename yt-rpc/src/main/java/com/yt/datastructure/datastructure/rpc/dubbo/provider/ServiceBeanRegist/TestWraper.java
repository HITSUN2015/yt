package com.yt.datastructure.datastructure.rpc.dubbo.provider.ServiceBeanRegist;

import com.alibaba.dubbo.common.bytecode.NoSuchMethodException;
import com.alibaba.dubbo.common.bytecode.NoSuchPropertyException;
import com.alibaba.dubbo.common.bytecode.Wrapper;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by yantong on 2019/3/2.
 */
public class TestWraper extends Wrapper {

    @Override
    public String[] getPropertyNames() {
        return new String[0];
    }

    @Override
    public Class<?> getPropertyType(String pn) {
        return null;
    }

    @Override
    public boolean hasProperty(String name) {
        return false;
    }

    @Override
    public Object getPropertyValue(Object instance, String pn) throws NoSuchPropertyException, IllegalArgumentException {
        return null;
    }

    @Override
    public void setPropertyValue(Object instance, String pn, Object pv) throws NoSuchPropertyException, IllegalArgumentException {

    }

    @Override
    public String[] getMethodNames() {
        return new String[0];
    }

    @Override
    public String[] getDeclaredMethodNames() {
        return new String[0];
    }

    @Override
    public Object invokeMethod(Object instance, String mn, Class<?>[] types, Object[] args) throws NoSuchMethodException, InvocationTargetException {
        return null;
    }
}
