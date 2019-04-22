package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Rarely;

/**
 * @author SUN
 * @create 2019-04-21 21:22
 * @desc 把匿名内部类换成私有类的写法 这个在引入lamda之后，应该没什么用了。。。
 */
public class ConvertAnonymousToInner extends AbstractIdeaRefactoralbe implements Rarely {
    @Override
    String getRefactoringMethod() {
        return "convert-anonymous-to-inner";
    }


    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();

        Thread t = new Thread(runnable);
        t.start();

    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("lala");
        }
    }
}
