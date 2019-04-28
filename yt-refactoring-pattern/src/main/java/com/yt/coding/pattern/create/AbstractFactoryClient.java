package com.yt.coding.pattern.create;

import com.yt.coding.pattern.create.abstractFactory.AbstractMazeFactory;
import com.yt.coding.pattern.create.abstractFactory.green.ConcreteGreenMazeFactory;
import com.yt.coding.pattern.create.demo.AbstractRoom;
import com.yt.coding.pattern.create.demo.Maze;

/**
 * @author SUN
 * @create 2019-04-23 下午8:02
 * @desc
 */
public class AbstractFactoryClient implements Creatable {

    @Override
    public Maze create() {
        AbstractMazeFactory factory = new ConcreteGreenMazeFactory();
        return realCode(factory);
    }

    public Maze realCode(AbstractMazeFactory factory) {
        final Maze maze = factory.makeMaze();
        //一开始没有参数
        //我第一次是直接在这里添加参数的，但是传播只能往caller方向传播，所以我就没法更改factory的内部实现
        //第二次我找到room实例，添加参数，由于传播，确实room的调用方全部修改了代码，但是room平行的redRoom没有更改
        //所有，如果对象初始化用的是接口，我只需要更改接口，就可以全部修改了
        //所以我在这里修改了room接口，提供instance方法
        //我想多了，更改之后，由于instance方法还是会调用对象的构造方法，而由于RedRoom和GreenRoom的构造方法并非有Room接口统一约束
        //所以如果Room是接口，就用于无法实现这个目标

        //这也就引出了 interface 和 abstract的另一个区别：构造函数

        //又由于 java里类只能继承一个类，但是可以实现多个接口
        //如果子redRoom、greenRoom确实以Room为主体，我认为把Room改成抽象类，也挺好，多了对构造函数的约束
        //然后我就删掉了 instance方法 重新尝试这个添加参数的重构
        //由于不在一个包下，权限需要修改成protected 子类才能调用super
        //这样我就可以通过修改AbstractRoom一次性重构完所有 不过这里好像有时有bug，idea并不能第一次就识别到构造函数的引用
        final AbstractRoom r1 = factory.makeRoom(1);
        final AbstractRoom r2 = factory.makeRoom(2);
        /**
         * ...
         */
        return maze;
    }
}
