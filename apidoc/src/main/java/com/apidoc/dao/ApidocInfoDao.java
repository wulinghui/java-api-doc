package com.apidoc.dao;

import com.apidoc.entity.ApidocAction;
import com.apidoc.entity.ApidocInfo;
import com.apidoc.entity.ApidocModule;
import com.apidoc.entity.ApidocParam;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 文件基本信息 Mapper 接口
 * </p>
 *
 * @author 此代码为自动生成
 * @since 2018-09-11
 */
@Mapper
public interface ApidocInfoDao  {

    @Select("select * from `apidoc_info` where `packageName`=#{packageName}")
    ApidocInfo selectByPackageName(@Param("packageName") String packageName);

     default public boolean exeSql(String sql){
         Boolean obj = exeSql0(sql);
         if( obj == null ){
             return  false;
         }else{
             return obj;
         }
    }

    @Select("${sql}")
    Boolean exeSql0(@Param("sql") String sql);


    @InsertProvider(type=ApidocInfoSqlProvider.class, method="insertAction")
    int insertAction(ApidocAction record);

    @InsertProvider(type=ApidocInfoSqlProvider.class, method="insertInfo")
    int insertInfo(ApidocInfo record);

    @InsertProvider(type=ApidocInfoSqlProvider.class, method="insertModule")
    int insertModule(ApidocModule record);

    @InsertProvider(type=ApidocInfoSqlProvider.class, method="insertParam")
    int insertParam(ApidocParam record);
}

