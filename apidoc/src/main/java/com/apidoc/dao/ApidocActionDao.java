package com.apidoc.dao;

import com.apidoc.entity.ApidocAction;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 文档接口信息 Mapper 接口
 * </p>
 *
 * @author 此代码为自动生成
 * @since 2018-09-14
 */
@Mapper
public interface ApidocActionDao  {

    /**
     * 通过模块id查询接口列表
     *
     * @param moduleId
     * @return
     */
    @Select("select id,`name`,moduleId,`order`,methodUUID from apidoc_action where moduleId=#{moduleId}")
    List<ApidocAction> selectByModuleId(@Param("moduleId") Integer moduleId);


    /**
     * 通过id查询接口描述
     *
     * @param id
     * @return
     */
    @Select("select description from apidoc_action where id = #{id}")
    String selectDescriptionById(@Param("id") Integer id);

    /**
     * 通过id查询接口请求参数的描述
     *
     * @param id
     * @return
     */
    @Select("select requestDescription from apidoc_action where id = #{id}")
    String selectRequestDescriptionById(@Param("id") Integer id);

    /**
     * 通过id查询接口响应参数的描述
     *
     * @param id
     * @return
     */
    @Select("select responseDescription from apidoc_action where id = #{id}")
    String selectResponseDescriptionById(@Param("id") Integer id);

    @Delete("delete from apidoc_action where id = #{id}")
    int deleteById(Integer id);

    @UpdateProvider(type = ApidocActionSqlProvider.class,method = "updateByPrimaryKeySelective")
    int updateById(ApidocAction apidocAction);
}
