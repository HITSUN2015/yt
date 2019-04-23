package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.demo.frequently.SafeDeleteDemo;
import com.yt.coding.idea.keymap.dimension.Frequently;
import com.yt.coding.idea.keymap.dimension.IdeaMostPopular;

/**
 * @author SUN
 * @create 2019-04-21 20:57
 * @desc {@link SafeDeleteDemo}
 *  object can be methodParameter,method,class
 */
public class SafeDelete extends AbstractIdeaRefactoralbe implements Frequently, IdeaMostPopular {
    @Override
    String getRefactoringMethod() {
        return "safe-delete";
    }

    /**
     * 类似 {@link ChangeSignature#changeMethodSignature()} 支持propagate
     *
     * 我在尝试这个方式时，卡住了一会，因为我做了个demo是从调用链的中间开始删参数
     * 实际是这个功能，只能支持 从最底层往caller删除，没法安全删除这个方法由这个参数 call的别人
     *
     * 既然要执行删参数，一定会删代码的：肯定是以前的某个方法（包括这个方法）不在需要某个参数的那个代码行，可以删掉
     *
     * 所以这种删除想做到安全删除，一定要找到，最起初的变化方法，是哪个方法不要参数了，从那个方法开始执行安全删除
     *
     * 另外，在propagate的过程中，如果别的函数里还需要那个参数 idea会自动截止到那个方法
     *
     * @param i
     */
    private void deleteParameter(int i) {
        System.out.println(i);
        level1();
    }

    private void level1() {
        level2();
    }

    private void level2() {
        System.out.println();
    }

    private void level12() {
        level2();
    }
}
