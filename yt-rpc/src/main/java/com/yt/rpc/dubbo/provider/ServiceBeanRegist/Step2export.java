package com.yt.rpc.dubbo.provider.ServiceBeanRegist;

import com.alibaba.dubbo.common.bytecode.Wrapper;
import org.apache.ibatis.javassist.*;


/**
 * Created by yantong on 2019/3/1.
 *
 * {@link com.alibaba.dubbo.config.ServiceConfig}
 */
public class Step2export {

/**
 package com.alibaba.dubbo.common.bytecode;

 import com.yt.rpc.dubbo.provider.ServiceBeanRegist.Test;
 import com.yt.rpc.dubbo.provider.ServiceBeanRegist.CopyClassGenerator.DC;
 import java.lang.reflect.InvocationTargetException;
 import java.util.Map;

 public class Wrapper0 extends Wrapper implements DC {
     public static String[] pns;
     public static Map pts;
     public static String[] mns;
     public static String[] dmns;
     public static Class[] mts0;

     public String[] getPropertyNames() {
     return pns;
     }

     public boolean hasProperty(String var1) {
        return pts.containsKey(var1);
     }

     public Class getPropertyType(String var1) {
        return (Class)pts.get(var1);
     }

     public String[] getMethodNames() {
        return mns;
     }

     public String[] getDeclaredMethodNames() {
        return dmns;
     }

     public void setPropertyValue(Object var1, String var2, Object var3) {
         try {
            Test var4 = (Test)var1;
         } catch (Throwable var6) {
            throw new IllegalArgumentException(var6);
         }

        throw new NoSuchPropertyException("Not found property \"" + var2 + "\" filed or setter method in class com.yt.rpc.dubbo.provider.ServiceBeanRegist.Test.");
     }

     public Object getPropertyValue(Object var1, String var2) {
         try {
            Test var3 = (Test)var1;
         } catch (Throwable var5) {
            throw new IllegalArgumentException(var5);
         }

        throw new NoSuchPropertyException("Not found property \"" + var2 + "\" filed or setter method in class com.yt.rpc.dubbo.provider.ServiceBeanRegist.Test.");
     }

     public Object invokeMethod(Object var1, String var2, Class[] var3, Object[] var4) throws InvocationTargetException {
         Test var5;
        try {
            var5 = (Test)var1;
         } catch (Throwable var8) {
            throw new IllegalArgumentException(var8);
         }

         try {
            if("test".equals(var2) && var3.length == 0) {
                var5.test();
                return null;
            }
        } catch (Throwable var9) {
            throw new InvocationTargetException(var9);
         }

        throw new NoSuchMethodException("Not found method \"" + var2 + "\" in class com.yt.rpc.dubbo.provider.ServiceBeanRegist.Test.");
     }

     public Wrapper0() {
     }
 }

 */
    /**
     * 上面 是 用 {@link com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory}
     * 通过 {@link Wrapper} 生成的类
     */
    public void makeWraper() {
        //TODO 这里 我本想 用 javassist 给wraper方法加行代码 输出wrapper之后的代码，但是，需要provider，就暂时没弄
        //TODO 寻找下 如何 改变 运行中的bean

        //notEffectiveMethod();

        //直接抄代码 边private 为 public
        Wrapper wrapper = CopyClassFromDubboWraper.makeWrapper(Test.class);
    }

    private void notEffectiveMethod() {
        //参见 yt-java-class项目
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = null;
            ctClass = pool.getCtClass("com.yt.rpc.dubbo.provider.ServiceBeanRegist.TestWraper");

            //ctClass.getMethods();//这里 没有获取到 私有方法
            //无法改编 私有方法。。。

            CtMethod[] methods = ctClass.getDeclaredMethods();
            CtMethod makeWrapperMethod = null;
            for (CtMethod method : methods) {
                if (method.getLongName().contains("makeWrapper")) {
                    makeWrapperMethod = method;
                }
            }
            System.out.println(makeWrapperMethod);
            //不写明路径，则生成到 项目的根目录了
//            ctClass.writeFile();
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
//        } catch (CannotCompileException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
        }
    }

}
