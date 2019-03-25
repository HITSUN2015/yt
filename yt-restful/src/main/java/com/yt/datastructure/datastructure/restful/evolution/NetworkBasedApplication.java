package com.yt.datastructure.datastructure.restful.evolution;

/**
 * Created by yantong on 2019/2/20.
 * style 继承关系是树形结构
 * 要求style的实现类 的继承关系 与 接口继承关系一致
 */
public interface NetworkBasedApplication {

    /**
     * 架构属性评估
     * 评估 并非 随style树形继承
     * 所以 每种style 单独实现自己的 评估
     * @return
     */
    EvaluateResultModel evaluate();


}
