package com.yt.coding.method.base;

/**
 * Created by yantong on 2019/4/17.
 *
 */
public class ReplaceMethodWithObject extends AbstractRefactorable implements Amazing{

    @Override
    public String motivation() {
        return "代码实在太乱，临时变量太多了，分解着太麻烦，用 replaceTempWithQuery 不好使时，用这个";
    }

    /**
     * 1.建立一个新类N
     * 2.类N中建立final字段，存储原类S，把原函数M的每个临时变量和参数，建立一个字段保存之
     * 3.类N中建立构造函数，参数为：S和S中待拆分函数M的所有参数
     * 4.类N中建立compute函数
     * 5.将类S中M方法完全复制到N中compute方法，如果需要调用原函数的其他方法，用final字段调用
     * 6.拆
     *
     * point:实施这个方法前 先用{@link InlineMethod} 效果不错：原来的函数分法可能不好，所以先全放一起，重新分
     *
     * 我尝试了下 修改了一个300行的函数。。。不太适合这个方法，因为web的方法，调用的都是属性的service，变量太多而导致难以拆分，该方法可以直接拆分
     */
    @Override
    public void action() {
    }

    @Override
    public int page() {
        return 135;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
