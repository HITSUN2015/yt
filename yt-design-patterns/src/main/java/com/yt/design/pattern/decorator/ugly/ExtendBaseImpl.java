package com.yt.design.pattern.decorator.ugly;

import java.util.List;

/**
 * Created by yantong on 2019/2/18.
 */
public class ExtendBaseImpl implements BaseInterface {

    private BaseInterface baseInterface;

    List<BaseInterface> extendList;

    public void setBaseInterface(BaseInterface baseInterface) {
        this.baseInterface = baseInterface;
    }

    public void setExtendList(List<BaseInterface> extendList) {
        this.extendList = extendList;
    }

    @Override
    public void extendibleMethod() {
        baseInterface.extendibleMethod();
        extendList.forEach(BaseInterface :: extendibleMethod);
    }
}
