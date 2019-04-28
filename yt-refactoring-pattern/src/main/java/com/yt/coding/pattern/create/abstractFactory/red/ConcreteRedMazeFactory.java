package com.yt.coding.pattern.create.abstractFactory.red;

import com.yt.coding.pattern.create.abstractFactory.AbstractMazeFactory;
import com.yt.coding.pattern.create.demo.Door;
import com.yt.coding.pattern.create.demo.Maze;
import com.yt.coding.pattern.create.demo.AbstractRoom;
import com.yt.coding.pattern.create.demo.Wall;

/**
 * @author SUN
 * @create 2019-04-23 下午3:44
 * @desc 绿色主题迷*/
public class ConcreteRedMazeFactory implements AbstractMazeFactory {

    @Override
    public Maze makeMaze() {
        return new RedMaze();
    }

    @Override
    public AbstractRoom makeRoom(int number) {
        return new RedRoom(number);
    }

    @Override
    public Door makeDoor(AbstractRoom r1, AbstractRoom r2) {
        return new RedDoor(r1, r2);
    }

    @Override
    public Wall createWall() {
        return new RedWall();
    }
}
