package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Frequently;

/**
 * @author SUN
 * @create 2019-04-21 20:09
 * @desc
 */
public class WrapReturnValue extends AbstractIdeaRefactoralbe implements Frequently {

    private InnerReturn returnValue() {
        return new InnerReturn(null);
    }

    @Override
    String getRefactoringMethod() {
        return "wrap-return-value";
    }

    public class InnerReturn {
        private final String value;

        public InnerReturn(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
