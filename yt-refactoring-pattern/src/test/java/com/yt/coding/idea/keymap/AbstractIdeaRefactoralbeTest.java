package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.IdeaRefactorable;
import org.testng.annotations.Test;

public class AbstractIdeaRefactoralbeTest {

    @Test
    public void testGetInformationUrl() {

        IdeaRefactorable refactorable = new ExtractConstant();
        System.out.println(refactorable.getInformationUrl());

    }
}