package com.apidoc.dao;

import com.apidoc.entity.ApidocModule;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 文档模块信息 Mapper 接口
 * </p>
 *
 * @author 此代码为自动生成
 * @since 2018-09-13
 */
public interface ApidocModuleDao  {

    /**
     * 通过包名称查询
     *
     * @param packageName
     * @return
     */
    @Select("select * from apidoc_module where packageName=#{packageName}")
    Set<ApidocModule> selectByPackageName(@Param("packageName") String packageName);

    /**
     * 通过id查询classList
     *
     * @param moduleId
     * @return
     */
    @Select("select classList from apidoc_module where id =#{moduleId}")
    String findClassListById(@Param("moduleId") Integer moduleId);

    @Delete("delete from apidoc_module where id  =#{id}")
    int deleteById(Integer id);

    @UpdateProvider(type = ApidocModuleSqlProvider.class,method = "updateByPrimaryKeySelective")
    int updateById(ApidocModule m);

    @SelectProvider(type=ApidocModuleSqlProvider.class, method="selSql")
    Map<String,Object> selSql(String odd);
}
