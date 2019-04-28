package com.yt.coding.pattern.create.builder;

import com.yt.coding.pattern.create.demo.Maze;

/**
 * @author SUN
 * @create 2019-04-23 下午8:00
 * @desc
 */
public class Director {

    public Maze createMaze(MazeBuilder builder) {
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);
        return builder.createMaze();
    }
}
