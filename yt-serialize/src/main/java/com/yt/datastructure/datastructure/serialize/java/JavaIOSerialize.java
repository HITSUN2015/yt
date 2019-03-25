package com.yt.datastructure.datastructure.serialize.java;

import com.yt.datastructure.datastructure.serialize.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Optional;

/**
 * Created by yantong on 2019/2/19.
 *
 *
 可以 在 实现 Serializable 接口的勒种 添加 这两个方法 来自定义 序列化及 反序列化
 private void writeObject(ObjectOutputStream stream) throws IOException{
 //TODO
 }
 private void readObject(ObjectInputStream stream) throws IOException , ClassNotFoundException{
 //TODO
 }
 */
public class JavaIOSerialize implements SerializeUtil {

    private static final Logger logger = LoggerFactory.getLogger(JavaIOSerialize.class);

    @Override
    public String serialize(Object object) {
//        return object.toString(); 这种是打印出对象内存地址
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        String result = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            result = byteArrayOutputStream.toString("ISO-8859-1");
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            logger.error("序列化出现错误 Object {}", object.toString(), e);
        }
        return result;
    }

    @Override
    public <T> T deserialize(String source, Class<T> clazz) {
        Object result = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(source.getBytes("ISO-8859-1"));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            result = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
        } catch (IOException e) {
            logger.error("反序列化异常 source {} clazz {}", source, Optional.ofNullable(clazz.getName()).orElse(null), e);
        } catch (ClassNotFoundException e) {
            logger.error("反序列化异常 source {} clazz {}", source, Optional.ofNullable(clazz.getName()).orElse(null), e);
        }
        return (T)result;// TODO: 2019/2/20 这里的强转 略 草率
    }
}
