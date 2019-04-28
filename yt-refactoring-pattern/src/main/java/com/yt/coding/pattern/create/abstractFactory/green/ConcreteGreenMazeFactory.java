package com.yt.coding.pattern.create.abstractFactory.green;

import com.yt.coding.pattern.create.abstractFactory.AbstractMazeFactory;
import com.yt.coding.pattern.create.demo.Door;
import com.yt.coding.pattern.create.demo.Maze;
import com.yt.coding.pattern.create.demo.AbstractRoom;
import com.yt.coding.pattern.create.demo.Wall;

/**
 * @author SUN
 * @create 2019-04-23 下午3:44
 * @desc 绿色主题迷
 */
public class ConcreteGreenMazeFactory implements AbstractMazeFactory {

    @Override
    public Maze makeMaze() {
        return new GreenMaze();
    }

    @Override
    public AbstractRoom makeRoom(int number) {
        return new GreenRoom(number);
    }

    @Override
    public Door makeDoor(AbstractRoom r1, AbstractRoom r2) {
        return new GreenDoor(r1, r2);
    }

    @Override
    public Wall createWall() {
        return new GreenWall();
    }
}
