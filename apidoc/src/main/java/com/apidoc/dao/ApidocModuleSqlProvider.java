package com.apidoc.dao;

import com.apidoc.entity.ApidocModule;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ApidocModuleSqlProvider {
    public String selSql(String odd){
        return odd;
    }
    public String insertSelective(ApidocModule record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("apidoc_module");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getOrder() != null) {
            sql.VALUES("`order`", "#{order,jdbcType=INTEGER}");
        }

        if (record.getPackageName() != null) {
            sql.VALUES("packageName", "#{packageName,jdbcType=VARCHAR}");
        }

        if (record.getClassList() != null) {
            sql.VALUES("classList", "#{classList,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ApidocModule record) {
        SQL sql = new SQL();
        sql.UPDATE("apidoc_module");

        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }

        if (record.getOrder() != null) {
            sql.SET("`order` = #{order,jdbcType=INTEGER}");
        }

        if (record.getPackageName() != null) {
            sql.SET("packageName = #{packageName,jdbcType=VARCHAR}");
        }

        if (record.getClassList() != null) {
            sql.SET("classList = #{classList,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }
}