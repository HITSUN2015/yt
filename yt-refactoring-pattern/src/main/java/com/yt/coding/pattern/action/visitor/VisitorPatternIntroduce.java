package com.yt.coding.pattern.action.visitor;

/**
 * @author SUN
 * @create 2019-04-29 下午10:23
 * @desc
 *
 * 访问者模式也是用于两个对象传递消息
 * 他类似Iterator，用于访问Reciever的数据结构比较复杂的情况
 * 不同于Iterator的是，Receiver的内部结构并不是n个一样的类，而是并非完全一致
 *
 * 我感觉这种方法有点类似重构中的methodObject:
 * 访问者/MethodObjectRefactor是将复杂的结构对象/复杂的参数 封装成 统一接口的对象/一个方法的多个属性，
 *      需要时，再挨个调用 统一接口的对象/属性。
 *
 * 这个方法将 数据结构与访问的操作分离，如果想更换访问操作，new Visitor即可
 *
 * 这个方法 进行了双向依赖，所以，代码逻辑复杂
 *
 * 这个模式也不适合，在复杂结构对象中，新增对象，这样所有的visitor都得实现新的接口，或者超类提供默认方法
 */
public class VisitorPatternIntroduce {
}
