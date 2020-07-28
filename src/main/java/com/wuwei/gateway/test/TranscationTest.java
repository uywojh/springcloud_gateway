package com.wuwei.gateway.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: wuwei
 * @Date:2020-03-22 16:51
 */
public class TranscationTest {

    @Autowired
    private TranscationTest1 transcationTest1;

    /**
     * propagation 属性
     * 事务的传播行为，默认值为 Propagation.REQUIRED。
     * 可选的值有：
     * Propagation.REQUIRED
     * 如果当前存在事务，则加入该事务，如果当前不存在事务，则创建一个新的事务。
     * Propagation.SUPPORTS
     * 如果当前存在事务，则加入该事务；如果当前不存在事务，则以非事务的方式继续运行。
     * Propagation.MANDATORY
     * 如果当前存在事务，则加入该事务；如果当前不存在事务，则抛出异常。
     * Propagation.REQUIRES_NEW
     * 重新创建一个新的事务，如果当前存在事务，暂停当前的事务。
     * Propagation.NOT_SUPPORTED
     * 以非事务的方式运行，如果当前存在事务，暂停当前的事务。
     * Propagation.NEVER
     * 以非事务的方式运行，如果当前存在事务，则抛出异常。
     * Propagation.NESTED
     * 和 Propagation.REQUIRED 效果一样。
     * <p>
     * 现在有需求如下，就算 save 方法的后面抛异常了，也不能影响 method1 方法的数据插入。
     * 或许很多人的想法如下，给 method1 页加入一个新的事务，这样 method1 就会在这个新的事务中执行，
     * 原来的事务不会影响到新的事务。比如 method1 方法上面再加入注解 @Transactional，
     * 设置 propagation 属性为 Propagation.REQUIRES_NEW，代码如下。
     * <p>
     * 隔离级别是指若干个并发的事务之间的隔离程度。TransactionDefinition 接口中定义了五个表示隔离级别的常量：
     * <p>
     * TransactionDefinition.ISOLATION_DEFAULT：这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是TransactionDefinition.ISOLATION_READ_COMMITTED。
     * TransactionDefinition.ISOLATION_READ_UNCOMMITTED：该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。该级别不能防止脏读，不可重复读和幻读，因此很少使用该隔离级别。比如PostgreSQL实际上并没有此级别。
     * TransactionDefinition.ISOLATION_READ_COMMITTED：该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
     * TransactionDefinition.ISOLATION_REPEATABLE_READ：该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。该级别可以防止脏读和不可重复读。
     * TransactionDefinition.ISOLATION_SERIALIZABLE：所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void save() {
        method1();
        System.out.println("save method");

        transcationTest1.method1();//这种情况下都会被spring事务拦截并执行需要的操作


    }

    /**
     * 内部调用的时候是无法被spring的事务拦截的所有他们还是使用同一个事务,只有在外部调用才会被spring事务拦截
     * 大概意思：在默认的代理模式下，只有目标方法由外部调用，才能被 Spring 的事务拦截器拦截。
     * 在同一个类中的两个方法直接调用，是不会被 Spring 的事务拦截器拦截，
     * 就像上面的 save 方法直接调用了同一个类中的 method1方法，
     * method1 方法不会被 Spring 的事务拦截器拦截。
     * 可以使用 AspectJ 取代 Spring AOP 代理来解决这个问题，但是这里暂不讨论。
     */

    /**
     * 接着把 save 方法的 @Transactional 注解去掉，otherService.method1 的 @Transactional 注解保持不变，
     * 从日志就可以看出，只会创建一个 otherService.method1 方法的事务，两条数据都会插入。
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method1() {
        System.out.println("method1");
    }


}
