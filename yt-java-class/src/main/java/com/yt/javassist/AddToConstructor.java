package com.yt.javassist;

import org.apache.ibatis.javassist.*;

import java.io.IOException;
import java.util.Date;

/**
 * Created by yantong on 2019/3/1.
 */
public class AddToConstructor {

    public void inserString(String classPath, String insertString) {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = null;
            ctClass = pool.getCtClass("java.util.Date");
            CtConstructor[] constructors = ctClass.getConstructors();
            constructors[0].insertAfter(insertString, true);
            //不写明路径，则生成到 项目的根目录了
            ctClass.writeFile();
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        } catch (CannotCompileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
