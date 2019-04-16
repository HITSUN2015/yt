package com.yt.coding.pattern.structure.adapter;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 上午9:03
 * @desc 感觉这个没什么好讲的。
 * 就是 把 {@link ExistA} {@link ExistB} 方法合起来
 *
 * 这里我个人理解的是 与 Facade 的区别就是:需求顺序不一样
 *
 * Facade是现有 {@link ExistA} 和 {@link ExistB},不知道client需求,把他俩功能暴露出来
 *
 * 而Adapter是 知道需求是想要什么功能,把{@link ExistA} 和 {@link ExistB} 按需实现
 *
 * 至于Adater 是 类类型还是什么借口类型,个人感觉不重要,能实现即可,只不过java 单继承,两个是 类就要持有有个
 */
public class Adapter extends ExistA{

    private ExistB existB;

    public Adapter() {
        this.existB = new ExistB();
    }

    //通过继承 得到 methodA

    public void methodB() {
        existB.methodB();
    }
}
