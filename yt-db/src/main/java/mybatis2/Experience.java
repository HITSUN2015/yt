package mybatis2;

/**
 * Created by yantong on 2019/1/31.
 *
 * 1.如果你需要做很复杂的事情，那么最好使用 XML 来映射语句
 * 2.依赖注入框架可以创建线程安全的、基于事务的 SqlSession 和映射器（mapper）并将它们直接注入到你的 bean 中
 *   TODO  说明sqlSession、mapper需要注意 线程安全、事物 这里考虑下为什么 以及 spring-mybatis如何实现
 * 3.http://www.mybatis.org/mybatis-3/zh/getting-started.html
 *      “但是最好还是不要让其一直存在以保证所有的 XML 解析资源开放给更重要的事情” 没看懂，我看配置是sqlSessionFactory的一部分
 *      关于生命中期的维度 来判断 某些对象的 方法的使用 这个角度我认为特别好
 */
public class Experience {

}
