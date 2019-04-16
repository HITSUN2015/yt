package com.yt.coding.smell;/**
 * Created by SUN on 19/4/16.
 */

import java.util.List;

/**
 * @author SUN
 * @create 2019-04-16 下午7:23
 * @desc 由于badSmell都是有迹可循的, 所以这里给出badSmell的明确识别方法
 */
public interface BadSmellFindable {

    /**
     * 在单个文件中查找 badSmell
     * @param filePath 为了简便,这里先给出 文件路径 目前不对package 和 source进行扩展
     * @return
     */
    List<String> findFile(String filePath);

}
