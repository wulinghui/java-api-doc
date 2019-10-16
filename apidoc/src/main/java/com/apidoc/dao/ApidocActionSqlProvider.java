package com.apidoc.dao;

import com.apidoc.entity.ApidocAction;
import org.apache.ibatis.jdbc.SQL;

public class ApidocActionSqlProvider {

    public String insertSelective(ApidocAction record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("apidoc_action");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleId() != null) {
            sql.VALUES("`moduleId`", "#{moduleId,jdbcType=INTEGER}");
        }
        
        if (record.getOrder() != null) {
            sql.VALUES("`order`", "#{order,jdbcType=INTEGER}");
        }
        
        if (record.getMethodUUID() != null) {
            sql.VALUES("methodUUID", "#{methodUUID,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestDescription() != null) {
            sql.VALUES("requestDescription", "#{requestDescription,jdbcType=VARCHAR}");
        }
        
        if (record.getResponseDescription() != null) {
            sql.VALUES("responseDescription", "#{responseDescription,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ApidocAction record) {
        SQL sql = new SQL();
        sql.UPDATE("apidoc_action");
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleId() != null) {
            sql.SET("moduleId = #{moduleId,jdbcType=INTEGER}");
        }
        
        if (record.getOrder() != null) {
            sql.SET("`order` = #{order,jdbcType=INTEGER}");
        }
        
        if (record.getMethodUUID() != null) {
            sql.SET("`methodUUID` = #{methodUUID,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestDescription() != null) {
            sql.SET("requestDescription = #{requestDescription,jdbcType=VARCHAR}");
        }
        
        if (record.getResponseDescription() != null) {
            sql.SET("responseDescription = #{responseDescription,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}