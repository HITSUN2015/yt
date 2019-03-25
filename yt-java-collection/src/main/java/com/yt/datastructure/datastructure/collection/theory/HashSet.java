package com.yt.datastructure.datastructure.collection.theory;/**
 * Created by SUN on 18/3/20.
 */

/**
 * @author SUN
 * @create 2018-03-20 下午5:27
 * @desc
 */
public class HashSet extends HashMap {

    /**
     * 实际上并不严谨，也有一种构造方法，底层的实现是LinkedHashMap
     *              HashSet(int initialCapacity, float loadFactor, boolean dummy) {
     *                      map = new LinkedHashMap<>(initialCapacity, loadFactor);
     *              }
     * 而之所以提供这种构造方法，实际也是给他的子类LinkedHashSet使用，只不过代码写在这里
     */
}
