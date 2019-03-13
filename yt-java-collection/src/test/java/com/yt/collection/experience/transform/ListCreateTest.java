package com.yt.collection.experience.transform;/**
 * Created by SUN on 19/3/13.
 */

import com.yt.collection.experience.create.ListCreate;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author SUN
 * @create 2019-03-13 下午5:17
 * @desc
 */
@Test
public class ListCreateTest {

    @Test
    public void testCreate() {
        try {
            List listTransform = ListCreate.createWithCollections1();
            listTransform.add("t");
        } catch (UnsupportedOperationException ex) {
            ex.printStackTrace();
        }
    }
}
