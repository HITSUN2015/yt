package com.yt.coding.pattern.create.abstractFactory;

import com.yt.coding.pattern.create.demo.AbstractRoom;
import com.yt.coding.pattern.create.demo.Door;
import com.yt.coding.pattern.create.demo.Maze;
import com.yt.coding.pattern.create.demo.Wall;

/**
 * @author SUN
 * @create 2019-04-23 下午3:38
 * @desc 抽象工厂
 *
 * 场景：一个系统要有多个产品系列的一个来配置时 采用这个模式
 * 优点：
 *  1.客户端与类的实现分离
 *      客户端只需要与 {@link AbstractMazeFactory},{@link Maze},{@link AbstractRoom},{@link Door},{@link Wall}交互，而不用与他们的实现类交互
 *  2.易于变更产品系列
 *  2）产品的一致性：
 *      {@link com.yt.coding.pattern.create.abstractFactory.green.GreenDoor}
 *      {@link com.yt.coding.pattern.create.abstractFactory.green.GreenMaze}
 *      {@link com.yt.coding.pattern.create.abstractFactory.green.GreenRoom}
 *      {@link com.yt.coding.pattern.create.abstractFactory.green.GreenWall}
 *      这些组件会同一时间一起使用
 * 缺点：
 *  1.难以支持新种类的产品：接口已经发布
 *
 * 注意事项：
 *  1.ConcreteFactory最好实现单例模式 TODO 工厂方法
 *  2.工厂比较多：TODO 原型模式
 *  3.定义可扩展 产品的工厂：{@link AbstractMazeFactory}不为每个产品单独提供方法,而是提供一个make方法，接收参数，根据参数返回产品
 *      向下转型，可能失败：非安全。是一个高度灵活和可扩展接口的权衡
 *
 * 变体：
 *  {@link AbstractMazeFactory} 与 {@link com.yt.coding.pattern.create.abstractFactory.green.ConcreteGreenMazeFactory}
 *  两个结合，或者说去掉{@link AbstractMazeFactory},
 *  而 ConcreteRedMazeFactory 直接继承 ConcreteGreenMazeFactory
 *
 */
public interface AbstractMazeFactory {

    Maze makeMaze();

    AbstractRoom makeRoom(int number);

    Door makeDoor(AbstractRoom r1, AbstractRoom r2);

    Wall createWall();
}
