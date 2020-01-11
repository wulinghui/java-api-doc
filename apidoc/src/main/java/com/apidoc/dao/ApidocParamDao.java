package com.apidoc.dao;

import com.apidoc.entity.ApidocParam;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * <p>
 * 文档参数信息 Mapper 接口
 * </p>
 *
 * @author 此代码为自动生成
 * @since 2018-09-15
 */
@Mapper
public interface ApidocParamDao {
    @Select("select * from `apidoc_param` where `id`=#{id}")
    ApidocParam selectById(@Param("id") int id);
    /**
     * 通过actionId查询参数列表
     *
     * @param actionId
     * @return
     */
    @Select("select * from apidoc_param where actionId=#{actionId} and returnd=#{returnd}")
    List<ApidocParam> selectListByActionId(@Param("actionId") Integer actionId, @Param("returnd") boolean returnd);

    @Delete("delete from apidoc_param where actionId=#{actionId}")
    int deleteByActionId(@Param("actionId") Integer actionId);

    @Delete("delete from apidoc_param where id=#{id}")
    int deleteById(Integer id);








    @Delete({
            "delete from apidoc_param",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into apidoc_param (name, dataType, ",
            "description, defaultValue, ",
            "required, actionId, ",
            "returnd, pid, pclassName)",
            "values (#{name,jdbcType=VARCHAR}, #{datatype,jdbcType=VARCHAR}, ",
            "#{description,jdbcType=VARCHAR}, #{defaultvalue,jdbcType=VARCHAR}, ",
            "#{required,jdbcType=TINYINT}, #{actionid,jdbcType=INTEGER}, ",
            "#{returnd,jdbcType=TINYINT}, #{pid,jdbcType=INTEGER}, #{pclassname,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(ApidocParam record);

    @InsertProvider(type=ApidocParamSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(ApidocParam record);

    @Select({
            "select",
            "id, name, dataType, description, defaultValue, required, actionId, returnd, ",
            "pid, pclassName",
            "from apidoc_param",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataType", property="datatype", jdbcType=JdbcType.VARCHAR),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="defaultValue", property="defaultvalue", jdbcType=JdbcType.VARCHAR),
            @Result(column="required", property="required", jdbcType=JdbcType.TINYINT),
            @Result(column="actionId", property="actionid", jdbcType=JdbcType.INTEGER),
            @Result(column="returnd", property="returnd", jdbcType=JdbcType.TINYINT),
            @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
            @Result(column="pclassName", property="pclassname", jdbcType=JdbcType.VARCHAR)
    })
    ApidocParam selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ApidocParamSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApidocParam record);

    @Update({
            "update apidoc_param",
            "set name = #{name,jdbcType=VARCHAR},",
            "dataType = #{datatype,jdbcType=VARCHAR},",
            "description = #{description,jdbcType=VARCHAR},",
            "defaultValue = #{defaultvalue,jdbcType=VARCHAR},",
            "required = #{required,jdbcType=TINYINT},",
            "actionId = #{actionid,jdbcType=INTEGER},",
            "returnd = #{returnd,jdbcType=TINYINT},",
            "pid = #{pid,jdbcType=INTEGER},",
            "pclassName = #{pclassname,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ApidocParam record);


}