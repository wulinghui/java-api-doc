package com.apidoc.utis;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface IPhoneMapper {
    @Delete({
        "delete from iPhone",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iPhone (Item, Description, ",
        "Qty, Rate, Amount)",
        "values (#{item,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{qty,jdbcType=VARCHAR}, #{rate,jdbcType=VARCHAR}, #{amount,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(IPhone record);

    @InsertProvider(type=IPhoneSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(IPhone record);

    @Select({
        "select",
        "id, Item, Description, Qty, Rate, Amount",
        "from iPhone",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="Item", property="item", jdbcType= JdbcType.VARCHAR),
        @Result(column="Description", property="description", jdbcType= JdbcType.VARCHAR),
        @Result(column="Qty", property="qty", jdbcType= JdbcType.VARCHAR),
        @Result(column="Rate", property="rate", jdbcType= JdbcType.VARCHAR),
        @Result(column="Amount", property="amount", jdbcType= JdbcType.VARCHAR)
    })
    IPhone selectByPrimaryKey(Integer id);

    @UpdateProvider(type=IPhoneSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IPhone record);

    @Update({
        "update iPhone",
        "set Item = #{item,jdbcType=VARCHAR},",
          "Description = #{description,jdbcType=VARCHAR},",
          "Qty = #{qty,jdbcType=VARCHAR},",
          "Rate = #{rate,jdbcType=VARCHAR},",
          "Amount = #{amount,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(IPhone record);
}