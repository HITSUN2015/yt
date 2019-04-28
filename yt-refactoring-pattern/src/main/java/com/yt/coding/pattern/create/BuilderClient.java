package com.yt.coding.pattern.create;

import com.yt.coding.pattern.create.builder.ConcreteMazeBuilder;
import com.yt.coding.pattern.create.builder.Director;
import com.yt.coding.pattern.create.builder.MazeBuilder;
import com.yt.coding.pattern.create.demo.Maze;

/**
 * @author SUN
 * @create 2019-04-23 下午8:06
 * @desc
 */
public class BuilderClient {

    public void createMaze() {
        Director director = new Director();
        MazeBuilder builder = new ConcreteMazeBuilder();
        final Maze maze = director.createMaze(builder);
    }
}
