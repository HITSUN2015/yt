package com.yt.coding.pattern.create.builder;

import com.yt.coding.pattern.create.demo.Maze;

/**
 * Created by yantong on 2019/3/22.
 *
 * Builder 模式
 *
 * 看了下自己以往对这个模式的理解。。。知识还是别自己揣度了。。。直接看专家怎么看的。。。
 *
 * 优点：
 *  1.将构造代码与表示代码分离
 *      1）产品的表示：意思就是实际用来描述的产品部件的概念类
 *          将产品的表示延迟到{@link MazeBuilder}的实现类，而用户只接触过builder接口，所以用户不知道产品最终是用哪些类来组建的
 *          所以，只要更改builder的实现类，就可以更改产品的内部表示
 *      2）将构造的过程独立的放入{@link Director}类中，由该类更精细的控制产品的构造
 *
 * 要点：
 *  1.有时你可能需要访问前面已经构造了的产品部件，这种情况下，生成器会将部件返回给Director
 *      以前我总理解为，builder就得是 连续build。。。
 *  2.产品{@link Maze}一般没有抽象类，因为不同builder生产出来的产品差异巨大
 *  3.builder中缺省的方法为空
 *
 * 个人理解：
 * 1.Director是一种产品的描述，Builder接口提供了可选的元件，当Director确定了，这个产品的组成结构就确定了，
 *          但是Builder的实现类，可以在别的维度来描述这个产品。eg：counting
 * 2.我拿这个模式与抽象工厂模式比较：
 *      抽象工厂将装配过程，完全交给了客户端
 *      抽象工厂也不在内部维护产品对象，只负责制造各个部件
 *      所以抽象工厂并不知道后面产品的具体结构，但是Builder模式知道
 * 3.可以写多个Director，构建多种产品
 */
public interface MazeBuilder {

    MazeBuilder buildRoom(int number);

    MazeBuilder buildDoor(int r1Number, int r2Number);

    Maze createMaze();

}
