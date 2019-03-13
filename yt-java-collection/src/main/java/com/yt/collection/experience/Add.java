package com.yt.collection.experience;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SUN
 * @create 2019-03-13 下午5:26
 * @desc
 */
public class Add {

    public void addOneElement(String str) {
        List<String> list = Lists.newArrayList();
        list.add(str);

        Set<String> set = Sets.newHashSet();
        set.add(str);

        Map<String, String> map = Maps.newHashMap();

        map.put(str, str);
        //见名知意 如果空缺,则放入,否则返回之前的value
        map.putIfAbsent(str, str);
    }

    /**
     * 这种写法 感觉 适合写test
     * 两层 大括号 TODO
     * 第一次见于Baeldung
     */
    public void addWithConstructor() {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(0);add(1);add(2); add(3); add(0); add(0);
            }
        };

        Set<Integer> set = new HashSet<Integer>(){
            {
                add(0);
                add(2);
            }
        };

        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
            {
                put(1, 1);
                put(2, 2);
            }
        };
    }

    /**
     * 还有这种 只建立一个元素的
     * 不可改变
     */
    public void createOneElement() {
        List list = Collections.singletonList("test");
        Set set = Collections.singleton("test");
        Map map = Collections.singletonMap("testKey", "testValue");
    }

    /**
     * Collections的原理是 loop调用对象的add方法
     *
     * 而collectionObject调用的是自己实现的方法
     * 个人认为的是,Collections的方法肯定是更通用的,适合编写框架类代码
     *
     * 但是一定是 collectoinObject的addAll效率更快的
     *
     * 我测试的效果是,数据量小的时候,可能Collections的addAll方法更快
     * 但是数据量大的时候 ListArray的addAll采用copy的方法 更快些
     * @param list
     * @param array
     */
    public static void addElementsByCollections(List list, Integer[] array) {
//        list.addAll(Arrays.asList(array));
        //不用建立新对象
        Collections.addAll(list, array);

//        Set<Integer> set = Sets.newHashSet();
//        Collections.addAll(set, array);

//        Map<String, Demo> map = Maps.newHashMap();
        //loop
    }

    public static void addElementsByObject(List list, Integer[] array) {
        list.addAll(Arrays.asList(array));

//        Sets.newHashSet().addAll(array);
    }

    public static void mixAdd() {
        Set<Demo> set = Sets.newHashSet();
        List<Demo> list = Lists.newArrayList();
        Map<String, Demo> map = Maps.newHashMap();

        //这俩集合都可以互相添加

        list.addAll(set);

//        Collections.addAll(list, set);// TODO: 19/3/13

        set.addAll(list);

//        Collections.addAll(set, list);

        //set/list to map:
//        1.loop
//        2.lamda 除非数据量大,需要多线程,否则感觉,不够费劲的。。。
        map.putAll(set.stream().collect(Collectors.toMap(Demo::getKey, x -> x)));
        map.putAll(list.stream().collect(Collectors.toMap(Demo::getKey, x -> x)));
    }

    private class Demo {
        private String key;
        private int value;

        public Demo(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
