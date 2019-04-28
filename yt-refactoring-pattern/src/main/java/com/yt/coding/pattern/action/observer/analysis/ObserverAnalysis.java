package com.yt.coding.pattern.action.observer.analysis;

/**
 * @author SUN
 * @create 2019-04-28 下午6:05
 * @desc
 *
 * {@link com.yt.coding.pattern.action.observer.bad.Receiver}
 * 与
 * {@link com.yt.coding.pattern.action.observer.bad.Sender}
 * 是
 * {@link com.yt.coding.uml.Dependency} 关系
 *
 * 扩展：
 *  扩展的方法：扩展一个类：增加字段
 *             扩展两个类：关联类型：{@link com.yt.coding.uml.Dependency}等
 *                        数量：1:1,1:n,n:1,n:n
 *             当扩展1扩展出来的字段，逐渐丰富，他将扩展为一个新的类，从而再考虑用 扩展2来扩展
 *             所以问题就来了：何时把字段 归结为一个类
 *                  1.至少有一个必要条件，我们是知道的，当当前类需要与属性考虑关联类型或数量时
 *                      当前类与属性：1:1:可能不需要建立新的类
 *                                  1:n:需要建立新的类
 *                                  n:1:需要建立新的类
 *                                  n:n:需要建立新的类
 *                                      但这种情况，在类的结构上，最好用n:1或1:n进行表达，决定哪个对象是驱动类
 *                                      ：我对这个驱动类（我暂且这么起名字）的理解是：如果想管理（增删改查）一个类A，必须借由某个类B来管理
 *                                          则这某个类B，即为类A的驱动类
 *                                      eg:teacher and student
 *                                      如果是学校的职员组织：所有教师->科目->教师->学生 教师与学生是1：n，教师是驱动类
 *                                      这样的软件设计，并不提供从学生 去 管理老师的行为：
 *                                      班级->学生->教师
 *                                      视实际业务需求，来选择
 *
 *                                      所以我把类间关系的数量维度转化为：
 *                                      驱动类 与 被驱动类：1：1：非必须建立新类
 *                                                        1：n：建立新类
 *                                                        n：1：我这里暂时定为，不存在这种情况，这种情况需要改为1的是驱动类 TODO
 *                                      n:n的情况：TODO 积累下看看哪个模式 用了这种关系。。。
 *
 * 这个交互，涉及多个模型：
 * Message
 * Sender
 * Receiver
 *
 * Message 最多变
 *  扩展：消息类型：Topic：频道？ 或称 Subject
 *       或二级消息类型：topic1下的某某操作消息
 * Sender 相对稳定
 * Receiver 相对稳定
 *
 * 关系数量有如下的组合：
 *   Sender:Messsage  Recevier:Message  Sender:Receiver  情景
 * 1 1:1              1:1               1:1              一个对象只能与一个对象通信，只能发一种消息
 * 2                                    1:n
 * 3                                    n:1
 * 4                                    n:n
 * 5                  1:n               1:1
 * 6                                    1:n
 * 7                                    n:1
 * 8                                    n:n
 * 9                  n:1               1:1
 * 10                                   1:n
 * 11                                   n:1
 * 12                                   n:n
 * 13                 n:n               1:1
 * 14                                   1:n
 * 15                                   n:1
 * 16                                   n:n
 *
 * 关系实现也有64种组合（由于实现的区别，只有两种：{@link com.yt.coding.uml.Dependency} 和 {@link com.yt.coding.uml.Association}）
 *   Sender -> Message    Receiver -> Message    Sender -> Receiver
 *
 *   depend on，被depend on，association with，被association with
 *
 *   再分析：
 *   dependency 的实现，可以实现 1：1，1：n
 *   association的实现，也可以实现 1：1，1：n。二者好像都不擅长n：1，n：n TODO 这两种数量关系，在设计模式里找下，是否有实现应用
 *
 *   目前有三个维度，迫使我们来分析coding的最终实现：
 *   主动        or 被动
 *   dependency or association
 *   1：1        or 1：n
 *
 *   好像数量上，我们更容易分析出结果，就先分析数量的维度：
 *   1：n 涵盖了 1：1，所以，从扩展性来讲，1：n的扩展性，比1：1的大，所以，在实现时，触发严格要求1：1，否则我都实现成1：n
 *     缺点：这样做的坏处时，如果实际确实是1：1的关系，曾经方开的口子，会造成bug
 *
 *   dependency 与 association，个人认为，主要区别有两点：
 *     是否 方法传入的参数 如果一直是相同的对象，那么把 dependency 转化为 association
 *     换句话说，从扩展性来考虑，我认为，dependency 比 association更大，因为他支持每次传入不同的被驱动者。
 *     缺点：如果确实每次传入的被驱动者都是一致的，那么，所有和该对象有关的方法，都需要有他这个参数，methods的signature比较冗余
 *
 *   主动和被动：
 *     在1：n的情况下，1的一方 驱动 n的一方被驱动，如果方法在1驱动类中，是主动，如果方法在n的一方，需要被动传入驱动者
 *     在1：1的情况下，谁驱动谁都行
 *
 *  综上，我把考量两个对象的思路，化为如下：
 *      考虑数量关系
 *      1：1        如果确实任何情景都考虑到了，还是1：1的关系，那么谁主动，谁被动，是dependency还是Association都没有关系了
 *      1：n        得出1的一方是驱动类，多次调用这个方法，传入的驱动对象或被驱动对象，是否一直是同一个：
 *                  每次传入的对象不同：dependency
 *                  每次传入的对象相同：dependency 或 association
 *                          主动被动，其实决定的是 method写到哪个类里，语义上，个人偏向主语主动的去做一件事，
 *                                  但是实际还需要考虑的是，这个方法大多数依赖的对象，在哪个类里 TODO
 *      关于n:n的处理：1.思考这样一句话：A可以[同时] action 多种B吗？->A:B = 1:n
 *                                    B可以[同时] 被action 多种A吗？->B:A = 1:n,都可以的话，这俩就确实是n：n的关系
 *                   2.根据业务，是否可以化为总用A去驱动B，不提供B驱动A的情况
 *                   3.如果必须提供n：n的情况，那么，建立Mapping对象，类似数据库的中间表，转化为1：n TODO
 *
 *
 *  综上，在数量关系严格不确定、依赖关系也无法确定时，找一个更像1的一方，用1：n + dependency + 方法放在主语类中的实现方式实现
 *
 *
 *
 *
 */
public class ObserverAnalysis {
}
