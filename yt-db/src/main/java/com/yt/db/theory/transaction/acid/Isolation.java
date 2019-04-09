package com.yt.db.theory.transaction.acid;

/**
 * Created by yantong on 2019/4/9.
 *
 * read uncommited      能读到别的事务未提交的数据：脏读
 *
 * read commited        只能读到别的事务已提交的数据，
 *                      但是我的事务里，读别的事务提交前的数据和提交后的数据 不一致：不可重复读
 *
 * repeatable read      类似，我开始我的事务时，都在操作一个数据库的当前快照，读的数据，只受我的影响，
 *                      但是我看不到别的事务的动作，所以修改数据时，可能该数据已经变更，我会没有权限：幻读
 *
 * serializable         所有事务，完全序列化
 */
public interface Isolation {
}
