package com.yt.demo.helper.util.print;/**
 * Created by SUN on 19/4/7.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SUN
 * @create 2019-04-07 上午10:21
 * @desc 先仅支持 java
 */
public class SequenceDiagram {

    public static boolean isPrintPackage = false;

    public static int LIFELIFE_ABSOLUTE_DISTANCE = 5;

    private LifeLine[] printedLifeLines;

    private Map<String, LifeLine> lifeLineMap = new HashMap<>();

    private List<LifePointer> pointers = new ArrayList<>();

    public SequenceDiagram(StackTraceElement stackElement) {
        // TODO: 19/4/7
    }

    public SequenceDiagram(String directoryPath, String packagePath, String classPath, String methodPath) {
        // TODO: 19/4/7
    }

    public static boolean isPrintPackage() {
        return isPrintPackage;
    }

    public static void setIsPrintPackage(boolean isPrintPackage) {
        SequenceDiagram.isPrintPackage = isPrintPackage;
    }

    public Map<String, LifeLine> getLifeLineMap() {
        return lifeLineMap;
    }

    public void setLifeLineMap(Map<String, LifeLine> lifeLineMap) {
        this.lifeLineMap = lifeLineMap;
        this.printedLifeLines = new LifeLine[lifeLineMap.size()];
    }

    public List<LifePointer> getPointers() {
        return pointers;
    }

    public void setPointers(List<LifePointer> pointers) {
        this.pointers = pointers;
    }

    public LifeLine[] getPrintedLifeLines() {
        return printedLifeLines;
    }
}
