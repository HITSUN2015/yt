package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Rarely;

/**
 * @author SUN
 * @create 2019-04-21 20:16
 * @desc
 *
 * 感觉 正常情况下，一般会把类型写成超类或接口
 *
 * todo 怎么也没按出来。。。
 */
public class UseInterfaceWherePossible extends AbstractIdeaRefactoralbe implements Rarely {

    Implement implement = new Implement();

    public void useInterfaceWherePossible() {

        System.out.println(implement.getName());
    }

    @Override
    String getRefactoringMethod() {
        return "use-interface-where-possible";
    }


    public interface Interface {
        String getName();
    }

    public class Implement implements Interface {

        @Override
        public String getName() {
            return "test";
        }
    }
}
