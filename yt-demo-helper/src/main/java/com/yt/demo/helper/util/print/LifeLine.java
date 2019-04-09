package com.yt.demo.helper.util.print;/**
 * Created by SUN on 19/4/7.
 */

/**
 * @author SUN
 * @create 2019-04-07 上午10:23
 * @desc
 */
public class LifeLine {

    protected String packagePath;
    protected String className;
    protected String method;

    private int printIndex = -1;           //-1表示未画,

    public String getPackagePath() {
        return packagePath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getPrintIndex() {
        return printIndex;
    }

    public void setPrintIndex(int printIndex) {
        this.printIndex = printIndex;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public boolean isPrinted() {
        return printIndex != -1;
    }

    public String getFullKey() {
        // TODO: 19/4/7 lamda
        if (packagePath == null || packagePath.isEmpty()) {
            return className;
        }
        return packagePath + "." + className;
    }

    public int getPackagePathLength() {
        if (null == packagePath || packagePath.isEmpty()) {
            return 0;
        } else {
            return packagePath.length() + 1;
        }
    }

    public int getClassNameLength() {
        if (null == className || className.isEmpty()) {
            return 0;
        } else {
            return className.length();
        }
    }
}
