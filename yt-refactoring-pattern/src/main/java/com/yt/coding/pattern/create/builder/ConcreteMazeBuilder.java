package com.yt.coding.pattern.create.builder;

import com.yt.coding.pattern.create.demo.Maze;

/**
 * @author SUN
 * @create 2019-04-23 下午7:59
 * @desc
 */
public class ConcreteMazeBuilder implements MazeBuilder {

    @Override
    public MazeBuilder buildRoom(int number) {
        return null;
    }

    @Override
    public MazeBuilder buildDoor(int r1Number, int r2Number) {
        return null;
    }

    @Override
    public Maze createMaze() {
        return null;
    }
}
