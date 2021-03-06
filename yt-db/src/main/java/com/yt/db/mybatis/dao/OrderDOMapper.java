package com.yt.db.mybatis.dao;

import com.yt.db.mybatis.domain.OrderDO;
import com.yt.db.mybatis.domain.OrderDOExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrderDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @SelectProvider(type=OrderDOSqlProvider.class, method="countByExample")
    int countByExample(OrderDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @DeleteProvider(type=OrderDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @Delete({
        "delete from order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @Insert({
        "insert into order (id, order_id, ",
        "buyer_name, cost, ",
        "ware_name, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=BIGINT}, #{orderId,jdbcType=VARCHAR}, ",
        "#{buyerName,jdbcType=VARCHAR}, #{cost,jdbcType=INTEGER}, ",
        "#{wareName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(OrderDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @InsertProvider(type=OrderDOSqlProvider.class, method="insertSelective")
    int insertSelective(OrderDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @SelectProvider(type=OrderDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyer_name", property="buyerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cost", property="cost", jdbcType=JdbcType.INTEGER),
        @Result(column="ware_name", property="wareName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderDO> selectByExample(OrderDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @Select({
        "select",
        "id, order_id, buyer_name, cost, ware_name, create_time, update_time",
        "from order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyer_name", property="buyerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cost", property="cost", jdbcType=JdbcType.INTEGER),
        @Result(column="ware_name", property="wareName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @UpdateProvider(type=OrderDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderDO record, @Param("example") OrderDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @UpdateProvider(type=OrderDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderDO record, @Param("example") OrderDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @UpdateProvider(type=OrderDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Sat Nov 24 15:50:11 CST 2018
     */
    @Update({
        "update order",
        "set order_id = #{orderId,jdbcType=VARCHAR},",
          "buyer_name = #{buyerName,jdbcType=VARCHAR},",
          "cost = #{cost,jdbcType=INTEGER},",
          "ware_name = #{wareName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderDO record);
}